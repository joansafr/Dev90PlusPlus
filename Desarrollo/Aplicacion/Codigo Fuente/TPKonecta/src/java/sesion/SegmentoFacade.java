/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.Segmento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class SegmentoFacade extends AbstractFacade<Segmento> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegmentoFacade() {
        super(Segmento.class);
    }
    
}
