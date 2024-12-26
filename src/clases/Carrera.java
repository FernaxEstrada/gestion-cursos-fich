package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Carrera {

    private String carcodigo;
    private String carplan;
    private String carnombre;

    Conexion con = FormLogin.conexionBD;

    public Carrera() {
    }

    public Carrera(String carcodigo, String carplan, String carnombre) {
        this.carcodigo = carcodigo;
        this.carplan = carplan;
        this.carnombre = carnombre;
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

    public String getCarnombre() {
        return carnombre;
    }

    public void setCarnombre(String carnombre) {
        this.carnombre = carnombre;
    }

    public void insertar() {
        String comando = "insert into carrera (carcodigo, carplan, carnombre) values ('" + this.carcodigo + "','" + this.carplan + "','" + this.carnombre + "');";
        con.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update carrera set carcodigo = '" + this.carcodigo + "', carplan = '" + this.carplan + "', carnombre = '" + this.carnombre + "' where carcodigo = '" + this.carcodigo + "' and carplan = '" + this.carplan + "';";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from carrera where carcodigo = '" + this.carcodigo + "' and carplan ='" + this.carplan + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"CODIGO", "PLAN", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from carrera;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[3];
                filaDatos[0] = resultado.getObject("carcodigo");
                filaDatos[1] = resultado.getObject("carplan");
                filaDatos[2] = resultado.getObject("carnombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void busquedaPorNombre(JTable tabla, String textoBusqueda) {
        String[] titulos = {"CODIGO", "PLAN", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * \n"
                + "from carrera \n"
                + "where carnombre ILIKE '%" + textoBusqueda + "%';";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[3];
                filaDatos[0] = resultado.getObject("carcodigo");
                filaDatos[1] = resultado.getObject("carplan");
                filaDatos[2] = resultado.getObject("carnombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
