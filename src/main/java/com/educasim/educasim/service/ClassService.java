package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import com.educasim.educasim.request.clases.ClaseRegistroRequest;
import com.educasim.educasim.request.clases.ClaseResponse;
import com.educasim.educasim.request.clases.Response;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClassService {

    ClaseResponse crearClase(@RequestBody ClaseRegistroRequest clase);
    Response eliminarClase(@RequestBody ClaseDeleteRequest clase);
    String obtenerCodigo(String codigo);
    int darDeAlta(Alumno alumno, Clase clase);
    int darDeBaja(Alumno alumno, Clase clase);
    List<Clase> obtenerClases(Alumno alumno);

}
