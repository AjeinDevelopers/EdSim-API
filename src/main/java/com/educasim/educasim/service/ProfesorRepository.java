package com.educasim.educasim.service;

import com.educasim.educasim.domain.Profesor;
import com.educasim.educasim.domain.Sesion;
import com.educasim.educasim.request.clases.ProfesorLoginRequest;
import com.educasim.educasim.request.clases.ProfesorRegistroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfesorRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public String insertProfesor(ProfesorRegistroRequest registro) {
        String sql = "CALL sp_registrarProf(?,?,?,?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{registro.getCorreo(), registro.getContrasena(), registro.getNombre(), registro.getApePat(), registro.getApeMat()}, String.class);
    }
    
    public Profesor getProfesor(ProfesorLoginRequest consulta){
        String sql = "CALL sp_consulProf(?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{consulta.getCorreo(), consulta.getContrasena()},(rs, rowNum) ->
                new Profesor(
                        rs.getInt("idProfesor"),
                        rs.getString("nombreProf"),
                        rs.getString("apePatProf"),
                        rs.getString("apeMatProf")
                ));
    }
    
    public int delProfesor(ProfesorLoginRequest consulta){
        String sql = "CALL sp_elimProf(?,?)";
        return jdbcTemplate.update(sql, consulta.getCorreo(), consulta.getContrasena());
    }

    public String validarSesion(Sesion sesion){
        String sql = "CALL sp_verSesionProf(?, ?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{sesion.getSesionId(), sesion.getType()}, String.class);
    }

    public String login(ProfesorLoginRequest login){
        String sql = "CALL sp_loginProf(?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{login.getCorreo(), login.getContrasena()}, String.class);
    }
    
}
