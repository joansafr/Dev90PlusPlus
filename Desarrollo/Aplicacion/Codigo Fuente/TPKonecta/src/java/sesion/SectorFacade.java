/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.Sector;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class SectorFacade extends AbstractFacade<Sector> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SectorFacade() {
        super(Sector.class);
    }
    
    public Integer findByID(Integer id) {
        String jpqlQuery = "SELECT s.idSector FROM Sector s WHERE s.idSector = :idSector";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("idSector", id);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
    
    public Integer vehiculoExisteEnSector(Integer id_tipo_vehiculo,String sector_nombre) {
        String jpqlQuery = "SELECT s.idSector FROM Sector s WHERE s.sectorNombre = :sectorNombre and s.idTipoVehiculo.idTipoVehiculo = :idTipoVehiculo";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("sectorNombre", sector_nombre);
            q.setParameter("idTipoVehiculo", id_tipo_vehiculo);
            return Integer.parseInt(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
    public BigDecimal CostoSector(Integer id_tipo_vehiculo,String sector_nombre) {
        String jpqlQuery = "SELECT s.sectorCosto FROM Sector s WHERE s.sectorNombre = :sectorNombre and s.idTipoVehiculo.idTipoVehiculo = :idTipoVehiculo";
        try{
            javax.persistence.Query q = em.createQuery(jpqlQuery);
            q.setParameter("sectorNombre", sector_nombre);
            q.setParameter("idTipoVehiculo", id_tipo_vehiculo);
            return new BigDecimal(q.getResultList().get(0).toString());
        }
        catch(Exception ex0){
            return null;
        }
    }
}
