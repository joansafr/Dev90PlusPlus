/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.DiaTrabajo;
import entidad.HoraIngreso;
import entidad.TransporteDiaTrabajo;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class TransporteDiaTrabajoFacade extends AbstractFacade<TransporteDiaTrabajo> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransporteDiaTrabajoFacade() {
        super(TransporteDiaTrabajo.class);
    }
    
    public List<TransporteDiaTrabajo> getTransporteDiaTrabajo(Date fecha) {
        String jpqlQuery =
                "SELECT t FROM TransporteDiaTrabajo t "
                + "WHERE t.transporteDiaTrabajoFecha = :hoydia "
                + "AND t.idProveedor IS NULL";
        try{
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("hoydia", fecha);
        return q.getResultList();
        }
        catch(Exception ex0){
            return null;
        }
    }
    
    public List<TransporteDiaTrabajo> getTransporteDiaTrabajoFecha(Date fecha) {
        String jpqlQuery =
                "SELECT t FROM TransporteDiaTrabajo t "
                + "WHERE t.transporteDiaTrabajoFecha = :hoydia";
        try{
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("hoydia", fecha);
        return q.getResultList();
        }
        catch(Exception ex0){
            return null;
        }
    }
    
    public List<TransporteDiaTrabajo> getTransporteDiaTrabajoValidacion(Date fecha, HoraIngreso hora) {
        String jpqlQuery =
                "SELECT t FROM TransporteDiaTrabajo t "
                + "WHERE t.transporteDiaTrabajoFecha = :hoydia "
                + "AND t.idHoraIngreso = :hora "
                + "AND t.idProveedor IS NOT NULL";
        try{
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("hoydia", fecha);
        q.setParameter("hora", hora);
        return q.getResultList();
        }
        catch(Exception ex0){
            return null;
        }
    }
    
    public List<TransporteDiaTrabajo> getTransporteDiaTrabajoManual(Date fecha) {
        String jpqlQuery =
                "SELECT t FROM TransporteDiaTrabajo t "
                + "WHERE t.transporteDiaTrabajoFecha = :hoydia "
                + "AND t.idTipoVehiculo.tipoVehiculoCantidadPersonas > t.transporteDiaTrabajoCantidadPersonas";
        try{
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("hoydia", fecha);
        return q.getResultList();
        }
        catch(Exception ex0){
            return null;
        }
    }
    
    
}
