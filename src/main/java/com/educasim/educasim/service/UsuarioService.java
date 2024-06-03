package com.educasim.educasim.service;


import com.educasim.educasim.domain.Usuario;
import java.util.regex.Pattern;


public interface UsuarioService {

    String regexPass = "/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,20}$/";
    Pattern passPatern = Pattern.compile(regexPass);
    String regexmail = "/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/";
    Pattern mailPattern = Pattern.compile(regexmail);

    public int registro(Usuario usuario, String codigoClase);

    public Usuario login(String correo, String contrasena);

    public int cambiarContrasena(String correo, String oldPass, String newPass);

    public int cambiarCorreo(String oldMail, String newMail, String contrasena);

    public int cambiarPin(String oldPin, String newPin, String correo, String contrasena);

    public int eliminarCuenta(String correo, String contrasena);

}
