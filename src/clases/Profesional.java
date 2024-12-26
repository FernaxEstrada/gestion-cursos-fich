package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Profesional extends Persona {

    public Profesional() {
    }

    public Profesional(String perci, String perapellidos, String pernombres, char persexo, String pertelefono, String perdireccion, char tipoe, char tipop, char tipoa, char tipoc) {
        super(perci, perapellidos, pernombres, persexo, pertelefono, perdireccion, tipoe, tipop, tipoa, tipoc);
    }

    public void insertar() {
        String comandoInsertarProfesional = "insert into persona (perci, perapellidos, pernombres, persexo, pertelefono, perdireccion, tipop) values ('" + this.getPerci() + "', '" + this.getPerapellidos() + "', '" + this.getPernombres() + "', '" + this.getPersexo() + "', '" + this.getPertelefono() + "', '" + this.getPerdireccion() + "', '1');";
        con.ejecutarComando(comandoInsertarProfesional);
    }

    public void modificar() {
        String comandoModificarProfesional = "update persona set perci = '" + this.getPerci() + "', perapellidos = '" + this.getPerapellidos() + "', pernombres = '" + this.getPernombres() + "', persexo = '" + this.getPersexo() + "', pertelefono = '" + this.getPertelefono() + "', perdireccion = '" + this.getPerdireccion() + "' where perci = '" + this.getPerci() + "';";
        con.ejecutarComando(comandoModificarProfesional);
    }

    public void eliminar() {
        String comando = "delete from persona where perci = '" + this.getPerci() + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        try {

            String[] titulos = {"CI", "APELLIDOS", "NOMBRE", "SEXO", "TELEFONO", "DIRECCION"};
            DefaultTableModel model = new DefaultTableModel(null, titulos);

            String consulta = "select * from persona where tipop = '1';";
            ResultSet resultado = con.ejecutarConsulta(consulta);

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Error interno en el servidor");
            }

            while (resultado.next()) {
                Object[] filaDatos = new Object[6];
                filaDatos[0] = resultado.getObject("perci");
                filaDatos[1] = resultado.getObject("perapellidos");
                filaDatos[2] = resultado.getObject("pernombres");
                filaDatos[3] = resultado.getObject("persexo");
                filaDatos[4] = resultado.getObject("pertelefono");
                filaDatos[5] = resultado.getObject("perdireccion");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
