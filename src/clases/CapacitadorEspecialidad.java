package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CapacitadorEspecialidad {

    private String perci;
    private String espeid;

    Conexion con = FormLogin.conexionBD;

    public CapacitadorEspecialidad() {
    }

    public CapacitadorEspecialidad(String perci, String espeid) {
        this.perci = perci;
        this.espeid = espeid;
    }

    public String getPerci() {
        return perci;
    }

    public void setPerci(String perci) {
        this.perci = perci;
    }

    public String getEspeid() {
        return espeid;
    }

    public void setEspeid(String espeid) {
        this.espeid = espeid;
    }

    public void insertar() {
        String comando = "insert into capacitador_especialidad values ('" + this.perci + "', '" + this.espeid + "');";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from capacitador_especialidad where perci = '" + this.perci + "' and espeid = '" + this.espeid + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"CI PERSONA", "ID ESPECIALIDAD"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from capacitador_especialidad;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("perci");
                filaDatos[1] = resultado.getObject("espeid");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(CapacitadorEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
