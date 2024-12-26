package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Especialidad {

    private String espeid;
    private String espenombre;

    Conexion con = FormLogin.conexionBD;

    public Especialidad() {
    }

    public Especialidad(String espeid, String espenombre) {
        this.espeid = espeid;
        this.espenombre = espenombre;
    }

    public String getEspeid() {
        return espeid;
    }

    public void setEspeid(String espeid) {
        this.espeid = espeid;
    }

    public String getEspenombre() {
        return espenombre;
    }

    public void setEspenombre(String espenombre) {
        this.espenombre = espenombre;
    }

    public void insertar() {
        String comando = "insert into especialidad (espenombre) values ('" + this.espenombre + "');";
        con.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update especialidad set espenombre = '" + this.espenombre + "' where espeid = '" + this.espeid + "';";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from especialidad where espeid = '" + this.espeid + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from especialidad;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("espeid");
                filaDatos[1] = resultado.getObject("espenombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Especialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void busquedaPorNombre(JTable tabla, String nombreBusqueda) {
        String[] titulos = {"ID", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from especialidad where espenombre ILIKE '%" + nombreBusqueda + "%';";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("espeid");
                filaDatos[1] = resultado.getObject("espenombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Especialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
