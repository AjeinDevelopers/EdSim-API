package com.educasim.educasim.service;

import com.educasim.educasim.domain.Ejercicio;
import com.educasim.educasim.domain.Examen;
import com.educasim.educasim.domain.Alumno;

import java.util.List;

public interface PruebasService {

    List<Examen> obtenerExamenes(int nivel, String materia);
    List<Ejercicio> obtenerEjercicios(int nivel, String materia);
    int registrarExamen(Alumno alumno, Examen examen, int aciertos, int intentos);
    int registrarEjercico(Alumno alumno, Ejercicio ejercicio, int aciertos);

}
