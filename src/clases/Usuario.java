package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Usuario {

    private String perci;
    private String usucontrasena;

    Conexion conexion = FormLogin.conexionBD;

    public Usuario() {
    }

    public Usuario(String perci, String usucontrasena) {
        this.perci = perci;
        this.usucontrasena = usucontrasena;
    }

    public String getPerci() {
        return perci;
    }

    public void setPerci(String perci) {
        this.perci = perci;
    }

    public String getUsucontrasena() {
        return usucontrasena;
    }

    public void setUsucontrasena(String usucontrasena) {
        this.usucontrasena = usucontrasena;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public void insertar() {
        String comando = "insert into usuario (perci, usucontrasena) values ('" + this.perci + "', md5('" + this.usucontrasena + "')" + ");";
        conexion.ejecutarComando(comando);
    }

    public void modificar() {
        String comando = "update usuario set perci = '" + this.perci + "', usucontrasena = md5('" + this.usucontrasena + "') " + " where id = '" + this.perci + "';";
        conexion.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from usuario where perci = '" + this.perci + "';";
        conexion.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"CI PERSONAL"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select perci from usuario;";
        ResultSet resultado = conexion.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[1];
                filaDatos[0] = resultado.getObject("perci");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Validacion de usuario y contraseña para el inicio de sesión
    public String verificarUsuario(String perci, String usucontrasena) {
        try {
            String consulta = "select perci from usuario where perci = '" + perci + "' and usucontrasena = md5('" + usucontrasena + "');";
            ResultSet resultado = conexion.ejecutarConsulta(consulta);
            
            if(resultado == null) {
                JOptionPane.showMessageDialog(null, "Error interno en el servidor");
            }
            
            if (resultado.next()) {
                return resultado.getString("perci");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void obtenerUsuarioLogueado(JLabel labelCI, JLabel labelNombre, String ciPersona) {
        try {
            String consulta = "select u.perci, p.pernombres from usuario u, persona p where u.perci = p.perci and u.perci = '" + ciPersona + "';";
            ResultSet resultado = conexion.ejecutarConsulta(consulta);

            resultado.next();

            String var_perci = resultado.getString("perci");
            String var_pernombres = resultado.getString("pernombres");
            labelCI.setText(var_perci);
            labelNombre.setText(var_pernombres);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
