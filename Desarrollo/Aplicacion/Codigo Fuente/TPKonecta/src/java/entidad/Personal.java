/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "personal", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.idPersonal = :idPersonal"),
    @NamedQuery(name = "Personal.findByPersonalCodigoPlanilla", query = "SELECT p FROM Personal p WHERE p.personalCodigoPlanilla = :personalCodigoPlanilla"),
    @NamedQuery(name = "Personal.findByPersonalCodigoFotocheck", query = "SELECT p FROM Personal p WHERE p.personalCodigoFotocheck = :personalCodigoFotocheck"),
    @NamedQuery(name = "Personal.findByPersonalNombre", query = "SELECT p FROM Personal p WHERE p.personalNombre = :personalNombre"),
    @NamedQuery(name = "Personal.findByPersonalApellidoPaterno", query = "SELECT p FROM Personal p WHERE p.personalApellidoPaterno = :personalApellidoPaterno"),
    @NamedQuery(name = "Personal.findByPersonalApellidoMaterno", query = "SELECT p FROM Personal p WHERE p.personalApellidoMaterno = :personalApellidoMaterno"),
    @NamedQuery(name = "Personal.findByPersonalUsuario", query = "SELECT p FROM Personal p WHERE p.personalUsuario = :personalUsuario"),
    @NamedQuery(name = "Personal.findByPersonalContrasena", query = "SELECT p FROM Personal p WHERE p.personalContrasena = :personalContrasena"),
    @NamedQuery(name = "Personal.findByPersonalCantidadHorasSemanal", query = "SELECT p FROM Personal p WHERE p.personalCantidadHorasSemanal = :personalCantidadHorasSemanal"),
    @NamedQuery(name = "Personal.findByPersonalConfianza", query = "SELECT p FROM Personal p WHERE p.personalConfianza = :personalConfianza"),
    @NamedQuery(name = "Personal.findByPersonalFechaIncorporacion", query = "SELECT p FROM Personal p WHERE p.personalFechaIncorporacion = :personalFechaIncorporacion"),
    @NamedQuery(name = "Personal.findByPersonalActividad", query = "SELECT p FROM Personal p WHERE p.personalActividad = :personalActividad"),
    @NamedQuery(name = "Personal.findByPersonalFechaBaja", query = "SELECT p FROM Personal p WHERE p.personalFechaBaja = :personalFechaBaja"),
    @NamedQuery(name = "Personal.findByPersonalFechaFormacion", query = "SELECT p FROM Personal p WHERE p.personalFechaFormacion = :personalFechaFormacion"),
    @NamedQuery(name = "Personal.findByPersonalFechaIngresoGestion", query = "SELECT p FROM Personal p WHERE p.personalFechaIngresoGestion = :personalFechaIngresoGestion"),
    @NamedQuery(name = "Personal.findByPersonalFechaNacimiento", query = "SELECT p FROM Personal p WHERE p.personalFechaNacimiento = :personalFechaNacimiento"),
    @NamedQuery(name = "Personal.findByPersonalSexo", query = "SELECT p FROM Personal p WHERE p.personalSexo = :personalSexo"),
    @NamedQuery(name = "Personal.findByPersonalCantidadHijos", query = "SELECT p FROM Personal p WHERE p.personalCantidadHijos = :personalCantidadHijos"),
    @NamedQuery(name = "Personal.findByPersonalDireccion", query = "SELECT p FROM Personal p WHERE p.personalDireccion = :personalDireccion"),
    @NamedQuery(name = "Personal.findByPersonalDireccionReferencia", query = "SELECT p FROM Personal p WHERE p.personalDireccionReferencia = :personalDireccionReferencia"),
    @NamedQuery(name = "Personal.findByPersonalTelefonoFijo", query = "SELECT p FROM Personal p WHERE p.personalTelefonoFijo = :personalTelefonoFijo"),
    @NamedQuery(name = "Personal.findByPersonalTelefonoMovil", query = "SELECT p FROM Personal p WHERE p.personalTelefonoMovil = :personalTelefonoMovil"),
    @NamedQuery(name = "Personal.findByPersonalEmail", query = "SELECT p FROM Personal p WHERE p.personalEmail = :personalEmail"),
    @NamedQuery(name = "Personal.findByPersonalHoraRefrigerioInicio", query = "SELECT p FROM Personal p WHERE p.personalHoraRefrigerioInicio = :personalHoraRefrigerioInicio"),
    @NamedQuery(name = "Personal.findByPersonalHoraRefrigerioDuracion", query = "SELECT p FROM Personal p WHERE p.personalHoraRefrigerioDuracion = :personalHoraRefrigerioDuracion"),
    @NamedQuery(name = "Personal.findByPersonalLatitude", query = "SELECT p FROM Personal p WHERE p.personalLatitude = :personalLatitude"),
    @NamedQuery(name = "Personal.findByPersonalLongitude", query = "SELECT p FROM Personal p WHERE p.personalLongitude = :personalLongitude"),
    @NamedQuery(name = "Personal.findByPersonalCantidadDiasSemanal", query = "SELECT p FROM Personal p WHERE p.personalCantidadDiasSemanal = :personalCantidadDiasSemanal"),
    @NamedQuery(name = "Personal.findByPersonalFechaVencimientoContrato", query = "SELECT p FROM Personal p WHERE p.personalFechaVencimientoContrato = :personalFechaVencimientoContrato")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "id_personal", nullable = false, length = 9)
    private String idPersonal;
    @Size(max = 20)
    @Column(name = "personal_codigo_planilla", length = 20)
    private String personalCodigoPlanilla;
    @Size(max = 20)
    @Column(name = "personal_codigo_fotocheck", length = 20)
    private String personalCodigoFotocheck;
    @Size(max = 50)
    @Column(name = "personal_nombre", length = 50)
    private String personalNombre;
    @Size(max = 50)
    @Column(name = "personal_apellido_paterno", length = 50)
    private String personalApellidoPaterno;
    @Size(max = 50)
    @Column(name = "personal_apellido_materno", length = 50)
    private String personalApellidoMaterno;
    @Size(max = 8)
    @Column(name = "personal_usuario", length = 8)
    private String personalUsuario;
    @Size(max = 16)
    @Column(name = "personal_contrasena", length = 16)
    private String personalContrasena;
    @Column(name = "personal_cantidad_horas_semanal")
    private Integer personalCantidadHorasSemanal;
    @Column(name = "personal_confianza")
    private Boolean personalConfianza;
    @Column(name = "personal_fecha_incorporacion")
    @Temporal(TemporalType.DATE)
    private Date personalFechaIncorporacion;
    @Column(name = "personal_actividad")
    private Boolean personalActividad;
    @Column(name = "personal_fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date personalFechaBaja;
    @Column(name = "personal_fecha_formacion")
    @Temporal(TemporalType.DATE)
    private Date personalFechaFormacion;
    @Column(name = "personal_fecha_ingreso_gestion")
    @Temporal(TemporalType.DATE)
    private Date personalFechaIngresoGestion;
    @Column(name = "personal_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date personalFechaNacimiento;
    @Column(name = "personal_sexo")
    private Boolean personalSexo;
    @Column(name = "personal_cantidad_hijos")
    private Integer personalCantidadHijos;
    @Size(max = 300)
    @Column(name = "personal_direccion", length = 300)
    private String personalDireccion;
    @Size(max = 200)
    @Column(name = "personal_direccion_referencia", length = 200)
    private String personalDireccionReferencia;
    @Size(max = 15)
    @Column(name = "personal_telefono_fijo", length = 15)
    private String personalTelefonoFijo;
    @Size(max = 15)
    @Column(name = "personal_telefono_movil", length = 15)
    private String personalTelefonoMovil;
    @Size(max = 100)
    @Column(name = "personal_email", length = 100)
    private String personalEmail;
    @Column(name = "personal_hora_refrigerio_inicio")
    @Temporal(TemporalType.TIME)
    private Date personalHoraRefrigerioInicio;
    @Column(name = "personal_hora_refrigerio_duracion")
    @Temporal(TemporalType.TIME)
    private Date personalHoraRefrigerioDuracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "personal_latitude", precision = 10, scale = 6)
    private Float personalLatitude;
    @Column(name = "personal_longitude", precision = 10, scale = 6)
    private Float personalLongitude;
    @Lob
    @Column(name = "personal_contrato")
    private byte[] personalContrato;
    @Column(name = "personal_cantidad_dias_semanal")
    private Integer personalCantidadDiasSemanal;
    @Column(name = "personal_fecha_vencimiento_contrato")
    @Temporal(TemporalType.DATE)
    private Date personalFechaVencimientoContrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonal")
    private Collection<PersonalLog> personalLogCollection;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne
    private Responsable idResponsable;
    @JoinColumn(name = "id_centro_estudios", referencedColumnName = "id_centro_estudios")
    @ManyToOne
    private CentroEstudios idCentroEstudios;
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    @ManyToOne
    private Carrera idCarrera;
    @JoinColumn(name = "id_nivel_educativo", referencedColumnName = "id_nivel_educativo")
    @ManyToOne
    private NivelEducativo idNivelEducativo;
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id_estado_civil")
    @ManyToOne
    private EstadoCivil idEstadoCivil;
    @JoinColumn(name = "id_grupo_formacion", referencedColumnName = "id_grupo_formacion")
    @ManyToOne
    private GrupoFormacion idGrupoFormacion;
    @JoinColumn(name = "id_motivo_baja", referencedColumnName = "id_motivo_baja")
    @ManyToOne
    private MotivoBaja idMotivoBaja;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne
    private Cargo idCargo;
    @JoinColumn(name = "id_hora_ingreso", referencedColumnName = "id_hora_ingreso")
    @ManyToOne
    private HoraIngreso idHoraIngreso;
    @JoinColumn(name = "id_sector", referencedColumnName = "id_sector")
    @ManyToOne
    private Sector idSector;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne
    private Departamento idDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private Collection<DiaTrabajo> diaTrabajoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private Collection<PersonalDiaDescanso> personalDiaDescansoCollection;

    public Personal() {
    }

    public Personal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getPersonalCodigoPlanilla() {
        return personalCodigoPlanilla;
    }

    public void setPersonalCodigoPlanilla(String personalCodigoPlanilla) {
        this.personalCodigoPlanilla = personalCodigoPlanilla;
    }

    public String getPersonalCodigoFotocheck() {
        return personalCodigoFotocheck;
    }

    public void setPersonalCodigoFotocheck(String personalCodigoFotocheck) {
        this.personalCodigoFotocheck = personalCodigoFotocheck;
    }

    public String getPersonalNombre() {
        return personalNombre;
    }

    public void setPersonalNombre(String personalNombre) {
        this.personalNombre = personalNombre;
    }

    public String getPersonalApellidoPaterno() {
        return personalApellidoPaterno;
    }

    public void setPersonalApellidoPaterno(String personalApellidoPaterno) {
        this.personalApellidoPaterno = personalApellidoPaterno;
    }

    public String getPersonalApellidoMaterno() {
        return personalApellidoMaterno;
    }

    public void setPersonalApellidoMaterno(String personalApellidoMaterno) {
        this.personalApellidoMaterno = personalApellidoMaterno;
    }

    public String getPersonalUsuario() {
        return personalUsuario;
    }

    public void setPersonalUsuario(String personalUsuario) {
        this.personalUsuario = personalUsuario;
    }

    public String getPersonalContrasena() {
        return personalContrasena;
    }

    public void setPersonalContrasena(String personalContrasena) {
        this.personalContrasena = personalContrasena;
    }

    public Integer getPersonalCantidadHorasSemanal() {
        return personalCantidadHorasSemanal;
    }

    public void setPersonalCantidadHorasSemanal(Integer personalCantidadHorasSemanal) {
        this.personalCantidadHorasSemanal = personalCantidadHorasSemanal;
    }

    public Boolean getPersonalConfianza() {
        return personalConfianza;
    }

    public void setPersonalConfianza(Boolean personalConfianza) {
        this.personalConfianza = personalConfianza;
    }

    public Date getPersonalFechaIncorporacion() {
        return personalFechaIncorporacion;
    }

    public void setPersonalFechaIncorporacion(Date personalFechaIncorporacion) {
        this.personalFechaIncorporacion = personalFechaIncorporacion;
    }

    public Boolean getPersonalActividad() {
        return personalActividad;
    }

    public void setPersonalActividad(Boolean personalActividad) {
        this.personalActividad = personalActividad;
    }

    public Date getPersonalFechaBaja() {
        return personalFechaBaja;
    }

    public void setPersonalFechaBaja(Date personalFechaBaja) {
        this.personalFechaBaja = personalFechaBaja;
    }

    public Date getPersonalFechaFormacion() {
        return personalFechaFormacion;
    }

    public void setPersonalFechaFormacion(Date personalFechaFormacion) {
        this.personalFechaFormacion = personalFechaFormacion;
    }

    public Date getPersonalFechaIngresoGestion() {
        return personalFechaIngresoGestion;
    }

    public void setPersonalFechaIngresoGestion(Date personalFechaIngresoGestion) {
        this.personalFechaIngresoGestion = personalFechaIngresoGestion;
    }

    public Date getPersonalFechaNacimiento() {
        return personalFechaNacimiento;
    }

    public void setPersonalFechaNacimiento(Date personalFechaNacimiento) {
        this.personalFechaNacimiento = personalFechaNacimiento;
    }

    public Boolean getPersonalSexo() {
        return personalSexo;
    }

    public void setPersonalSexo(Boolean personalSexo) {
        this.personalSexo = personalSexo;
    }

    public Integer getPersonalCantidadHijos() {
        return personalCantidadHijos;
    }

    public void setPersonalCantidadHijos(Integer personalCantidadHijos) {
        this.personalCantidadHijos = personalCantidadHijos;
    }

    public String getPersonalDireccion() {
        return personalDireccion;
    }

    public void setPersonalDireccion(String personalDireccion) {
        this.personalDireccion = personalDireccion;
    }

    public String getPersonalDireccionReferencia() {
        return personalDireccionReferencia;
    }

    public void setPersonalDireccionReferencia(String personalDireccionReferencia) {
        this.personalDireccionReferencia = personalDireccionReferencia;
    }

    public String getPersonalTelefonoFijo() {
        return personalTelefonoFijo;
    }

    public void setPersonalTelefonoFijo(String personalTelefonoFijo) {
        this.personalTelefonoFijo = personalTelefonoFijo;
    }

    public String getPersonalTelefonoMovil() {
        return personalTelefonoMovil;
    }

    public void setPersonalTelefonoMovil(String personalTelefonoMovil) {
        this.personalTelefonoMovil = personalTelefonoMovil;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public Date getPersonalHoraRefrigerioInicio() {
        return personalHoraRefrigerioInicio;
    }

    public void setPersonalHoraRefrigerioInicio(Date personalHoraRefrigerioInicio) {
        this.personalHoraRefrigerioInicio = personalHoraRefrigerioInicio;
    }

    public Date getPersonalHoraRefrigerioDuracion() {
        return personalHoraRefrigerioDuracion;
    }

    public void setPersonalHoraRefrigerioDuracion(Date personalHoraRefrigerioDuracion) {
        this.personalHoraRefrigerioDuracion = personalHoraRefrigerioDuracion;
    }

    public Float getPersonalLatitude() {
        return personalLatitude;
    }

    public void setPersonalLatitude(Float personalLatitude) {
        this.personalLatitude = personalLatitude;
    }

    public Float getPersonalLongitude() {
        return personalLongitude;
    }

    public void setPersonalLongitude(Float personalLongitude) {
        this.personalLongitude = personalLongitude;
    }

    public byte[] getPersonalContrato() {
        return personalContrato;
    }

    public void setPersonalContrato(byte[] personalContrato) {
        this.personalContrato = personalContrato;
    }

    public Integer getPersonalCantidadDiasSemanal() {
        return personalCantidadDiasSemanal;
    }

    public void setPersonalCantidadDiasSemanal(Integer personalCantidadDiasSemanal) {
        this.personalCantidadDiasSemanal = personalCantidadDiasSemanal;
    }

    public Date getPersonalFechaVencimientoContrato() {
        return personalFechaVencimientoContrato;
    }

    public void setPersonalFechaVencimientoContrato(Date personalFechaVencimientoContrato) {
        this.personalFechaVencimientoContrato = personalFechaVencimientoContrato;
    }

    @XmlTransient
    public Collection<PersonalLog> getPersonalLogCollection() {
        return personalLogCollection;
    }

    public void setPersonalLogCollection(Collection<PersonalLog> personalLogCollection) {
        this.personalLogCollection = personalLogCollection;
    }

    public Responsable getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsable idResponsable) {
        this.idResponsable = idResponsable;
    }

    public CentroEstudios getIdCentroEstudios() {
        return idCentroEstudios;
    }

    public void setIdCentroEstudios(CentroEstudios idCentroEstudios) {
        this.idCentroEstudios = idCentroEstudios;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public NivelEducativo getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(NivelEducativo idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public EstadoCivil getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public GrupoFormacion getIdGrupoFormacion() {
        return idGrupoFormacion;
    }

    public void setIdGrupoFormacion(GrupoFormacion idGrupoFormacion) {
        this.idGrupoFormacion = idGrupoFormacion;
    }

    public MotivoBaja getIdMotivoBaja() {
        return idMotivoBaja;
    }

    public void setIdMotivoBaja(MotivoBaja idMotivoBaja) {
        this.idMotivoBaja = idMotivoBaja;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public HoraIngreso getIdHoraIngreso() {
        return idHoraIngreso;
    }

    public void setIdHoraIngreso(HoraIngreso idHoraIngreso) {
        this.idHoraIngreso = idHoraIngreso;
    }

    public Sector getIdSector() {
        return idSector;
    }

    public void setIdSector(Sector idSector) {
        this.idSector = idSector;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @XmlTransient
    public Collection<DiaTrabajo> getDiaTrabajoCollection() {
        return diaTrabajoCollection;
    }

    public void setDiaTrabajoCollection(Collection<DiaTrabajo> diaTrabajoCollection) {
        this.diaTrabajoCollection = diaTrabajoCollection;
    }

    @XmlTransient
    public Collection<PersonalDiaDescanso> getPersonalDiaDescansoCollection() {
        return personalDiaDescansoCollection;
    }

    public void setPersonalDiaDescansoCollection(Collection<PersonalDiaDescanso> personalDiaDescansoCollection) {
        this.personalDiaDescansoCollection = personalDiaDescansoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPersonal;
    }
    
}
