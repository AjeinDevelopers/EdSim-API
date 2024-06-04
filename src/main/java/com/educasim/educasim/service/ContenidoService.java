package com.educasim.educasim.service;

import com.educasim.educasim.domain.Articulo;
import com.educasim.educasim.domain.Materia;
import com.educasim.educasim.domain.Nivel;

public interface ContenidoService {

    Articulo obtenerLecciones(Materia materia, Nivel nivel);

}
