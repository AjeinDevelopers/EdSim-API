package com.educasim.educasim.service;

import com.educasim.educasim.domain.Alumno;
import com.educasim.educasim.domain.Clase;
import com.educasim.educasim.request.clases.ClaseDeleteRequest;
import com.educasim.educasim.request.clases.RegistroAlumClaseRequest;
import com.educasim.educasim.request.clases.ClaseRegistroRequest;
import com.educasim.educasim.request.clases.ClaseResponse;
import com.educasim.educasim.request.clases.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/clase")
@CrossOrigin
public class ClaseServiceImpl implements ClaseService {

@Autowired
private ClaseRepository classRepository;

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
    @PostMapping("/alumno/registrar")
    public Response darDeAlta(@RequestBody RegistroAlumClaseRequest request) {
        if(request != null & request.getAlumno() != null & request.getIdClase() != null){
            if(!request.getAlumno().isEmpty() & !request.getIdClase().isEmpty()){
                String resul;
                resul = classRepository.darAlta(request);
                if(resul.equals("error")){
                    return new Response("Hubo un error inesperado, intentelo más tarde", true);
                    
                }else if(resul.equals("existe")){
                    return new Response("El alumno ya existe", true);
                }else{
                    return new Response("Registradito", false);
                }
            }else{
                return new Response("Llena todos los campos", true);
            }
        }else{
            return new Response("Llena todos los campos", true);
        }
    }

    @Override
    public Response darDeBaja(@RequestBody RegistroAlumClaseRequest request) {
        if (request !=  null & request.getAlumno() != null & request.getIdClase() != null) {
            if(!request.getAlumno().isEmpty() & !request.getIdClase().isEmpty()){
                String resul;
                resul = classRepository.darDeBaja(request);
                if(resul.equals("error")){
                    return new Response("Ha ocurrido un error inesperado, intente de nuevo mas tarde", true);
                }else{
                    return new Response("Dado de baja", false);
                }
            }else{
                return new Response("Ingresa todos los campos", true);
            }
        } else {
            return new Response("Ingrese todos los campos", true);
        }
    }

    @Override
    @PostMapping("/alumno/clases")
    public List<Clase> obtenerClases(@RequestBody String alumno) {
        if (alumno != null) {
            List<Clase> clases = new ArrayList<>();
            //Query
            return clases;
        } else {
            return null;
        }
    }

    @Override
    public List<Alumno> obtenerAlumnos(String idClase) {
        if (idClase != null) {
            List<Alumno> alumnos = new ArrayList<>();
            //Query
            return alumnos;
        } else {
            return null;
        }
    }

    @Override
    @GetMapping("/materias")
    public List<String> listarMaterias(){
        return classRepository.getMaterias();
    }

     @Override
    @GetMapping("/fases")
    public List<String> listarFases(){
        return classRepository.getFases();
    }
}
