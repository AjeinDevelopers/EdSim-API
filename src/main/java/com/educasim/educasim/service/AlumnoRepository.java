package com.educasim.educasim.service;


import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.domain.Sesion;
import com.educasim.educasim.request.clases.AlumnoDeleteRequest;
import com.educasim.educasim.request.clases.AlumnoLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String insertUsuario(Alumno alumno, Clase clase) {
        String sql = "CALL sp_registrarAlum(?,?,?,?, ?,?,?)";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{clase.getId(), alumno.getCorreo(), alumno.getContrasena(), alumno.getPinSeguridad(), alumno.getNombre(), alumno.getApePat(), alumno.getApeMat()}, String.class);
        } catch (IncorrectResultSizeDataAccessException e) {
            return "error";
        }
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


    public String validarSesion(Sesion sesion){
        String sql = "CALL sp_verSesionAlum(?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{sesion.getSesionId(), sesion.getType()}, String.class);
    }

    public String login(AlumnoLoginRequest logn){
        String sql = "CALL sp_loginAlum(?,?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{logn.getCorreo(), logn.getContrasena()}, String.class);
    }
}