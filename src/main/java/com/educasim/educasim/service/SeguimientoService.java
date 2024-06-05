package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;

import java.util.Map;

public interface SeguimientoService {

    Map<String, Progreso> obtenerProgreso(Alumno alumno);

}
