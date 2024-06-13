package com.educasim.educasim.request.clases;
import com.educasim.educasim.domain.Alumno;
import java.util.List;

public class ClaseObtenerAlumnosResponse {

    List<Alumno> alumnos;
    boolean error;
    String mensaje;

    public ClaseObtenerAlumnosResponse(List<Alumno> alumnos, boolean error, String mensaje) {
        this.alumnos = alumnos;
        this.error = error;
        this.mensaje = mensaje;
    }

    public ClaseObtenerAlumnosResponse() {
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
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
