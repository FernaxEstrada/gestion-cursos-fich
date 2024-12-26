package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CursoCapacitador {

    private String curid;
    private String perci;

    Conexion con = FormLogin.conexionBD;

    public CursoCapacitador() {
    }

    public CursoCapacitador(String curid, String perci) {
        this.curid = curid;
        this.perci = perci;
    }

    public String getCurid() {
        return curid;
    }

    public void setCurid(String curid) {
        this.curid = curid;
    }

    public String getPerci() {
        return perci;
    }

    public void setPerci(String perci) {
        this.perci = perci;
    }

    public void insertar() {
        String comando = "insert into capacitador_curso (curid, perci) values ('" + this.curid + "', '" + this.perci + "');";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from capacitador_curso where curid = '" + this.curid + "' and perci = '" + this.perci + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID CURSO", "CI CAPACITADOR"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from capacitador_curso;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("curid");
                filaDatos[1] = resultado.getObject("perci");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CursoCapacitador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
