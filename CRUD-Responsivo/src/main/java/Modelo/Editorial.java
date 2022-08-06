package Modelo;

/**
 * Clase que contiene el constructor y métodos get and set de editorial
 *
 * @author Javier
 */
public class Editorial {

    private Integer cod_edi;
    private String nombre;

    /**
     * Constructor editorial sin parametros
     */
    public Editorial() {
    }

    /**
     * Constructor editorial con parametros
     *
     * @param cod_edi Codigo de editorial
     * @param nombre Nombre de editorial
     */
    public Editorial(Integer cod_edi, String nombre) {
        this.cod_edi = cod_edi;
        this.nombre = nombre;
    }

    /**
     * Método que solicita el código de editorial
     *
     * @return Devuelve el código de editorial
     */
    public Integer getCod_edi() {
        return cod_edi;
    }

    /**
     * Método que envia el código de editorial
     *
     * @param cod_edi Codigo de editorial
     */
    public void setCod_edi(Integer cod_edi) {
        this.cod_edi = cod_edi;
    }

    /**
     * Método que solicita el nombre de editorial
     *
     * @return Devuelve el nombre de editorial
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que envia el nombre de editorial
     *
     * @param nombre Nombre de editorial
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que crea un arrgeglo con los atributos del objeto editorial
     *
     * @return Devuelve el arreglo con los atributos del objeto editorial
     */
    public Object toArray() {
        Object[] array = {cod_edi, nombre};
        return array;
    }
}
