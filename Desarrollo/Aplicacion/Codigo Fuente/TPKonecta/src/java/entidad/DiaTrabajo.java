/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "dia_trabajo", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaTrabajo.findAll", query = "SELECT d FROM DiaTrabajo d"),
    @NamedQuery(name = "DiaTrabajo.findByIdPersonal", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoPK.idPersonal = :idPersonal"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoFecha", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoPK.diaTrabajoFecha = :diaTrabajoFecha"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoHoraRefrigerio", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoHoraRefrigerio = :diaTrabajoHoraRefrigerio"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoCodigoPlanilla", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoCodigoPlanilla = :diaTrabajoCodigoPlanilla"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoCodigoFotocheck", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoCodigoFotocheck = :diaTrabajoCodigoFotocheck"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoCantidadHorasSemanal", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoCantidadHorasSemanal = :diaTrabajoCantidadHorasSemanal"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoFechaIncorporacion", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoFechaIncorporacion = :diaTrabajoFechaIncorporacion"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoFechaBaja", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoFechaBaja = :diaTrabajoFechaBaja"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoCantidadHijos", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoCantidadHijos = :diaTrabajoCantidadHijos"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoDireccion", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoDireccion = :diaTrabajoDireccion"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoDireccionReferencia", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoDireccionReferencia = :diaTrabajoDireccionReferencia"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoSexo", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoSexo = :diaTrabajoSexo"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoHoraIngresoReal", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoHoraIngresoReal = :diaTrabajoHoraIngresoReal"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoNroVale", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoNroVale = :diaTrabajoNroVale"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoNombre", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoNombre = :diaTrabajoNombre"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoApellidoPaterno", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoApellidoPaterno = :diaTrabajoApellidoPaterno"),
    @NamedQuery(name = "DiaTrabajo.findByDiaTrabajoApellidoMaterno", query = "SELECT d FROM DiaTrabajo d WHERE d.diaTrabajoApellidoMaterno = :diaTrabajoApellidoMaterno")})
public class DiaTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiaTrabajoPK diaTrabajoPK;
    @Column(name = "dia_trabajo_hora_refrigerio")
    @Temporal(TemporalType.TIME)
    private Date diaTrabajoHoraRefrigerio;
    @Size(max = 20)
    @Column(name = "dia_trabajo_codigo_planilla", length = 20)
    private String diaTrabajoCodigoPlanilla;
    @Size(max = 20)
    @Column(name = "dia_trabajo_codigo_fotocheck", length = 20)
    private String diaTrabajoCodigoFotocheck;
    @Column(name = "dia_trabajo_cantidad_horas_semanal")
    private Integer diaTrabajoCantidadHorasSemanal;
    @Column(name = "dia_trabajo_fecha_incorporacion")
    @Temporal(TemporalType.DATE)
    private Date diaTrabajoFechaIncorporacion;
    @Column(name = "dia_trabajo_fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date diaTrabajoFechaBaja;
    @Column(name = "dia_trabajo_cantidad_hijos")
    private Integer diaTrabajoCantidadHijos;
    @Size(max = 300)
    @Column(name = "dia_trabajo_direccion", length = 300)
    private String diaTrabajoDireccion;
    @Size(max = 200)
    @Column(name = "dia_trabajo_direccion_referencia", length = 200)
    private String diaTrabajoDireccionReferencia;
    @Column(name = "dia_trabajo_sexo")
    private Boolean diaTrabajoSexo;
    @Column(name = "dia_trabajo_hora_ingreso_real")
    @Temporal(TemporalType.TIME)
    private Date diaTrabajoHoraIngresoReal;
    @Size(max = 50)
    @Column(name = "dia_trabajo_nro_vale", length = 50)
    private String diaTrabajoNroVale;
    @Size(max = 50)
    @Column(name = "dia_trabajo_nombre", length = 50)
    private String diaTrabajoNombre;
    @Size(max = 50)
    @Column(name = "dia_trabajo_apellido_paterno", length = 50)
    private String diaTrabajoApellidoPaterno;
    @Size(max = 50)
    @Column(name = "dia_trabajo_apellido_materno", length = 50)
    private String diaTrabajoApellidoMaterno;
    @JoinColumn(name = "id_hora_ingreso", referencedColumnName = "id_hora_ingreso")
    @ManyToOne
    private HoraIngreso idHoraIngreso;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne
    private Responsable idResponsable;
    @JoinColumn(name = "id_sector", referencedColumnName = "id_sector")
    @ManyToOne
    private Sector idSector;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne
    private Cargo idCargo;
    @JoinColumn(name = "id_transporte_dia_trabajo", referencedColumnName = "id_transporte_dia_trabajo")
    @ManyToOne
    private TransporteDiaTrabajo idTransporteDiaTrabajo;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;
    @JoinColumn(name = "id_dia_trabajo_estado", referencedColumnName = "id_dia_trabajo_estado")
    @ManyToOne
    private DiaTrabajoEstado idDiaTrabajoEstado;
    @JoinColumn(name = "id_causa_incidencia", referencedColumnName = "id_causa_incidencia")
    @ManyToOne
    private CausaIncidencia idCausaIncidencia;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne
    private Departamento idDepartamento;

    public DiaTrabajo() {
    }

    public DiaTrabajo(DiaTrabajoPK diaTrabajoPK) {
        this.diaTrabajoPK = diaTrabajoPK;
    }

    public DiaTrabajo(String idPersonal, Date diaTrabajoFecha) {
        this.diaTrabajoPK = new DiaTrabajoPK(idPersonal, diaTrabajoFecha);
    }

    public DiaTrabajoPK getDiaTrabajoPK() {
        return diaTrabajoPK;
    }

    public void setDiaTrabajoPK(DiaTrabajoPK diaTrabajoPK) {
        this.diaTrabajoPK = diaTrabajoPK;
    }

    public Date getDiaTrabajoHoraRefrigerio() {
        return diaTrabajoHoraRefrigerio;
    }

    public void setDiaTrabajoHoraRefrigerio(Date diaTrabajoHoraRefrigerio) {
        this.diaTrabajoHoraRefrigerio = diaTrabajoHoraRefrigerio;
    }

    public String getDiaTrabajoCodigoPlanilla() {
        return diaTrabajoCodigoPlanilla;
    }

    public void setDiaTrabajoCodigoPlanilla(String diaTrabajoCodigoPlanilla) {
        this.diaTrabajoCodigoPlanilla = diaTrabajoCodigoPlanilla;
    }

    public String getDiaTrabajoCodigoFotocheck() {
        return diaTrabajoCodigoFotocheck;
    }

    public void setDiaTrabajoCodigoFotocheck(String diaTrabajoCodigoFotocheck) {
        this.diaTrabajoCodigoFotocheck = diaTrabajoCodigoFotocheck;
    }

    public Integer getDiaTrabajoCantidadHorasSemanal() {
        return diaTrabajoCantidadHorasSemanal;
    }

    public void setDiaTrabajoCantidadHorasSemanal(Integer diaTrabajoCantidadHorasSemanal) {
        this.diaTrabajoCantidadHorasSemanal = diaTrabajoCantidadHorasSemanal;
    }

    public Date getDiaTrabajoFechaIncorporacion() {
        return diaTrabajoFechaIncorporacion;
    }

    public void setDiaTrabajoFechaIncorporacion(Date diaTrabajoFechaIncorporacion) {
        this.diaTrabajoFechaIncorporacion = diaTrabajoFechaIncorporacion;
    }

    public Date getDiaTrabajoFechaBaja() {
        return diaTrabajoFechaBaja;
    }

    public void setDiaTrabajoFechaBaja(Date diaTrabajoFechaBaja) {
        this.diaTrabajoFechaBaja = diaTrabajoFechaBaja;
    }

    public Integer getDiaTrabajoCantidadHijos() {
        return diaTrabajoCantidadHijos;
    }

    public void setDiaTrabajoCantidadHijos(Integer diaTrabajoCantidadHijos) {
        this.diaTrabajoCantidadHijos = diaTrabajoCantidadHijos;
    }

    public String getDiaTrabajoDireccion() {
        return diaTrabajoDireccion;
    }

    public void setDiaTrabajoDireccion(String diaTrabajoDireccion) {
        this.diaTrabajoDireccion = diaTrabajoDireccion;
    }

    public String getDiaTrabajoDireccionReferencia() {
        return diaTrabajoDireccionReferencia;
    }

    public void setDiaTrabajoDireccionReferencia(String diaTrabajoDireccionReferencia) {
        this.diaTrabajoDireccionReferencia = diaTrabajoDireccionReferencia;
    }

    public Boolean getDiaTrabajoSexo() {
        return diaTrabajoSexo;
    }

    public void setDiaTrabajoSexo(Boolean diaTrabajoSexo) {
        this.diaTrabajoSexo = diaTrabajoSexo;
    }

    public Date getDiaTrabajoHoraIngresoReal() {
        return diaTrabajoHoraIngresoReal;
    }

    public void setDiaTrabajoHoraIngresoReal(Date diaTrabajoHoraIngresoReal) {
        this.diaTrabajoHoraIngresoReal = diaTrabajoHoraIngresoReal;
    }

    public String getDiaTrabajoNroVale() {
        return diaTrabajoNroVale;
    }

    public void setDiaTrabajoNroVale(String diaTrabajoNroVale) {
        this.diaTrabajoNroVale = diaTrabajoNroVale;
    }

    public String getDiaTrabajoNombre() {
        return diaTrabajoNombre;
    }

    public void setDiaTrabajoNombre(String diaTrabajoNombre) {
        this.diaTrabajoNombre = diaTrabajoNombre;
    }

    public String getDiaTrabajoApellidoPaterno() {
        return diaTrabajoApellidoPaterno;
    }

    public void setDiaTrabajoApellidoPaterno(String diaTrabajoApellidoPaterno) {
        this.diaTrabajoApellidoPaterno = diaTrabajoApellidoPaterno;
    }

    public String getDiaTrabajoApellidoMaterno() {
        return diaTrabajoApellidoMaterno;
    }

    public void setDiaTrabajoApellidoMaterno(String diaTrabajoApellidoMaterno) {
        this.diaTrabajoApellidoMaterno = diaTrabajoApellidoMaterno;
    }

    public HoraIngreso getIdHoraIngreso() {
        return idHoraIngreso;
    }

    public void setIdHoraIngreso(HoraIngreso idHoraIngreso) {
        this.idHoraIngreso = idHoraIngreso;
    }

    public Responsable getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsable idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Sector getIdSector() {
        return idSector;
    }

    public void setIdSector(Sector idSector) {
        this.idSector = idSector;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public TransporteDiaTrabajo getIdTransporteDiaTrabajo() {
        return idTransporteDiaTrabajo;
    }

    public void setIdTransporteDiaTrabajo(TransporteDiaTrabajo idTransporteDiaTrabajo) {
        this.idTransporteDiaTrabajo = idTransporteDiaTrabajo;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public DiaTrabajoEstado getIdDiaTrabajoEstado() {
        return idDiaTrabajoEstado;
    }

    public void setIdDiaTrabajoEstado(DiaTrabajoEstado idDiaTrabajoEstado) {
        this.idDiaTrabajoEstado = idDiaTrabajoEstado;
    }

    public CausaIncidencia getIdCausaIncidencia() {
        return idCausaIncidencia;
    }

    public void setIdCausaIncidencia(CausaIncidencia idCausaIncidencia) {
        this.idCausaIncidencia = idCausaIncidencia;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaTrabajoPK != null ? diaTrabajoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaTrabajo)) {
            return false;
        }
        DiaTrabajo other = (DiaTrabajo) object;
        if ((this.diaTrabajoPK == null && other.diaTrabajoPK != null) || (this.diaTrabajoPK != null && !this.diaTrabajoPK.equals(other.diaTrabajoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.DiaTrabajo[ diaTrabajoPK=" + diaTrabajoPK + " ]";
    }
    
}
