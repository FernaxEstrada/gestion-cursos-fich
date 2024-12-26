package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Categoria {

    private String catid;
    private String catnombre;

    Conexion con = FormLogin.conexionBD;

    public Categoria() {
    }

    public Categoria(String catid, String catnombre) {
        this.catid = catid;
        this.catnombre = catnombre;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getCatnombre() {
        return catnombre;
    }

    public void setCatnombre(String catnombre) {
        this.catnombre = catnombre;
    }

    public void insertar() {
        String comando = "insert into categoria (catnombre) values ('" + this.catnombre + "');";
        con.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update categoria set catnombre = '" + this.catnombre + "' where catid = '" + this.catid + "';";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from categoria where catid = '" + this.catid + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from categoria;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("catid");
                filaDatos[1] = resultado.getObject("catnombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void busquedaPorNombre(JTable tabla, String textoBusqueda) {
        String[] titulos = {"ID", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * \n"
                + "from categoria \n"
                + "where catnombre ILIKE '%" + textoBusqueda + "%';";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("catid");
                filaDatos[1] = resultado.getObject("catnombre");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
