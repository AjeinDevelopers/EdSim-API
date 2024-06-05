package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.RegistroRequest;
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
    public int registro(@RequestBody RegistroRequest registroRequest) {

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

                Alumno registro = new Alumno();
                registro.setNombre(alumno.getNombre());
                registro.setApeMat(alumno.getApeMat());
                registro.setApePat(alumno.getApePat());
                registro.setCorreo(alumno.getCorreo());
                registro.setContrasena(alumno.getContrasena());
                registro.setPinSeguridad(alumno.getPinSeguridad());

                return userRepository.insertUsuario(registro, clase);

            }
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    @GetMapping("consulta/alumno/")
    @Override
    public Alumno login(String correo, String contrasena){
        if(!correo.isEmpty() & !contrasena.isEmpty()){
            Alumno alumno = new Alumno();
            try{
                alumno = userRepository.obtenerALumno(correo, contrasena);
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

    @Override
    public int eliminarCuenta(String correo, String contrasena) {
        if(!correo.isEmpty() && !contrasena.isEmpty()){
            int resul = 0;
            //resul = @Query()
            return resul;
        }else{
            return 0;
        }
    }
}
