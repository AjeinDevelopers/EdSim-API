package com.educasim.educasim.service;

import com.educasim.educasim.domain.Sesion;
import com.educasim.educasim.request.clases.LoginResponse;
import com.educasim.educasim.request.clases.Response;
import com.educasim.educasim.request.clases.ProfesorLoginRequest;
import com.educasim.educasim.request.clases.ProfesorRegistroRequest;

public interface ProfesorService {
    
    
    
    public LoginResponse registro(ProfesorRegistroRequest registro);

    public LoginResponse login(ProfesorLoginRequest consulta);

    public Response eliminarCuenta(ProfesorLoginRequest consulta );

    public Response validarSesion(Sesion sesion);

}
