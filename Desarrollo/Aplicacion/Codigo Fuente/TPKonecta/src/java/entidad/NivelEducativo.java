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
@Table(name = "nivel_educativo", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEducativo.findAll", query = "SELECT n FROM NivelEducativo n"),
    @NamedQuery(name = "NivelEducativo.findByNivelEducativoNombre", query = "SELECT n FROM NivelEducativo n WHERE n.nivelEducativoNombre = :nivelEducativoNombre"),
    @NamedQuery(name = "NivelEducativo.findByIdNivelEducativo", query = "SELECT n FROM NivelEducativo n WHERE n.idNivelEducativo = :idNivelEducativo")})
public class NivelEducativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "nivel_educativo_nombre", length = 50)
    private String nivelEducativoNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel_educativo", nullable = false)
    private Integer idNivelEducativo;
    @OneToMany(mappedBy = "idNivelEducativo")
    private Collection<Personal> personalCollection;

    public NivelEducativo() {
    }

    public NivelEducativo(Integer idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public String getNivelEducativoNombre() {
        return nivelEducativoNombre;
    }

    public void setNivelEducativoNombre(String nivelEducativoNombre) {
        this.nivelEducativoNombre = nivelEducativoNombre;
    }

    public Integer getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(Integer idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelEducativo != null ? idNivelEducativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEducativo)) {
            return false;
        }
        NivelEducativo other = (NivelEducativo) object;
        if ((this.idNivelEducativo == null && other.idNivelEducativo != null) || (this.idNivelEducativo != null && !this.idNivelEducativo.equals(other.idNivelEducativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nivelEducativoNombre;
    }
    
}
