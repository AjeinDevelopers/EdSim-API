package com.educasim.educasim.domain;

import java.util.List;

public class Usuario {

    private int id;
    private String tipo;
    private String contrasena;
    private String pin;
    private String nombre;
    private String apePat;
    private String apeMat;
    private List<Contacto> contactos;
    private FormaAprendizaje formaAprendizaje;
    private List<Progreso> progresos;

    public Usuario() {
    }

    public Usuario(int id, String tipo, String contrasena, String nombre, String apePat, String apeMat, List<Contacto> contactos, FormaAprendizaje formaAprendizaje, List<Progreso> progresos) {
        this.id = id;
        this.tipo = tipo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.contactos = contactos;
        this.formaAprendizaje = formaAprendizaje;
        this.progresos = progresos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public FormaAprendizaje getFormaAprendizaje() {
        return formaAprendizaje;
    }

    public void setFormaAprendizaje(FormaAprendizaje formaAprendizaje) {
        this.formaAprendizaje = formaAprendizaje;
    }

    public List<Progreso> getProgresos() {
        return progresos;
    }

    public void setProgresos(List<Progreso> progresos) {
        this.progresos = progresos;
    }
}
