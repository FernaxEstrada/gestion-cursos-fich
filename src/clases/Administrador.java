package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Administrador extends Persona {

    public Administrador() {
    }

    public Administrador(String perci, String perapellidos, String pernombres, char persexo, String pertelefono, String perdireccion, char tipoe, char tipop, char tipoa, char tipoc) {
        super(perci, perapellidos, pernombres, persexo, pertelefono, perdireccion, tipoe, tipop, tipoa, tipoc);
    }

    public void insertar() {
        String comandoInsertarAdministrador = "insert into persona (perci, perapellidos, pernombres, persexo, pertelefono, perdireccion, tipoa) values ('" + this.perci + "', '" + this.perapellidos + "', '" + this.pernombres + "', '" + this.persexo + "', '" + this.pertelefono + "', '" + this.perdireccion + "', '1');";
        con.ejecutarComando(comandoInsertarAdministrador);
    }

    public void modificar() {
        String comandoModificarPersona = "update persona set perci = '" + this.perci + "', perapellidos = '" + this.perapellidos + "', pernombres = '" + this.pernombres + "', persexo = '" + this.persexo + "', pertelefono = '" + this.pertelefono + "', perdireccion = '" + this.perdireccion + "' where perci = '" + this.perci + "';";
        con.ejecutarComando(comandoModificarPersona);
    }

    public void eliminar() {
        String comando = "delete from persona where perci = '" + this.perci + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        try {
            String[] titulos = {"CI", "APELLIDOS", "NOMBRE", "SEXO", "TELEFONO", "DIRECCION"};
            DefaultTableModel model = new DefaultTableModel(null, titulos);

            String consulta = "select * from persona where tipoa = '1';";
            ResultSet resultado = con.ejecutarConsulta(consulta);

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Error interno en el servidor");
            }

            while (resultado.next()) {
                Object[] filaDatos = new Object[6];
                filaDatos[0] = resultado.getString("perci");
                filaDatos[1] = resultado.getString("perapellidos");
                filaDatos[2] = resultado.getString("pernombres");
                filaDatos[3] = resultado.getString("persexo");
                filaDatos[4] = resultado.getString("pertelefono");
                filaDatos[5] = resultado.getString("perdireccion");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
