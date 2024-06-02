package com.educasim.educasim.domain;

import java.util.List;
import java.util.Timer;

public class Examen {

    private int id;
    private int cantReactivos;
    private Timer duracion;
    private List<Pregunta> preguntas;
    private Tema tema;
    private String url;

    public Examen() {
    }

    public Examen(int id, int cantReactivos, Timer duracion, List<Pregunta> preguntas, Tema tema, String url) {
        this.id = id;
        this.cantReactivos = cantReactivos;
        this.duracion = duracion;
        this.preguntas = preguntas;
        this.tema = tema;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantReactivos() {
        return cantReactivos;
    }

    public void setCantReactivos(int cantReactivos) {
        this.cantReactivos = cantReactivos;
    }

    public Timer getDuracion() {
        return duracion;
    }

    public void setDuracion(Timer duracion) {
        this.duracion = duracion;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
