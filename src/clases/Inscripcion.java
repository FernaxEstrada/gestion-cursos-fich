package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Inscripcion {

    private String curid;
    private String perci;
    private String isnfecha;
    private String inspago;

    Conexion con = FormLogin.conexionBD;

    public Inscripcion() {
    }

    public Inscripcion(String curid, String perci, String isnfecha, String inspago) {
        this.curid = curid;
        this.perci = perci;
        this.isnfecha = isnfecha;
        this.inspago = inspago;
    }

    public String getCurid() {
        return curid;
    }

    public void setCurid(String curid) {
        this.curid = curid;
    }

    public String getPerci() {
        return perci;
    }

    public void setPerci(String perci) {
        this.perci = perci;
    }

    public String getIsnfecha() {
        return isnfecha;
    }

    public void setIsnfecha(String isnfecha) {
        this.isnfecha = isnfecha;
    }

    public String getInspago() {
        return inspago;
    }

    public void setInspago(String inspago) {
        this.inspago = inspago;
    }

    public void insertar() {
        String comando = "insert into inscripcion (curid, perci, insfecha, inspago) values ('" + this.curid + "', '" + this.perci + "', NOW(), '" + this.inspago + "');";
        con.ejecutarComando(comando);
    }

    public void eliminar() {
        String comando = "delete from inscripcion where curid = '" + this.curid + "' and perci = '" + this.perci + "';";
        con.ejecutarComando(comando);
    }

    public void mostrar(JTable tabla) {
        String[] titulos = {"ID CURSO", "ID PERSONA", "FECHA", "PAGO"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select * from inscripcion;";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {

            while (resultado.next()) {
                Object[] filaDatos = new Object[4];
                filaDatos[0] = resultado.getObject("curid");
                filaDatos[1] = resultado.getObject("perci");
                filaDatos[2] = resultado.getObject("insfecha");
                filaDatos[3] = resultado.getObject("inspago");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
