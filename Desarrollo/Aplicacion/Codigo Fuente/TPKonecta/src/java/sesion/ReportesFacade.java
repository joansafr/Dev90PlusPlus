/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.Personal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antonio
 */
@Stateless
public class ReportesFacade extends AbstractFacade<Personal> {
    @PersistenceContext(unitName = "TPKonectaPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ReportesFacade() {
        super(Personal.class);
    }
    /*PLANIFICACION*/
     public List<Object> pa_PL_Agentes_Permanencia() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_Agentes_Permanencia() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_Campana(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_Campana(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_Servicio(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_Servicio(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_Segmento(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_Segmento(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_Responsable(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_Responsable(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_HorarioIngreso(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_HorarioIngreso(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_HoraRefrigerio(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_HoraRefrigerio(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_Departamento(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_Departamento(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_CondicionLaboral(Date FechaDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_CondicionLaboral(?) }"); 
            query.setParameter(1, FechaDia); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_TurnoServicio() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_TurnoServicio() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_TurnoSegmento() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_TurnoSegmento() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_TurnoDepartamento() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_TurnoDepartamento() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadAgente_TurnoCampana() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadAgente_TurnoCampana() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_Departamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_Departamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_CondicionLaboralServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_CondicionLaboralServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_CondicionLaboralSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_CondicionLaboralSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_CondicionLaboralDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_CondicionLaboralDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_CondicionLaboralCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_CondicionLaboralCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_Campana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_Campana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EdadServicio(Date FechaInicio, Date FechaFin, Integer EdadMinima, Integer EdadMaxima) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EdadServicio(?,?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EdadMinima);
            query.setParameter(4, EdadMaxima);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EdadSegmento(Date FechaInicio, Date FechaFin, Integer EdadMinima, Integer EdadMaxima) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EdadSegmento(?,?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EdadMinima);
            query.setParameter(4, EdadMaxima);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EdadDepartamento(Date FechaInicio, Date FechaFin, Integer EdadMinima, Integer EdadMaxima) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EdadDepartamento(?,?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EdadMinima);
            query.setParameter(4, EdadMaxima);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EdadCampana(Date FechaInicio, Date FechaFin, Integer EdadMinima, Integer EdadMaxima) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EdadCampana(?,?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EdadMinima);
            query.setParameter(4, EdadMaxima);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_GrupoFormacionServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_GrupoFormacionServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_GrupoFormacionSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_GrupoFormacionSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_GrupoFormacionDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_GrupoFormacionDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_GrupoFormacionCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_GrupoFormacionCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EstadoCivilServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EstadoCivilServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EstadoCivilSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EstadoCivilSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EstadoCivilDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EstadoCivilDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_EstadoCivilCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_EstadoCivilCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_MotivoServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_MotivoServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_MotivoSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_MotivoSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_MotivoDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_MotivoDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_MotivoCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_MotivoCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_NivelEducativoServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_NivelEducativoServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_NivelEducativoSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_NivelEducativoSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_NivelEducativoDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_NivelEducativoDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_NivelEducativoCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_NivelEducativoCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_PermanenciaServicio() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_PermanenciaServicio() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_PermanenciaSegmento() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_PermanenciaSegmento() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_PermanenciaDepartamento() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_PermanenciaDepartamento() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_PermanenciaCampana() 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_PermanenciaCampana() }"); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadDescanso_Servicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadDescanso_Servicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadDescanso_Segmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadDescanso_Segmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadDescanso_Departamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadDescanso_Departamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadDescanso_Campana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadDescanso_Campana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_TurnoServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_TurnoServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_TurnoSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_TurnoSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_TurnoDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_TurnoDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_TurnoCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_TurnoCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_SexoServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_SexoServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_SexoSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_SexoSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_SexoDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_SexoDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_SexoCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_SexoCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_Servicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_Servicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_Segmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_Segmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_ResponsableServicio(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_ResponsableServicio(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_ResponsableSegmento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_ResponsableSegmento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_ResponsableDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_ResponsableDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_CantidadBajas_ResponsableCampana(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_CantidadBajas_ResponsableCampana(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_Rotacion_SexoDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_Rotacion_SexoDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_Rotacion_ResponsableDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_Rotacion_ResponsableDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_Rotacion_NivelEducativoDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_Rotacion_NivelEducativoDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_Rotacion_GrupoFormacionDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_Rotacion_GrupoFormacionDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_Rotacion_EstadoCivilDepartamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_Rotacion_EstadoCivilDepartamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_PL_Rotacion_EdadDepartamento(Date FechaInicio, Date FechaFin, Integer EdadMinima, Integer EdadMaxima) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_PL_Rotacion_EdadDepartamento(?,?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EdadMinima);
            query.setParameter(4, EdadMaxima);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     /*PLANIFICACION*/
     /*TRANSPORTE*/
     public List<Object> pa_TR_CantidadEstado_SectorHora(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_SectorHora(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadEstado_Sector(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_Sector(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadEstado_DistritoHora(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_DistritoHora(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadEstado_Distrito(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_Distrito(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadEstado_DiaHora(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_DiaHora(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadEstado_Dia(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_Dia(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadEstado_DepartamentoHora(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_DepartamentoHora(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadEstado_Departamento(Date FechaInicio, Date FechaFin, Integer EstadoDia) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadEstado_Departamento(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, EstadoDia);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_SectorHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_SectorHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_Sector(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_Sector(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_RatioTipoVehiculo(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_RatioTipoVehiculo(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_DistritoHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_DistritoHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_Distrito(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_Distrito(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_DiaHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_DiaHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_Dia(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_Dia(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_DepartamentoHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_DepartamentoHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTransportados_Departamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTransportados_Departamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_SectorHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_SectorHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_Sector(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_Sector(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_DistritoHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_DistritoHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_Distrito(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_Distrito(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_DiaHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_DiaHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_Dia(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_Dia(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_DepartamentoHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_DepartamentoHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadTardanzas_Departamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadTardanzas_Departamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_Dia(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_Dia(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_SectorHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_SectorHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_Sector(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_Sector(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_DistritoHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_DistritoHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_Distrito(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_Distrito(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_DiaHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_DiaHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_DepartamentoHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_DepartamentoHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadNoAtendido_Departamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadNoAtendido_Departamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadIncidentes_DiaHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadIncidentes_DiaHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadIncidentes_Dia(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadIncidentes_Dia(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadIncidentes_DepartamentoHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadIncidentes_DepartamentoHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadIncidentes_Departamento(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadIncidentes_Departamento(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadIncidentes_CausaHora(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadIncidentes_CausaHora(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_CantidadIncidentes_Causa(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_CantidadIncidentes_Causa(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Ranking_Transportados(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Ranking_Transportados(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Ranking_Tardanzas(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Ranking_Tardanzas(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Ranking_PerCapita(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Ranking_PerCapita(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Ranking_Penalidades(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Ranking_Penalidades(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Ranking_Incidencias(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Ranking_Incidencias(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Ranking_Facturacion(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Ranking_Facturacion(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Ranking_Distritos(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Ranking_Distritos(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Facturacion_ProveedorDia(Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Facturacion_ProveedorDia(?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Facturacion_DiaProveedor(Date FechaInicio, Date FechaFin, Integer Proveedor) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Facturacion_DiaProveedor(?,?,?) }"); 
            query.setParameter(1, FechaInicio); 
            query.setParameter(2, FechaFin);
            query.setParameter(3, Proveedor);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_TR_Transportar_DiaProveedor(Date Fecha, Integer Proveedor) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_TR_Transportar_DiaProveedor(?,?) }"); 
            query.setParameter(1, Fecha); 
            query.setParameter(2, Proveedor);
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     /*TRANSPORTE*/
    
}
