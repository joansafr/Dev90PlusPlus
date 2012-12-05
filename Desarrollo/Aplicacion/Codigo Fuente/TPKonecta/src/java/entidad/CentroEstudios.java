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
@Table(name = "centro_estudios", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroEstudios.findAll", query = "SELECT c FROM CentroEstudios c"),
    @NamedQuery(name = "CentroEstudios.findByCentroEstudiosNombre", query = "SELECT c FROM CentroEstudios c WHERE c.centroEstudiosNombre = :centroEstudiosNombre"),
    @NamedQuery(name = "CentroEstudios.findByIdCentroEstudios", query = "SELECT c FROM CentroEstudios c WHERE c.idCentroEstudios = :idCentroEstudios")})
public class CentroEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "centro_estudios_nombre", length = 100)
    private String centroEstudiosNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_centro_estudios", nullable = false)
    private Integer idCentroEstudios;
    @OneToMany(mappedBy = "idCentroEstudios")
    private Collection<Personal> personalCollection;

    public CentroEstudios() {
    }

    public CentroEstudios(Integer idCentroEstudios) {
        this.idCentroEstudios = idCentroEstudios;
    }

    public String getCentroEstudiosNombre() {
        return centroEstudiosNombre;
    }

    public void setCentroEstudiosNombre(String centroEstudiosNombre) {
        this.centroEstudiosNombre = centroEstudiosNombre;
    }

    public Integer getIdCentroEstudios() {
        return idCentroEstudios;
    }

    public void setIdCentroEstudios(Integer idCentroEstudios) {
        this.idCentroEstudios = idCentroEstudios;
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
        hash += (idCentroEstudios != null ? idCentroEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroEstudios)) {
            return false;
        }
        CentroEstudios other = (CentroEstudios) object;
        if ((this.idCentroEstudios == null && other.idCentroEstudios != null) || (this.idCentroEstudios != null && !this.idCentroEstudios.equals(other.idCentroEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return centroEstudiosNombre;
    }
    
}
