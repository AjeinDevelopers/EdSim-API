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
    passAlum varchar(20) not null,
    pinSeguridad varchar(20),
    nombreAlum varchar(50), 
	apePatAlum varchar(50), 
	apeMatAlum varchar(50),
    formaAprendizaje varchar(50)
);

create table sesiones(
	idSesion varchar(100) primary key,
    fecha date
);

create table relSesionAlum(
	idRel int(5) primary key auto_increment,
    idSesion varchar(100),
    idAlumno int(3),
    foreign key (idAlumno) references Alumno(idAlumno),
    foreign key (idSesion) references sesiones(idSesion)
);

create table relSesionProf(
	idRel int(5) primary key auto_increment,
    idSesion varchar(100),
    idProfesor int(3),
    foreign key (idProfesor) references Profesor(idProfesor),
    foreign key (idSesion) references sesiones(idSesion)
);

create table Materia(
	idMateria int(3) auto_increment not null primary key,
    nombre varchar(40)
);

create table fase(
	idFase int(3) auto_increment not null primary key,
    nombre varchar(50)
);

create table Clase(
	idClase varchar(6) not null primary key,
    nombre varchar(50),
    idMateria int(3),
    idProfesor int(3),
    idFase int(3),
    foreign key(idMateria) references Materia(idMateria),
    foreign key(idProfesor) references Profesor(idProfesor),
    foreign key(idFase) references fase(idFase)
);

create table Articulo(
	idArticulo int(3) auto_increment not null primary key,
    titulo varchar(100),
    resumen varchar(600),
    url varchar(450)
);

create table Examen(
	idExamen int(3) auto_increment not null primary key,
    nombre varchar(40),
    cantReactivos int(2),
    url varchar(450)
);

create table Ejercicio(
	idEjercicio int(3) auto_increment not null primary key,
    nombre varchar(40),
    cantReactivos int(2),
    url varchar(450)
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
    idClase varChar(6),
    idAlumno int(3),
    foreign key(idClase) references Clase(idClase),
    foreign key(idAlumno) references Alumno(idAlumno)
);

create table Temario(
	idTemario int(3) auto_increment not null primary key,
    idMateria int(3),
    foreign key(idMateria) references Materia(idMateria)
);

create table Tema(
	idTema int(3) auto_increment not null primary key,
    nombre varchar(40),
    idTemario int(3),
    foreign key(idTemario) references Temario(idTemario)
);

create table Material(
	idMaterial int(3) auto_increment not null primary key,
    idTema int(3),
    idArticulo int(3),
    foreign key(idTema) references Tema(idTema),
    foreign key(idArticulo) references Articulo(idArticulo)
);

create table RelMateMatel(
	idRelMateMatel int(2) auto_increment not null primary key,
    idMateria int(3),
    idMaterial int(3),
    foreign key(idMateria) references Materia(idMateria),
    foreign key(idMaterial) references Material(idMaterial)
);

create table RelAlumExam(
	idRelAlumExam int(3) auto_increment not null primary key,
    idAlumno int(3),
    idExamen int(3),
    calificacion int(2),
    foreign key(idAlumno) references Alumno(idAlumno),
    foreign key(idExamen) references Examen(idExamen)
);

create table RelAlumEjer(
	idRelAlumEjer int(3) auto_increment not null primary key,
    idAlumno int(3),
    idEjercicio int(3),
    calificacion int(2),
    foreign key(idAlumno) references Alumno(idAlumno),
    foreign key(idEjercicio) references Ejercicio(idEjercicio)
);

create table RelEXPRE(
	idRelEXPRE int(3) auto_increment not null primary key,
    idExamen int(3),
    idPregunta int(3),
    foreign key(idExamen) references Examen(idExamen),
    foreign key(idPregunta) references PreguntasExam(idPregunta)
);

create table RelEJPRE(
	idRelEJPRE int(3) auto_increment not null primary key,
	idEjercicio int(3),
    idPregunta int(3),
    foreign key(idEjercicio) references Ejercicio(idEjercicio),
    foreign key(idPregunta) references PreguntasEjer(idPregunta)
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