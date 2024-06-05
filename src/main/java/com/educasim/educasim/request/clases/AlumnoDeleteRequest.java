/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educasim.educasim.request.clases;

public class AlumnoDeleteRequest {

    private String correo;
    private String pinSeguridad;

    public AlumnoDeleteRequest() {
    }

    public AlumnoDeleteRequest(String correo, String pinSeguridad) {
        this.correo = correo;
        this.pinSeguridad = pinSeguridad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPinSeguridad() {
        return pinSeguridad;
    }

    public void setPinSeguridad(String pinSeguridad) {
        this.pinSeguridad = pinSeguridad;
    }
    
    
    
}
