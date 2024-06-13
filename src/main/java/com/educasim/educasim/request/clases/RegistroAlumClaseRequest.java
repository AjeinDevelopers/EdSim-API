package com.educasim.educasim.request.clases;

public class RegistroAlumClaseRequest {

    private String alumno;
    private String idClase;

    public RegistroAlumClaseRequest() {
    }

    public RegistroAlumClaseRequest(String alumno, String idClase) {
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
