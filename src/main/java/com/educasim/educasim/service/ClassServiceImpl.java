package com.educasim.educasim.service;

import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl implements ClassService{
    @Override
    public int crearClase(Usuario profesor, String nombre, int nivel, List<Usuario> alumnos) {
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
    public int darDeAlta(Usuario usuario, Clase clase) {
        if(usuario != null && clase != null){
            int resul = 0;
            //Query
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public int darDeBaja(Usuario usuario, Clase clase) {
        if(usuario != null && clase != null){
            int resul = 0;
            // Query
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public List<Clase> obtenerClases(Usuario usuario) {
        if(usuario != null){
            List<Clase> clases = new ArrayList<>();
            //Query
            return clases;
        }else{
            return null;
        }
    }
}
