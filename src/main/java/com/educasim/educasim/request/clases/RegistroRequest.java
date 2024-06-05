package com.educasim.educasim.request.clases;

import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.domain.Usuario;

public class RegistroRequest {

    private Usuario usuario;
    private Clase clase;

    public RegistroRequest(Usuario usuario, Clase clase) {
        this.usuario = usuario;
        this.clase = clase;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
