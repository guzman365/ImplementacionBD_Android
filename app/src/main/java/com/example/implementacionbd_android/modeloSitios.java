package com.example.implementacionbd_android;

public class modeloSitios {
    //Atributos de la clase con los elementos de la tabla en la base de datos
    private String icono;
    private String titulo;
    private String introduccion;
    private String descripcion;
    private String portada;

    //Constructor
    public modeloSitios(String icono, String titulo, String introduccion, String descripcion, String portada) {
        this.icono = icono;
        this.titulo = titulo;
        this.introduccion = introduccion;
        this.descripcion = descripcion;
        this.portada = portada;
    }

    public modeloSitios() {
    }

    //Metodos GETTER y SETTER
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
