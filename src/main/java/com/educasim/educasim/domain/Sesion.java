package com.educasim.educasim.domain;

public class Sesion {

    String sesionId;
    String type;

    public Sesion(String sesionId, String type) {
        this.sesionId = sesionId;
        this.type = type;
    }

    public Sesion() {
    }

    public String getSesionId() {
        return sesionId;
    }

    public void setSesionId(String sesionId) {
        this.sesionId = sesionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
