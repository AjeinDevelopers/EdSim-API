package com.educasim.educasim.service;

import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.RegistroRequest;
import com.educasim.educasim.domain.Usuario;
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

    @PostMapping("/registro")
    @Override
    public int registro(@RequestBody RegistroRequest registroRequest) {

        Usuario usuario = registroRequest.getUsuario();
        Clase clase = registroRequest.getClase();

        if(usuario.getTipo().equals("a")){
            try{
                if(!usuario.getCorreo().isEmpty() && !usuario.getNombre().isEmpty()
                && !usuario.getApeMat().isEmpty() && !usuario.getApePat().isEmpty()
                && !usuario.getPinSeguridad().isEmpty() && !clase.getId().isEmpty()
                && !usuario.getContrasena().isEmpty()){


                    if(!usuario.getContrasena().matches(String.valueOf(passPatern)) || !usuario.getCorreo().matches(String.valueOf(mailPattern))){
                        return 0;
                    }

                    Usuario registro = new Usuario();
                    registro.setTipo(usuario.getTipo());
                    registro.setNombre(usuario.getNombre());
                    registro.setApeMat(usuario.getApeMat());
                    registro.setApePat(usuario.getApePat());
                    registro.setCorreo(usuario.getCorreo());
                    registro.setContrasena(usuario.getContrasena());
                    registro.setPinSeguridad(usuario.getPinSeguridad());

                    return userRepository.insertUsuario(registro, clase);

                }
            }catch(Exception e){
                return 0;
            }
        }else if(usuario.getTipo().equals("p")){
            try{
                if(!usuario.getCorreo().isEmpty() && !usuario.getNombre().isEmpty()
                        && !usuario.getApeMat().isEmpty() && !usuario.getApePat().isEmpty()
                        && !usuario.getContrasena().isEmpty()){


                    if(!usuario.getContrasena().matches(String.valueOf(passPatern)) || !usuario.getCorreo().matches(String.valueOf(mailPattern))){
                        return 0;
                    }

                    Usuario registro = new Usuario();
                    registro.setTipo(usuario.getTipo());
                    registro.setNombre(usuario.getNombre());
                    registro.setApeMat(usuario.getApeMat());
                    registro.setApePat(usuario.getApePat());
                    registro.setCorreo(usuario.getCorreo());
                    registro.setContrasena(usuario.getContrasena());
                    registro.setPinSeguridad(usuario.getPinSeguridad());

                    return userRepository.insertUsuario(registro, clase);

                }
            }catch(Exception e){
                return 0;
            }
        }else {
            return 0;
        }
        return 0;
    }

    @Override
    public Usuario login(String correo, String pin) {
        if(!correo.isEmpty() && !pin.isEmpty()){
            if(correo.matches(String.valueOf(mailPattern)) && pin.matches(String.valueOf(passPatern))){
                //@Query
                String sql = "SELECT * FROM Alumno WHERE correoAlum = ? AND passAlum = ?";
                Usuario usuario = null;
                usuario = userRepository.getJdbcTemplate().queryForObject(sql, new Object[]{correo, pin}, new BeanPropertyRowMapper<>(Usuario.class));
                return usuario;
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
