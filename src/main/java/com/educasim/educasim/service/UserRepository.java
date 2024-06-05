package com.educasim.educasim.service;


import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.AlumnoDeleteRequest;
import com.educasim.educasim.request.clases.AlumnoLoginRequest;
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

    public Alumno obtenerALumno(AlumnoLoginRequest consulta){
        String sql = "CALL sp_consulAlum(?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{consulta.getCorreo(), consulta.getContrasena()}, (rs, rowNum) ->
                new Alumno(
                        rs.getInt("idAlumno"),
                        rs.getString("correoAlum"),
                        rs.getString("nombreAlum"),
                        rs.getString("apePatAlum"),
                        rs.getString("apeMatAlum")
                ));
    }
    
    public int eliminarAlumno(AlumnoDeleteRequest consulta){
        String sql = "Call sp_elimAlum(?,?)";
        return jdbcTemplate.update(sql, consulta.getCorreo(), consulta.getPinSeguridad());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}