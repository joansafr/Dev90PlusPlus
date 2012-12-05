/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Antonio
 */
@Embeddable
public class DiaTrabajoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "id_personal", nullable = false, length = 9)
    private String idPersonal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia_trabajo_fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date diaTrabajoFecha;

    public DiaTrabajoPK() {
    }

    public DiaTrabajoPK(String idPersonal, Date diaTrabajoFecha) {
        this.idPersonal = idPersonal;
        this.diaTrabajoFecha = diaTrabajoFecha;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Date getDiaTrabajoFecha() {
        return diaTrabajoFecha;
    }

    public void setDiaTrabajoFecha(Date diaTrabajoFecha) {
        this.diaTrabajoFecha = diaTrabajoFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        hash += (diaTrabajoFecha != null ? diaTrabajoFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaTrabajoPK)) {
            return false;
        }
        DiaTrabajoPK other = (DiaTrabajoPK) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        if ((this.diaTrabajoFecha == null && other.diaTrabajoFecha != null) || (this.diaTrabajoFecha != null && !this.diaTrabajoFecha.equals(other.diaTrabajoFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.DiaTrabajoPK[ idPersonal=" + idPersonal + ", diaTrabajoFecha=" + diaTrabajoFecha + " ]";
    }
    
}
