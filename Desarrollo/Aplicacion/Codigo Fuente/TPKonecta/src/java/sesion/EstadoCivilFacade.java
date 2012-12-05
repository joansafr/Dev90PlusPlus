/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.EstadoCivil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class EstadoCivilFacade extends AbstractFacade<EstadoCivil> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT e.idEstadoCivil FROM EstadoCivil e WHERE e.idEstadoCivil = :idEstadoCivil";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idEstadoCivil", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
}
