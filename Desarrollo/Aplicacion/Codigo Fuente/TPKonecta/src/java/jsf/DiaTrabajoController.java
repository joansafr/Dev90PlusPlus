package jsf;

import entidad.*;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import sesion.DiaTrabajoFacade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.spi.Context;
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
import sesion.TransporteDiaTrabajoFacade;

@ManagedBean(name = "diaTrabajoController")
@SessionScoped
public class DiaTrabajoController implements Serializable {
    /*
     * ////////////////////////////////DIA
     * TRABAJO////////////////////////////////////////////////////////////////////////////
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private Personal[] selectedPersonal;

    public Personal[] getSelectedPersonal() {
        return selectedPersonal;
    }

    public void setSelectedPersonal(Personal[] selectedPersonal) {
        this.selectedPersonal = selectedPersonal;
    }

    public void generarDiaTrabajo(Date fecha) {
        if (selectedPersonal != null) {
            DiaTrabajoEstado estado = new DiaTrabajoEstado();
            estado.setDiaTrabajoEstadoNombre("Asistio");
            estado.setIdDiaTrabajoEstado(1);

            DiaTrabajo trabajador = null;
            for (Personal var : selectedPersonal) {
                trabajador = new DiaTrabajo();
                try {
                    trabajador.setDiaTrabajoPK(new DiaTrabajoPK(var.getIdPersonal(), fecha));
                    trabajador.setDiaTrabajoCantidadHijos(var.getPersonalCantidadHijos());
                    trabajador.setDiaTrabajoCantidadHorasSemanal(var.getPersonalCantidadHorasSemanal());
                    trabajador.setDiaTrabajoCodigoFotocheck(var.getPersonalCodigoFotocheck());
                    trabajador.setDiaTrabajoCodigoPlanilla(var.getPersonalCodigoPlanilla());
                    trabajador.setDiaTrabajoDireccion(var.getPersonalDireccion());
                    trabajador.setDiaTrabajoDireccionReferencia(var.getPersonalDireccionReferencia());
                    trabajador.setDiaTrabajoFechaBaja(var.getPersonalFechaBaja());
                    trabajador.setDiaTrabajoFechaIncorporacion(var.getPersonalFechaIncorporacion());
                    trabajador.setDiaTrabajoHoraIngresoReal(null);
                    trabajador.setDiaTrabajoHoraRefrigerio(var.getPersonalHoraRefrigerioInicio());
                    trabajador.setDiaTrabajoSexo(var.getPersonalSexo());
                    trabajador.setIdDepartamento(var.getIdDepartamento());
                    trabajador.setIdCargo(var.getIdCargo());
                    trabajador.setIdCausaIncidencia(null);
                    trabajador.setIdDiaTrabajoEstado(null);
                    trabajador.setIdResponsable(var.getIdResponsable());
                    trabajador.setIdHoraIngreso(var.getIdHoraIngreso());
                    trabajador.setIdSector(var.getIdSector());
                    /////////////////////////////////////////////////////
                    trabajador.setPersonal(new Personal(var.getIdPersonal()));
                    trabajador.setDiaTrabajoApellidoMaterno(var.getPersonalApellidoMaterno());
                    trabajador.setDiaTrabajoApellidoPaterno(var.getPersonalApellidoPaterno());
                    trabajador.setDiaTrabajoNombre(var.getPersonalNombre());
                    /////////////////////////////////////////////////////
                    getFacade().create(trabajador);
                } catch (Exception excepCreate) {
                    trabajador = null;
                    continue;
                }
                trabajador = null;
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Termino", "hola"));
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////DIA TRABAJO////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////GENERAR TRANSPORTE/////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Date fecha = new Date();
    private DataModel vDiaTrabajo = null;
    @EJB
    private sesion.TransporteDiaTrabajoFacade tFacade;
    @EJB
    private sesion.SectorFacade sectorFacade;

    public TransporteDiaTrabajoFacade gettFacade() {
        return tFacade;
    }

    public DataModel getvDiaTrabajo() {
        if (fecha != null) {
            vDiaTrabajo = new ListDataModel(getFacade().getDiaTrabajo(fecha));
        }

        return vDiaTrabajo;

    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void prepareDiaTrabajo() {
        recreateDiaTrabajo();

    }

    private void recreateDiaTrabajo() {
        vDiaTrabajo = null;
        vDiaTrabajo = getvDiaTrabajo();
    }

    private List<DiaTrabajo> traerDiaTrabajo(Date date, Date hora, String sector) {
        List<DiaTrabajo> diatrabajo = null;
        diatrabajo = getFacade().getDiaTrabajo(date, hora, sector);
        return diatrabajo;
    }

    public void generarTransporte(Date fecha) {
        ///Instaciamos clases - INICIO
        List<Sector> sectores = getFacade().getSectores();
        List<HoraIngreso> horaIngresos = getFacade().getHorarios();
        List<DiaTrabajo> diaTrabajo = null;
        BigDecimal sectorCostoVar = null;
        DiaTrabajo dia = new DiaTrabajo();
        Long idTransporte = new Long("270492");
        TransporteDiaTrabajo transporte = new TransporteDiaTrabajo();
        ///Instaciamos clases - FIN
        try {
            for (Sector sector : sectores) { //TODOS LOS SECTORES
                for (HoraIngreso hora : horaIngresos) {//TODOS LOS HORARIOS DE INGRESOS
                    //TODOS LOS DIAS DE TRABAJO QUE POSEAN LA MISMA HORA DE INGRESO, PERTENEZCAN AL MISMO SECTOR Y LA MISMA FECHA PARA PODER AGRUPARLOS.
                    diaTrabajo = traerDiaTrabajo(fecha, hora.getIdHoraIngreso(), sector.getSectorNombre());
                    //PREGUNTO SI HAY MAYOR O IGUAL A 4 PERSONAS, REGLA DE NEGOCIO, SI LAS HAY ENTRO.
                    if (diaTrabajo.size() >= 4) {
                        //PREGUNTO SI SON 4 EXACTAMENTE
                        if (diaTrabajo.size() % 4 == 0) {
                            //EMPIEZO A RECORRER EL LISTADO DE PERSONAS PARA ACTUALIZARLAS AGREANDO A UNA DE ELLAS SU ID DE TRANSPORTE
                            for (int i = 0; i < diaTrabajo.size(); i++) {
                                //ESTA VALIDACION SOLO SE DA CUANDO 'i' ES 0, POR ENDE CREA AL PRINCIPIO EL TRANSPORTE
                                if (i % 4 == 0) {
                                    transporte = new TransporteDiaTrabajo();
                                    //SETEO 0 POR QUE ES UN IDENTITY
                                    transporte.setIdTransporteDiaTrabajo(new Long("0"));
                                    //SETEO HORA
                                    transporte.setIdHoraIngreso(hora);
                                    //SETEO SECTOR
                                    transporte.setIdSector(sector);
                                    //SETEO VEHICULO DE 4 PERSONAS, CONFIGURADO COMO 1
                                    transporte.setIdTipoVehiculo(new TipoVehiculo(1));
                                    //SETEO FECHA
                                    transporte.setTransporteDiaTrabajoFecha(fecha);
                                    //SETEO CANTIDAD DE PERSONAS, OBVIAMENTE 4
                                    transporte.setTransporteDiaTrabajoCantidadPersonas(4);
                                    //OBTENEMOS EL COSTO DEL SECTOR
                                    sectorCostoVar = sectorFacade.CostoSector(1, sector.getSectorNombre());
                                    //CALCULAMOS EL COSTO POR PERSONA: (COSTOSECTOR+3*4)/4
                                    transporte.setTransporteDiaTrabajoCostoPorPersona(sectorCostoVar.add(new BigDecimal(12)).divide(new BigDecimal(4)));
                                    //CALCULAMOS EL COSTO TOTAL: COSTOSECTOR + 12
                                    transporte.setTransporteDiaTrabajoCostoTotal(sectorCostoVar.add(new BigDecimal(12)));
                                    //CREAMOS DIA TRABAJO
                                    tFacade.create(transporte);
                                    idTransporte = transporte.getIdTransporteDiaTrabajo();
                                }
                                dia = diaTrabajo.get(i);
                                dia.setIdTransporteDiaTrabajo(transporte);
                                //ACTUALIZAMOS EL DIA DE TRABAJO
                                update(dia);
                            }
                        } 
                        //EN CASO DE SER MAYOR A 4
                        else {
                            //SSE REPITE LA MISMA ANTERIOR SOLO QUE PARARA CUANDO 'i' SEA IGUAL A 4
                            for (int i = 0; i < (diaTrabajo.size() - (diaTrabajo.size() % 4)); i++) {
                                if (i % 4 == 0) {
                                    transporte = new TransporteDiaTrabajo();
                                    transporte.setIdTransporteDiaTrabajo(new Long("0"));
                                    transporte.setIdHoraIngreso(hora);
                                    transporte.setIdSector(sector);
                                    sectorCostoVar = sectorFacade.CostoSector(1, sector.getSectorNombre());
                                    transporte.setIdTipoVehiculo(new TipoVehiculo(1));
                                    transporte.setTransporteDiaTrabajoCantidadPersonas(4);
                                    transporte.setTransporteDiaTrabajoCostoPorPersona(sectorCostoVar.add(new BigDecimal(12)).divide(new BigDecimal(4)));
                                    transporte.setTransporteDiaTrabajoFecha(fecha);
                                    transporte.setTransporteDiaTrabajoCostoTotal(sectorCostoVar.add(new BigDecimal(12)));
                                    tFacade.create(transporte);
                                    idTransporte = transporte.getIdTransporteDiaTrabajo();
                                }
                                dia = diaTrabajo.get(i);
                                dia.setIdTransporteDiaTrabajo(transporte);
                                update(dia);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            JsfUtil.addErrorMessage(ex, null);
        }


    }

    public void update(DiaTrabajo dia) {
        try {
            getFacade().edit(dia);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DiaTrabajoUpdated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    public String irManual() {
        return "ManualIndex";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////GENERAR TRANSPORTE////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private DiaTrabajo[] selectedDiaTrabajo;
    private Date fecha_manual = new Date();
    private DataModel mDiaTrabajo = null;
    private TransporteDiaTrabajo UtransporteDiaTrabajo;
    private TransporteDiaTrabajo selectedTDT;

    public TransporteDiaTrabajo getSelectedTDT() {
        return selectedTDT;
    }

    public void setSelectedTDT(TransporteDiaTrabajo selectedTDT) {
        this.selectedTDT = selectedTDT;
    }

    public TransporteDiaTrabajo getUtransporteDiaTrabajo() {
        return UtransporteDiaTrabajo;
    }

    public void setUtransporteDiaTrabajo(TransporteDiaTrabajo UtransporteDiaTrabajo) {
        this.UtransporteDiaTrabajo = UtransporteDiaTrabajo;
    }

    public void prepareDiaTrabajoManual() {
        recreateDiaTrabajoManual();

    }

    private void recreateDiaTrabajoManual() {
        mDiaTrabajo = null;
        mDiaTrabajo = getmDiaTrabajo();
    }

    public DataModel getmDiaTrabajo() {
        if (fecha_manual != null) {
            mDiaTrabajo = new ListDataModel(getFacade().getDiaTrabajo(fecha_manual));
        }
        return mDiaTrabajo;
    }

    public Date getFecha_manual() {
        return fecha_manual;
    }

    public void setFecha_manual(Date fecha_manual) {
        this.fecha_manual = fecha_manual;
    }

    public DiaTrabajo[] getSelectedDiaTrabajo() {
        return selectedDiaTrabajo;
    }

    public void setSelectedDiaTrabajo(DiaTrabajo[] selectedDiaTrabajo) {
        this.selectedDiaTrabajo = selectedDiaTrabajo;
    }

    public String irAutomatico() {
        return "AutomaticoIndex";
    }

    public void asignarTransporte(Date fecha) {
        for (DiaTrabajo dia : selectedDiaTrabajo) {
            if ((dia.getIdHoraIngreso().getIdHoraIngreso() != selectedTDT.getIdHoraIngreso().getIdHoraIngreso()) || (selectedTDT.getTransporteDiaTrabajoFecha().compareTo(fecha_manual) != 0)) {
                JsfUtil.addErrorMessage("No se pudo asignar el transporte, hora de ingreso o fecha diferente: " + dia.getPersonal().getIdPersonal());
                return;
            }
        }
        
        if ((selectedDiaTrabajo.length + selectedTDT.getTransporteDiaTrabajoCantidadPersonas()) >= selectedTDT.getIdTipoVehiculo().getTipoVehiculoCantidadPersonas()) {
            JsfUtil.addErrorMessage("No se pudo asignar el transporte.\nVehiculo:" + selectedTDT.getIdTipoVehiculo().getTipoVehiculoCantidadPersonas()
                    + " ,\nDentro del Vehiculo:" + selectedTDT.getTransporteDiaTrabajoCantidadPersonas());
            return;
        }


        ArrayList<DiaTrabajo> listado = new ArrayList<DiaTrabajo>();
        for (DiaTrabajo dia : selectedDiaTrabajo) {
            dia.setIdTransporteDiaTrabajo(new TransporteDiaTrabajo(selectedTDT.getIdTransporteDiaTrabajo()));
            listado.add(dia);
            update(dia);
        }

        /*
         * Actualizacion de TransporteDiaTrabajo
         */
        try {
            TransporteDiaTrabajo transporte = tFacade.find(selectedTDT.getIdTransporteDiaTrabajo());
            BigDecimal Costo = new BigDecimal(0.0);
            Sector sector = new Sector();
            listado.addAll(transporte.getDiaTrabajoCollection());
            for (DiaTrabajo dia : listado) {
                if (dia.getPersonal().getIdSector().getSectorCosto().compareTo(Costo) == 1) {
                    Costo = dia.getPersonal().getIdSector().getSectorCosto();
                    sector = dia.getIdSector();
                }
            }

            transporte.setIdSector(sector);
            transporte.setTransporteDiaTrabajoCantidadPersonas(listado.size());
            transporte.setTransporteDiaTrabajoCostoPorPersona(sector.getSectorCosto().add(new BigDecimal(4 * (listado.size() - 1))).divide(new BigDecimal(listado.size())));
            transporte.setTransporteDiaTrabajoCostoTotal(sector.getSectorCosto().add(new BigDecimal(4 * (listado.size() - 1))));
            tFacade.edit(transporte);
            JsfUtil.addSuccessMessage("Finalizó");
        } catch (Exception exit2) {
            JsfUtil.addErrorMessage("Finalizó con errores");
        }
        /*
         * Actualizacion de TransporteDiaTrabajo
         */

        JsfUtil.addSuccessMessage("Finalizó");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////GENERAR TRANSPORTE////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////REVISION DIA//////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private DataModel vRevisionDia = null;
    private Date fechaRevisionDia = new Date();

    public Date getFechaRevisionDia() {
        return fechaRevisionDia;
    }

    public void setFechaRevisionDia(Date fechaRevisionDia) {
        this.fechaRevisionDia = fechaRevisionDia;
    }

    public DataModel getvRevisionDia() {
        if (getFechaRevisionDia() != null) {
            vRevisionDia = new ListDataModel(getFacade().getRevisionDia(fechaRevisionDia));
        }
        return vRevisionDia;
    }

    public void prepareRevisionDia() {
        recreateRevisionDia();

    }

    private void recreateRevisionDia() {
        vRevisionDia = null;
        vRevisionDia = getvRevisionDia();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////REVISION DIA//////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private DiaTrabajo current;
    private DataModel items = null;
    @EJB
    private sesion.DiaTrabajoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DiaTrabajoController() {
    }

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
        current = (DiaTrabajo) vRevisionDia.getRowData();
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
        current = (DiaTrabajo) getvRevisionDia().getRowData();
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
        current = (DiaTrabajo) getvRevisionDia().getRowData();
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
        vRevisionDia = null;
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

    @FacesConverter(forClass = DiaTrabajo.class)
    public static class DiaTrabajoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DiaTrabajoController controller = (DiaTrabajoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "diaTrabajoController");
            return controller.ejbFacade.find(getKey(value));
        }

        entidad.DiaTrabajoPK getKey(String value) {
            entidad.DiaTrabajoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entidad.DiaTrabajoPK();
            key.setIdPersonal(values[0]);
            key.setDiaTrabajoFecha(java.sql.Date.valueOf(values[1]));
            return key;
        }

        String getStringKey(entidad.DiaTrabajoPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getIdPersonal());
            sb.append(SEPARATOR);
            sb.append(value.getDiaTrabajoFecha());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DiaTrabajo) {
                DiaTrabajo o = (DiaTrabajo) object;
                return getStringKey(o.getDiaTrabajoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + DiaTrabajoController.class.getName());
            }
        }
    }
}
