package com.educasim.educasim.service;

import com.educasim.educasim.domain.Profesor;
import com.educasim.educasim.request.clases.ProfesorDeleteRequest;
import com.educasim.educasim.request.clases.ProfesorLoginRequest;
import com.educasim.educasim.request.clases.ProfesorRegistroRequest;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class ProfesorServiceImpl implements ProfesorService{
    
    @Autowired
    private ProfesorRepository profesorRepository;
    
    private final String regexPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,20}$";
    private final Pattern passPatern = Pattern.compile(regexPass);
    private final String regexmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final Pattern mailPattern = Pattern.compile(regexmail);
    
    @PostMapping("registro/profesor")
    public int registro(@RequestBody ProfesorRegistroRequest registro){
        if(registro != null){
            
            if(!registro.getApeMat().isEmpty() && !registro.getApePat().isEmpty() && !registro.getContrasena().isEmpty() && !registro.getCorreo().isEmpty() && !registro.getNombre().isEmpty()){
                if(registro.getCorreo().matches(regexmail) && registro.getContrasena().matches(regexPass)){
                    return profesorRepository.insertProfesor(registro);
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
            
        }else{
            return 0;
        }
    }

    @GetMapping("consulta/profesor/")
    public Profesor login(ProfesorLoginRequest consulta){
        if(consulta != null){
            if(!consulta.getContrasena().isEmpty() && !consulta.getCorreo().isEmpty()){
                if(consulta.getCorreo().matches(regexmail) && consulta.getContrasena().matches(regexPass)){
                    return profesorRepository.getProfesor(consulta);
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @PostMapping("/eliminar/profesor")
    public int eliminarCuenta(ProfesorLoginRequest consulta){
        if(consulta != null){
            if(!consulta.getContrasena().isEmpty() && !consulta.getCorreo().isEmpty()){
                if(consulta.getCorreo().matches(regexmail) && consulta.getContrasena().matches(regexPass)){
                    return profesorRepository.delProfesor(consulta);
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
   
}
