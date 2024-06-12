package com.educasim.educasim.request.clases;

public class ClaseDeleteRequest {

    private String idClase;
    private String profesor;

    public ClaseDeleteRequest() {
    }

    public ClaseDeleteRequest(String idClase, String profesor) {
        this.idClase = idClase;
        this.profesor = profesor;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
