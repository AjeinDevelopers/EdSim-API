package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.AlumnoDeleteRequest;
import com.educasim.educasim.request.clases.AlumnoLoginRequest;
import com.educasim.educasim.request.clases.AlumnoRegistroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UserRepository userRepository;


    private final String regexPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,20}$";
    private final Pattern passPatern = Pattern.compile(regexPass);
    private final String regexmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final Pattern mailPattern = Pattern.compile(regexmail);

    public UsuarioServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/registro/alumno")
    @Override
    public int registro(@RequestBody AlumnoRegistroRequest registroRequest) {

        Alumno alumno = registroRequest.getUsuario();
        Clase clase = registroRequest.getClase();

        try {
            if (!alumno.getCorreo().isEmpty() && !alumno.getNombre().isEmpty()
                    && !alumno.getApeMat().isEmpty() && !alumno.getApePat().isEmpty()
                    && !alumno.getPinSeguridad().isEmpty() && !clase.getId().isEmpty()
                    && !alumno.getContrasena().isEmpty()) {


                if (!alumno.getContrasena().matches(String.valueOf(passPatern)) || !alumno.getCorreo().matches(String.valueOf(mailPattern))) {
                    return 0;
                }

                return userRepository.insertUsuario(alumno, clase);

            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
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

    @Override
    public int cambiarContrasena(String correo, String oldPass, String newPass) {
        if(!correo.isEmpty() && !oldPass.isEmpty() && !newPass.isEmpty()){
            int resul = 0;
            //resul = @Query()
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public int cambiarCorreo(String oldMail, String newMail, String contrasena) {
        if(!oldMail.isEmpty() && !newMail.isEmpty() && !contrasena.isEmpty()){
            int resul = 0;
            //resul = @Query()
            return resul;
        }else{
            return 0;
        }
    }

    @Override
    public int cambiarPin(String oldPin, String newPin, String correo, String contrasena) {
        if(!oldPin.isEmpty() && !newPin.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty()){
            int resul = 0;
            //resul = @Query()
            return resul;
        }else{
            return 0;
        }
    }

    @PostMapping("/eliminar/alumno")
    @Override
    public int eliminarCuenta(@RequestBody AlumnoDeleteRequest consulta) {
        if(!consulta.getCorreo().isEmpty() && !consulta.getPinSeguridad().isEmpty()){
            try{
                return userRepository.eliminarAlumno(consulta);
            }catch(Exception e){
                return 0;
            }
        }else{
            return 0;
        }
    }
}
