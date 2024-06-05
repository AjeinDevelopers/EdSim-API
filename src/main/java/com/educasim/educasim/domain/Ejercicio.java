package com.educasim.educasim.domain;

import java.util.List;

public class Ejercicio {

    private int id;
    private String nombre;
    private int cantReactivos;
    private String url;

    public Ejercicio() {
    }

    public Ejercicio(int id, String nombre, int cantReactivos, String url) {
        this.id = id;
        this.nombre = nombre;
        this.cantReactivos = cantReactivos;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantReactivos() {
        return cantReactivos;
    }

    public void setCantReactivos(int cantReactivos) {
        this.cantReactivos = cantReactivos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
