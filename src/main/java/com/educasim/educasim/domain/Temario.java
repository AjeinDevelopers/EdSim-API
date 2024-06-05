package com.educasim.educasim.domain;

public class Temario {

    private int id;
    private Materia materia;

    public Temario() {
    }

    public Temario(int id, Materia materia) {
        this.id = id;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
