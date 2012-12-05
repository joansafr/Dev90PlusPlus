/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.TipoVehiculo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class TipoVehiculoFacade extends AbstractFacade<TipoVehiculo> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoVehiculoFacade() {
        super(TipoVehiculo.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT t.idTipoVehiculo FROM TipoVehiculo t WHERE t.idTipoVehiculo = :idTipoVehiculo";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idTipoVehiculo", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
}
