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
        String sql = "CALL sp_agregAlumn(?,?,?,?, ?,?,?)";
        return jdbcTemplate.update(sql, clase.getId(), alumno.getCorreo(), alumno.getContrasena(), alumno.getPinSeguridad(), alumno.getNombre(), alumno.getApePat(), alumno.getApeMat());
    }

    public Alumno obtenerALumno(String correo, String contrasena){
        String sql = "CALL sp_consultAlum(?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{correo, contrasena}, (rs, rowNum) ->
                new Alumno(
                        rs.getInt("id"),
                        rs.getString("correo"),
                        rs.getString("nombre"),
                        rs.getString("apePat"),
                        rs.getString("apeMat")
                ));
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}