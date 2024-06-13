package com.educasim.educasim.request.clases;

public class ClaseRegistrarRequest {

    private String alumno;
    private String idClase;

    public ClaseRegistrarRequest() {
    }

    public ClaseRegistrarRequest(String alumno, String idClase) {
        this.alumno = alumno;
        this.idClase = idClase;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }
}
