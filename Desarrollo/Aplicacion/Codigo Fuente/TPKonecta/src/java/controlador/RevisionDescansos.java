/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Antonio
 */
@ManagedBean
@SessionScoped
public class RevisionDescansos {
    public RevisionDescansos() {
    }
    private DataModel RevisionDescanso = null;
    private Date fecha = new Date();
    @EJB
    private sesion.PersonalDiaDescansoFacade personalDiaDescansoFacade;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DataModel getRevisionDescanso() {
        if (getFecha() != null) {
            RevisionDescanso = new ListDataModel(personalDiaDescansoFacade.getRevisionDescanso(fecha));
        }
        return RevisionDescanso;
    }
    

    public void prepareRevisionDescanso() {
        recreateRevisionDescanso();

    }

    private void recreateRevisionDescanso() {
        RevisionDescanso = null;
        RevisionDescanso = getRevisionDescanso();
    }
}
