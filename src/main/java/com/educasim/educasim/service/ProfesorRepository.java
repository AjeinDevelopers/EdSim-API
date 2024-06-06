package com.educasim.educasim.service;

import com.educasim.educasim.domain.Profesor;
import com.educasim.educasim.request.clases.ProfesorLoginRequest;
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
    
}
