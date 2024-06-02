package com.educasim.educasim.domain;

public class Tema {

    private int id;
    private String nombre;
    private Materia materia;
    private Nivel nivel;

    public Tema() {
    }

    public Tema(int id, String nombre, Materia materia, Nivel nivel) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
        this.nivel = nivel;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
