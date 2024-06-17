package com.educasim.educasim.domain;

public class Clase {

    private String id;
    private String nombre;
    private String materia;
    private String profesor;
    private String fase;

    public Clase() {
    }

    public Clase(String id, String nombre, String materia, String profesor, String fase) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
        this.profesor = profesor;
        this.fase = fase;
    }

    public Clase(String id, String nombre, String materia, String fase) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
        this.fase = fase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
}
