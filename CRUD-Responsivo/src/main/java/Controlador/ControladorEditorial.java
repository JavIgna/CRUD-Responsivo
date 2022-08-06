package Controlador;

import Modelo.Editorial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que contiene los métodos de editorial para realizar CRUD en la BBDD
 *
 * @author Javier
 */
public class ControladorEditorial {

    Conexion miConexion = new Conexion();

    /**
     * Método que realiza consulta a la BBDD y crea una lista que contiene
     * editoriales
     *
     * @return Retorna una lista que contiene editoriales con sus atributos
     */
    public ArrayList<Editorial> getEditoriales() {
        ArrayList<Editorial> listaEditoriales = new ArrayList<>();
        try {
            String query = "SELECT * FROM editorial";
            Statement consulta = miConexion.getConexion().createStatement();
            ResultSet resultado = consulta.executeQuery(query);

            while (resultado.next()) {
                Integer cod_edi = resultado.getInt("cod_edi");
                String nombre = resultado.getString("nombre");
                Editorial editorial = new Editorial(cod_edi, nombre);
                listaEditoriales.add(editorial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEditoriales;
    }

    /**
     * Método que ejecuta consulta a la BBDD para eliminar una editorial
     *
     * @param code_edi Código de la editorial
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean eliminarEditorial(Integer code_edi) {
        boolean resultado = false;

        try {
            String query = "DELETE FROM editorial WHERE cod_edi = " + code_edi.toString();

            Statement eliminar = miConexion.getConexion().createStatement();
            eliminar.executeUpdate(query);

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Método que ejecuta consulta a la BBDD para crear una editorial
     *
     * @param nombre Nombre de la editorial
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean crearEditorial(String nombre) {
        boolean resultado = false;

        try {
            String query = "INSERT INTO editorial (cod_edi, nombre) VALUES ( NULL, '" + nombre + "')";
            Statement crear = miConexion.getConexion().createStatement();
            crear.executeUpdate(query);
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Método que ejecuta consulta a la BBDD para modificar una editorial
     *
     * @param cod_edi Código de la editorial
     * @param nombre Nombre de la editorial
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean cambiarEditorial(Integer cod_edi, String nombre) {
        boolean resultado = false;
        try {
            String query = "UPDATE editorial SET nombre = '" + nombre
                    + "' WHERE cod_edi = " + cod_edi.toString();

            Statement actualizar = miConexion.getConexion().createStatement();
            actualizar.executeUpdate(query);

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEditorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
