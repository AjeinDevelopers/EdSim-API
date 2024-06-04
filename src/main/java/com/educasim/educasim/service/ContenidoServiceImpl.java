package com.educasim.educasim.service;

import com.educasim.educasim.domain.Articulo;
import com.educasim.educasim.domain.Materia;
import com.educasim.educasim.domain.Nivel;

public class ContenidoServiceImpl implements ContenidoService{
    @Override
    public Articulo obtenerLecciones(Materia materia, Nivel nivel) {
        if(materia != null && nivel != null){
            Articulo articulo = new Articulo();
            //Query
            return articulo;
        }else{
            return null;
        }
    }

}
