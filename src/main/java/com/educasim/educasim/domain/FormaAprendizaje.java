package com.educasim.educasim.domain;

public class FormaAprendizaje {

    private int id;
    private int nombre;

    public FormaAprendizaje() {
    }

    public FormaAprendizaje(int id, int nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
