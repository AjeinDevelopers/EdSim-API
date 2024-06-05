package com.educasim.educasim.request.clases;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;

public class RegistroRequest {

    private Alumno alumno;
    private Clase clase;

    public RegistroRequest(Alumno alumno, Clase clase) {
        this.alumno = alumno;
        this.clase = clase;
    }

    public Alumno getUsuario() {
        return alumno;
    }

    public void setUsuario(Alumno alumno) {
        this.alumno = alumno;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
