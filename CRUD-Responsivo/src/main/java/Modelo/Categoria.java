package Modelo;

/**
 * Clase que contiene el constructor y métodos get and set de categoría
 *
 * @author Javier
 */
public class Categoria {

    private Integer cod_cate;
    private String nombre;

    /**
     * Constructor categoría sin parametros
     */
    public Categoria() {
    }

    /**
     * Constructor categoria con parametros
     *
     * @param cod_cate Codigo de categoría
     * @param nombre Nombre de categoría
     */
    public Categoria(Integer cod_cate, String nombre) {
        this.cod_cate = cod_cate;
        this.nombre = nombre;
    }

    /**
     * Método que solicita el código de categoria
     *
     * @return Devuelve el código de categoría
     */
    public Integer getCod_cate() {
        return cod_cate;
    }

    /**
     * Método que envia el código de categoría
     *
     * @param cod_cate Codigo de categoría
     */
    public void setCod_cate(Integer cod_cate) {
        this.cod_cate = cod_cate;
    }

    /**
     * Método que solicita el nombre de categoria
     *
     * @return Devuelve el nombre de categoría
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que envia el nombre de categoría
     *
     * @param nombre Nombre de categoría
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que crea un arrgeglo con los atributos del objeto categoría
     *
     * @return Devuelve el arreglo con los atributos del objeto categoría
     */
    public Object toArray() {
        Object[] array = {cod_cate, nombre};
        return array;
    }

}
