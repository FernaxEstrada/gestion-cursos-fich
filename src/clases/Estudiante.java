package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Estudiante extends Persona {

    private String estnumregistro;

    public Estudiante() {
    }

    public Estudiante(String perci, String perapellidos, String pernombres, char persexo, String pertelefono, String perdireccion, String estnumregistro, char tipoe, char tipop, char tipoa, char tipoc) {
        super(perci, perapellidos, pernombres, persexo, pertelefono, perdireccion, tipoe, tipop, tipoa, tipoc);
        this.estnumregistro = estnumregistro;
    }

    public String getEstnumregistro() {
        return estnumregistro;
    }

    public void setEstnumregistro(String estnumregistro) {
        this.estnumregistro = estnumregistro;
    }

    public void insertar() {
        String comandoInsertarEstudiante = "insert into persona (perci, perapellidos, pernombres, persexo, pertelefono, perdireccion, estnumregistro, tipoe) values ('" + this.getPerci() + "', '" + this.getPerapellidos() + "', '" + this.getPernombres() + "', '" + this.getPersexo() + "', '" + this.getPertelefono() + "', '" + this.getPerdireccion() + "', '" + this.getEstnumregistro() + "', '1');";
        con.ejecutarComando(comandoInsertarEstudiante);
    }

    public void modificar() {
        String comandoModificarEstudiante = "update persona set perci = '" + this.getPerci() + "', perapellidos = '" + this.getPerapellidos() + "', pernombres = '" + this.getPernombres() + "', persexo = '" + this.getPersexo() + "', pertelefono = '" + this.getPertelefono() + "', perdireccion = '" + this.getPerdireccion() + "', estnumregistro = '" + this.getEstnumregistro() + "' where perci = '" + this.getPerci() + "';";
        con.ejecutarComando(comandoModificarEstudiante);
    }

    public void eliminar() {
        String comando = "delete from persona where perci = '" + this.getPerci() + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        try {
            String[] titulos = {"CI", "REGISTRO", "APELLIDOS", "NOMBRE", "SEXO", "TELEFONO", "DIRECCION"};
            DefaultTableModel model = new DefaultTableModel(null, titulos);

            String consulta = "select * from persona where tipoe = '1';";
            ResultSet resultado = con.ejecutarConsulta(consulta);

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Error interno en el servidor");
            }

            while (resultado.next()) {
                Object[] filaDatos = new Object[7];
                filaDatos[0] = resultado.getString("perci");
                filaDatos[1] = resultado.getString("estnumregistro");
                filaDatos[2] = resultado.getString("perapellidos");
                filaDatos[3] = resultado.getString("pernombres");
                filaDatos[4] = resultado.getString("persexo");
                filaDatos[5] = resultado.getString("pertelefono");
                filaDatos[6] = resultado.getString("perdireccion");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
