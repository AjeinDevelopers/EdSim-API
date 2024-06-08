use EducaSim;

#Procedimientos para Alumno
#Procedimiento para agregar Alumno

drop procedure if exists sp_agregAlumn;

delimiter //

CREATE PROCEDURE sp_agregAlumn(
	IN p_clase VARCHAR(6),
    IN p_correoAlum VARCHAR(80),
    IN p_passAlum VARCHAR(20),
    IN p_pinSeguridad varchar(20),
    IN p_nombreAlum VARCHAR(50), 
    IN p_apePatAlum VARCHAR(50), 
    IN p_apeMatAlum VARCHAR(50)
    
)
BEGIN
    DECLARE existe INT;
	DECLARE claseExiste int;
    DECLARE idAlumito int;

    SET existe = (SELECT COUNT(idAlumno) FROM Alumno WHERE correoAlum = p_correoAlum);
	set claseExiste = (select count(*) from clase where idClase = p_clase);

    IF (existe = 0 and claseExiste = 1) THEN
        INSERT INTO Alumno(correoAlum, passAlum, nombreAlum, apePatAlum, apeMatAlum, pinSeguridad)
        VALUES (p_correoAlum, p_passAlum, p_nombreAlum, p_apePatAlum, p_apeMatAlum, p_pinSeguridad);
        set idAlumito = (select idAlumno from Alumno where correoAlum = p_correoAlum and passAlum = p_passAlum);
        insert into RelAlumClase(idClase, idAlumno) values(p_clase, idAlumito); 
    END IF;
END;
//

delimiter ;

select * from alumno;
select * from RelAlumClase;


#Procedimiento para consultar Alumno

delimiter //

CREATE PROCEDURE sp_consulAlum(
    IN p_correoAlum VARCHAR(80),
    IN p_contrasena varchar(20)
)
BEGIN
    DECLARE existe INT;
    DECLARE xMsj VARCHAR(50);

    SET existe = (SELECT COUNT(*) FROM Alumno WHERE correoAlum = p_correoAlum and passAlum = p_contrasena);

    IF (existe > 0) THEN
        SELECT idAlumno, correoAlum, nombreAlum, apePatAlum, apeMatAlum
        FROM Alumno
        WHERE correoAlum = p_correoAlum and passAlum = p_contrasena;
    END IF;
END;
//

delimiter ;

CALL sp_consulAlum('hola@gmail.com', "m3$n23InSa2");

#Procedimiento para eliminar Alumno

delimiter //

CREATE PROCEDURE sp_elimAlum(
    IN p_correoAlum VARCHAR(80),
    IN p_pinSeguridad VARCHAR(20)
)
BEGIN
    DECLARE existe INT;
    DECLARE idAlumnito INT;
    

    SET existe = (SELECT COUNT(*) FROM Alumno WHERE correoAlum = p_correoAlum and pinSeguridad = p_pinSeguridad);

    IF (existe = 1) THEN
		SET idAlumnito = (select idAlumno FROM Alumno WHERE correoAlum = p_correoAlum and pinSeguridad = p_pinSeguridad);
        DELETE FROM relAlumClase where idAlumno = idAlumnito;
        DELETE FROM relAlumExam where idAlumno = idAlumnito;
        DELETE FROM relAlumEjer where idAlumno = idAlumnito;
        DELETE FROM Alumno WHERE correoAlum = p_correoAlum and pinSeguridad = p_pinSeguridad;
    END IF;
END;
//

delimiter ;


