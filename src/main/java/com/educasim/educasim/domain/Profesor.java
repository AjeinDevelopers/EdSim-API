package com.educasim.educasim.domain;

public class Profesor {

    private int id;
    private String correo;
    private String contrasena;
    private String nombre;
    private String apePat;
    private String apeMat;

    public Profesor() {
    }

    public Profesor(int id, String correo, String contrasena, String nombre, String apePat, String apeMat) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
    }

    public Profesor(int id, String nombre, String apePat, String apeMat) {
        this.id = id;
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
}
