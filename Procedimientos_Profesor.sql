use EducaSim;

#Procedimientos para Profesor
#Procedimiento para agregar Profesor

#drop procedure sp_agregProf;

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

    SET existe = (SELECT COUNT(idProfesor) FROM Profesor WHERE correoProf = p_correoProf);

    IF (existe = 0) THEN
        INSERT INTO Profesor(correoProf, passProf, nombreProf, apePatProf, apeMatProf)
        VALUES (p_correoProf, p_passProf, p_nombreProf, p_apePatProf, p_apeMatProf);
    END IF;
END;
//

delimiter ;

select * from profesor;

#Procedimiento para consultar Profesor

delimiter //

CREATE PROCEDURE sp_consulProf(
    IN p_correoProf VARCHAR(80)
)
BEGIN
    DECLARE existe INT;

    SET existe = (SELECT COUNT(*) FROM Profesor WHERE correoProf = p_correoProf);

    IF (existe > 0) THEN
        SELECT idProfesor, correoProf, nombreProf, apePatProf, apeMatProf
        FROM Profesor
        WHERE correoProf = p_correoProf;
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
    SET existe = (SELECT COUNT(*) FROM Profesor WHERE correoProf = p_correoProf);

    IF (existe = 1) THEN
        DELETE FROM Profesor WHERE correoProf = p_correoProf;
    END IF;
END;
//

delimiter ;
CALL sp_elimProf('pablo@gmail.com');