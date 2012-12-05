/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.Cargo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class CargoFacade extends AbstractFacade<Cargo> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(Cargo.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT c.idCargo FROM Cargo c WHERE c.idCargo = :idCargo";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idCargo", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
}
