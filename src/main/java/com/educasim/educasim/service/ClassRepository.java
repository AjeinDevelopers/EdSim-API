package com.educasim.educasim.service;

import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClassRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String crearClase(Clase clase){
        String sql = "call sp_crearClase(?,?,?,?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{clase.getId(), clase.getNombre(), clase.getFase(), clase.getMateria(), clase.getProfesor()}, String.class);
    }

    public String eliminarClase(ClaseDeleteRequest clase){
        String sql = "call sp_eliminarClase(?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{clase.getIdClase(), clase.getProfesor()}, String.class);
    }


}
