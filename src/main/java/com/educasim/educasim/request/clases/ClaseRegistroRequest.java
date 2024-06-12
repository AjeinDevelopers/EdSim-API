package com.educasim.educasim.request.clases;

public class ClaseRegistroRequest {

    private String nombre;
    private String materia;
    private String profesor;
    private String fase;

    public ClaseRegistroRequest(String nombre, String materia, String profesor, String fase) {
        this.nombre = nombre;
        this.materia = materia;
        this.profesor = profesor;
        this.fase = fase;
    }

    public ClaseRegistroRequest() {
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
