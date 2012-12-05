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
@Table(name = "dia_trabajo_estado", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaTrabajoEstado.findAll", query = "SELECT d FROM DiaTrabajoEstado d"),
    @NamedQuery(name = "DiaTrabajoEstado.findByDiaTrabajoEstadoNombre", query = "SELECT d FROM DiaTrabajoEstado d WHERE d.diaTrabajoEstadoNombre = :diaTrabajoEstadoNombre"),
    @NamedQuery(name = "DiaTrabajoEstado.findByIdDiaTrabajoEstado", query = "SELECT d FROM DiaTrabajoEstado d WHERE d.idDiaTrabajoEstado = :idDiaTrabajoEstado")})
public class DiaTrabajoEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "dia_trabajo_estado_nombre", length = 50)
    private String diaTrabajoEstadoNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dia_trabajo_estado", nullable = false)
    private Integer idDiaTrabajoEstado;
    @OneToMany(mappedBy = "idDiaTrabajoEstado")
    private Collection<DiaTrabajo> diaTrabajoCollection;

    public DiaTrabajoEstado() {
    }

    public DiaTrabajoEstado(Integer idDiaTrabajoEstado) {
        this.idDiaTrabajoEstado = idDiaTrabajoEstado;
    }

    public String getDiaTrabajoEstadoNombre() {
        return diaTrabajoEstadoNombre;
    }

    public void setDiaTrabajoEstadoNombre(String diaTrabajoEstadoNombre) {
        this.diaTrabajoEstadoNombre = diaTrabajoEstadoNombre;
    }

    public Integer getIdDiaTrabajoEstado() {
        return idDiaTrabajoEstado;
    }

    public void setIdDiaTrabajoEstado(Integer idDiaTrabajoEstado) {
        this.idDiaTrabajoEstado = idDiaTrabajoEstado;
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
        hash += (idDiaTrabajoEstado != null ? idDiaTrabajoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaTrabajoEstado)) {
            return false;
        }
        DiaTrabajoEstado other = (DiaTrabajoEstado) object;
        if ((this.idDiaTrabajoEstado == null && other.idDiaTrabajoEstado != null) || (this.idDiaTrabajoEstado != null && !this.idDiaTrabajoEstado.equals(other.idDiaTrabajoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return diaTrabajoEstadoNombre;
    }
    
}
