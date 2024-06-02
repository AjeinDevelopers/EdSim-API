package com.educasim.educasim.domain;

public class Progreso {

    private int id;
    private int escala;
    private Tema tema;

    public Progreso() {
    }

    public Progreso(int id, int escala, Tema tema) {
        this.id = id;
        this.escala = escala;
        this.tema = tema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEscala() {
        return escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}