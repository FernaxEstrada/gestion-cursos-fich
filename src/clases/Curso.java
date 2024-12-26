package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Curso {

    private String curid;
    private String curtitulo;
    private String curdescripcion;
    private String curfechainicio;
    private String curfechafin;
    private String curcupomaximo;
    private String curcostoestudiante;
    private String curcostoprofesional;
    private String ubiid;
    private String catid;

    Conexion con = FormLogin.conexionBD;

    public Curso() {
    }

    public Curso(String curid, String curtitulo, String curdescripcion, String curfechainicio, String curfechafin, String curcupomaximo, String curcostoestudiante, String curcostoprofesional, String ubiid, String catid) {
        this.curid = curid;
        this.curtitulo = curtitulo;
        this.curdescripcion = curdescripcion;
        this.curfechainicio = curfechainicio;
        this.curfechafin = curfechafin;
        this.curcupomaximo = curcupomaximo;
        this.curcostoestudiante = curcostoestudiante;
        this.curcostoprofesional = curcostoprofesional;
        this.ubiid = ubiid;
        this.catid = catid;
    }

    public String getCurid() {
        return curid;
    }

    public void setCurid(String curid) {
        this.curid = curid;
    }

    public String getCurtitulo() {
        return curtitulo;
    }

    public void setCurtitulo(String curtitulo) {
        this.curtitulo = curtitulo;
    }

    public String getCurdescripcion() {
        return curdescripcion;
    }

    public void setCurdescripcion(String curdescripcion) {
        this.curdescripcion = curdescripcion;
    }

    public String getCurfechainicio() {
        return curfechainicio;
    }

    public void setCurfechainicio(String curfechainicio) {
        this.curfechainicio = curfechainicio;
    }

    public String getCurfechafin() {
        return curfechafin;
    }

    public void setCurfechafin(String curfechafin) {
        this.curfechafin = curfechafin;
    }

    public String getCurcupomaximo() {
        return curcupomaximo;
    }

    public void setCurcupomaximo(String curcupomaximo) {
        this.curcupomaximo = curcupomaximo;
    }

    public String getCurcostoestudiante() {
        return curcostoestudiante;
    }

    public void setCurcostoestudiante(String curcostoestudiante) {
        this.curcostoestudiante = curcostoestudiante;
    }

    public String getCurcostoprofesional() {
        return curcostoprofesional;
    }

    public void setCurcostoprofesional(String curcostoprofesional) {
        this.curcostoprofesional = curcostoprofesional;
    }

    public String getUbiid() {
        return ubiid;
    }

    public void setUbiid(String ubiid) {
        this.ubiid = ubiid;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public void insertar() {
        String comando = "insert into curso (curtitulo, curdescripcion, curfechainicio, curfechafin, curcupomaximo, curcostoestudiante, curcostoprofesional, ubiid, catid) values ('" + this.curtitulo + "','" + this.curdescripcion + "','" + this.curfechainicio + "','" + this.curfechafin + "','" + this.curcupomaximo + "','" + this.curcostoestudiante + "','" + this.curcostoprofesional + "','" + this.ubiid+ "','" + this.catid + "');";
        con.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update curso set curtitulo = '" + this.curtitulo + "', curdescripcion ='" + this.curdescripcion + "', curfechainicio= '" + this.curfechainicio + "', curfechafin ='" + this.curfechafin + "', curcupomaximo ='" + this.curcupomaximo + "', curcostoestudiante ='" + this.curcostoestudiante + "', curcostoprofesional ='" + this.curcostoprofesional + "', ubiid ='" + this.ubiid + "', catid ='" + this.catid + "' where curid = '" + this.curid + "';";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from curso where curid = '" + this.curid + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID", "TITULO", "DESCRIPCION", "FECHA INICIO", "FECHA FIN", "CUPO MAXIMO", "COSTO ESTUDIANTE", "COSTO PROFESIONAL", "ID UBICACION", "ID CATEGORIA"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from curso;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[10];
                filaDatos[0] = resultado.getObject("curid");
                filaDatos[1] = resultado.getObject("curtitulo");
                filaDatos[2] = resultado.getObject("curdescripcion");
                filaDatos[3] = resultado.getObject("curfechainicio");
                filaDatos[4] = resultado.getObject("curfechafin");
                filaDatos[5] = resultado.getObject("curcupomaximo");
                filaDatos[6] = resultado.getObject("curcostoestudiante");
                filaDatos[7] = resultado.getObject("curcostoprofesional");
                filaDatos[8] = resultado.getObject("ubiid");
                filaDatos[9] = resultado.getObject("catid");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void busquedaPorNombre(JTable tabla, String textoBusqueda) {
        String[] titulos = {"ID", "TITULO", "DESCRIPCION", "FECHA INICIO", "FECHA FIN", "CUPO MAXIMO", "COSTO ESTUDIANTE", "COSTO PROFESIONAL", "ID UBICACION", "ID CATEGORIA"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * \n"
                + "from curso \n"
                + "where curtitulo ILIKE '%" + textoBusqueda + "%';";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[10];
                filaDatos[0] = resultado.getObject("curid");
                filaDatos[1] = resultado.getObject("curtitulo");
                filaDatos[2] = resultado.getObject("curdescripcion");
                filaDatos[3] = resultado.getObject("curfechainicio");
                filaDatos[4] = resultado.getObject("curfechafin");
                filaDatos[5] = resultado.getObject("curcupomaximo");
                filaDatos[6] = resultado.getObject("curcostoestudiante");
                filaDatos[7] = resultado.getObject("curcostoprofesional");
                filaDatos[8] = resultado.getObject("ubiid");
                filaDatos[9] = resultado.getObject("catid");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
