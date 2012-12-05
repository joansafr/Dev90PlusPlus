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
@Table(name = "segmento", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Segmento.findAll", query = "SELECT s FROM Segmento s"),
    @NamedQuery(name = "Segmento.findBySegmentoNombre", query = "SELECT s FROM Segmento s WHERE s.segmentoNombre = :segmentoNombre"),
    @NamedQuery(name = "Segmento.findByIdSegmento", query = "SELECT s FROM Segmento s WHERE s.idSegmento = :idSegmento")})
public class Segmento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "segmento_nombre", length = 50)
    private String segmentoNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_segmento", nullable = false)
    private Integer idSegmento;
    @OneToMany(mappedBy = "idSegmento")
    private Collection<Servicio> servicioCollection;
    @JoinColumn(name = "id_campana", referencedColumnName = "id_campana")
    @ManyToOne
    private Campana idCampana;

    public Segmento() {
    }

    public Segmento(Integer idSegmento) {
        this.idSegmento = idSegmento;
    }

    public String getSegmentoNombre() {
        return segmentoNombre;
    }

    public void setSegmentoNombre(String segmentoNombre) {
        this.segmentoNombre = segmentoNombre;
    }

    public Integer getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(Integer idSegmento) {
        this.idSegmento = idSegmento;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    public Campana getIdCampana() {
        return idCampana;
    }

    public void setIdCampana(Campana idCampana) {
        this.idCampana = idCampana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSegmento != null ? idSegmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Segmento)) {
            return false;
        }
        Segmento other = (Segmento) object;
        if ((this.idSegmento == null && other.idSegmento != null) || (this.idSegmento != null && !this.idSegmento.equals(other.idSegmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return segmentoNombre;
    }
    
}
