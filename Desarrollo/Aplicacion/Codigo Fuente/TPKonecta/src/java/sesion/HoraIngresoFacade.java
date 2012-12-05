/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.HoraIngreso;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class HoraIngresoFacade extends AbstractFacade<HoraIngreso> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoraIngresoFacade() {
        super(HoraIngreso.class);
    }
    
    public Date findByID(Date id) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("HH:mm");
        Date var = null;
        String jpqlQuery = "SELECT h.idHoraIngreso FROM HoraIngreso h WHERE h.idHoraIngreso = :idHoraIngreso";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idHoraIngreso", id);
            var = (Date) (q.getResultList().get(0));
            return var;
        }
        catch(Exception ex0){
            return null;
        }
    }
}
