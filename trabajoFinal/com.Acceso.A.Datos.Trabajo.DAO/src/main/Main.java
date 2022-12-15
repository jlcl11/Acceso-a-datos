package main;

import java.util.Iterator;
import java.util.Scanner;

import dao.EquipoDao;
import dao.JugadorDao;
import dao.ObjetoDao;
import pojo.Equipo;
import pojo.Jugador;

public class Main {

	public static void main(String[] args) {
		// TODO updatear un jugador

		ObjetoDao od = new ObjetoDao();
		EquipoDao ed = new EquipoDao();
		JugadorDao jd = new JugadorDao();

		od.crearTablas();

		System.out.println("------CREAR E INSERTAR EQUIPOS------");
		Equipo e1 = new Equipo("Lakers", "Los Ángeles", "Rob Pelinka", "Jeanie Buss", false);
		ed.insertar(e1);
		Equipo e2 = new Equipo("76es", "Phidaldelphia", "Elton Brand", "Josh Harris", true);
		ed.insertar(e2);
		Equipo e3 = new Equipo("Bulls", "Chicago", "Marc Eversley", "Jerry Reinsdorf", true);
		ed.insertar(e3);

		System.out.println("------MOSTRADO DE TODOS LOS EQUIPOS------" + "\n");

		for (byte i = 0; i < ed.buscarTodos().size(); i++) {
			System.out.println(ed.buscarTodos().get(i));
		}

		System.out.println("------MOSTRADO DE TODOS LOS EQUIPOS DE LA CONFERENCIA ESTE------" + "\n");

		for (int i = 0; i < ed.buscarPorConferencia(true).size(); i++) {
			System.out.println(ed.buscarPorConferencia(true).get(i));
		}

		System.out.println("------MOSTRADO DE TODOS LOS EQUIPOS DE LA CONFERENCIA OESTE------" + "\n");

		for (int i = 0; i < ed.buscarPorConferencia(false).size(); i++) {
			System.out.println(ed.buscarPorConferencia(false).get(i));
		}

		System.out.println("\"------SELECCIONAR UN EQUIPO POR ID------\"+\"\\n\"");
		System.out.println("Vamos a usar el id 1");
		System.out.println(ed.buscarPorId(1));

		System.out.println("------MODIFICAR UN EQUIPO POR ID------");
		System.out.println("Vamos a usar el id 1 y vamos a cambiar los siguientes datos");
		System.out.println("Ciudad actual: Los Ángeles \t Ciudad nueva: Las Vegas");
		System.out.println("Nombre actual:Lakers \t Nombre nuevo: Poggers");
		System.out.println("GM actual: Rob Pelinka \t  GM nuevo: Manolo el del bombo");
		System.out.println("Dueña actua: Jeani Buss \t Dueño nuevo: Bugs Bunny");
		System.out.println("Conferencia actual: oeste \t Conferencia nueva: este");

		Equipo modificEquipo = new Equipo(1, "Poggers", "Las Vegas", "Manolo el del bombo", "Bugs Bunny", true);
		ed.modificar(modificEquipo);

		System.out.println("------MOSTRADO DE TODOS LOS EQUIPOS------" + "\n");

		for (byte i = 0; i < ed.buscarTodos().size(); i++) {
			System.out.println(ed.buscarTodos().get(i));
		}

		System.out.println("------MOSTRADO DE TODOS LOS EQUIPOS DE LA CONFERENCIA ESTE------" + "\n");

		for (int i = 0; i < ed.buscarPorConferencia(true).size(); i++) {
			System.out.println(ed.buscarPorConferencia(true).get(i));
		}

		System.out.println("------MOSTRADO DE TODOS LOS EQUIPOS DE LA CONFERENCIA OESTE------" + "\n");

		for (int i = 0; i < ed.buscarPorConferencia(false).size(); i++) {
			System.out.println(ed.buscarPorConferencia(false).get(i));
		}

		System.out.println("------BORRAR UN EQUIPO POR ID------");
		System.out.println("Vamos a borrar el equipo con el id 3");
		ed.borrar(3);
		System.out.println("------MOSTRADO DE TODOS LOS EQUIPOS------" + "\n");

		for (byte i = 0; i < ed.buscarTodos().size(); i++) {
			System.out.println(ed.buscarTodos().get(i));
		}

		System.out.println("------CREAR JUGADORES------");
		Jugador leBron = new Jugador("LeBron", "James", "The King", (byte) 6, 44.47f, "ALERO", 1);
		jd.insertar(leBron);
		Jugador aD = new Jugador("Anthony", "Davis", "The Brow", (byte) 3, 37.98f, "ALAPIVOT", 1);
		jd.insertar(aD);
		Jugador joelEmbiid = new Jugador("Joel", "Embiid", "Troell", (byte) 21, 33.61f, "PIVOT", 2);
		jd.insertar(joelEmbiid);
		Jugador jamesHarden = new Jugador("James", "Harden", "The Beard", (byte) 1, 33f, "ESCOLTA", 2);
		jd.insertar(jamesHarden);

		for (int o = 0; o < jd.buscarTodos().size(); o++) {
			System.out.println(jd.buscarTodos().get(o));
		}

		System.out.println("------SELECCIONAR UN JUGADOR POR ID------");
		System.out.println("Vamos a seleccionar el jugador 1");
		System.out.println(jd.buscarPorId(1));

		System.out.println("------MODIFICAR UN JUGADOR------");
		System.out.println("Vamos a modificar el jugador con id 2");
		System.out.println("Nombre actual: Anthony \t Nombre nuevo:Cristiano ");
		System.out.println("Apellido actual:Davis \t Apellido:Ronaldo");
		System.out.println("Apodo actual:The Brow\tApodo nuevo:El bicho suuu");
		System.out.println("Dorsal actual:3\tDorsal nuevo:7");
		System.out.println("Salario actual:40\nSalario nuevo:30");
		System.out.println("Posición actual:ALERO\tPosición nuevo:BASE");
		System.out.println("id del equipo actual:1\nNuevo id:2 ");

		Jugador modifcado = new Jugador(2, "Cristiano", "Ronaldo", "El bicho suuu", (byte) 7, 30, "BASE", 2);
		jd.modificar(modifcado);
		System.out.println("\n");
		for (int o = 0; o < jd.buscarTodos().size(); o++) {
			System.out.println(jd.buscarTodos().get(o));
		}
		System.out.println("------BORRAR UN JUGADOR POR ID------");
		System.out.println("Vamos a borrar el jugador con el id 1");
		jd.borrar(1);
		for (int o = 0; o < jd.buscarTodos().size(); o++) {
			System.out.println(jd.buscarTodos().get(o));
		}

		System.out.println("------MOSTRAR LA PLANTILLA DE UN EQUIPO------");
		System.out.println("Vamos a imprimir la plantilla del equipo 2");
		for (int i = 0; i < ed.seleccionarPlantilla(2).size(); i++) {
			System.out.println(ed.seleccionarPlantilla(2).get(i));
		}

		System.out.println("------BORRAR LA PLANTILLA DE UN EQUIPO------");
		System.out.println("Vamos a borrar la plantilla del equipo 2");
		jd.borrarPorEquipo(2);

		System.out.println("------FINALMENTE MOSTRAMOS LOS JUGADORES QUE NOS QUEDAN------");
		for (int o = 0; o < jd.buscarTodos().size(); o++) {
			System.out.println(jd.buscarTodos().get(o));
		}
		System.out.println("Como hemos cambiado al jugador de equipo,ya los hemos borrado todos");

		od.borrarTablas();

	}

}
