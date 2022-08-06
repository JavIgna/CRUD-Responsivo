package Controlador;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase que contiene métodos para realizar validaciones input
 *
 * @author Javier
 */
public class ControladorValidacion {

    /**
     * Método que limita la cantidad de caracteres que permite un JTextField
     *
     * @param e Captura teclas presionadas
     * @param campoTexto Campo de texto en el que se ingresarán caracteres
     * @param limite Número máximo de caracteres que permitira el campo de texto
     */
    public void limitarCaracteres(KeyEvent e, JTextField campoTexto, int limite) {
        if (campoTexto.getText().length() == limite) {
            e.consume();
        }
    }

    /**
     * Método que verifica si un campo esta vacio
     *
     * @param campoTexto Campo de texto en el que se ingresarán caracteres
     * @return Verdadero o falso, según el campo de texto contenga o no
     * caracteres
     */
    public boolean esVacio(JTextField campoTexto) {
        if (campoTexto.getText().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Método que limita los caracteres a numeros No permite ingresar letras en
     * un campo de texto
     *
     * @param evt Captura teclas presionadas
     */
    public void soloNumeros(KeyEvent evt) {
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo ingresar numeros");
        }

    }

    /**
     * Método que limita los caracteres a letras No permite ingresar numeros en
     * un campo de texto
     *
     * @param evt Captura teclas presionadas
     */
    public void soloLetras(KeyEvent evt) {
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo ingresar letras");
        }

    }
}
