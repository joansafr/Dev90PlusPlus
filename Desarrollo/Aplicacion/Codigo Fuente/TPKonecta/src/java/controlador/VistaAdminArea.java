/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import jsf.DiaTrabajoController;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import sesion.DiaTrabajoFacade;
import sesion.TransporteDiaTrabajoFacade;

/**
 *
 * @author Antonio
 */

@ManagedBean
@SessionScoped
public class VistaAdminArea {

    /**
     * Creates a new instance of VistaAdminArea
     */
    public VistaAdminArea() {
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////PLANIFICACION////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Date fechaPlanificacion = new Date();
    private DataModel vDiaTrabajoPlanificacion = null;
    private Departamento areaPlanificacion;

    public Departamento getAreaPlanificacion() {
        return areaPlanificacion;
    }

    public void setAreaPlanificacion(Departamento areaPlanificacion) {
        this.areaPlanificacion = areaPlanificacion;
    }

    public Date getFechaPlanificacion() {
        return fechaPlanificacion;
    }

    public void setFechaPlanificacion(Date fechaPlanificacion) {
        this.fechaPlanificacion = fechaPlanificacion;
    }

    public DataModel getvDiaTrabajoPlanificacion() {
        if (fechaPlanificacion != null && areaPlanificacion != null) {
            vDiaTrabajoPlanificacion = new ListDataModel(getFacade().getDiaTrabajoPLanificacion(fechaPlanificacion, areaPlanificacion));
        }
        return vDiaTrabajoPlanificacion;
    }

    public void preparePlanificacion() {
        recreatePlanificacion();

    }

    private void recreatePlanificacion() {
        vDiaTrabajoPlanificacion = null;
        vDiaTrabajoPlanificacion = getvDiaTrabajoPlanificacion();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////PLANIFICACION////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private DiaTrabajo current;
    private DataModel items = null;
    @EJB
    private sesion.DiaTrabajoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DiaTrabajo getSelected() {
        if (current == null) {
            current = new DiaTrabajo();
            current.setDiaTrabajoPK(new entidad.DiaTrabajoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private DiaTrabajoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        //current = (DiaTrabajo) getvRevisionDia().getRowData();
        current = (DiaTrabajo) vDiaTrabajoPlanificacion.getRowData();
        //selectedItemIndex = pagination.getPageFirstItem() + getvRevisionDia().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new DiaTrabajo();
        current.setDiaTrabajoPK(new entidad.DiaTrabajoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DiaTrabajoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (DiaTrabajo) vDiaTrabajoPlanificacion.getRowData();
        //selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DiaTrabajoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (DiaTrabajo) vDiaTrabajoPlanificacion.getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DiaTrabajoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        vDiaTrabajoPlanificacion = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }
}
