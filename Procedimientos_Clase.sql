use educasim;

drop procedure if exists sp_crearClase;

delimiter //

create procedure sp_crearClase(
	in p_idClase varchar(6),
	in p_nombre varchar(50),
    in p_fase varchar(50),
    in p_materia varchar(50),
    in p_sesion varchar(100)
)
BEGIN

	Declare idProf int;
    Declare p_idMateria int;
    Declare p_idFase int;
    Declare xMsg varchar(50);
    Declare existe int;
    Declare inserto int;
    declare repetida int;
    
    set existe = (select count(*) from Clase where idClase = p_idClase);
    set idProf = (select idProfesor from relSesionProf where idSesion = p_sesion);
    set p_idMateria = (select idMateria from Materia where nombre = p_materia);
    set p_idFase = (select idFase from fase where nombre = p_fase);
    if existe = 1 then
		set Xmsg = "repetido";
        select Xmsg;
    end if;
    set repetida = (select count(*) from clase where nombre = p_nombre and idProfesor = idProf);
    if repetida > 0 then
		set Xmsg = "existe";
        select Xmsg;
    end if;
    if idProf is not null and p_idMateria is not null and p_idFase is not null and p_nombre is not null then
		insert into Clase(idClase, nombre, idMateria, idProfesor, idFase) values(p_idClase, p_nombre, p_idMateria, idProf, p_idFase);
        set inserto = (select count(*) from Clase where idClase = p_idClase);
        if inserto = 1 then
			set Xmsg = p_idClase;
            select Xmsg;
        else
			set Xmsg = "error";
            select Xmsg;
        end if;
	else
		set xMsg = "error";
        select xMsg;
    end if;
    
END;//

delimiter ;

drop procedure if exists sp_eliminarClase;

delimiter //

create procedure sp_eliminarClase(
	
    in p_idClase varchar(6),
    in p_sesion varchar(100)
    
)
BEGIN

	DECLARE p_idProfe int;
    DECLARE existe int;
    DECLARE existeProfe int;
    DECLARE Xmsg varchar(50);
    
    set existeProfe = (select count(*) from relSesionProf where idSesion = p_sesion);
    if existeProfe = 1 then
		set p_idProfe = (select idProfesor from relSesionProf where idSesion = p_sesion);
        set existe = (select count(*) from Clase where idClase = p_idClase and idProfesor = p_idProfe);
        if existe = 1 then
			delete from RelAlumClase where idClase = p_idClase;
            delete from Clase where idClase = p_idClase;
            set Xmsg = "elimino";
            select Xmsg;
        else
			set Xmsg = "error";
            select Xmsg;
        end if;
    else
		set Xmsg = "error";
        select Xmsg;
    end if;

END;//

delimiter ;