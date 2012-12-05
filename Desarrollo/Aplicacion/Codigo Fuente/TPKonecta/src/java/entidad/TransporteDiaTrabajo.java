/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
@Table(name = "transporte_dia_trabajo", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransporteDiaTrabajo.findAll", query = "SELECT t FROM TransporteDiaTrabajo t"),
    @NamedQuery(name = "TransporteDiaTrabajo.findByTransporteDiaTrabajoCantidadPersonas", query = "SELECT t FROM TransporteDiaTrabajo t WHERE t.transporteDiaTrabajoCantidadPersonas = :transporteDiaTrabajoCantidadPersonas"),
    @NamedQuery(name = "TransporteDiaTrabajo.findByTransporteDiaTrabajoPlaca", query = "SELECT t FROM TransporteDiaTrabajo t WHERE t.transporteDiaTrabajoPlaca = :transporteDiaTrabajoPlaca"),
    @NamedQuery(name = "TransporteDiaTrabajo.findByIdTransporteDiaTrabajo", query = "SELECT t FROM TransporteDiaTrabajo t WHERE t.idTransporteDiaTrabajo = :idTransporteDiaTrabajo"),
    @NamedQuery(name = "TransporteDiaTrabajo.findByTransporteDiaTrabajoObservaciones", query = "SELECT t FROM TransporteDiaTrabajo t WHERE t.transporteDiaTrabajoObservaciones = :transporteDiaTrabajoObservaciones"),
    @NamedQuery(name = "TransporteDiaTrabajo.findByTransporteDiaTrabajoFecha", query = "SELECT t FROM TransporteDiaTrabajo t WHERE t.transporteDiaTrabajoFecha = :transporteDiaTrabajoFecha"),
    @NamedQuery(name = "TransporteDiaTrabajo.findByTransporteDiaTrabajoCostoTotal", query = "SELECT t FROM TransporteDiaTrabajo t WHERE t.transporteDiaTrabajoCostoTotal = :transporteDiaTrabajoCostoTotal"),
    @NamedQuery(name = "TransporteDiaTrabajo.findByTransporteDiaTrabajoCostoPorPersona", query = "SELECT t FROM TransporteDiaTrabajo t WHERE t.transporteDiaTrabajoCostoPorPersona = :transporteDiaTrabajoCostoPorPersona")})
public class TransporteDiaTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "transporte_dia_trabajo_cantidad_personas")
    private Integer transporteDiaTrabajoCantidadPersonas;
    @Size(max = 7)
    @Column(name = "transporte_dia_trabajo_placa", length = 7)
    private String transporteDiaTrabajoPlaca;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transporte_dia_trabajo", nullable = false)
    private Long idTransporteDiaTrabajo;
    @Size(max = 500)
    @Column(name = "transporte_dia_trabajo_observaciones", length = 500)
    private String transporteDiaTrabajoObservaciones;
    @Column(name = "transporte_dia_trabajo_fecha")
    @Temporal(TemporalType.DATE)
    private Date transporteDiaTrabajoFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "transporte_dia_trabajo_costo_total", precision = 7, scale = 3)
    private BigDecimal transporteDiaTrabajoCostoTotal;
    @Column(name = "transporte_dia_trabajo_costo_por_persona", precision = 7, scale = 3)
    private BigDecimal transporteDiaTrabajoCostoPorPersona;
    @JoinColumn(name = "id_tiempo_demora", referencedColumnName = "id_tiempo_demora")
    @ManyToOne
    private TiempoDemora idTiempoDemora;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne
    private Proveedor idProveedor;
    @JoinColumn(name = "id_hora_ingreso", referencedColumnName = "id_hora_ingreso")
    @ManyToOne
    private HoraIngreso idHoraIngreso;
    @JoinColumn(name = "id_sector", referencedColumnName = "id_sector")
    @ManyToOne
    private Sector idSector;
    @JoinColumn(name = "id_padron", referencedColumnName = "id_padron")
    @ManyToOne
    private Padron idPadron;
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id_tipo_vehiculo")
    @ManyToOne
    private TipoVehiculo idTipoVehiculo;
    @JoinColumn(name = "id_causa_demora", referencedColumnName = "id_causa_demora")
    @ManyToOne
    private CausaDemora idCausaDemora;
    @OneToMany(mappedBy = "idTransporteDiaTrabajo")
    private Collection<DiaTrabajo> diaTrabajoCollection;

    public TransporteDiaTrabajo() {
    }

    public TransporteDiaTrabajo(Long idTransporteDiaTrabajo) {
        this.idTransporteDiaTrabajo = idTransporteDiaTrabajo;
    }

    public Integer getTransporteDiaTrabajoCantidadPersonas() {
        return transporteDiaTrabajoCantidadPersonas;
    }

    public void setTransporteDiaTrabajoCantidadPersonas(Integer transporteDiaTrabajoCantidadPersonas) {
        this.transporteDiaTrabajoCantidadPersonas = transporteDiaTrabajoCantidadPersonas;
    }

    public String getTransporteDiaTrabajoPlaca() {
        return transporteDiaTrabajoPlaca;
    }

    public void setTransporteDiaTrabajoPlaca(String transporteDiaTrabajoPlaca) {
        this.transporteDiaTrabajoPlaca = transporteDiaTrabajoPlaca;
    }

    public Long getIdTransporteDiaTrabajo() {
        return idTransporteDiaTrabajo;
    }

    public void setIdTransporteDiaTrabajo(Long idTransporteDiaTrabajo) {
        this.idTransporteDiaTrabajo = idTransporteDiaTrabajo;
    }

    public String getTransporteDiaTrabajoObservaciones() {
        return transporteDiaTrabajoObservaciones;
    }

    public void setTransporteDiaTrabajoObservaciones(String transporteDiaTrabajoObservaciones) {
        this.transporteDiaTrabajoObservaciones = transporteDiaTrabajoObservaciones;
    }

    public Date getTransporteDiaTrabajoFecha() {
        return transporteDiaTrabajoFecha;
    }

    public void setTransporteDiaTrabajoFecha(Date transporteDiaTrabajoFecha) {
        this.transporteDiaTrabajoFecha = transporteDiaTrabajoFecha;
    }

    public BigDecimal getTransporteDiaTrabajoCostoTotal() {
        return transporteDiaTrabajoCostoTotal;
    }

    public void setTransporteDiaTrabajoCostoTotal(BigDecimal transporteDiaTrabajoCostoTotal) {
        this.transporteDiaTrabajoCostoTotal = transporteDiaTrabajoCostoTotal;
    }

    public BigDecimal getTransporteDiaTrabajoCostoPorPersona() {
        return transporteDiaTrabajoCostoPorPersona;
    }

    public void setTransporteDiaTrabajoCostoPorPersona(BigDecimal transporteDiaTrabajoCostoPorPersona) {
        this.transporteDiaTrabajoCostoPorPersona = transporteDiaTrabajoCostoPorPersona;
    }

    public TiempoDemora getIdTiempoDemora() {
        return idTiempoDemora;
    }

    public void setIdTiempoDemora(TiempoDemora idTiempoDemora) {
        this.idTiempoDemora = idTiempoDemora;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
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

    public Padron getIdPadron() {
        return idPadron;
    }

    public void setIdPadron(Padron idPadron) {
        this.idPadron = idPadron;
    }

    public TipoVehiculo getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public CausaDemora getIdCausaDemora() {
        return idCausaDemora;
    }

    public void setIdCausaDemora(CausaDemora idCausaDemora) {
        this.idCausaDemora = idCausaDemora;
    }

    @XmlTransient
    public Collection<DiaTrabajo> getDiaTrabajoCollection() {
        return diaTrabajoCollection;
    }

    public void setDiaTrabajoCollection(Collection<DiaTrabajo> diaTrabajoCollection) {
        this.diaTrabajoCollection = diaTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransporteDiaTrabajo != null ? idTransporteDiaTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransporteDiaTrabajo)) {
            return false;
        }
        TransporteDiaTrabajo other = (TransporteDiaTrabajo) object;
        if ((this.idTransporteDiaTrabajo == null && other.idTransporteDiaTrabajo != null) || (this.idTransporteDiaTrabajo != null && !this.idTransporteDiaTrabajo.equals(other.idTransporteDiaTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat  parserSDF=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat  parserSDF2=new SimpleDateFormat("HH:mm");
        try{
        return idTransporteDiaTrabajo.toString() + ". "+(transporteDiaTrabajoFecha == null? "":parserSDF.format(transporteDiaTrabajoFecha))+" - "+(idHoraIngreso == null? "":parserSDF2.format(idHoraIngreso.getIdHoraIngreso()));
        }
        catch(Exception ex1){
            return idTransporteDiaTrabajo.toString() + ". ";
        }
    }
    
}
