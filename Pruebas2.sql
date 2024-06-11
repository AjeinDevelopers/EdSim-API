use educasim;

select * from profesor;
select * from Alumno;
select * from relAlumClase;
select * from sesiones;
select * from relSesionAlum;
select * from relSesionProf;

call sp_registrarAlum("MnS3mj", "quesakl@ggg.com", "mnn$mn4Nse", "mnn$mn4Nse", "Juan", "Casas", "Hernandez");
call sp_registrarProf("holita@go.co", "m3#2NmsW", "Hugo", "Hernandez", "Carrillo");
call sp_verSesionProf("199a6e25-27a2-11ef-aa7f-ec8eb53cd564", "profesor");

select count(*) from sesiones where idSesion = UUID();