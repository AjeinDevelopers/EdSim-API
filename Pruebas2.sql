use educasim;

select * from Alumno;
select * from relAlumClase;
select * from sesiones;
select * from relSesionAlum;

call sp_registrarAlum("MnS3mj", "quesakl@ggg.com", "mnn$mn4Nse", "mnn$mn4Nse", "Juan", "Casas", "Hernandez");

select count(*) from sesiones where idSesion = UUID();