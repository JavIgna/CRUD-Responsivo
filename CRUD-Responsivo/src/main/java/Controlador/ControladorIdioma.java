package Controlador;

import Modelo.Idioma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que contiene los métodos de idioma para realizar CRUD en la BBDD
 *
 * @author Javier
 */
public class ControladorIdioma {

    Conexion miConexion = new Conexion();

    /**
     * Método que realiza consulta a la BBDD y crea una lista que contiene
     * idiomas
     *
     * @return Retorna una lista que contiene idiomas con sus atributos
     */
    public ArrayList<Idioma> getIdiomas() {
        ArrayList<Idioma> listaIdiomas = new ArrayList<>();
        try {
            String query = "SELECT * FROM idioma";
            Statement consulta = miConexion.getConexion().createStatement();
            ResultSet resultado = consulta.executeQuery(query);

            while (resultado.next()) {
                Integer cod_idioma = resultado.getInt("cod_idioma");
                String lengua = resultado.getString("lengua");
                Idioma idioma = new Idioma(cod_idioma, lengua);
                listaIdiomas.add(idioma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorIdioma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIdiomas;
    }

    /**
     * Método que ejecuta consulta a la BBDD para eliminar un idioma
     *
     * @param code_idioma Código del idioma
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean eliminarIdioma(Integer code_idioma) {
        boolean resultado = false;

        try {
            String query = "DELETE FROM idioma WHERE cod_idioma = " + code_idioma.toString();

            Statement eliminar = miConexion.getConexion().createStatement();
            eliminar.executeUpdate(query);

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorIdioma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Método que ejecuta consulta a la BBDD para crear un idioma
     *
     * @param lengua Nombre del idioma o lengua
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean crearIdioma(String lengua) {
        boolean resultado = false;

        try {
            String query = "INSERT INTO idioma (cod_idioma, lengua) VALUES ( NULL, '" + lengua + "')";
            Statement crear = miConexion.getConexion().createStatement();
            crear.executeUpdate(query);
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorIdioma.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    /**
     * Método que ejecuta consulta a la BBDD para modificar un idioma
     *
     * @param cod_idioma Código del idioma
     * @param lengua Nombre del idioma o lengua
     * @return Verdadero o falso, según se concreta o no la consulta SQL
     */
    public boolean cambiarIdioma(Integer cod_idioma, String lengua) {
        boolean resultado = false;
        try {
            String query = "UPDATE idioma SET lengua = '" + lengua
                    + "' WHERE cod_idioma = " + cod_idioma.toString();

            Statement actualizar = miConexion.getConexion().createStatement();
            actualizar.executeUpdate(query);

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorIdioma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
