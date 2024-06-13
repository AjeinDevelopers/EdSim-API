package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import com.educasim.educasim.request.clases.ClaseRegistrarRequest;
import com.educasim.educasim.request.clases.ClaseRegistroRequest;
import com.educasim.educasim.request.clases.ClaseResponse;
import com.educasim.educasim.request.clases.Response;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClassService {

    ClaseResponse crearClase(@RequestBody ClaseRegistroRequest clase);
    Response eliminarClase(@RequestBody ClaseDeleteRequest clase);
    Response darDeAlta(@RequestBody ClaseRegistrarRequest request);
    Response darDeBaja(@RequestBody ClaseRegistrarRequest request);
    List<Clase> obtenerClases(Alumno alumno);

}
