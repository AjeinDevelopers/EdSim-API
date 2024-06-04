package com.educasim.educasim.domain;

public class Clase {

    private String id;
    private String nombre;
    private Nivel nivel;
    private Usuario profesor;
    private Materia materia;

    public Clase() {
    }

    public Clase(int id, String nombre, Nivel nivel, Usuario profesor, Materia materia) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.profesor = profesor;
        this.materia = materia;
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

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
