package com.educasim.educasim.service;

import com.educasim.educasim.domain.Sesion;
import com.educasim.educasim.request.clases.LoginResponse;
import com.educasim.educasim.request.clases.Response;
import com.educasim.educasim.request.clases.ProfesorLoginRequest;
import com.educasim.educasim.request.clases.ProfesorRegistroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class ProfesorServiceImpl implements ProfesorService{
    
    @Autowired
    private ProfesorRepository profesorRepository;
    
    private final String regexPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,20}$";
    private final String regexmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    @PostMapping("registro/profesor")
    @Override
    public LoginResponse registro(@RequestBody ProfesorRegistroRequest registro){
        if(registro != null){
            
            if(!registro.getApeMat().isEmpty() && !registro.getApePat().isEmpty() && !registro.getContrasena().isEmpty() && !registro.getCorreo().isEmpty() && !registro.getNombre().isEmpty()){
                if(registro.getCorreo().matches(regexmail) && registro.getContrasena().matches(regexPass)){
                    String resul = profesorRepository.insertProfesor(registro);
                    if(!resul.equals("error")) {
                        return new LoginResponse(resul, "Registro exitoso", false);
                    }else {
                        return new LoginResponse(null, "Algo salió mal, intentelo de nuevo 1", true);
                    }
                }else{
                    return new LoginResponse(null, "Correo o contraseña no válidos", true);
                }
            }else{
                return new LoginResponse(null, "Llena todos los campos", true);
            }
            
        }else{
            return new LoginResponse(null, "Algo salió mal, intentelo de nuevo", true);
        }
    }

    @PostMapping("login/profesor/")
    @Override
    public LoginResponse login(@RequestBody ProfesorLoginRequest consulta){
        if(consulta != null){
            if(!consulta.getContrasena().isEmpty() && !consulta.getCorreo().isEmpty()){
                if(consulta.getCorreo().matches(regexmail) && consulta.getContrasena().matches(regexPass)){
                    String resul = profesorRepository.login(consulta);
                    if(!resul.equals("error")) {
                        return new LoginResponse(resul, "Sesion iniciada", false);
                    }else{
                        return new LoginResponse(null, "Correo o contraseña incorrectos", true);
                    }
                }else{
                    return new LoginResponse(null, "Correo o contraseña no válidos", true);
                }
            }else{
                return new LoginResponse(null, "Llena todos los campos", true);
            }
        }else{
            return new LoginResponse(null, "Algo salió mal, intentelo de nuevo", true);
        }
    }

    @PostMapping("/eliminar/profesor")
    @Override
    public Response eliminarCuenta(@RequestBody ProfesorLoginRequest consulta){
        if(consulta != null){
            if(!consulta.getContrasena().isEmpty() && !consulta.getCorreo().isEmpty()){
                if(consulta.getCorreo().matches(regexmail) && consulta.getContrasena().matches(regexPass)){
                    int resul = profesorRepository.delProfesor(consulta);
                    if(resul == 1) {
                        return new Response("Cuenta eliminada", false);
                    }else{
                        return new Response("Algo salió mal, intentelo de nuevo", true);
                    }
                }else{
                    return new Response("Correo o contraseña no válidos", true);
                }
            }else{
                return new Response("Llena todos los campos", true);
            }
        }else{
            return new Response("Algo salió mal, intentelo de nuevo", true);
        }
    }

    @PostMapping("/validar/profesor")
    @Override
    public Response validarSesion(@RequestBody Sesion sesion) {
        try {
            if (sesion != null) {
                if (!sesion.getSesionId().isEmpty() && !sesion.getType().isEmpty()) {
                    String resul = profesorRepository.validarSesion(sesion);
                    if (resul.equals("existe")) {
                        return new Response("Sesion Validada", false);
                    } else if (resul.equals("tipoError")) {
                        return new Response("Tipo de sesión no válido", true);
                    } else {
                        return new Response("Sesión no válida", true);
                    }
                } else {
                    return new Response("Sesión no válida", true);
                }
            } else {
                return new Response("Sesion vacia", true);
            }
        } catch (Exception e) {
            return new Response("Sesión no válida", true);
        }
    }


}
