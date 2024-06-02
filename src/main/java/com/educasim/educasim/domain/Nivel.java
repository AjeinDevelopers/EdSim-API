package com.educasim.educasim.domain;

public class Nivel {

    private int id;
    private int nivel;

    public Nivel() {
    }

    public Nivel(int id, int nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
