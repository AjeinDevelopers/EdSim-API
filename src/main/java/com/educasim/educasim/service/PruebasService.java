package com.educasim.educasim.service;

import com.educasim.educasim.domain.Ejercicio;
import com.educasim.educasim.domain.Examen;
import com.educasim.educasim.domain.Usuario;

import java.util.List;

public interface PruebasService {

    List<Examen> obtenerExamenes(int nivel, String materia);
    List<Ejercicio> obtenerEjercicios(int nivel, String materia);
    int registrarExamen(Usuario usuario, Examen examen, int aciertos, int intentos);
    int registrarEjercico(Usuario usuario, Ejercicio ejercicio, int aciertos);

}
