/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.Cono;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class ConoFacade extends AbstractFacade<Cono> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConoFacade() {
        super(Cono.class);
    }
    
}
