package com.educasim.educasim.service;

import com.educasim.educasim.domain.Profesor;
import com.educasim.educasim.request.clases.ProfesorDeleteRequest;
import com.educasim.educasim.request.clases.ProfesorLoginRequest;
import com.educasim.educasim.request.clases.ProfesorRegistroRequest;

public interface ProfesorService {
    
    
    
    public int registro(ProfesorRegistroRequest registro);

    /*public Profesor login(ProfesorLoginRequest consulta);

    public int eliminarCuenta(ProfesorDeleteRequest consulta);
    */
}
