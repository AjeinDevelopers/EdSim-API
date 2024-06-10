# Procedimientos Módulo de Contenido

# PRocedimiento de Acceder Lecciones
delimiter //

CREATE PROCEDURE sp_accesLeccion(
	IN p_formaAprendizaje varchar(50),
    IN p_clase VARCHAR(6),
    IN p_materia VARCHAR(3),
    IN p_nivelAlum int
)
BEGIN
	DECLARE claseExiste int;
    DECLARE materiaExiste int;

	set claseExiste = (select count(*) from clase where idClase = p_clase);
    set materiaExiste = (select count(*) from clase where idMateria = p_materia);

    IF (materiaExiste = 1 and claseExiste = 1) THEN
        select titulo, resumen from Articulo inner join Alumno on Alumno.nivelAlum = Articulo.nivelArt;
    END IF;
END;
//
delimiter ;

#Procedimiento Material Imprimible

delimiter //

create procedure sp_accesMatLecc(
	IN p_clase VARCHAR(6),
    IN p_materia VARCHAR(3),
    IN p_idMaterial int
)
BEGIN
	DECLARE claseExiste int;
    DECLARE materiaExiste int;

	set claseExiste = (select count(*) from clase where idClase = p_clase);
    set materiaExiste = (select count(*) from clase where idMateria = p_materia);
    
    IF (materiaExiste = 1 and claseExiste > 0) THEN
        select titulo, nombre from Material 
			inner join RelMateMatel on RelMateMatel.idMaterial = Material.idMaterial 
			inner join Materia on RelMateMatel.idMateria = Materia.idMateria 
            inner join Clase on Materia.idMateria = Clase.idMateria 
            inner join Profesor on Clase.idProfesor = Profesor.idProfesor
            where Profesor.idProfesor = Clase.idProfesor;
    END IF;
END;
//

delimiter ;