package Modelo;

/**
 * Clase que contiene el constructor y métodos get and set de idioma
 *
 * @author Javier
 */
public class Idioma {

    private Integer cod_idioma;
    private String lengua;

    /**
     * Constructor idioma sin parametros
     */
    public Idioma() {
    }

    /**
     * Constructor idioma con parametros
     *
     * @param cod_idioma  Codigo de idioma
     * @param lengua Nombre de idioma o lengua
     */
    public Idioma(Integer cod_idioma, String lengua) {
        this.cod_idioma = cod_idioma;
        this.lengua = lengua;
    }

    /**
     * Método que solicita el código de idioma
     *
     * @return Devuelve el código de idioma
     */
    public Integer getCod_idioma() {
        return cod_idioma;
    }

    /**
     * Método que envia el código de idioma
     *
     * @param cod_idioma  Codigo de idioma
     */
    public void setCod_idioma(Integer cod_idioma) {
        this.cod_idioma = cod_idioma;
    }

    /**
     * Método que solicita el nombre de idioma o lengua
     *
     * @return Devuelve el nombre de idioma o lengua
     */
    public String getLengua() {
        return lengua;
    }

     /**
     * Método que envia el nombre de idioma o lengua
     *
     * @param lengua Nombre de idioma o lengua
     */
    public void setLengua(String lengua) {
        this.lengua = lengua;
    }

    /**
     * Método que crea un arrgeglo con los atributos del objeto idioma
     *
     * @return Devuelve el arreglo con los atributos del objeto idioma
     */
    public Object toArray() {
        Object[] array = {cod_idioma, lengua};
        return array;
    }
}
