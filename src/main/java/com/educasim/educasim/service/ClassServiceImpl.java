package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;

import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl implements ClassService{
    @Override
    public int crearClase(Alumno profesor, String nombre, int nivel, List<Alumno> alumnos) {
        if(profesor != null && !nombre.isEmpty() && nivel > 0 && alumnos != null){
            int resul = 0;
            // Query()
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public int eliminarClase(Clase clase) {
        if(clase != null){
            int resul = 0;
            // Query ()
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public String obtenerCodigo(String codigo) {
        if(!codigo.isEmpty()){
            String resul = "";
            // Query
            return resul;
        }else{
            return null;
        }
    }

    @Override
    public int darDeAlta(Alumno alumno, Clase clase) {
        if(alumno != null && clase != null){
            int resul = 0;
            //Query
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public int darDeBaja(Alumno alumno, Clase clase) {
        if(alumno != null && clase != null){
            int resul = 0;
            // Query
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public List<Clase> obtenerClases(Alumno alumno) {
        if(alumno != null){
            List<Clase> clases = new ArrayList<>();
            //Query
            return clases;
        }else{
            return null;
        }
    }
}
