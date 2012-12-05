/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.*;
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
public class DiaTrabajoFacade extends AbstractFacade<DiaTrabajo> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiaTrabajoFacade() {
        super(DiaTrabajo.class);
    }
    public List<DiaTrabajo> getDiaTrabajo(Date fecha) {
        String jpqlQuery =
                "SELECT d FROM DiaTrabajo d "
                + "WHERE d.diaTrabajoPK.diaTrabajoFecha = :hoydia "
                + "AND d.idTransporteDiaTrabajo IS NULL";
        try{
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("hoydia", fecha);
        return q.getResultList();
        }
        catch(Exception ex0){
            return null;
        }
    }

    
    
    public List<HoraIngreso> getHorarios() {
        String jpqlQuery =
                "SELECT h FROM HoraIngreso h";
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        return q.getResultList();
    }
    public List<Sector> getSectores() {
        String jpqlQuery =
                "SELECT s FROM Sector s ";
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        return q.getResultList();
    }

    public List<DiaTrabajo> getDiaTrabajo(Date fecha, Date horaIngreso, String sector) {
        String jpqlQuery =
                "SELECT d FROM DiaTrabajo d "
                + "WHERE d.diaTrabajoPK.diaTrabajoFecha = :fecha "
                + "AND d.idHoraIngreso.idHoraIngreso = :horaIngreso "
                + "AND d.idSector.sectorNombre = :sector "
                + "AND d.idTransporteDiaTrabajo IS NULL";
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("fecha", fecha);
        q.setParameter("horaIngreso", horaIngreso);
        q.setParameter("sector", sector);
        return q.getResultList();
    }
    
    public List<DiaTrabajo> getRevisionDia(Date fecha) {
        String jpqlQuery =
                "SELECT d FROM DiaTrabajo d "
                + "WHERE d.diaTrabajoPK.diaTrabajoFecha = :fecha ";
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("fecha", fecha);
        return q.getResultList();
    }
    
    public List<DiaTrabajo> getDiaTrabajoValidacion(Date fecha, HoraIngreso horaIngreso) {
        String jpqlQuery =
                "SELECT d FROM DiaTrabajo d "
                + "WHERE d.diaTrabajoPK.diaTrabajoFecha = :fecha "
                + "AND d.idHoraIngreso = :horaIngreso "
                + "AND d.idDiaTrabajoEstado IS NULL "
                + "AND d.idTransporteDiaTrabajo IS NOT NULL";
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("fecha", fecha);
        q.setParameter("horaIngreso", horaIngreso);
        return q.getResultList();
    }
    
    public List<TransporteDiaTrabajo> getManualSelectOneMenuTDT(Date fecha) {
        String jpqlQuery =
                "SELECT t FROM transporteDiaTrabajo t "
                + "WHERE t.transporteDiaTrabajoFecha = :hoydia "
                + "AND t.idHoraIngreso IS NOT NULL "
                + "AND t.idProveedor IS NOT NULL";
        try{
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("hoydia", fecha);
        return q.getResultList();
        }
        catch(Exception ex0){
            return null;
        }
    }
    public List<DiaTrabajo> getDiaTrabajoPLanificacion(Date fecha, Departamento area) {
        String jpqlQuery =
                "SELECT d FROM DiaTrabajo d "
                + "WHERE d.diaTrabajoPK.diaTrabajoFecha = :fecha "
                + "AND d.idDepartamento = :area";
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("fecha", fecha);
        q.setParameter("area", area);
        try{
        return q.getResultList();}
        catch(Exception ex){
            return null;
        }
    }
    public List<DiaTrabajo> getDiaTrabajoTransporte(Long idTransporteDiatrabajo) {
        String jpqlQuery =
                "SELECT d FROM DiaTrabajo d "
                + "WHERE d.idTransporteDiaTrabajo.idTransporteDiaTrabajo = :idTransporte ";
        javax.persistence.Query q = em.createQuery(jpqlQuery);
        q.setParameter("idTransporte", idTransporteDiatrabajo);
        try{
        return q.getResultList();}
        catch(Exception ex){
            return null;
        }
    }
    
}
