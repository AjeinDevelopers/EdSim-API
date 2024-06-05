drop database if exists EducaSim;
create database EducaSim;
use EducaSim;

create table Nombre (idNombre int(3) auto_increment primary key, nombre varchar(50), 
apePat varchar(50), apeMat varchar(50));

create table relUsuNom(
	idRel int(3) auto_increment primary key,
    idUsuario int(3),
    idNombre int(3), foreign key(idNombre) references Nombre(idNombre) );
 
 
create table Usuario(
	idUsuario int(3) auto_increment primary key,
    tipoUsu varchar(2),
    contrasena varchar(20),
    pin varchar(20),
    correo varchar(50)
);

create table relUsApr (
	idRelUsApr int(3) auto_increment primary key,
    idUsuario int(3), idFAprendizaje int(1), 
    foreign key(idUsuario) references Usuario(idUsuario)
);

create table FormaAprendizaje (
	idFAprendizaje int(3) auto_increment primary key,
    nombre varchar(12) 
);

create table RelUsuProgr (
	idRelUsuPro int(3) auto_increment primary key,
    idUsuario int(3), idProgreso int(3), foreign key(idUsuario) references Usuario(idUsuario) 
);

create table Progreso (
	idProgreso int(3) auto_increment primary key,
    escala int(2)
);

create table RelExUsu(  
	idRelExU int(3) auto_increment primary key,
    idExamen int(2), 
    idUsuario int(3),
    aciertos int(2),
    intentos int(1), foreign key(idUsuario) references Usuario(idUsuario)
);

create table Examen (
	idExamen int(2) auto_increment primary key, 
    duracion time,
    cantReactivos int(2)
);

create table relPreguntaEx (
	idRelPreguntaEx int(3) auto_increment primary key,
	idPregunta int(2),
    idExamen int(3), foreign key(idExamen) references Examen(idExamen)
);

create table Pregunta (
	idPregunta int(2) auto_increment primary key,
    respuestaCorrecta int(2),
    enunciado text(9000)
);

create table Respuesta (
	idRespuesta int(2) auto_increment primary key,
    repuesta char(1),
    pregunta int(2), foreign key(pregunta) references Pregunta(idPregunta)
);

create table relPreguntaEj (
	idPreguntaEj int(2) auto_increment primary key,
    idEjercicio int(2), 
    idPregunta int(2), foreign key(idPregunta) references Pregunta(idPregunta)
);

create table Ejercicio (
	idEjercicio int(2) auto_increment primary key, 
    cantReactivos int(2)
);

create table relEjUrl (
	idRelEjUrl int(3) auto_increment primary key,
    idEjercicio int(2),
    idUrl int(2), foreign key(idEjercicio) references Ejercicio(idEjercicio)
);

create table url (
	idUrl int(2) auto_increment primary key,
    url varchar(500)
);

create table relExUrl (
	idRelExUrl int(3) auto_increment primary key,
    idExamen int(2),
    idUrl int(2), foreign key(idExamen) references Examen(idExamen), foreign key(idUrl) references url(idUrl)
);

create table relArtUrl (
	idRelArtUrl int(3) auto_increment primary key,
    idArticulo int(2),
    idUrl int(2), foreign key(idUrl) references url(idUrl)
);

create table Articulo (
	idArticulo int(2) auto_increment primary key,
    titulo varchar(100),
    resumen text(1000)
);

create table Tema (
	idTema int(3) auto_increment primary key,
    nombre varchar(100)
);
create table relArtTema (
	idRelTemArt int(3) auto_increment primary key,
    idTema int(3), 
    idArticulo int(2), foreign key(idTema) references Tema(idTema), foreign key(idArticulo) references Articulo(idArticulo)
);

create table relEjercicioTema (
	idRelTemEj int(3) auto_increment primary key,
    idTema int(3), 
    idEjercicio int(2), foreign key(idTema) references Tema(idTema), foreign key(idEjercicio) references Ejercicio(idEjercicio)
);

create table relEjUsu (
	idRelEjUsu int(3) auto_increment primary key, 
	idEjercicio int(2),
    idUsuario int(3),
    aciertos int(2), foreign key(idEjercicio) references Ejercicio(idEjercicio),
    foreign key(idUsuario) references Usuario(idUsuario)
);

create table reExamenTema(
	idRelTemaEx int(3) auto_increment primary key,
    idTema int(3),
    idExamen int(3), foreign key(idExamen) references Examen(idExamen),
    foreign key(idTema) references Tema(idTema)
);

create table Materia(
	idMateria int(3) auto_increment primary key,
    nombre varchar(100)
);
create table relTemaMateria (
	idRelTM int(3) auto_increment primary key,
    idTema int(3),
    idMateria int(3), foreign key(idTema) references Tema(idTema),
    foreign key(idMateria) references Materia(idMateria)
);
create table Clase (
	idClase varChar(6) primary key,
    nombre varchar(100),
    profesor int(3),
    foreign key(profesor) references alumno(idUsuario)
);
create table relClaseMat(
	idRelCM int(3) auto_increment primary key,
    idClase varChar(6), idMateria int(3), foreign key(idClase) references Clase(idClase),
    foreign key(idMateria) references Materia(idMateria)
);

create table Nivel(
	idNivel int(3) auto_increment primary key,
    nivel int(1)
);
create table relClaseNivel (
	idRelCN int(3) auto_increment primary key,
    idClase varChar(6),
    idNivel int(3), foreign key(idClase) references Clase(idClase),
    foreign key(idNivel) references Nivel(idNivel)
);

create table relTemaNivel(
	 idRelTN int(3) auto_increment primary key,
	 idTema int(3),
	 idNivel int(3), foreign key(idTema) references Tema(idTema),
	 foreign key(idNivel) references Nivel(idNivel)
);

create table relProgresoTema(
	idRelPT int(3) auto_increment primary key,
    idTema int(3), 
    idProgreso int(3), foreign key(idTema) references Tema(idTema),
    foreign key(idProgreso) references Progreso(idProgreso)
);

create table relClaseUsuario(
	idRelCP int(3),
    idClase varChar(6),
    idUsuario int(3), 
    foreign key(idUsuario) references Usuario(idUsuario),
	foreign key(idClase) references Clase(idClase)
);

alter table relUsuNom add foreign key(idUsuario) references Usuario(idUsuario);

alter table relUsApr add foreign key(idFAprendizaje) references FormaAprendizaje(idFAprendizaje);

alter table RelUsuProgr add foreign key(idProgreso) references Progreso(idProgreso);

alter table RelExUsu add foreign key(idExamen) references Examen(idExamen);

alter table relPreguntaEx add foreign key(idPregunta) references Pregunta(idPregunta);

alter table Pregunta add foreign key(respuestaCorrecta) references Respuesta(idRespuesta);

alter table relPreguntaej add foreign key(idEjercicio) references Ejercicio(idEjercicio); 

alter table relEjUrl add foreign key(idUrl) references url(idUrl);

alter table relArtUrl add foreign key(idArticulo) references Articulo(idArticulo);