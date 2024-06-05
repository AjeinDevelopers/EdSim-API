package com.educasim.educasim.domain;

public class Tema {

    private int id;
    private String nombre;
    private Temario temario;

    public Tema() {
    }

    public Tema(int id, String nombre, Temario temario) {
        this.id = id;
        this.nombre = nombre;
        this.temario = temario;
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

    public Temario getTemario() {
        return temario;
    }

    public void setTemario(Temario temario) {
        this.temario = temario;
    }
}
