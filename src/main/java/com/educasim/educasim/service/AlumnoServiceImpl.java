package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoRepository userRepository;


    private final String regexPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,20}$";
    private final Pattern passPatern = Pattern.compile(regexPass);
    private final String regexmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final Pattern mailPattern = Pattern.compile(regexmail);

    public AlumnoServiceImpl(AlumnoRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/registro/alumno")
    @Override
    public LoginResponse registro(@RequestBody AlumnoRegistroRequest registroRequest) {

        Alumno alumno = registroRequest.getUsuario();
        Clase clase = registroRequest.getClase();

        try {
            if (!alumno.getCorreo().isEmpty() && !alumno.getNombre().isEmpty()
                    && !alumno.getApeMat().isEmpty() && !alumno.getApePat().isEmpty()
                    && !alumno.getPinSeguridad().isEmpty() && !clase.getId().isEmpty()
                    && !alumno.getContrasena().isEmpty()) {


                if (!alumno.getContrasena().matches(String.valueOf(passPatern)) || !alumno.getCorreo().matches(String.valueOf(mailPattern))) {
                    return new LoginResponse(0, "Correo o contraseña no válidos", true);
                }

                int userID =  userRepository.insertUsuario(alumno, clase);
                if(userID != 0) {
                    return new LoginResponse(userID, "Registro exitoso", false);
                } else {
                    return new LoginResponse(0, "Algo salió mal, intentelo de nuevo más tarde", true);
                }
            }
        } catch (Exception e) {
            return new LoginResponse(0, "Llena todos los campos!", true);
        }
        return new LoginResponse(0, "Algo salió mal, intentelo de nuevo más tarde", true);
    }

    @GetMapping("consulta/alumno/")
    @Override
    public Alumno login(@RequestBody AlumnoLoginRequest consulta){
        if(!consulta.getCorreo().isEmpty() & !consulta.getContrasena().isEmpty()){
            try{
                Alumno alumno  = new Alumno();
                alumno = userRepository.obtenerALumno(consulta);
                return alumno;
            }catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @PostMapping("/eliminar/alumno")
    @Override
    public Response eliminarCuenta(@RequestBody AlumnoDeleteRequest consulta) {
        if(!consulta.getCorreo().isEmpty() && !consulta.getPinSeguridad().isEmpty()){
            try{
                int resul = userRepository.eliminarAlumno(consulta);
                if(resul == 1){
                    return new Response("Cuenta eliminada", false);
                }else{
                    return new Response("Algo salió mal, intentelo de nuevo", true);
                }
            }catch(Exception e){
                return new Response("Llena todos los campos!", true);
            }
        }else{
            return new Response("Algo salió mal, intentelo de nuevo", true);
        }
    }
}
