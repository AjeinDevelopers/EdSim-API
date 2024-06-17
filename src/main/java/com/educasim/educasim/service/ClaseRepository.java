package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.domain.Fase;
import com.educasim.educasim.domain.Materia;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import com.educasim.educasim.request.clases.ObtenerClasesRequest;
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

    public List<Materia> getMaterias(){
        String sql = "select * from vw_obtenerMaterias";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Materia materia = new Materia();
            materia.setId(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            return materia;
        });
    }

    public List<Fase> getFases(){
        String sql = "select * from vw_obtenerFases";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Fase fase = new Fase();
            fase.setId(rs.getInt("idFase"));
            fase.setNombre(rs.getString("nombre"));
            return fase;
        });
    }

    public List<Alumno> getAlumnos(ClaseDeleteRequest clase){
        String sql = "call sp_obtenerAlumClase(?, ?)";
        return jdbcTemplate.query(sql, new Object[]{clase.getIdClase(), clase.getProfesor()}, (rs, rowNum) -> {
            Alumno alumno = new Alumno();
            alumno.setId(rs.getInt("idAlumno"));
            alumno.setNombre(rs.getString("nombreAlum"));
            alumno.setApePat(rs.getString("apePatAlum"));
            alumno.setApeMat(rs.getString("apeMatAlum"));
            return alumno;
        });
    }

    public List<Clase> getClases(ObtenerClasesRequest usuario){
        String sql = "call sp_obtenerClasesProfesor(?, ?)";
        return jdbcTemplate.query(sql, new Object[]{usuario.getUsuario(), usuario.getTipoUsuario()}, (rs, rowNum) -> {
            Clase clase = new Clase();
            clase.setId(rs.getString("idClase"));
            clase.setNombre(rs.getString("nombre"));
            clase.setMateria(rs.getString("materia"));
            clase.setFase(rs.getString("fase"));
            return clase;
        });
    }

}
