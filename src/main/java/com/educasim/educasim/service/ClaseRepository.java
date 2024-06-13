package com.educasim.educasim.service;

import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import com.educasim.educasim.request.clases.RegistroAlumClaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClaseRepository {

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
    
    public String darAlta(RegistroAlumClaseRequest request){
        String sql = "call sp_claseAddAlumno(?, ?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{request.getAlumno(), request.getIdClase()}, String.class);
    }
    
    public String darDeBaja(RegistroAlumClaseRequest request){
        String sql = "call sp_claseDeleteAlumno(?, ?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{request.getAlumno(), request.getIdClase()}, String.class);
    }

    public List<String> getMaterias(){
        String sql = "select * from vw_obtenerMaterias";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> getFases(){
        String sql = "select * from vw_obtenerFases";
        return jdbcTemplate.queryForList(sql, String.class);
    }

}
