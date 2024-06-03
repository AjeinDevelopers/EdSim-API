package com.educasim.educasim.domain;

public class Contacto {

    private int id;
    private String tipoContacto;
    private String contacto;

    public Contacto() {
    }

    public Contacto(int id, String tipoContacto, String contacto) {
        this.id = id;
        this.tipoContacto = tipoContacto;
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
