package com.educasim.educasim.request.clases;

public class ProfesorRegistroRequest {

    private String correo;
    private String contrasena;
    private String nombre;
    private String apePat;
    private String apeMat;

    public ProfesorRegistroRequest() {
    }

    public ProfesorRegistroRequest(String correo, String contrasena, String nombre, String apePat, String apeMat) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
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
