package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Una clase encargada de establecer la conexion con la base de datos.
 * @author Javier Navarrete
 */
public class Conexion {

    private Connection miConexion;

    private String user_bd = "root";
    private String pass_bd = "";
    private String str_conn = "jdbc:mysql://localhost:3306/fastdevelopment";

    /**
     * Método que crea la conexión a BBDD.
     */
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            miConexion = DriverManager.getConnection(str_conn, user_bd, pass_bd);
        } catch (SQLException e) {
            e.printStackTrace();
            int op = JOptionPane.showConfirmDialog(null, "No se logró conectar a la Base de Datos","No hay conexión",JOptionPane.CANCEL_OPTION);
            if (op == 0) {
                System.exit(0);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);

        }
    }

    /**
     * Método que retorna una conexión con la BBDD.
     * Si la conexión es exitosa el programa inicia correctamente.
     * Si la conexión no es exitosa, informa y luego se cierra la aplicación.
     * @return Connection Devuele la conexión.
     */
    public Connection getConexion() {
        return miConexion;
    }
}
