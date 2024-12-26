package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ubicacion {

    private String ubiid;
    private String ubinombre;

    Conexion con = FormLogin.conexionBD;

    public Ubicacion() {
    }

    public Ubicacion(String ubiid, String ubinombre) {
        this.ubiid = ubiid;
        this.ubinombre = ubinombre;
    }

    public String getUbiid() {
        return ubiid;
    }

    public void setUbiid(String ubiid) {
        this.ubiid = ubiid;
    }

    public String getUbinombre() {
        return ubinombre;
    }

    public void setUbinombre(String ubinombre) {
        this.ubinombre = ubinombre;
    }

    public void insertar() {
        String comando = "insert into ubicacion (ubinombre) values ('" + this.ubinombre + "');";
        con.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update ubicacion set ubinombre = '" + this.ubinombre + "' where ubiid = '" + this.ubiid + "';";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from ubicacion where ubiid = '" + this.ubiid + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from ubicacion;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("ubiid");
                filaDatos[1] = resultado.getObject("ubinombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void busquedaPorNombre(JTable tabla, String textoBusqueda) {
        String[] titulos = {"ID", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * \n"
                + "from ubicacion \n"
                + "where ubinombre ILIKE '%" + textoBusqueda + "%';";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("ubiid");
                filaDatos[1] = resultado.getObject("ubinombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Ubicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
