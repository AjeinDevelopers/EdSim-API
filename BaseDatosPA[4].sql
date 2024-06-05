drop database if exists EducaSim;
create database EducaSim;
use EducaSim;

create table Profesor(
	idProfesor int(3) auto_increment not null primary key,
	correoProf varchar(80) not null,
    passProf varchar(12) not null,
    nombreProf varchar(50), 
	apePatProf varchar(50), 
	apeMatProf varchar(50)
);

create table Alumno(
	idAlumno int(3) auto_increment not null primary key,
	correoAlum varchar(80) not null,
    passAlum varchar(12) not null,
    nombreAlum varchar(50), 
	apePatAlum varchar(50), 
	apeMatAlum varchar(50)
);

create table Materia(
	idMateria int(3) auto_increment not null primary key,
    nombre varchar(40)
);

create table Clase(
	idClase int(3) auto_increment not null primary key,
    nombre varchar(50),
    idMateria int(3),
    idProfesor int(3),
    foreign key(idMateria) references Materia(idMateria)
);

create table Tema(
	idTema int(3) auto_increment not null primary key,
    nombre varchar(40)
);

create table Articulo(
	idArticulo int(3) auto_increment not null primary key,
    nombre varchar(40)
);

create table Examen(
	idExamen int(3) auto_increment not null primary key,
    nombre varchar(40)
);

create table Ejercicio(
	idEjercicio int(3) auto_increment not null primary key,
    nombre varchar(40)
);

create table PreguntasExam(
	idPregunta int(3) auto_increment not null primary key,
    enunciado varchar(9000),
    respCorrecta varchar(500)
);

create table PreguntasEjer(
	idPregunta int(3) auto_increment not null primary key,
    enunciado varchar(9000),
    respCorrecta varchar(500)
);

create table RespuestasOpc(
	idRespOpc int(3) auto_increment primary key,
    enunciado varchar(9000)
);

create table RelAlumClase(
	idRelAlumClase int(3) auto_increment not null primary key,
    idClase int(3),
    idAlumno int(3),
    progreso int(3),
    foreign key(idClase) references Clase(idClase),
    foreign key(idAlumno) references Alumno(idAlumno)
);

create table Temario(
	idTemario int(3) auto_increment not null primary key,
    idMateria int(3),
    idTema int(3),
    foreign key(idMateria) references Materia(idMateria),
    foreign key(idTema) references Tema(idTema)
);

create table Material(
	idMaterial int(3) auto_increment not null primary key,
    idTema int(3),
    idArticulo int(3),
    foreign key(idTema) references Tema(idTema),
    foreign key(idArticulo) references Articulo(idArticulo)
);

create table RelAlumExam(
	idRelAlumExam int(3) auto_increment not null primary key,
    idAlumno int(3),
    idExamen int(3),
    foreign key(idAlumno) references Alumno(idAlumno),
    foreign key(idExamen) references Examen(idExamen)
);

create table RelAlumEjer(
	idRelAlumEjer int(3) auto_increment not null primary key,
    idAlumno int(3),
    idEjercicio int(3),
    foreign key(idAlumno) references Alumno(idAlumno),
    foreign key(idEjercicio) references Ejercicio(idEjercicio)
);

create table relPEXROP(
	idrelPEXROP int(3) auto_increment not null primary key,
	idPregunta int(3),
    idRespOpc int (3),
    foreign key(idPregunta) references PreguntasExam(idPregunta),
    foreign key(idRespOpc) references RespuestasOpc(idRespOpc)
);

create table relPEJROP(
	idrelPEXROP int(3) auto_increment not null primary key,
	idPregunta int(3),
    idRespOpc int (3),
    foreign key(idPregunta) references PreguntasEjer(idPregunta),
    foreign key(idRespOpc) references RespuestasOpc(idRespOpc)
);


/*alter table relUsuNom add foreign key(idUsuario) references Usuario(idUsuario);

alter table relUsApr add foreign key(idFAprendizaje) references FormaAprendizaje(idFAprendizaje);

alter table RelUsuProgr add foreign key(idProgreso) references Progreso(idProgreso);

alter table RelExUsu add foreign key(idExamen) references Examen(idExamen);

alter table relPreguntaEx add foreign key(idPregunta) references Pregunta(idPregunta);

alter table Pregunta add foreign key(respuestaCorrecta) references Respuesta(idRespuesta);

alter table relPreguntaej add foreign key(idEjercicio) references Ejercicio(idEjercicio); */



/*alter table relEjUrl add foreign key(idUrl) references url(idUrl);

alter table relArtUrl add foreign key(idArticulo) references Articulo(idArticulo);*/
