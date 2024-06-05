use educasim;

#drop procedure sp_registrarUsuario;

delimiter //



create procedure sp_registrarUsuario(
	in nombreIn varchar(50),
    in tipoUsuario varchar(2),
    in apePatIn varchar(50),
    in apeMatIn varchar(50),
    in correoIn varchar(50),
    in pinIn varchar(20),
    in contrasenaIn varchar(20),
    in clase varchar(6)
)
begin
	
    declare existe int;
    declare idUs int;
    declare idNom int;
    declare existeClase int;
    
	set existe = (select count(*) from usuario where correo = correoIn and contrasena = contrasenaIn and pin = pinIn);
    set existeClase = (select count(*) from clase where idClase = clase);
    
	if(existe = 0 and existeClase = 1) then			
		insert into usuario(tipoUsu, contrasena, pin, correo) values(tipoUsuario, contrasenaIn, pinIn, correoIn);
		insert into nombre(nombre, apePat, apeMat) values(nombreIn, apePatIn, apeMatIn);
        set idUs = (select idUsuario from usuario where correo = correoIn and contrasena = contrasenaIn and pin = pinIn);
        set idNom = (select idNombre from nombre where nombre = nombreIn and apePat = apePatIn and apeMat = apeMatIn);
        insert into relUsuNom(idUsuario, idNombre) values(idUs, idNom);
    end if;			
    
end;//

delimiter ;