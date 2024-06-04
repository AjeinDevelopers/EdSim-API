package com.educasim.educasim.service;

import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.domain.Usuario;

import java.util.List;

public interface ClassService {

    int crearClase(Usuario profesor, String nombre, int nivel, List<Usuario> alumnos);
    int eliminarClase(Clase clase);
    int obtenerCodigo(String codigo);
    int darDeAlta(Usuario usuario, Clase clase);
    int darDeBaja(Usuario usuario, Clase clase);
    List<Clase> obtenerClases(Usuario usuario);

}
