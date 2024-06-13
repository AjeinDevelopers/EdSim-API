use educasim;

select * from profesor;
select * from Alumno;
select * from relAlumClase;
select * from sesiones;
select * from relSesionAlum;
select * from relSesionProf;
select * from fase;
select * from materia;
select * from Clase;
select * from RelAlumClase;

call sp_registrarAlum("MnS3mj", "quesakl@ggg.com", "mnn$mn4Nse", "mnn$mn4Nse", "Juan", "Casas", "Hernandez");
call sp_registrarProf("holita@go.co", "m3#2NmsW", "Hugo", "Hernandez", "Carrillo");
call sp_verSesionProf("45a6a377-27fa-11ef-aa7f-ec8eb53cd564", "profesor");
insert into fase(nombre) values("Fase 1");
insert into fase(nombre) values("Fase 2");
insert into Materia(nombre) values("Matematicas");
insert into Materia(nombre) values("Quimica");
insert into Materia(nombre) values("Historia");
call sp_crearClase("Mn3n2a", "Clase 1", "Fase 1", "Matematicas", "45a6a377-27fa-11ef-aa7f-ec8eb53cd564");
select idProfesor from relSesionProf where idSesion = "45a6a377-27fa-11ef-aa7f-ec8eb53cd564";
select count(*) from sesiones where idSesion = UUID();