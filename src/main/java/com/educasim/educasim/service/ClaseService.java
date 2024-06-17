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
    ObtenerClasesResponse obtenerClasesProfesor(@RequestBody ObtenerClasesRequest profesor);
    ClaseObtenerAlumnosResponse obtenerAlumnos(@RequestBody ClaseDeleteRequest idClase);
    List<Materia> listarMaterias();
    List<Fase> listarFases();
    //Response cambiarClase(@RequestBody )
}
