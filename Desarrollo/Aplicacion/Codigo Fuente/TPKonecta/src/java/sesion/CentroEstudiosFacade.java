/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.CentroEstudios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class CentroEstudiosFacade extends AbstractFacade<CentroEstudios> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroEstudiosFacade() {
        super(CentroEstudios.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT c.idCentroEstudios FROM CentroEstudios c WHERE c.idCentroEstudios = :idCentroEstudios";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idCentroEstudios", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
    
}
