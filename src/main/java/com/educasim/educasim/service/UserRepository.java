package com.educasim.educasim.service;


import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertUsuario(Usuario usuario, Clase clase) {
        String sql = "CALL sp_registrarUsuario(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, usuario.getNombre(), usuario.getTipo(), usuario.getApePat(), usuario.getApeMat(), usuario.getCorreo(), usuario.getPinSeguridad(), usuario.getContrasena(), clase.getId());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}