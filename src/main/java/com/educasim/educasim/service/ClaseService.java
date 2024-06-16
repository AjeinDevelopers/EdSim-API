package com.educasim.educasim.service;

import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.domain.Fase;
import com.educasim.educasim.domain.Materia;
import com.educasim.educasim.request.clases.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClaseService {

    ClaseResponse crearClase(@RequestBody ClaseRegistroRequest clase);
    Response eliminarClase(@RequestBody ClaseDeleteRequest clase);
    Response darDeAlta(@RequestBody RegistroAlumClaseRequest request);
    Response darDeBaja(@RequestBody RegistroAlumClaseRequest request);
    List<Clase> obtenerClasesAlumno(@RequestBody String alumno);
    ClaseObtenerAlumnosResponse obtenerAlumnos(@RequestBody ClaseDeleteRequest idClase);
    List<Materia> listarMaterias();
    List<Fase> listarFases();
}
