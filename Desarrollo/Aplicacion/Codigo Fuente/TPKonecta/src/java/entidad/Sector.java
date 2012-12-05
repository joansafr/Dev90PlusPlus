/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
@Table(name = "sector", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s"),
    @NamedQuery(name = "Sector.findBySectorNombre", query = "SELECT s FROM Sector s WHERE s.sectorNombre = :sectorNombre"),
    @NamedQuery(name = "Sector.findBySectorLatitude", query = "SELECT s FROM Sector s WHERE s.sectorLatitude = :sectorLatitude"),
    @NamedQuery(name = "Sector.findBySectorLongitude", query = "SELECT s FROM Sector s WHERE s.sectorLongitude = :sectorLongitude"),
    @NamedQuery(name = "Sector.findBySectorCosto", query = "SELECT s FROM Sector s WHERE s.sectorCosto = :sectorCosto"),
    @NamedQuery(name = "Sector.findByIdSector", query = "SELECT s FROM Sector s WHERE s.idSector = :idSector")})
public class Sector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "sector_nombre", length = 50)
    private String sectorNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sector_latitude", precision = 10, scale = 6)
    private Float sectorLatitude;
    @Column(name = "sector_longitude", precision = 10, scale = 6)
    private Float sectorLongitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sector_costo", nullable = false, precision = 7, scale = 3)
    private BigDecimal sectorCosto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sector", nullable = false)
    private Integer idSector;
    @JoinColumn(name = "id_distrito", referencedColumnName = "id_distrito")
    @ManyToOne
    private Distrito idDistrito;
    @JoinColumn(name = "id_cono", referencedColumnName = "id_cono")
    @ManyToOne
    private Cono idCono;
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id_tipo_vehiculo")
    @ManyToOne
    private TipoVehiculo idTipoVehiculo;
    @OneToMany(mappedBy = "idSector")
    private Collection<Personal> personalCollection;
    @OneToMany(mappedBy = "idSector")
    private Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection;
    @OneToMany(mappedBy = "idSector")
    private Collection<DiaTrabajo> diaTrabajoCollection;

    public Sector() {
    }

    public Sector(Integer idSector) {
        this.idSector = idSector;
    }

    public Sector(Integer idSector, BigDecimal sectorCosto) {
        this.idSector = idSector;
        this.sectorCosto = sectorCosto;
    }

    public String getSectorNombre() {
        return sectorNombre;
    }

    public void setSectorNombre(String sectorNombre) {
        this.sectorNombre = sectorNombre;
    }

    public Float getSectorLatitude() {
        return sectorLatitude;
    }

    public void setSectorLatitude(Float sectorLatitude) {
        this.sectorLatitude = sectorLatitude;
    }

    public Float getSectorLongitude() {
        return sectorLongitude;
    }

    public void setSectorLongitude(Float sectorLongitude) {
        this.sectorLongitude = sectorLongitude;
    }

    public BigDecimal getSectorCosto() {
        return sectorCosto;
    }

    public void setSectorCosto(BigDecimal sectorCosto) {
        this.sectorCosto = sectorCosto;
    }

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

    public Distrito getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Distrito idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Cono getIdCono() {
        return idCono;
    }

    public void setIdCono(Cono idCono) {
        this.idCono = idCono;
    }
    public TipoVehiculo getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    @XmlTransient
    public Collection<TransporteDiaTrabajo> getTransporteDiaTrabajoCollection() {
        return transporteDiaTrabajoCollection;
    }

    public void setTransporteDiaTrabajoCollection(Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection) {
        this.transporteDiaTrabajoCollection = transporteDiaTrabajoCollection;
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
        hash += (idSector != null ? idSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idSector == null && other.idSector != null) || (this.idSector != null && !this.idSector.equals(other.idSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sectorNombre;
    }
    
}
