package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Ejercicio;
import com.educasim.educasim.domain.Examen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PurebasServiceImpl implements PruebasService{


    @Override
    public List<Examen> obtenerExamenes(int nivel, String materia) {
        if(nivel != 0 && !materia.isEmpty()){
            List<Examen> examenes = new ArrayList<Examen>();
            ResultSet resulQuery = null;
            //@Query
            return examenes;
        }else{
            return null;
        }
    }

    @Override
    public List<Ejercicio> obtenerEjercicios(int nivel, String materia) {
        if(nivel != 0 && !materia.isEmpty()){
            List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
            ResultSet resulQuery = null;
            //@Query
            return ejercicios;
        }else{
            return null;
        }
    }

    @Override
    public int registrarExamen(Alumno alumno, Examen examen, int aciertos, int intentos) {
        if(alumno != null && examen != null && aciertos >= 0 && intentos > 0){
            int resultado = 0;
            //Query
            return resultado;
        }else{
            return 0;
        }
    }

    @Override
    public int registrarEjercico(Alumno alumno, Ejercicio ejercicio, int aciertos) {
        return 0;
    }
}
