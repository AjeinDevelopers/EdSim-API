use educasim;

insert into clase (idClase, nombre) values("mn2ns2", "prueba");

select * from clase;

select * from alumno;
select * from nombre;
select * from relUsuNom;

call sp_registrarUsuario("Juan", "a", "Casas", "Hernandez", "hola@gmail.com", "pin223ms8", "m3$n23InSa2", "mn2ns2");

select idUsuario from alumno where correo = "hola@gmail.com" and contrasena = "m3$n23InSa2" and pin = "pin223ms8";

select count(*) from alumno where correo = "hola@gmail.com" and contrasena = "m3$n23InSa2" and pin = "pin223ms8";
select count(*) from clase where idClase = "mn2ns2";

insert into alumno(tipoUsu, contrasena, pin, correo) values("a", "m3$n23InSa2", "pin223ms8");