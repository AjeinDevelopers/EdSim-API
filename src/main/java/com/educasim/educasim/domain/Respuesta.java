package com.educasim.educasim.domain;

public class Respuesta {

    private int id;
    private String respuesta;
    private Pregunta pregunta;

    public Respuesta() {
    }

    public Respuesta(int id, String respuesta, Pregunta pregunta) {
        this.id = id;
        this.respuesta = respuesta;
        this.pregunta = pregunta;
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

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
