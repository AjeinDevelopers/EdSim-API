package com.educasim.educasim.domain;

import java.util.List;

public class Materia {

    private int id;
    private String nombre;


    public Materia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Materia() {
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
}
