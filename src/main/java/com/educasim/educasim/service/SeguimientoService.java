package com.educasim.educasim.service;

import com.educasim.educasim.domain.Progreso;
import com.educasim.educasim.domain.Usuario;

import java.util.Map;

public interface SeguimientoService {

    Map<String, Progreso> obtenerProgreso(Usuario usuario);

}
