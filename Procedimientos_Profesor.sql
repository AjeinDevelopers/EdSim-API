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

drop procedure if exists sp_registrarProf;

delimiter //

CREATE PROCEDURE sp_registrarProf(
    IN p_correoProf VARCHAR(80),
    IN p_passProf VARCHAR(20),
    IN p_nombreProf VARCHAR(50), 
    IN p_apePatProf VARCHAR(50), 
    IN p_apeMatProf VARCHAR(50)
)
BEGIN
    DECLARE existe INT;
	DECLARE claseExiste int;
    DECLARE idProfe int;
    DECLARE idSesion1 varchar(100);
    DECLARE Xmsg varchar(100);

    SET existe = (SELECT COUNT(idProfesor) FROM Profesor WHERE correoProf = p_correoProf);

    IF (existe = 0) THEN
        INSERT INTO Profesor(correoProf, passProf, nombreProf, apePatProf, apeMatProf)
        VALUES (p_correoProf, p_passProf, p_nombreProf, p_apePatProf, p_apeMatProf);
        set idProfe = (select idProfesor from Profesor where correoProf = p_correoProf and passProf = p_passProf);
        set idSesion1 = UUID();
        insert into sesiones(idSesion, fecha) values(idSesion1, now());
        insert into relSesionProf(idSesion, idProfesor) values(idSesion1, idProfe);
        select idSesion1;
	else
		set Xmsg = "error";
		select Xmsg;
    END IF;
END;
//

delimiter ;

#Procedimiento para consultar Profesor
#drop procedure sp_consulProf;

delimiter //

CREATE PROCEDURE sp_consulProf(
    IN p_correoProf VARCHAR(80),
    in p_passProf VARCHAR(20)
)
BEGIN
    DECLARE existe INT;

    SET existe = (SELECT COUNT(*) FROM Profesor WHERE correoProf = p_correoProf and passProf = p_passProf);

    IF (existe = 1) THEN
        SELECT idProfesor, correoProf, nombreProf, apePatProf, apeMatProf
        FROM Profesor
        WHERE correoProf = p_correoProf and passProf = p_passProf;
    END IF;
END;
//

delimiter ;

#Procedimiento para eliminar Profesor

delimiter //

CREATE PROCEDURE sp_elimProf(
    IN p_correoProf VARCHAR(80),
    in p_passProf VARCHAR(20)
)
BEGIN
    DECLARE existe INT;
    SET existe = (SELECT COUNT(*) FROM Profesor WHERE correoProf = p_correoProf and passProf = p_passProf);

    IF (existe = 1) THEN
        DELETE FROM Profesor WHERE correoProf = p_correoProf and passProf = p_passProf;
    END IF;
END;
//

delimiter ;

delimiter //

create procedure sp_verSesionProf(
	IN p_sesion VARCHAR(100),
    IN TIPO VARCHAR(50)
)
BEGIN
	
    declare Xmsg varchar(50);
    declare existe int;
    
    if(tipo != "profesor" and tipo != "Profesor") then
		set Xmsg = "tipoError";
        select Xmsg;
    else
		set existe = (select count(*) from relSesionProf where idSesion = p_sesion);
        if(existe = 1) then
			set Xmsg = "existe";
            select Xmsg;
        else
			set Xmsg = "noExiste";
            select Xmsg;	
        end if;
    end if;
    
END;//

delimiter ;

drop procedure if exists sp_loginProf;

delimiter //

create procedure sp_loginProf(
	in p_correo varchar(80),
    in p_pass varchar(20)
)
BEGIN

	declare existe int;
    declare idProf int;
    declare idSesion1 varchar(100);
    declare xMsg varchar(50);
    
    set existe = (select count(*) from Profesor where correoProf = p_correo and passProf = p_pass);
    if(existe = 1) then
		set idProf = (select idProfesor from Profesor where correoProf = p_correo and passProf = p_pass);
        set idSesion1 = UUID();
        insert into sesiones(idSesion, fecha) values(idSesion1, now());
        insert into relSesionProf(idSesion, idProfesor) values(idSesion1, idProf);
        select idSesion1;
	else
		set Xmsg = "error";
        select Xmsg;
    end if;

END;//

delimiter ;