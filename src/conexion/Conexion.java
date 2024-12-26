package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    private final String DATABASE = "db_gestion_de_cursos_de_capacitacion";
    private final String HOST = "localhost";
    private final String PORT = "5432";
    private final String USER = "postgres";
    private final String PASS = "developer";
    static int contadorInstacia = 0;

    protected Connection con = null;
    private final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;

    public Conexion() {
        this.conectar();
        contadorInstacia++;
        System.out.println("Instancia: " + contadorInstacia);
    }

    private void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexion con la base de datos, exitosa!!!");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion: " + ex.getMessage());
        }
    }

    public void desconectar() {
        if (getConnection() != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas al desconectar: " + ex.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return con;
    }

    public boolean ejecutarComando(String comando) {
        try {
            Statement Cmd = con.createStatement();
            Cmd.execute(comando);
            return true;
        } catch (SQLException err) {
            System.out.println("Error al intentar ejecutar comando: " + err);
            return false;
        }
    }

    public ResultSet ejecutarConsulta(String consulta) {
        ResultSet res = null;
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery(consulta);
        } catch (SQLException err) {
            System.out.println("Error al intentar ejecutar consulta: " + err);
        }
        return res;
    }
}
