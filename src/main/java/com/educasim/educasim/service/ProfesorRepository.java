package com.educasim.educasim.service;

import com.educasim.educasim.request.clases.ProfesorRegistroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfesorRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public int insertProfesor(ProfesorRegistroRequest registro) {
        String sql = "CALL sp_agregProf(?,?,?,?,?)";
        return jdbcTemplate.update(sql, registro.getCorreo(), registro.getContrasena(), registro.getNombre(), registro.getApePat(), registro.getApeMat());
    }
    
}
