/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "personal_dia_descanso", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalDiaDescanso.findAll", query = "SELECT p FROM PersonalDiaDescanso p"),
    @NamedQuery(name = "PersonalDiaDescanso.findByIdPersonal", query = "SELECT p FROM PersonalDiaDescanso p WHERE p.personalDiaDescansoPK.idPersonal = :idPersonal"),
    @NamedQuery(name = "PersonalDiaDescanso.findByPersonalDiaDescansoFecha", query = "SELECT p FROM PersonalDiaDescanso p WHERE p.personalDiaDescansoPK.personalDiaDescansoFecha = :personalDiaDescansoFecha")})
public class PersonalDiaDescanso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonalDiaDescansoPK personalDiaDescansoPK;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;

    public PersonalDiaDescanso() {
    }

    public PersonalDiaDescanso(PersonalDiaDescansoPK personalDiaDescansoPK) {
        this.personalDiaDescansoPK = personalDiaDescansoPK;
    }

    public PersonalDiaDescanso(String idPersonal, Date personalDiaDescansoFecha) {
        this.personalDiaDescansoPK = new PersonalDiaDescansoPK(idPersonal, personalDiaDescansoFecha);
    }

    public PersonalDiaDescansoPK getPersonalDiaDescansoPK() {
        return personalDiaDescansoPK;
    }

    public void setPersonalDiaDescansoPK(PersonalDiaDescansoPK personalDiaDescansoPK) {
        this.personalDiaDescansoPK = personalDiaDescansoPK;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personalDiaDescansoPK != null ? personalDiaDescansoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalDiaDescanso)) {
            return false;
        }
        PersonalDiaDescanso other = (PersonalDiaDescanso) object;
        if ((this.personalDiaDescansoPK == null && other.personalDiaDescansoPK != null) || (this.personalDiaDescansoPK != null && !this.personalDiaDescansoPK.equals(other.personalDiaDescansoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.PersonalDiaDescanso[ personalDiaDescansoPK=" + personalDiaDescansoPK + " ]";
    }
    
}
