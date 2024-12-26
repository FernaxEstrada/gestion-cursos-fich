package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dia {

    private String diaid;
    private String dianombre;

    Conexion con = FormLogin.conexionBD;

    public Dia() {
    }

    public Dia(String diaid, String dianombre) {
        this.diaid = diaid;
        this.dianombre = dianombre;
    }

    public String getDiaid() {
        return diaid;
    }

    public void setDiaid(String diaid) {
        this.diaid = diaid;
    }

    public String getDianombre() {
        return dianombre;
    }

    public void setDianombre(String dianombre) {
        this.dianombre = dianombre;
    }

    public void insertar() {
        String comando = "insert into dia (dianombre) values ('" + this.dianombre + "');";
        con.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update dia set dianombre = '" + this.dianombre + "' where diaid = '" + this.diaid + "';";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from dia where diaid = '" + this.diaid + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID DIA","NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from dia;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("diaid");
                filaDatos[1] = resultado.getObject("dianombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Dia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void busquedaPorNombre(JTable tabla, String textoBusqueda) {
        String[] titulos = {"ID DIA","NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * \n"
                + "from dia \n"
                + "where dianombre ILIKE '%" + textoBusqueda + "%';";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("diaid");
                filaDatos[1] = resultado.getObject("dianombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Dia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
