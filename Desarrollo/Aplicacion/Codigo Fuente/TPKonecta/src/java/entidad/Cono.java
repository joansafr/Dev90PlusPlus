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
@Table(name = "cono", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cono.findAll", query = "SELECT c FROM Cono c"),
    @NamedQuery(name = "Cono.findByConoNombre", query = "SELECT c FROM Cono c WHERE c.conoNombre = :conoNombre"),
    @NamedQuery(name = "Cono.findByIdCono", query = "SELECT c FROM Cono c WHERE c.idCono = :idCono")})
public class Cono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "cono_nombre", length = 20)
    private String conoNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cono", nullable = false)
    private Integer idCono;
    @OneToMany(mappedBy = "idCono")
    private Collection<Sector> sectorCollection;

    public Cono() {
    }

    public Cono(Integer idCono) {
        this.idCono = idCono;
    }

    public String getConoNombre() {
        return conoNombre;
    }

    public void setConoNombre(String conoNombre) {
        this.conoNombre = conoNombre;
    }

    public Integer getIdCono() {
        return idCono;
    }

    public void setIdCono(Integer idCono) {
        this.idCono = idCono;
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
        hash += (idCono != null ? idCono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cono)) {
            return false;
        }
        Cono other = (Cono) object;
        if ((this.idCono == null && other.idCono != null) || (this.idCono != null && !this.idCono.equals(other.idCono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return conoNombre;
    }
    
}
