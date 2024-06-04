package com.educasim.educasim.service;


import com.educasim.educasim.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    @Procedure("sp_registrarUsuario")
    int registerUser(@Param("nombre") String nombre, @Param("tipo") String tipo, @Param("apePat") String apePat, @Param("apeMat") String apeMat, @Param("correo") String correo, @Param("pin") String pin, @Param("contrasena") String contrasena);
}