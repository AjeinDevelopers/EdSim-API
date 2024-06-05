package com.educasim.educasim.service;


import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.request.clases.AlumnoDeleteRequest;
import com.educasim.educasim.request.clases.AlumnoLoginRequest;
import com.educasim.educasim.request.clases.AlumnoRegistroRequest;

import java.util.regex.Pattern;

public interface UsuarioService {

    String regexPass = "/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,20}$/";
    Pattern passPatern = Pattern.compile(regexPass);
    String regexmail = "/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/";
    Pattern mailPattern = Pattern.compile(regexmail);

    public int registro(AlumnoRegistroRequest registroRequest);

    public Alumno login(AlumnoLoginRequest consulta);
    
    public int eliminarCuenta(AlumnoDeleteRequest consulta);

}
