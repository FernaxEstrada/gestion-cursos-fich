package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CursoCarrera {

    private String curid;
    private String carcodigo;
    private String carplan;

    Conexion con = FormLogin.conexionBD;

    public CursoCarrera() {
    }

    public CursoCarrera(String curid, String carcodigo, String carplan) {
        this.curid = curid;
        this.carcodigo = carcodigo;
        this.carplan = carplan;
    }

    public String getCurid() {
        return curid;
    }

    public void setCurid(String curid) {
        this.curid = curid;
    }

    public String getCarcodigo() {
        return carcodigo;
    }

    public void setCarcodigo(String carcodigo) {
        this.carcodigo = carcodigo;
    }

    public String getCarplan() {
        return carplan;
    }

    public void setCarplan(String carplan) {
        this.carplan = carplan;
    }

    public void insertar() {
        String comando = "insert into curso_carrera (curid, carcodigo, carplan) values ('" + this.curid + "', '" + this.carcodigo + "', '" + this.carplan + "');";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from curso_carrera where curid = '" + this.curid + "' and carcodigo = '" + this.carcodigo + "' and carplan = '" + this.carplan + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID CURSO", "CODIGO CARRERA", "PLAN CARRERA"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from curso_carrera;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[3];
                filaDatos[0] = resultado.getObject("curid");
                filaDatos[1] = resultado.getObject("carcodigo");
                filaDatos[2] = resultado.getObject("carplan");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CursoCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
