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
    
    set existe = (select count(*) from Clase where idClase = p_idClase);
    set idProf = (select idProfesor from relSesionProf where idSesion = p_sesion);
    set p_idMateria = (select idMateria from Materia where nombre = p_materia);
    set p_idFase = (select idFase from fase where nombre = p_fase);
    if idProf is not null and p_idMateria is not null and p_idFase is not null and p_nombre is not null then
		insert into Clase(idClase, nombre, idMateria, idProfesor, idFase) values(p_idClase, p_nombre, p_idMateria, idProf, p_idFase);
	else
		set xMsg = "error";
        select xMsg;
    end if;
    
END;//

delimiter ;