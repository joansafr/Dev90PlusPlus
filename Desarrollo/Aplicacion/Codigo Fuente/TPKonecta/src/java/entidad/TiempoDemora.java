/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "tiempo_demora", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiempoDemora.findAll", query = "SELECT t FROM TiempoDemora t"),
    @NamedQuery(name = "TiempoDemora.findByIdTiempoDemora", query = "SELECT t FROM TiempoDemora t WHERE t.idTiempoDemora = :idTiempoDemora"),
    @NamedQuery(name = "TiempoDemora.findByTiempoDemoraFactor", query = "SELECT t FROM TiempoDemora t WHERE t.tiempoDemoraFactor = :tiempoDemoraFactor")})
public class TiempoDemora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tiempo_demora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date idTiempoDemora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempo_demora_factor", precision = 4, scale = 2)
    private BigDecimal tiempoDemoraFactor;
    @OneToMany(mappedBy = "idTiempoDemora")
    private Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection;

    public TiempoDemora() {
    }

    public TiempoDemora(Date idTiempoDemora) {
        this.idTiempoDemora = idTiempoDemora;
    }

    public Date getIdTiempoDemora() {
        return idTiempoDemora;
    }

    public void setIdTiempoDemora(Date idTiempoDemora) {
        this.idTiempoDemora = idTiempoDemora;
    }

    public BigDecimal getTiempoDemoraFactor() {
        return tiempoDemoraFactor;
    }

    public void setTiempoDemoraFactor(BigDecimal tiempoDemoraFactor) {
        this.tiempoDemoraFactor = tiempoDemoraFactor;
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
        hash += (idTiempoDemora != null ? idTiempoDemora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiempoDemora)) {
            return false;
        }
        TiempoDemora other = (TiempoDemora) object;
        if ((this.idTiempoDemora == null && other.idTiempoDemora != null) || (this.idTiempoDemora != null && !this.idTiempoDemora.equals(other.idTiempoDemora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idTiempoDemora +" [" + tiempoDemoraFactor + "]";
    }
    
}
