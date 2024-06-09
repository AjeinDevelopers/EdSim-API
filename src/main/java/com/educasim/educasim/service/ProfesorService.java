package com.educasim.educasim.service;

import com.educasim.educasim.domain.Profesor;
import com.educasim.educasim.request.clases.Response;
import com.educasim.educasim.request.clases.ProfesorLoginRequest;
import com.educasim.educasim.request.clases.ProfesorRegistroRequest;

public interface ProfesorService {
    
    
    
    public Response registro(ProfesorRegistroRequest registro);

    public Profesor login(ProfesorLoginRequest consulta);

    public Response eliminarCuenta(ProfesorLoginRequest consulta );
    
}
