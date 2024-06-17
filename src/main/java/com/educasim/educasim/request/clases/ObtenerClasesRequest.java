package com.educasim.educasim.request.clases;

public class ObtenerClasesRequest {

    String usuario;
    String tipoUsuario;

    public ObtenerClasesRequest(String usuario, String tipoUsuario) {
        this.usuario = usuario;
        this.tipoUsuario = tipoUsuario;
    }

    public ObtenerClasesRequest() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
