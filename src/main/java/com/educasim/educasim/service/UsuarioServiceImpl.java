package com.educasim.educasim.service;

import com.educasim.educasim.domain.Contacto;
import com.educasim.educasim.domain.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.util.regex.Pattern;

public class UsuarioServiceImpl implements UsuarioService{

    private final String regexPass = "/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,20}$/";
    private final Pattern passPatern = Pattern.compile(regexPass);
    private final String regexmail = "/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/";
    private final Pattern mailPattern = Pattern.compile(regexmail);

    @Override
    public int registro(Usuario usuario,  String codigoClase) {
        if(usuario.getTipo().equals("alumno")){
            try{
                if(usuario.getContactos() != null && !usuario.getNombre().isEmpty()
                && !usuario.getApeMat().isEmpty() && !usuario.getApePat().isEmpty()
                && !usuario.getPinSeguridad().isEmpty() && !codigoClase.isEmpty()
                && !usuario.getContrasena().isEmpty()){

                    Contacto correo = new Contacto();

                    for(Contacto x: usuario.getContactos()){
                        if(x.getTipoContacto().equals("email")){
                            correo = x;
                        }
                    }

                    if(!usuario.getContrasena().matches(String.valueOf(passPatern)) || !correo.getContacto().matches(String.valueOf(mailPattern))){
                        return 0;
                    }

                    //Buscar codigo clase

                    Usuario registro = new Usuario();
                    registro.setNombre(usuario.getNombre());
                    registro.setApeMat(usuario.getApeMat());
                    registro.setApePat(usuario.getApePat());
                    registro.setPinSeguridad(usuario.getPinSeguridad());
                    registro.setContactos(usuario.getContactos());

                    //@Query()

                    return 1;

                }
            }catch(Exception e){
                return 0;
            }
        }else{
            return 0;
        }
        return 0;
    }

    @Override
    public Usuario login(String correo, String pin) {
        if(!correo.isEmpty() && !pin.isEmpty()){
            if(correo.matches(String.valueOf(mailPattern)) /*REGEX DE PIN*/){
                //@Query
            }
            else{
                return null;
            }
        }else{
            return null;
        }
        return null;
    }

    @Override
    public int cambiarContrasena(String correo, String oldPass, String newPass) {
        if(!correo.isEmpty() && oldPass.isEmpty() && newPass.isEmpty()){
            
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int cambiarCorreo(String oldMail, String newMail, String contrasena) {
        return 0;
    }

    @Override
    public int cambiarPin(String oldPin, String newPin, String correo, String contrasena) {
        return 0;
    }

    @Override
    public int eliminarCuenta(String correo, String contrasena) {
        return 0;
    }
}
