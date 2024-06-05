package com.educasim.educasim.domain;

public class Respuesta {

    private int id;
    private String respuesta;

    public Respuesta() {
    }

    public Respuesta(int id, String respuesta) {
        this.id = id;
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
