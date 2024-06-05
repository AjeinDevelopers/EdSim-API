package com.educasim.educasim.service;


import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertUsuario(Alumno alumno, Clase clase) {
        String sql = "CALL sp_registrarUsuario(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, alumno.getNombre(), alumno.getTipo(), alumno.getApePat(), alumno.getApeMat(), alumno.getCorreo(), alumno.getPinSeguridad(), alumno.getContrasena(), clase.getId());
    }
}