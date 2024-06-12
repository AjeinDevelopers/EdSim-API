package com.educasim.educasim.request.clases;

public class ClaseResponse {

    private String idClase;
    private boolean error;
    private String mensaje;

    public ClaseResponse(String idClase, boolean error, String mensaje) {
        this.idClase = idClase;
        this.error = error;
        this.mensaje = mensaje;
    }

    public ClaseResponse() {
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
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
