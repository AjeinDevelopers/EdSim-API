use EducaSim;

#Procedimientos para Profesor
#Procedimiento para agregar Profesor

delimiter //

CREATE PROCEDURE sp_agregProf(
    IN p_correoProf VARCHAR(80),
    IN p_passProf VARCHAR(12),
    IN p_nombreProf VARCHAR(50), 
    IN p_apePatProf VARCHAR(50), 
    IN p_apeMatProf VARCHAR(50)
)
BEGIN
    DECLARE existe INT;
    DECLARE xMsj VARCHAR(50);

    SET existe = (SELECT COUNT(idProfesor) FROM Profesor WHERE correoProf = p_correoProf);

    IF (existe = 0) THEN
        INSERT INTO Profesor(correoProf, passProf, nombreProf, apePatProf, apeMatProf)
        VALUES (p_correoProf, p_passProf, p_nombreProf, p_apePatProf, p_apeMatProf);
        SELECT * FROM Profesor;
    ELSE
        SET xMsj = 'El correo ya está registrado';
        SELECT xMsj AS mensajeError;
    END IF;
END;
//

delimiter ;

CALL sp_agregProf("pablo@gmail.com", "p4bl0", "Pablo", "Roca", "Filete");

#Procedimiento para consultar Profesor

delimiter //

CREATE PROCEDURE sp_consulProf(
    IN p_correoProf VARCHAR(80)
)
BEGIN
    DECLARE existe INT;
    DECLARE xMsj VARCHAR(50);

    SET existe = (SELECT COUNT(*) FROM Profesor WHERE correoProf = p_correoProf);

    IF (existe > 0) THEN
        SELECT idProfesor, correoProf, nombreProf, apePatProf, apeMatProf
        FROM Profesor
        WHERE correoProf = p_correoProf;
    ELSE
        SET xMsj = 'El correo no está registrado';
        SELECT xMsj AS mensajeError;
    END IF;
END;
//

delimiter ;

CALL sp_consulProf('pablo@gmail.com');

#Procedimiento para eliminar Profesor

delimiter //

CREATE PROCEDURE sp_elimProf(
    IN p_correoProf VARCHAR(80)
)
BEGIN
    DECLARE existe INT;
    DECLARE xMsj VARCHAR(50);

    SET existe = (SELECT COUNT(*) FROM Profesor WHERE correoProf = p_correoProf);

    IF (existe > 0) THEN
        DELETE FROM Profesor WHERE correoProf = p_correoProf;
        SET xMsj = 'Alumno eliminado correctamente';
        SELECT xMsj AS mensaje;
    ELSE
        SET xMsj = 'El correo no está registrado';
        SELECT xMsj AS mensajeError;
    END IF;
END;
//

delimiter ;
CALL sp_elimProf('pablo@gmail.com');