/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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
@Table(name = "tipo_vehiculo", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVehiculo.findAll", query = "SELECT t FROM TipoVehiculo t"),
    @NamedQuery(name = "TipoVehiculo.findByTipoVehiculoNombre", query = "SELECT t FROM TipoVehiculo t WHERE t.tipoVehiculoNombre = :tipoVehiculoNombre"),
    @NamedQuery(name = "TipoVehiculo.findByTipoVehiculoCantidadPersonas", query = "SELECT t FROM TipoVehiculo t WHERE t.tipoVehiculoCantidadPersonas = :tipoVehiculoCantidadPersonas"),
    @NamedQuery(name = "TipoVehiculo.findByIdTipoVehiculo", query = "SELECT t FROM TipoVehiculo t WHERE t.idTipoVehiculo = :idTipoVehiculo")})
public class TipoVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "tipo_vehiculo_nombre", length = 50)
    private String tipoVehiculoNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_vehiculo_cantidad_personas", nullable = false)
    private int tipoVehiculoCantidadPersonas;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_vehiculo", nullable = false)
    private Integer idTipoVehiculo;
    @OneToMany(mappedBy = "idTipoVehiculo")
    private Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection;
    @OneToMany(mappedBy = "idTipoVehiculo")
    private Collection<Sector> sectorCollection;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public TipoVehiculo(Integer idTipoVehiculo, int tipoVehiculoCantidadPersonas) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.tipoVehiculoCantidadPersonas = tipoVehiculoCantidadPersonas;
    }

    public String getTipoVehiculoNombre() {
        return tipoVehiculoNombre;
    }

    public void setTipoVehiculoNombre(String tipoVehiculoNombre) {
        this.tipoVehiculoNombre = tipoVehiculoNombre;
    }

    public int getTipoVehiculoCantidadPersonas() {
        return tipoVehiculoCantidadPersonas;
    }

    public void setTipoVehiculoCantidadPersonas(int tipoVehiculoCantidadPersonas) {
        this.tipoVehiculoCantidadPersonas = tipoVehiculoCantidadPersonas;
    }

    public Integer getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    @XmlTransient
    public Collection<TransporteDiaTrabajo> getTransporteDiaTrabajoCollection() {
        return transporteDiaTrabajoCollection;
    }

    public void setTransporteDiaTrabajoCollection(Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection) {
        this.transporteDiaTrabajoCollection = transporteDiaTrabajoCollection;
    }
    
    @XmlTransient
    public Collection<Sector> getSectorCollection() {
        return sectorCollection;
    }

    public void setSectorCollection(Collection<Sector> sectorCollection) {
        this.sectorCollection = sectorCollection;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVehiculo != null ? idTipoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVehiculo)) {
            return false;
        }
        TipoVehiculo other = (TipoVehiculo) object;
        if ((this.idTipoVehiculo == null && other.idTipoVehiculo != null) || (this.idTipoVehiculo != null && !this.idTipoVehiculo.equals(other.idTipoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoVehiculoNombre+": para "+tipoVehiculoCantidadPersonas+" personas.";
    }
    
}
