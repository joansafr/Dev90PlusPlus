/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.Responsable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class ResponsableFacade extends AbstractFacade<Responsable> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsableFacade() {
        super(Responsable.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT r.idResponsable FROM Responsable r WHERE r.idResponsable = :idResponsable";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idResponsable", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
    
}
