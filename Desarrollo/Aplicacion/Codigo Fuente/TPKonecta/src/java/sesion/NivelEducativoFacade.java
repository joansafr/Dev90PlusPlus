/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.NivelEducativo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class NivelEducativoFacade extends AbstractFacade<NivelEducativo> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelEducativoFacade() {
        super(NivelEducativo.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT n.idNivelEducativo FROM NivelEducativo n WHERE n.idNivelEducativo = :idNivelEducativo";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idNivelEducativo", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
    
}
