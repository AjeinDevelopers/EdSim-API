package com.educasim.educasim.datos;

import com.educasim.educasim.domain.Contacto;
import com.educasim.educasim.domain.FormaAprendizaje;
import com.educasim.educasim.domain.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public class DatosUsuarioImpl  implements  DatosUsuario{


    @Override
    public int registro(String tipo, String contrasena, String pin, String nombre, String apeMat, String apePat, List<Contacto> contactos, FormaAprendizaje formaAprendizaje) {
        return 0;
    }

    @Override
    public Usuario iniciarSesion(Contacto correo, String contrasena) {
        return null;
    }
}
