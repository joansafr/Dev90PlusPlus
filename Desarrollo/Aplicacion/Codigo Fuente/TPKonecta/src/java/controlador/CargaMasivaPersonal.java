/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.util.JsfUtil;
import jxl.*;
import jxl.read.biff.BiffException;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class CargaMasivaPersonal {

    public CargaMasivaPersonal() {
    }
    private UploadedFile archivo;
    private String log_de_errores;
    @EJB
    private sesion.HoraIngresoFacade horaIngresoFacade;
    @EJB
    private sesion.PersonalFacade personalFacade;
    @EJB
    private sesion.DepartamentoFacade departamentoFacade;
    @EJB
    private sesion.MotivoBajaFacade motivoBajaFacade;
    @EJB
    private sesion.GrupoFormacionFacade grupoFormacionFacade;
    @EJB
    private sesion.EstadoCivilFacade estadoCivilFacade;
    @EJB
    private sesion.NivelEducativoFacade nivelEducativoFacade;
    @EJB
    private sesion.CarreraFacade carreraFacade;
    @EJB
    private sesion.CentroEstudiosFacade centroEstudiosFacade;
    @EJB
    private sesion.SectorFacade sectorFacade;
    @EJB
    private sesion.ResponsableFacade responsableFacade;
    @EJB
    private sesion.CargoFacade cargoFacade;

    public String getLog_de_errores() {
        return log_de_errores;
    }

    public void setLog_de_errores(String log_de_errores) {
        this.log_de_errores = log_de_errores;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public void verificar_sintaxis() {
        leer_verificar_sintaxis(comprobar());
        archivo = null;
    }

    public void comprobar_relaciones() {
        leer_comprobar_relaciones(comprobar());
        archivo = null;
    }

    public void registrar_en_el_sistema() throws IOException {
        leer_registrar_en_el_sistema(comprobar());
        archivo = null;
    }

    public UploadedFile comprobar() {
        try {
            log_de_errores = "";
            if (archivo == null) {
                return null;
            } else {
                return archivo;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void leer_registrar_en_el_sistema(UploadedFile inputFile) throws IOException {
        WorkbookSettings ws = null;
        Workbook w;
        String SqlQuery = "";
        String SqlQuery2 = "";
        boolean existe = false;
        PreparedStatement statement = null;
        Personal trabajador = null;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoDelTexto2 = new SimpleDateFormat("HH:mm");
        try {
            ws = new WorkbookSettings();
            ws.setLocale(new Locale("en", "EN"));
            ws.setEncoding("iso-8859-1");
            w = Workbook.getWorkbook(inputFile.getInputstream(), ws);
            Sheet sheet = w.getSheet(0);
            for (int j = 1; j < sheet.getRows(); j++) {
                SqlQuery = "INSERT INTO personal("
                        + "id_personal,personal_codigo_planilla,personal_codigo_fotocheck,personal_nombre,personal_apellido_paterno,"
                        + "personal_apellido_materno,personal_usuario,personal_contrasena,personal_direccion,personal_direccion_referencia,personal_email,"
                        + "personal_telefono_fijo,personal_telefono_movil,personal_cantidad_horas_semanal,personal_cantidad_hijos,personal_cantidad_dias_semanal,"
                        + "personal_fecha_incorporacion,personal_fecha_baja,personal_fecha_formacion,personal_fecha_ingreso_gestion,personal_fecha_nacimiento,"
                        + "personal_fecha_vencimiento_contrato,personal_hora_refrigerio_inicio,personal_hora_refrigerio_duracion,id_hora_ingreso,personal_sexo,personal_actividad,"
                        + "personal_confianza,id_departamento,id_motivo_baja,id_grupo_formacion,id_estado_civil,id_nivel_educativo,id_carrera,id_centro_estudios,"
                        + "id_sector,id_responsable,id_cargo"
                        + ")VALUES(";
                
                if(personalFacade.findByID(sheet.getCell(0, j).getContents().toString())){
                    trabajador = new Personal();
                    trabajador.setIdPersonal(sheet.getCell(0, j).getContents().toString());
                    trabajador.setPersonalCodigoPlanilla(sheet.getCell(1, j).getContents().toString());
                    trabajador.setPersonalCodigoFotocheck(sheet.getCell(2, j).getContents().toString());
                    trabajador.setPersonalNombre(sheet.getCell(3, j).getContents().toString());
                    trabajador.setPersonalApellidoPaterno(sheet.getCell(4, j).getContents().toString());
                    trabajador.setPersonalApellidoMaterno(sheet.getCell(5, j).getContents().toString());
                    trabajador.setPersonalUsuario(sheet.getCell(6, j).getContents().toString());
                    trabajador.setPersonalContrasena(sheet.getCell(7, j).getContents().toString());
                    trabajador.setPersonalDireccion(sheet.getCell(8, j).getContents().toString());
                    trabajador.setPersonalDireccionReferencia(sheet.getCell(9, j).getContents().toString());
                    trabajador.setPersonalEmail(sheet.getCell(10, j).getContents().toString());
                    trabajador.setPersonalTelefonoFijo(sheet.getCell(11, j).getContents().toString());
                    trabajador.setPersonalTelefonoMovil(sheet.getCell(12, j).getContents().toString());
                    
                    trabajador.setPersonalCantidadHorasSemanal(Integer.parseInt(sheet.getCell(13, j).getContents().toString()));
                    trabajador.setPersonalCantidadHijos(Integer.parseInt(sheet.getCell(14, j).getContents().toString()));
                    trabajador.setPersonalCantidadDiasSemanal(Integer.parseInt(sheet.getCell(15, j).getContents().toString()));
                    
                    trabajador.setPersonalFechaIncorporacion(formatoDelTexto.parse(sheet.getCell(16, j).getContents().toString()));
                    trabajador.setPersonalFechaBaja(sheet.getCell(17, j).getContents().toString().isEmpty()? null:formatoDelTexto.parse(sheet.getCell(17, j).getContents().toString()));
                    trabajador.setPersonalFechaFormacion(sheet.getCell(18, j).getContents().toString().isEmpty()? null:formatoDelTexto.parse(sheet.getCell(18, j).getContents().toString()));
                    trabajador.setPersonalFechaIngresoGestion(sheet.getCell(19, j).getContents().toString().isEmpty()? null:formatoDelTexto.parse(sheet.getCell(19, j).getContents().toString()));
                    trabajador.setPersonalFechaNacimiento(formatoDelTexto.parse(sheet.getCell(20, j).getContents().toString()));
                    trabajador.setPersonalFechaVencimientoContrato(sheet.getCell(21, j).getContents().toString().isEmpty()? null:formatoDelTexto.parse(sheet.getCell(21, j).getContents().toString()));

                    
                    trabajador.setPersonalHoraRefrigerioInicio(formatoDelTexto2.parse(sheet.getCell(22, j).getContents().toString()));
                    trabajador.setPersonalHoraRefrigerioDuracion(formatoDelTexto2.parse(sheet.getCell(23, j).getContents().toString()));
                    trabajador.setIdHoraIngreso(new HoraIngreso(formatoDelTexto2.parse(sheet.getCell(24, j).getContents().toString())));
                    
                    trabajador.setPersonalSexo(Boolean.parseBoolean(sheet.getCell(25, j).getContents().toString()));
                    trabajador.setPersonalActividad(Boolean.parseBoolean(sheet.getCell(26, j).getContents().toString()));
                    trabajador.setPersonalConfianza(Boolean.parseBoolean(sheet.getCell(27, j).getContents().toString()));
                    
                    trabajador.setIdDepartamento(new Departamento(Integer.parseInt(sheet.getCell(28, j).getContents().toString())));
                    trabajador.setIdMotivoBaja(sheet.getCell(29, j).getContents().toString().isEmpty()? null : new MotivoBaja(Integer.parseInt(sheet.getCell(29, j).getContents().toString())));
                    trabajador.setIdGrupoFormacion(sheet.getCell(30, j).getContents().toString().isEmpty()? null : new GrupoFormacion(Integer.parseInt(sheet.getCell(30, j).getContents().toString())));
                    trabajador.setIdEstadoCivil(sheet.getCell(31, j).getContents().toString().isEmpty()? null : new EstadoCivil(Integer.parseInt(sheet.getCell(31, j).getContents().toString())));
                    trabajador.setIdNivelEducativo(sheet.getCell(32, j).getContents().toString().isEmpty()? null : new NivelEducativo(Integer.parseInt(sheet.getCell(32, j).getContents().toString())));
                    trabajador.setIdCarrera(sheet.getCell(33, j).getContents().toString().isEmpty()? null : new Carrera(Integer.parseInt(sheet.getCell(33, j).getContents().toString())));
                    trabajador.setIdCentroEstudios(sheet.getCell(34, j).getContents().toString().isEmpty()? null : new CentroEstudios(Integer.parseInt(sheet.getCell(34, j).getContents().toString())));
                    trabajador.setIdSector(new Sector(Integer.parseInt(sheet.getCell(35, j).getContents().toString())));
                    trabajador.setIdResponsable(new Responsable(Integer.parseInt(sheet.getCell(36, j).getContents().toString())));
                    trabajador.setIdCargo(sheet.getCell(37, j).getContents().toString().isEmpty()? null : new Cargo(Integer.parseInt(sheet.getCell(37, j).getContents().toString())));
                    
                    personalFacade.edit(trabajador);
                }
                else{   
                    for (int i = 0; i < 38; i++) {
                        Cell cell = sheet.getCell(i, j);
                        //Cadenas
                        if (i >= 0 && i < 13) {
                            if (cell.getContents().toString().isEmpty()) {
                                SqlQuery += "null, ";
                            } else {
                                SqlQuery += "'" + cell.getContents().toString() + "', ";
                            }
                        }
                        //Numeros
                        if (i >= 13 && i < 16) {
                            if (cell.getContents().toString().isEmpty()) {
                                SqlQuery += "null, ";
                            } else {
                                SqlQuery += cell.getContents().toString() + ", ";
                            }
                        }
                        //Fechas
                        if (i >= 16 && i < 22) {
                            if (cell.getContents().toString().isEmpty()) {
                                SqlQuery += "null, ";
                            } else {
                                SqlQuery += "'" + cell.getContents().toString() + "', ";
                            }
                        }
                        //Horas
                        if (i >= 22 && i < 25) {
                            if (cell.getContents().toString().isEmpty()) {
                                SqlQuery += "null, ";
                            } else {
                                SqlQuery += "'" + cell.getContents().toString() + "', ";
                            }
                        }
                        //Bollean
                        if (i >= 25 && i < 28) {
                            if (cell.getContents().toString().isEmpty()) {
                                SqlQuery += "null, ";
                            } else {
                                SqlQuery += cell.getContents().toString() + ", ";
                            }
                        }
                        //IDs
                        if (i >= 28 && i < 38) {
                            if (i != 37) {
                                if (cell.getContents().toString().isEmpty()) {
                                    SqlQuery += "null, ";
                                } else {
                                    SqlQuery += cell.getContents().toString() + ", ";
                                }
                            } else {
                                if (cell.getContents().toString().isEmpty()) {
                                    SqlQuery += "null)";
                                } else {
                                    SqlQuery += cell.getContents().toString() + ")";
                                }
                            }
                        }
                    }
                    registrar_sql(SqlQuery);
                }
            }
        } catch (BiffException e) {
        } catch (Exception ex) {
        }
    }

    public void registrar_sql(String SqlQuery) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/konecta";
            int updateQuery = 0;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "konecta", "konecta");
            statement = connection.createStatement();
            updateQuery = statement.executeUpdate(SqlQuery);
            statement.close();
            connection.close();
        } catch (Exception e) {
            statement.close();
            connection.close();
        }
    }

    public void leer_comprobar_relaciones(UploadedFile inputFile) {
        WorkbookSettings ws = null;
        Workbook w;
        ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
        ArrayList<Date> arrayTime = new ArrayList<Date>();
        HashSet hs = new HashSet();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("HH:mm");
        try {
            ws = new WorkbookSettings();
            ws.setLocale(new Locale("en", "EN"));
            ws.setEncoding("iso-8859-1");
            w = Workbook.getWorkbook(inputFile.getInputstream(), ws);
            Sheet sheet = w.getSheet(0);
            for (int i = 1; i < sheet.getRows(); i++) {
                Cell cell = sheet.getCell(24, i);
                if (!cell.getContents().toString().isEmpty()) {
                    arrayTime.add(formatoDelTexto.parse(cell.getContents()));
                }
            }
            hs.addAll(arrayTime);
            arrayTime.clear();
            arrayTime.addAll(hs);
            log_de_errores += error_comprobarcion_date(arrayTime, 24);
            hs.clear();
            arrayTime.clear();
            
            for (int j = 28; j < 38; j++) {
                for (int i = 1; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    if (!cell.getContents().toString().isEmpty()) {
                        arrayInteger.add(Integer.parseInt(cell.getContents().toString()));
                    }
                }
                hs.addAll(arrayInteger);
                arrayInteger.clear();
                arrayInteger.addAll(hs);
                log_de_errores += error_comprobarcion_entero(arrayInteger, j);
                arrayInteger.clear();
                hs.clear();
            }
        } catch (BiffException e) {
        } catch (Exception ex) {
        }
    }

    public String error_comprobarcion_date(ArrayList<Date> arrayTime, Integer columna){
        String log = "";
        Date variable;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("HH:mm");
        for (int i = 0; i < arrayTime.size(); i++) {
            variable = horaIngresoFacade.findByID(arrayTime.get(i));
            if(variable == null)
                log += "\nHora de Ingreso: ID "+ formatoDelTexto.format(arrayTime.get(i)) +" no registrado.|\n";
        }
        return log;
    }
    public String error_comprobarcion_entero(ArrayList<Integer> arrayInteger, Integer columna) {
        Integer variable;
        String log = "";
        switch (columna) {
            case 28:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = departamentoFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nDepartamento: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 29:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = motivoBajaFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nMotivode Baja: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 30:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = grupoFormacionFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nGrupo de Formacion: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 31:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = estadoCivilFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nEstado Civil: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 32:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = nivelEducativoFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nNivel Educativo: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 33:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = carreraFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nCarrera: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 34:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = centroEstudiosFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nCentro de Estudios: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 35:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = sectorFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nSector: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 36:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = responsableFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nResponsable: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
            case 37:
                for (int i = 0; i < arrayInteger.size(); i++) {
                    variable = cargoFacade.findByID(arrayInteger.get(i));
                    if(variable == null)
                        log += "\nCarga: ID "+ arrayInteger.get(i) +" no registrado.|\n";
                }
                break;
        }
        return log;
    }

    private void leer_verificar_sintaxis(UploadedFile inputFile) {
        WorkbookSettings ws = null;
        Workbook w;
        ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
        ArrayList<Date> arrayTime = new ArrayList<Date>();
        HashSet hs = new HashSet();
        Integer pruebaInteger;
        Date pruebaDate = null;
        boolean pruebaBoolean;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoDelTexto2 = new SimpleDateFormat("HH:mm");
        try {
            ws = new WorkbookSettings();
            ws.setLocale(new Locale("en", "EN"));
            ws.setEncoding("iso-8859-1");
            w = Workbook.getWorkbook(inputFile.getInputstream(), ws);
            Sheet sheet = w.getSheet(0);
            for (int j = 13; j < 38; j++) {
                for (int i = 1; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    //Enteros
                    if ((j>12 && j<16) || (j>27 && j<38)) {
                        if(!cell.getContents().toString().isEmpty()){
                            try
                            {
                                pruebaInteger =  Integer.parseInt(cell.getContents().toString());
                            }
                            catch(Exception ex){
                                log_de_errores += "Celda("+(i+1)+","+(j+1)+") es incorrecta, debe ir un numero entero.| ";
                                continue;
                            }
                        }
                    }
                    //Fechas
                    if ((j>15 && j<22)) {
                        if(!cell.getContents().toString().isEmpty()){
                            try
                            {
                                pruebaDate =  formatoDelTexto.parse(cell.getContents().toString());
                            }
                            catch(Exception ex){
                                log_de_errores += "Celda("+(i+1)+","+(j+1)+") es incorrecta, debe ir la fecha en forma yyyy-mm-ss.| ";
                                continue;
                            }
                        }
                    }
                    
                    //Horas
                    if ((j>21 && j<25)) {
                        if(!cell.getContents().toString().isEmpty()){
                            try
                            {
                                pruebaDate =  formatoDelTexto2.parse(cell.getContents().toString());
                            }
                            catch(Exception ex){
                                log_de_errores += "Celda("+(i+1)+","+(j+1)+") es incorrecta, debe ir la hora en forma HH:mm.| ";
                                continue;
                            }
                        }
                    }
                    
                    if ((j>24 && j<28)) {
                        if(!cell.getContents().toString().isEmpty()){
                            try
                            {
                                pruebaBoolean =  Boolean.parseBoolean(cell.getContents().toString());
                            }
                            catch(Exception ex){
                                log_de_errores += "Celda("+(i+1)+","+(j+1)+") es incorrecta, debe ir true o false.| ";
                                continue;
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){
        }
    }
}
