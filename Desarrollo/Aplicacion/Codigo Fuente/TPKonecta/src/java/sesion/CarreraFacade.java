/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.Carrera;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class CarreraFacade extends AbstractFacade<Carrera> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarreraFacade() {
        super(Carrera.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT c.idCarrera FROM Carrera c WHERE c.idCarrera = :idCarrera";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idCarrera", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
}
