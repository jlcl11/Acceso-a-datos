
use trabajoaccesoadatos;
create database trabajoaccesoadatos;

CREATE TABLE equipos (
eq_id int PRIMARY KEY auto_increment,
nombre VARCHAR(30),
ciudadlocal VARCHAR(200),
generalManager VARCHAR(200),
propietario VARCHAR(200),
conferencia boolean
);

CREATE TABLE jugadores(
jugador_id int PRIMARY KEY auto_increment,
nombre varchar(20),
apellido varchar(20),
apodo varchar(20),
dorsal numeric(2),
salario numeric(4,2),
posicion ENUM('BASE','ESCOLTA','ALERO','ALAPIVOT','PIVOT'),
eq_id int ,
CONSTRAINT FK_equipo FOREIGN KEY (eq_id) REFERENCES equipos(eq_id)
);

UPDATE jugadores SET nombre='',apellido='',apodo='',dorsal=0,salario=0.0,posicion='PIVOT',eq_id=2 WHERE jugador_id=2;

DELETE  FROM jugadores WHERE jugador_id=1;

INSERT INTO equipos(nombre,ciudadlocal,generalManager,propietario,conferencia) VALUES('lakers','LA','Pelinka','Jeanie Buss',false);
INSERT INTO jugadores(nombre,apellido,apodo,dorsal,salario,posicion,eq_id) VALUES('Lebron','James','The King',6,42.44,'ALERO',3);


DELETE FROM equipos;