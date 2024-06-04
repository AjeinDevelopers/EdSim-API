package com.educasim.educasim.service;

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
        if(usuario.getTipo().equals("a")){
            try{
                if(!usuario.getCorreo().isEmpty() && !usuario.getNombre().isEmpty()
                && !usuario.getApeMat().isEmpty() && !usuario.getApePat().isEmpty()
                && !usuario.getPinSeguridad().isEmpty() && !codigoClase.isEmpty()
                && !usuario.getContrasena().isEmpty()){


                    if(!usuario.getContrasena().matches(String.valueOf(passPatern)) || !usuario.getCorreo().matches(String.valueOf(mailPattern))){
                        return 0;
                    }

                    //Buscar codigo clase

                    Usuario registro = new Usuario();
                    registro.setTipo(usuario.getTipo());
                    registro.setNombre(usuario.getNombre());
                    registro.setApeMat(usuario.getApeMat());
                    registro.setApePat(usuario.getApePat());
                    registro.setCorreo(usuario.getCorreo());
                    registro.setContrasena(usuario.getContrasena());
                    registro.setPinSeguridad(usuario.getPinSeguridad());

                    int resultado = 0;



                    return resultado;

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
