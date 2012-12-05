package jsf;

import entidad.Proveedor;
import entidad.TransporteDiaTrabajo;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import sesion.TransporteDiaTrabajoFacade;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
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
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.core.Response;

@ManagedBean(name = "transporteDiaTrabajoController")
@SessionScoped
public class TransporteDiaTrabajoController implements Serializable {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////ASIGNAR PROVEEDOR////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Date fecha =  new Date();
    private TransporteDiaTrabajo[] selectedTransporteDiaTrabajo;
    public Proveedor proveedor;
    public DataModel vTransporteDiaTrabajo = null;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DataModel getvTransporteDiaTrabajo() {
        if (fecha != null) {
            vTransporteDiaTrabajo = new ListDataModel(getFacade().getTransporteDiaTrabajo(fecha));
        }
        return vTransporteDiaTrabajo;
    }

    public TransporteDiaTrabajo[] getSelectedTransporteDiaTrabajo() {
        return selectedTransporteDiaTrabajo;
    }

    public void setSelectedTransporteDiaTrabajo(TransporteDiaTrabajo[] selectedTransporteDiaTrabajo) {
        this.selectedTransporteDiaTrabajo = selectedTransporteDiaTrabajo;
    }
    

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

   public void prepareTransporteDiaTrabajo() {
        recreateTransporteDiaTrabajo();

    }

    private void recreateTransporteDiaTrabajo() {
        vTransporteDiaTrabajo = null;
        vTransporteDiaTrabajo = getvTransporteDiaTrabajo();
    }


    public void generarAsignarProveedor(Date fecha) {
        if (selectedTransporteDiaTrabajo != null) {
            for (TransporteDiaTrabajo var : selectedTransporteDiaTrabajo) {
                    var.setIdProveedor(getProveedor());
                    update(var);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Termino", "hola"));
        }
    }
    
    public void update(TransporteDiaTrabajo trans) {
        try {
            getFacade().edit(trans);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TransporteDiaTrabajoUpdated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////ASIGNAR PROVEEDOR////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private TransporteDiaTrabajo current;
    private DataModel items = null;
    @EJB
    private sesion.TransporteDiaTrabajoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Date fechaTransporte = new Date();

    public Date getFechaTransporte() {
        return fechaTransporte;
    }

    public void setFechaTransporte(Date fechaTransporte) {
        this.fechaTransporte = fechaTransporte;
    }

    public TransporteDiaTrabajoController() {
    }

    public TransporteDiaTrabajo getSelected() {
        if (current == null) {
            current = new TransporteDiaTrabajo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private TransporteDiaTrabajoFacade getFacade() {
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
        current = (TransporteDiaTrabajo) getItems().getRowData();
        //selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new TransporteDiaTrabajo();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.setIdTransporteDiaTrabajo(new Long("0"));
            current.setTransporteDiaTrabajoCantidadPersonas(0);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TransporteDiaTrabajoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    public String createManual() {
        try {
            current.setIdTransporteDiaTrabajo(new Long("0"));
            current.setTransporteDiaTrabajoCantidadPersonas(0);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TransporteDiaTrabajoCreated"));
            return "ManualIndex";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    public void volver() throws URISyntaxException {
        Response.seeOther(new URI("ManualIndex"));
    }
    
    public TransporteDiaTrabajo create2() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TransporteDiaTrabajoCreated"));
            return current;
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (TransporteDiaTrabajo) getItems().getRowData();
        //selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TransporteDiaTrabajoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (TransporteDiaTrabajo) getItems().getRowData();
        //selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TransporteDiaTrabajoDeleted"));
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
            items = new ListDataModel(getFacade().getTransporteDiaTrabajoFecha(fechaTransporte));
        }
        return items;
    }

    private void recreateModel() {
        items = null;
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

    @FacesConverter(forClass = TransporteDiaTrabajo.class)
    public static class TransporteDiaTrabajoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TransporteDiaTrabajoController controller = (TransporteDiaTrabajoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "transporteDiaTrabajoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TransporteDiaTrabajo) {
                TransporteDiaTrabajo o = (TransporteDiaTrabajo) object;
                return getStringKey(o.getIdTransporteDiaTrabajo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TransporteDiaTrabajoController.class.getName());
            }
        }
    }
}
