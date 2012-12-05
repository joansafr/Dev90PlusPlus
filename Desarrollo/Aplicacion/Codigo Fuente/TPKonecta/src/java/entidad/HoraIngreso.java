/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
@Table(name = "hora_ingreso", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoraIngreso.findAll", query = "SELECT h FROM HoraIngreso h"),
    @NamedQuery(name = "HoraIngreso.findByIdHoraIngreso", query = "SELECT h FROM HoraIngreso h WHERE h.idHoraIngreso = :idHoraIngreso")})
public class HoraIngreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hora_ingreso", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date idHoraIngreso;
    @OneToMany(mappedBy = "idHoraIngreso")
    private Collection<Personal> personalCollection;
    @OneToMany(mappedBy = "idHoraIngreso")
    private Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection;
    @OneToMany(mappedBy = "idHoraIngreso")
    private Collection<DiaTrabajo> diaTrabajoCollection;

    public HoraIngreso() {
    }

    public HoraIngreso(Date idHoraIngreso) {
        this.idHoraIngreso = idHoraIngreso;
    }

    public Date getIdHoraIngreso() {
        return idHoraIngreso;
    }

    public void setIdHoraIngreso(Date idHoraIngreso) {
        this.idHoraIngreso = idHoraIngreso;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    @XmlTransient
    public Collection<TransporteDiaTrabajo> getTransporteDiaTrabajoCollection() {
        return transporteDiaTrabajoCollection;
    }

    public void setTransporteDiaTrabajoCollection(Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection) {
        this.transporteDiaTrabajoCollection = transporteDiaTrabajoCollection;
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
        hash += (idHoraIngreso != null ? idHoraIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraIngreso)) {
            return false;
        }
        HoraIngreso other = (HoraIngreso) object;
        if ((this.idHoraIngreso == null && other.idHoraIngreso != null) || (this.idHoraIngreso != null && !this.idHoraIngreso.equals(other.idHoraIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat  parserSDF=new SimpleDateFormat("HH:mm");
        return parserSDF.format(idHoraIngreso);
    }
    
}
