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
@Table(name = "grupo_formacion", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoFormacion.findAll", query = "SELECT g FROM GrupoFormacion g"),
    @NamedQuery(name = "GrupoFormacion.findByGrupoFormacionNombre", query = "SELECT g FROM GrupoFormacion g WHERE g.grupoFormacionNombre = :grupoFormacionNombre"),
    @NamedQuery(name = "GrupoFormacion.findByIdGrupoFormacion", query = "SELECT g FROM GrupoFormacion g WHERE g.idGrupoFormacion = :idGrupoFormacion")})
public class GrupoFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "grupo_formacion_nombre", length = 20)
    private String grupoFormacionNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupo_formacion", nullable = false)
    private Integer idGrupoFormacion;
    @OneToMany(mappedBy = "idGrupoFormacion")
    private Collection<Personal> personalCollection;

    public GrupoFormacion() {
    }

    public GrupoFormacion(Integer idGrupoFormacion) {
        this.idGrupoFormacion = idGrupoFormacion;
    }

    public String getGrupoFormacionNombre() {
        return grupoFormacionNombre;
    }

    public void setGrupoFormacionNombre(String grupoFormacionNombre) {
        this.grupoFormacionNombre = grupoFormacionNombre;
    }

    public Integer getIdGrupoFormacion() {
        return idGrupoFormacion;
    }

    public void setIdGrupoFormacion(Integer idGrupoFormacion) {
        this.idGrupoFormacion = idGrupoFormacion;
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
        hash += (idGrupoFormacion != null ? idGrupoFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoFormacion)) {
            return false;
        }
        GrupoFormacion other = (GrupoFormacion) object;
        if ((this.idGrupoFormacion == null && other.idGrupoFormacion != null) || (this.idGrupoFormacion != null && !this.idGrupoFormacion.equals(other.idGrupoFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return grupoFormacionNombre;
    }
    
}
