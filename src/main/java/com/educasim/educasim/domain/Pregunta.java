package com.educasim.educasim.domain;

public class Pregunta {

    private int idPregunta;
    private String enunciado;
    private Respuesta respuesta;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, String enunciado, Respuesta respuesta) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }
}
