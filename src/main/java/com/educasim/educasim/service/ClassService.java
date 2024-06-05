package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;

import java.util.List;

public interface ClassService {

    int crearClase(Alumno profesor, String nombre, int nivel, List<Alumno> alumnos);
    int eliminarClase(Clase clase);
    String obtenerCodigo(String codigo);
    int darDeAlta(Alumno alumno, Clase clase);
    int darDeBaja(Alumno alumno, Clase clase);
    List<Clase> obtenerClases(Alumno alumno);

}
