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
@Table(name = "padron", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Padron.findAll", query = "SELECT p FROM Padron p"),
    @NamedQuery(name = "Padron.findByPadronNombre", query = "SELECT p FROM Padron p WHERE p.padronNombre = :padronNombre"),
    @NamedQuery(name = "Padron.findByIdPadron", query = "SELECT p FROM Padron p WHERE p.idPadron = :idPadron")})
public class Padron implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "padron_nombre", length = 20)
    private String padronNombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_padron", nullable = false)
    private Integer idPadron;
    @OneToMany(mappedBy = "idPadron")
    private Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection;

    public Padron() {
    }

    public Padron(Integer idPadron) {
        this.idPadron = idPadron;
    }

    public String getPadronNombre() {
        return padronNombre;
    }

    public void setPadronNombre(String padronNombre) {
        this.padronNombre = padronNombre;
    }

    public Integer getIdPadron() {
        return idPadron;
    }

    public void setIdPadron(Integer idPadron) {
        this.idPadron = idPadron;
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
        hash += (idPadron != null ? idPadron.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Padron)) {
            return false;
        }
        Padron other = (Padron) object;
        if ((this.idPadron == null && other.idPadron != null) || (this.idPadron != null && !this.idPadron.equals(other.idPadron))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return padronNombre;
    }
    
}
