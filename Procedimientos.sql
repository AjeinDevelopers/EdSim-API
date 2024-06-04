use educasim;

delimiter //

create procedure sp_registrarUsuario(
	in nombreIn varchar(50),
    in tipoUsuario varchar(2),
    in apePatIn varchar(50),
    in apeMatIn varchar(50),
    in correoIn varchar(50),
    in pinIn varchar(20),
    in contrasenaIn varchar(20)
)
begin
	
    declare existe int;
    declare idA int;
    
	set existe = (select count(*) from usuario where correo = correoIn and contrasena = contrasenaIn and pin = pinIn);
    
	if(existe = 0) then			
		insert into usuario(tipoUsu, contrasena, pin, correo) values(tipoUsuario, contrasenaIn, pinIn);
		insert into nombre(nombre, apePat, apeMat) values(nombreIn, apePatIn, apeMatIn);
        
        set idA  = (select id from usuario where correo = correoIn and contrasena = contrasenaIn and pin = pinIn);
    end if;			
    
end;//

delimiter ;