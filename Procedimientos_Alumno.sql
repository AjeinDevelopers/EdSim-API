use EducaSim;

#Procedimientos para Alumno
#Procedimiento para agregar Alumno
delimiter //

CREATE PROCEDURE sp_agregAlumn(
    IN p_correoAlum VARCHAR(80),
    IN p_passAlum VARCHAR(12),
    IN p_nombreAlum VARCHAR(50), 
    IN p_apePatAlum VARCHAR(50), 
    IN p_apeMatAlum VARCHAR(50)
)
BEGIN
    DECLARE existe INT;
    DECLARE xMsj VARCHAR(50);

    SET existe = (SELECT COUNT(idAlumno) FROM Alumno WHERE correoAlum = p_correoAlum);

    IF (existe = 0) THEN
        INSERT INTO Alumno(correoAlum, passAlum, nombreAlum, apePatAlum, apeMatAlum)
        VALUES (p_correoAlum, p_passAlum, p_nombreAlum, p_apePatAlum, p_apeMatAlum);
        SELECT * FROM Alumno;
    ELSE
        SET xMsj = 'El correo ya está registrado';
        SELECT xMsj AS mensajeError;
    END IF;
END;
//

delimiter ;

CALL sp_agregAlumn('correo@example.com', 'password123', 'Juan', 'Perez', 'Gomez');

#Procedimiento para consultar Alumno

delimiter //

CREATE PROCEDURE sp_consulAlum(
    IN p_correoAlum VARCHAR(80)
)
BEGIN
    DECLARE existe INT;
    DECLARE xMsj VARCHAR(50);

    SET existe = (SELECT COUNT(*) FROM Alumno WHERE correoAlum = p_correoAlum);

    IF (existe > 0) THEN
        SELECT idAlumno, correoAlum, nombreAlum, apePatAlum, apeMatAlum
        FROM Alumno
        WHERE correoAlum = p_correoAlum;
    ELSE
        SET xMsj = 'El correo no está registrado';
        SELECT xMsj AS mensajeError;
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

