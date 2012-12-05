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
@Table(name = "causa_demora", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CausaDemora.findAll", query = "SELECT c FROM CausaDemora c"),
    @NamedQuery(name = "CausaDemora.findByIdCausaDemora", query = "SELECT c FROM CausaDemora c WHERE c.idCausaDemora = :idCausaDemora"),
    @NamedQuery(name = "CausaDemora.findByCausaDemoraNombre", query = "SELECT c FROM CausaDemora c WHERE c.causaDemoraNombre = :causaDemoraNombre")})
public class CausaDemora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_causa_demora", nullable = false)
    private Integer idCausaDemora;
    @Size(max = 100)
    @Column(name = "causa_demora_nombre", length = 100)
    private String causaDemoraNombre;
    @OneToMany(mappedBy = "idCausaDemora")
    private Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection;

    public CausaDemora() {
    }

    public CausaDemora(Integer idCausaDemora) {
        this.idCausaDemora = idCausaDemora;
    }

    public Integer getIdCausaDemora() {
        return idCausaDemora;
    }

    public void setIdCausaDemora(Integer idCausaDemora) {
        this.idCausaDemora = idCausaDemora;
    }

    public String getCausaDemoraNombre() {
        return causaDemoraNombre;
    }

    public void setCausaDemoraNombre(String causaDemoraNombre) {
        this.causaDemoraNombre = causaDemoraNombre;
    }

    @XmlTransient
    public Collection<TransporteDiaTrabajo> getTransporteDiaTrabajoCollection() {
        return transporteDiaTrabajoCollection;
    }

    public void setTransporteDiaTrabajoCollection(Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection) {
        this.transporteDiaTrabajoCollection = transporteDiaTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCausaDemora != null ? idCausaDemora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CausaDemora)) {
            return false;
        }
        CausaDemora other = (CausaDemora) object;
        if ((this.idCausaDemora == null && other.idCausaDemora != null) || (this.idCausaDemora != null && !this.idCausaDemora.equals(other.idCausaDemora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return causaDemoraNombre;
    }
    
}
