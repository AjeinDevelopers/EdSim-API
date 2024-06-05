package com.educasim.educasim.domain;

import java.util.List;

public class Alumno {

    private int id;
    private String correo;
    private String contrasena;
    private String pinSeguridad;
    private String nombre;
    private String apePat;
    private String apeMat;
    private String formaAprendizaje;

    public Alumno() {
    }

    public Alumno(int id, String correo, String contrasena, String pinSeguridad, String nombre, String apePat, String apeMat, String formaAprendizaje) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.pinSeguridad = pinSeguridad;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.formaAprendizaje = formaAprendizaje;
    }
    public Alumno(int id, String correo, String nombre, String apePat, String apeMat) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPinSeguridad() {
        return pinSeguridad;
    }

    public void setPinSeguridad(String pinSeguridad) {
        this.pinSeguridad = pinSeguridad;
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

    public String getFormaAprendizaje() {
        return formaAprendizaje;
    }

    public void setFormaAprendizaje(String formaAprendizaje) {
        this.formaAprendizaje = formaAprendizaje;
    }
}
