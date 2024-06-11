use educasim;

drop procedure if exists sp_crearClase;

delimiter //

create procedure sp_crearClase(
	in nombre varchar(50),
    in fase int(3),
    in materia int(3),
    in sesion varchar(100)
)
BEGIN

	

END;//

delimiter ;