package com.educasim.educasim.domain;

public class Clase {

    private String id;
    private String nombre;
    private Materia materia;
    private Alumno profesor;

    public Clase(String id, String nombre, Materia materia, Alumno profesor) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
        this.profesor = profesor;
    }

    public Clase() {
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getProfesor() {
        return profesor;
    }

    public void setProfesor(Alumno profesor) {
        this.profesor = profesor;
    }
}
