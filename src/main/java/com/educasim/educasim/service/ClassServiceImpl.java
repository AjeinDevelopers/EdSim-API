package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import com.educasim.educasim.request.clases.ClaseRegistroRequest;
import com.educasim.educasim.request.clases.ClaseResponse;
import com.educasim.educasim.request.clases.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/clase")
@CrossOrigin
public class ClassServiceImpl implements ClassService {

@Autowired
private ClassRepository classRepository;

    @Override
    @PostMapping("/registro")
    public ClaseResponse crearClase(@RequestBody ClaseRegistroRequest datos) {

        if (datos.getFase() != null && datos.getMateria() != null && datos.getNombre() != null && datos.getProfesor() != null) {
            int leftLimit = 48;
            int rightLimit = 122;
            int tamano = 6;
            Random random = new Random();
            String idClase = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(tamano)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            String resul = null;
            Clase clase = new Clase(idClase, datos.getNombre(), datos.getMateria(), datos.getProfesor(), datos.getFase());
            resul = classRepository.crearClase(clase);
            if (resul.equals("error")) {
                return new ClaseResponse(null, true, "Hubo un error inesperado, intentelo de nuevo mas tarde");
            } else if (resul.equals("repetido")) {
                return crearClase(datos);
            } else if (resul.equals("existe")) {
                return new ClaseResponse(null, true, "Ya tiene una clase con ese nombre");
            } else {
                return new ClaseResponse(resul, false, "Registro exitoso");
            }
        } else {
            return new ClaseResponse(null, true, "Llena todos los campos");
        }
    }

    @PostMapping("/eliminar")
    @Override
    public Response eliminarClase(@RequestBody ClaseDeleteRequest clase) {

        if (clase != null && clase.getProfesor() != null && clase.getIdClase() != null) {
            if(!clase.getIdClase().isEmpty() && !clase.getProfesor().isEmpty()){
                String resul = classRepository.eliminarClase(clase);
                if (resul.equals("error")) {
                    return new Response("Hubo un error inesperado, intentelo de nuevo mas tarde", true);
                } else {
                    return new Response("Eliminada", false);
                }
            }else{
                return new Response("Llena todos los campos", true);
            }
        } else {
            return new Response("Llena todos los campos", true);
        }
    }

    @Override
    public String obtenerCodigo(String codigo) {
        if (!codigo.isEmpty()) {
            String resul = "";
            // Query
            return resul;
        } else {
            return null;
        }
    }

    @Override
    public int darDeAlta(Alumno alumno, Clase clase) {
        if (alumno != null && clase != null) {
            int resul = 0;
            //Query
            return resul;
        } else {
            return 0;
        }
    }

    @Override
    public int darDeBaja(Alumno alumno, Clase clase) {
        if (alumno != null && clase != null) {
            int resul = 0;
            // Query
            return resul;
        } else {
            return 0;
        }
    }

    @Override
    public List<Clase> obtenerClases(Alumno alumno) {
        if (alumno != null) {
            List<Clase> clases = new ArrayList<>();
            //Query
            return clases;
        } else {
            return null;
        }
    }
}
