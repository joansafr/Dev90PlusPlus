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
@Table(name = "campana", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campana.findAll", query = "SELECT c FROM Campana c"),
    @NamedQuery(name = "Campana.findByCampanaNombre", query = "SELECT c FROM Campana c WHERE c.campanaNombre = :campanaNombre"),
    @NamedQuery(name = "Campana.findByIdCampana", query = "SELECT c FROM Campana c WHERE c.idCampana = :idCampana")})
public class Campana implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "campana_nombre", length = 50)
    private String campanaNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_campana", nullable = false)
    private Integer idCampana;
    @OneToMany(mappedBy = "idCampana")
    private Collection<Segmento> segmentoCollection;

    public Campana() {
    }

    public Campana(Integer idCampana) {
        this.idCampana = idCampana;
    }

    public String getCampanaNombre() {
        return campanaNombre;
    }

    public void setCampanaNombre(String campanaNombre) {
        this.campanaNombre = campanaNombre;
    }

    public Integer getIdCampana() {
        return idCampana;
    }

    public void setIdCampana(Integer idCampana) {
        this.idCampana = idCampana;
    }

    @XmlTransient
    public Collection<Segmento> getSegmentoCollection() {
        return segmentoCollection;
    }

    public void setSegmentoCollection(Collection<Segmento> segmentoCollection) {
        this.segmentoCollection = segmentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampana != null ? idCampana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campana)) {
            return false;
        }
        Campana other = (Campana) object;
        if ((this.idCampana == null && other.idCampana != null) || (this.idCampana != null && !this.idCampana.equals(other.idCampana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return campanaNombre;
    }
    
}
