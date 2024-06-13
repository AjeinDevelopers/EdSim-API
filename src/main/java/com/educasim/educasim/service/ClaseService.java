package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import com.educasim.educasim.request.clases.RegistroAlumClaseRequest;
import com.educasim.educasim.request.clases.ClaseRegistroRequest;
import com.educasim.educasim.request.clases.ClaseResponse;
import com.educasim.educasim.request.clases.Response;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClaseService {

    ClaseResponse crearClase(@RequestBody ClaseRegistroRequest clase);
    Response eliminarClase(@RequestBody ClaseDeleteRequest clase);
    Response darDeAlta(@RequestBody RegistroAlumClaseRequest request);
    Response darDeBaja(@RequestBody RegistroAlumClaseRequest request);
    List<String> listarMaterias();
}
