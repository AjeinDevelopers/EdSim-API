package com.educasim.educasim.request.clases;

import com.educasim.educasim.domain.Clase;

import java.util.List;

public class ObtenerClasesResponse {

    List<Clase> clases;
    boolean error;
    String mensaje;

    public ObtenerClasesResponse(List<Clase> clases, boolean error, String mensaje) {
        this.clases = clases;
        this.error = error;
        this.mensaje = mensaje;
    }

    public ObtenerClasesResponse() {
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
