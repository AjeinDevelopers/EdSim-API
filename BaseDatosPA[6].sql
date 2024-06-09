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

create table Clase(
	idClase varchar(6) not null primary key,
    nombre varchar(50),
    idMateria int(3),
    idProfesor int(3),
    foreign key(idMateria) references Materia(idMateria),
    foreign key(idProfesor) references Profesor(idProfesor)
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
    progreso int(3),
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

INSERT INTO Profesor (correoProf , passProf , nombreProf , apePatProf , 
	apeMatProf) VALUES ("rafa@gmail.com", "R4f0", "Rafa", "Cabañas", "Rocha");
    
INSERT INTO Profesor (correoProf , passProf , nombreProf , apePatProf , 
	apeMatProf) VALUES ("gaby@gmail.com", "G4b1", "Gaby", "Rocha", "Cortés");

INSERT INTO Alumno (correoAlum  , passAlum  , nombreAlum  , apePatAlum  , 
	apeMatAlum ) VALUES ("uri@gmail.com", "Ur1", "Ury", "Cabañas", "Rocha");
    
INSERT INTO Alumno (correoAlum  , passAlum  , nombreAlum  , apePatAlum  , 
	apeMatAlum ) VALUES ("angel@gmail.com", "4Ng3l", "Angel", "Reyes", "León");
    
INSERT INTO Materia (nombre) VALUES ("calculo diferencial");
INSERT INTO Materia (nombre) VALUES ("calculo integral");
INSERT INTO Materia (nombre) VALUES ("probabilidad");

INSERT INTO Clase (nombre, idMateria, idProfesor, idClase) VALUES ("6IM8", 1, 1, "MnS3mj");
#INSERT INTO Clase (nombre, idMateria, idProfesor) VALUES ("6IM6", 2, 2);

INSERT INTO Tema (nombre) VALUES ("limites");
INSERT INTO Tema (nombre) VALUES ("derivacion");
INSERT INTO Tema (nombre) VALUES ("maximos");
INSERT INTO Tema (nombre) VALUES ("integracion");
INSERT INTO Tema (nombre) VALUES ("solidos de revolucion");
INSERT INTO Tema (nombre) VALUES ("arandelas");

INSERT INTO Articulo (url) VALUES ("Calculo integral en campos electricos");
INSERT INTO Articulo (url) VALUES ("Teoria de conjuntos");
INSERT INTO Articulo (url) VALUES ("Calculo diferencial en ecuaciones diferenciales");

INSERT INTO Examen (nombre) VALUES ("Parcial 1");
INSERT INTO Examen (nombre) VALUES ("Parcial 2");
INSERT INTO Examen (nombre) VALUES ("Parcial 3");

INSERT INTO Ejercicio (nombre) VALUES ("Ejercicio 1");
INSERT INTO Ejercicio (nombre) VALUES ("Ejercicio 2");
INSERT INTO Ejercicio (nombre) VALUES ("Ejercicio 3");

INSERT INTO PreguntasExam (enunciado, respCorrecta) VALUES ("¿Cuánto vale la derivada de una constante?", "Cero");
INSERT INTO PreguntasExam (enunciado, respCorrecta) VALUES ("¿Qué representa derivada?", "Una recta tangente a la curva");

INSERT INTO PreguntasEjer (enunciado, respCorrecta) VALUES ("dy/dx (2x)", "2");
INSERT INTO PreguntasEjer (enunciado, respCorrecta) VALUES ("dy/dx (2x^2 + 3)", "4x");

INSERT INTO RespuestasOpc (enunciado) VALUES ("62");
INSERT INTO RespuestasOpc (enunciado) VALUES ("-2");
INSERT INTO RespuestasOpc (enunciado) VALUES ("x");
INSERT INTO RespuestasOpc (enunciado) VALUES ("zy");

INSERT INTO RelAlumClase (idClase, idAlumno, progreso) VALUES (1, 1, 80);
INSERT INTO RelAlumClase (idClase, idAlumno, progreso) VALUES (1, 2, 80);
INSERT INTO RelAlumClase (idClase, idAlumno, progreso) VALUES (2, 2, 80);

INSERT INTO Temario (idMateria , idTema) VALUES (1, 1);
INSERT INTO Temario (idMateria , idTema) VALUES (2, 4);
INSERT INTO Temario (idMateria , idTema) VALUES (3, 6);
INSERT INTO Temario (idMateria , idTema) VALUES (2, 5);

INSERT INTO Material (idTema , idArticulo) VALUES (4, 1);
INSERT INTO Material (idTema , idArticulo) VALUES (5, 1);
INSERT INTO Material (idTema , idArticulo) VALUES (6, 1);

INSERT INTO RelAlumExam (idAlumno, idExamen, calificacion) VALUES (1, 2, 9);
INSERT INTO RelAlumExam (idAlumno, idExamen, calificacion) VALUES (2, 1, 10);
INSERT INTO RelAlumExam (idAlumno, idExamen, calificacion) VALUES (1, 3, 5);

INSERT INTO RelAlumEjer (idAlumno, idEjercicio, calificacion) VALUES (1, 3, 7);
INSERT INTO RelAlumEjer (idAlumno, idEjercicio, calificacion) VALUES (2, 2, 8);
INSERT INTO RelAlumEjer (idAlumno, idEjercicio, calificacion) VALUES (1, 1, 9);

INSERT INTO RelEXPRE (idExamen, idPregunta) VALUES (1, 1);
INSERT INTO RelEXPRE (idExamen, idPregunta) VALUES (3, 2);

INSERT INTO RelEJPRE (idEjercicio, idPregunta) VALUES (1, 2);
INSERT INTO RelEJPRE (idEjercicio, idPregunta) VALUES (3, 1);

INSERT INTO relPEXROP (idPregunta, idRespOpc) VALUES (1, 2);
INSERT INTO relPEXROP (idPregunta, idRespOpc) VALUES (2, 1);

INSERT INTO relPEXROP (idPregunta, idRespOpc) VALUES (1, 4);
INSERT INTO relPEXROP (idPregunta, idRespOpc) VALUES (2, 3);

select * from Profesor;

select * from RelAlumExam;

/*alter table relEjUrl add foreign key(idUrl) references url(idUrl);

alter table relArtUrl add foreign key(idArticulo) references Articulo(idArticulo);*/
