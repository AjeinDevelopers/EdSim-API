package com.educasim.educasim.domain;

public class PreguntaEjercicio {

    private int idPregunta;
    private String enunciado;
    private String respCorrecta;

    public PreguntaEjercicio(int idPregunta, String enunciado, String respCorrecta) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.respCorrecta = respCorrecta;
    }

    public PreguntaEjercicio() {
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

    public String getRespCorrecta() {
        return respCorrecta;
    }

    public void setRespCorrecta(String respCorrecta) {
        this.respCorrecta = respCorrecta;
    }
}
