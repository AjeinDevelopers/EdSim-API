package com.educasim.educasim.domain;

public class PreguntaExamen {

    private int id;
    private String enunciado;
    private String respCorrecta;

    public PreguntaExamen() {
    }

    public PreguntaExamen(int id, String enunciado, String respCorrecta) {
        this.id = id;
        this.enunciado = enunciado;
        this.respCorrecta = respCorrecta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespCorrecta() {
        return respCorrecta;
    }

    public void setRespCorrecta(String respCorrecta) {
        this.respCorrecta = respCorrecta;
    }
}
