use EducaSim;

#Procedimientos para Alumno
#Procedimiento para agregar Alumno

drop procedure sp_agregAlumn;

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

select count(*) from clase where idClase = "MnS3mJ";
select * from alumno;
select * from RelAlumClase;
select idAlumno from Alumno where correoAlum = 'quesomanzana@gol.cmm' and passAlum = 'password123';
insert into RelAlumClase(idClase, idAlumno) values('MnS3mj', 3);
CALL sp_agregAlumn('MnS3mj', 'quesomanzana@gol.cmm', 'password123', 'pin223ms8', 'Juan', 'Perez', 'Gomez');

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

CALL sp_consulAlum('correo@example.com');

#Procedimiento para eliminar Alumno

delimiter //

CREATE PROCEDURE sp_elimAlum(
    IN p_correoAlum VARCHAR(80)
)
BEGIN
    DECLARE existe INT;
    DECLARE xMsj VARCHAR(50);

    SET existe = (SELECT COUNT(*) FROM Alumno WHERE correoAlum = p_correoAlum);

    IF (existe > 0) THEN
        DELETE FROM Alumno WHERE correoAlum = p_correoAlum;
        SET xMsj = 'Alumno eliminado correctamente';
        SELECT xMsj AS mensaje;
    ELSE
        SET xMsj = 'El correo no está registrado';
        SELECT xMsj AS mensajeError;
    END IF;
END;
//

delimiter ;

CALL sp_elimAlum('correo@example.com');

