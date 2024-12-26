package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CursoDia {

    private String curid;
    private String diaid;
    private String curdiahorainicio;
    private String curdiahorafin;

    Conexion con = FormLogin.conexionBD;

    public CursoDia() {
    }

    public CursoDia(String curid, String diaid, String curdiahorainicio, String curdiahorafin) {
        this.curid = curid;
        this.diaid = diaid;
        this.curdiahorainicio = curdiahorainicio;
        this.curdiahorafin = curdiahorafin;
    }

    public String getCurid() {
        return curid;
    }

    public void setCurid(String curid) {
        this.curid = curid;
    }

    public String getDiaid() {
        return diaid;
    }

    public void setDiaid(String diaid) {
        this.diaid = diaid;
    }

    public String getCurdiahorainicio() {
        return curdiahorainicio;
    }

    public void setCurdiahorainicio(String curdiahorainicio) {
        this.curdiahorainicio = curdiahorainicio;
    }

    public String getCurdiahorafin() {
        return curdiahorafin;
    }

    public void setCurdiahorafin(String curdiahorafin) {
        this.curdiahorafin = curdiahorafin;
    }
    
    public void insertar() {
        String comando = "insert into curso_dia (curid, diaid, curdiahorainicio, curdiahorafin) values ('" + this.curid + "', '" + this.diaid + "', '" + this.curdiahorainicio + "', '" + this.curdiahorafin + "');";
        con.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update curso_dia set curdiahorainicio = '" + this.curdiahorainicio + "', curdiahorafin = '" + this.curdiahorafin + "' where curid = '" + this.curid + "' and diaid = '" + this.diaid + "';";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from curso_dia where curid = '" + this.curid + "' and diaid = '" + this.diaid + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID CURSO", "ID DIA", "HORA INICIO", "HORA FIN"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from curso_dia;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[4];
                filaDatos[0] = resultado.getObject("curid");
                filaDatos[1] = resultado.getObject("diaid");
                filaDatos[2] = resultado.getObject("curdiahorainicio");
                filaDatos[3] = resultado.getObject("curdiahorafin");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CursoDia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
