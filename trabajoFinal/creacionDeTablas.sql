use trabajoaccesoadatos;

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
nominacionesallstar NUMERIC(2),
anillosdecampeon NUMERIC(2),
eq_id int ,
CONSTRAINT FK_equipo FOREIGN KEY (eq_id) REFERENCES equipos(eq_id)
);