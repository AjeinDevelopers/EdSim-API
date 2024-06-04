package com.educasim.educasim.service;

import com.educasim.educasim.domain.Progreso;
import com.educasim.educasim.domain.Usuario;

import java.util.HashMap;
import java.util.Map;

public class SeguimientoServiceImpl implements SeguimientoService{

    @Override
    public Map<String, Progreso> obtenerProgreso(Usuario usuario) {
        if(usuario != null){
            Map<String, Progreso> resul = new HashMap<>();
            // Query
            return resul;
        }else{
            return null;
        }
    }

}
