package clases;

import conexion.Conexion;
import formularios.FormLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Persona {

    protected String perci;
    protected String perapellidos;
    protected String pernombres;
    protected char persexo;
    protected String pertelefono;
    protected String perdireccion;
    protected char tipoe;
    protected char tipop;
    protected char tipoa;
    protected char tipoc;

    protected Conexion con = FormLogin.conexionBD;

    public Persona() {
    }

    public Persona(String perci, String perapellidos, String pernombres, char persexo, String pertelefono, String perdireccion, char tipoe, char tipop, char tipoa, char tipoc) {
        this.perci = perci;
        this.perapellidos = perapellidos;
        this.pernombres = pernombres;
        this.persexo = persexo;
        this.pertelefono = pertelefono;
        this.perdireccion = perdireccion;
        this.tipoe = tipoe;
        this.tipop = tipop;
        this.tipoa = tipoa;
        this.tipoc = tipoc;
    }

    public String getPerci() {
        return perci;
    }

    public void setPerci(String perci) {
        this.perci = perci;
    }

    public String getPerapellidos() {
        return perapellidos;
    }

    public void setPerapellidos(String perapellidos) {
        this.perapellidos = perapellidos;
    }

    public String getPernombres() {
        return pernombres;
    }

    public void setPernombres(String pernombres) {
        this.pernombres = pernombres;
    }

    public char getPersexo() {
        return persexo;
    }

    public void setPersexo(char persexo) {
        this.persexo = persexo;
    }

    public String getPertelefono() {
        return pertelefono;
    }

    public void setPertelefono(String pertelefono) {
        this.pertelefono = pertelefono;
    }

    public String getPerdireccion() {
        return perdireccion;
    }

    public void setPerdireccion(String perdireccion) {
        this.perdireccion = perdireccion;
    }

    public char getTipoe() {
        return tipoe;
    }

    public void setTipoe(char tipoe) {
        this.tipoe = tipoe;
    }

    public char getTipop() {
        return tipop;
    }

    public void setTipop(char tipop) {
        this.tipop = tipop;
    }

    public char getTipoa() {
        return tipoa;
    }

    public void setTipoa(char tipoa) {
        this.tipoa = tipoa;
    }

    public char getTipoc() {
        return tipoc;
    }

    public void setTipoc(char tipoc) {
        this.tipoa = tipoc;
    }

    public void busquedaPorCINombre(JTable tabla, String textoBusqueda) {
        String[] titulos = {"CI", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String consulta = "select perci, pernombres from persona where perci ILIKE '%" + textoBusqueda + "%' or pernombres ILIKE '%" + textoBusqueda + "%';";
        ResultSet resultado = con.ejecutarConsulta(consulta);

        try {
            while (resultado.next()) {
                Object[] filaDatos = new Object[2];
                filaDatos[0] = resultado.getObject("perci");
                filaDatos[1] = resultado.getObject("pernombres");

                model.addRow(filaDatos);
            }

            tabla.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
