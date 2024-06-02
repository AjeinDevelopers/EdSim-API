package com.educasim.educasim.domain;

public class Contacto {

    private int id;
    private Usuario usuario;
    private String tipoContacto;
    private String contacto;

    public Contacto() {
    }

    public Contacto(int id, Usuario usuario, String tipoContacto, String contacto) {
        this.id = id;
        this.usuario = usuario;
        this.tipoContacto = tipoContacto;
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
