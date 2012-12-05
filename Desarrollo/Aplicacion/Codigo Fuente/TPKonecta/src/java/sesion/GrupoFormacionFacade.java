/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.GrupoFormacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class GrupoFormacionFacade extends AbstractFacade<GrupoFormacion> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFormacionFacade() {
        super(GrupoFormacion.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT g.idGrupoFormacion FROM GrupoFormacion g WHERE g.idGrupoFormacion = :idGrupoFormacion";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idGrupoFormacion", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
}
