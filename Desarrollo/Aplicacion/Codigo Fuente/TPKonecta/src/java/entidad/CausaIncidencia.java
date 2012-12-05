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
@Table(name = "causa_incidencia", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CausaIncidencia.findAll", query = "SELECT c FROM CausaIncidencia c"),
    @NamedQuery(name = "CausaIncidencia.findByIdCausaIncidencia", query = "SELECT c FROM CausaIncidencia c WHERE c.idCausaIncidencia = :idCausaIncidencia"),
    @NamedQuery(name = "CausaIncidencia.findByCausaIncidenciaNombre", query = "SELECT c FROM CausaIncidencia c WHERE c.causaIncidenciaNombre = :causaIncidenciaNombre")})
public class CausaIncidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_causa_incidencia", nullable = false)
    private Integer idCausaIncidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "causa_incidencia_nombre", nullable = false, length = 100)
    private String causaIncidenciaNombre;
    @OneToMany(mappedBy = "idCausaIncidencia")
    private Collection<DiaTrabajo> diaTrabajoCollection;

    public CausaIncidencia() {
    }

    public CausaIncidencia(Integer idCausaIncidencia) {
        this.idCausaIncidencia = idCausaIncidencia;
    }

    public CausaIncidencia(Integer idCausaIncidencia, String causaIncidenciaNombre) {
        this.idCausaIncidencia = idCausaIncidencia;
        this.causaIncidenciaNombre = causaIncidenciaNombre;
    }

    public Integer getIdCausaIncidencia() {
        return idCausaIncidencia;
    }

    public void setIdCausaIncidencia(Integer idCausaIncidencia) {
        this.idCausaIncidencia = idCausaIncidencia;
    }

    public String getCausaIncidenciaNombre() {
        return causaIncidenciaNombre;
    }

    public void setCausaIncidenciaNombre(String causaIncidenciaNombre) {
        this.causaIncidenciaNombre = causaIncidenciaNombre;
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
        hash += (idCausaIncidencia != null ? idCausaIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CausaIncidencia)) {
            return false;
        }
        CausaIncidencia other = (CausaIncidencia) object;
        if ((this.idCausaIncidencia == null && other.idCausaIncidencia != null) || (this.idCausaIncidencia != null && !this.idCausaIncidencia.equals(other.idCausaIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return causaIncidenciaNombre;
    }
    
}
