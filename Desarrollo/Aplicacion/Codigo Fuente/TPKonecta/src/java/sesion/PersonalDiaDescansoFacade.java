/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.PersonalDiaDescanso;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class PersonalDiaDescansoFacade extends AbstractFacade<PersonalDiaDescanso> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalDiaDescansoFacade() {
        super(PersonalDiaDescanso.class);
    }
    public List<PersonalDiaDescanso> getRevisionDescanso(Date fecha) {
        String jpqlQuery =
                "SELECT d FROM PersonalDiaDescanso d "
                + "WHERE d.personalDiaDescansoPK.personalDiaDescansoFecha = :hoydia";
        try{
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("hoydia", fecha);
        return q.getResultList();
        }
        catch(Exception ex0){
            return null;
        }
    }
    
}
