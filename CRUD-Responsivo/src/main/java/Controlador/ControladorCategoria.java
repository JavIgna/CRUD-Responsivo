package Controlador;

import Modelo.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que contiene los métodos de categoria para realizar CRUD en la BBDD
 *
 * @author Javier
 */
public class ControladorCategoria {

    Conexion miConexion = new Conexion();

    /**
     * Método que realiza consulta a la BBDD y crea una lista que contiene
     * categorias
     *
     * @return Retorna una lista que contiene categorías con sus atributos
     */
    public ArrayList<Categoria> getCategorias() {
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        try {
            String query = "SELECT * FROM categoria";
            Statement consulta = miConexion.getConexion().createStatement();
            ResultSet resultado = consulta.executeQuery(query);

            while (resultado.next()) {
                Integer cod_cate = resultado.getInt("cod_cate");
                String nombre = resultado.getString("nombre");
                Categoria categoria = new Categoria(cod_cate, nombre);
                listaCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategorias;
    }

    /**
     * Método que ejecuta consulta a la BBDD para eliminar una categoría
     *
     * @param cod_cate Código de la categoría
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean eliminarCategoria(Integer cod_cate) {
        boolean resultado = false;

        try {
            String query = "DELETE FROM categoria WHERE cod_cate = " + cod_cate.toString();

            Statement eliminar = miConexion.getConexion().createStatement();
            eliminar.executeUpdate(query);

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Método que ejecuta consulta a la BBDD para crear una categoría
     *
     * @param nombre Nombre de la categoría
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean crearCategoria(String nombre) {
        boolean resultado = false;

        try {
            String query = "INSERT INTO categoria (cod_cate, nombre) VALUES ( NULL, '" + nombre + "')";
            Statement crear = miConexion.getConexion().createStatement();
            crear.executeUpdate(query);
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Método que ejecuta consulta a la BBDD para modificar una categoría
     *
     * @param cod_cate Código de la categoría
     * @param nombre Nombre de la categoría
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean cambiarCategoria(Integer cod_cate, String nombre) {
        boolean resultado = false;
        try {
            String query = "UPDATE categoria SET nombre = '" + nombre
                    + "' WHERE cod_cate = " + cod_cate.toString();

            Statement actualizar = miConexion.getConexion().createStatement();
            actualizar.executeUpdate(query);

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
