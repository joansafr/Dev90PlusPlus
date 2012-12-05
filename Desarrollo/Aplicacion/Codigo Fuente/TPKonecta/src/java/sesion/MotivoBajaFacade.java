/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.MotivoBaja;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class MotivoBajaFacade extends AbstractFacade<MotivoBaja> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotivoBajaFacade() {
        super(MotivoBaja.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT m.idMotivoBaja FROM MotivoBaja m WHERE m.idMotivoBaja = :idMotivoBaja";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idMotivoBaja", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
    
}
