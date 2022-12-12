package main;

import java.util.Iterator;
import java.util.Scanner;

import dao.EquipoDao;
import dao.JugadorDao;
import pojo.Equipo;
import pojo.Jugador;

public class Main {

	public static void main(String[] args) {
		//TODO Updates de equipos,reiniciar ids,borrar jugador,update jugador

		Scanner sc = new Scanner(System.in);

		EquipoDao ed = new EquipoDao();
		JugadorDao jd = new JugadorDao();

		for (byte i = 0; i < ed.buscarPorConferencia(false).size(); i++) {
			System.out.println(ed.buscarPorConferencia(true).get(i));

		}

		System.out.println("------CREAR E INSERTAR EQUIPOS------");
		Equipo e1 = new Equipo("Lakers", "Los Ángeles", "Rob Pelinka", "Jeanie Buss", false);
		ed.insertar(e1);
		Equipo e2 = new Equipo("76es", "Phidaldelphia", "Elton Brand", "Josh Harris", true);
		ed.insertar(e2);

		for (byte i = 0; i < ed.buscarTodos().size(); i++) {
			System.out.println(ed.buscarTodos().get(i));
		}

		System.out.println("------SELECCIONAR UN EQUIPO POR ID------");

		System.out.println("Dime el id del equipo que quieras buscar");
		int id_Equipo = Integer.parseInt(sc.nextLine());
		System.out.println(ed.buscarPorId(id_Equipo));

		System.out.println("------MODIFICAR UN EQUIPO POR ID------");
		System.out.println("Dime el id del equipo que quieras modificar");
		int id_Equipo_Modificar = Integer.parseInt(sc.nextLine());
		System.out.println("Dime el nuevo nombre");
		String nombre_Equipo = sc.nextLine();
		System.out.println("Dime la nueva ciudad");
		String nombre_Ciudad = sc.nextLine();
		System.out.println("Dime el nuevo General Manager");
		String nombre_GM = sc.nextLine();
		System.out.println("Dime el nuevo propietario");
		String nombre_Propietario = sc.nextLine();
		System.out.println("Dime la nueva conferencia,este u oeste");
		String nombre_conf = sc.nextLine().toLowerCase();

		if (nombre_conf.equals("este")) {
			Equipo modificado = new Equipo(id_Equipo_Modificar, nombre_Ciudad, nombre_GM, nombre_conf,
					nombre_Propietario, false);
			ed.modificar(modificado);
			System.out.println("Equipo modificado correctamente,ahora es el " + modificado);
		} else {
			Equipo modficado = new Equipo(id_Equipo_Modificar, nombre_Ciudad, nombre_GM, nombre_conf,
					nombre_Propietario, true);
		}

		System.out.println("------BORRAR UN EQUIPO POR ID------");
		System.out.println("Dime el id del equipo que quieras borrar");
		int id_Equipo_Borrar = Integer.parseInt(sc.nextLine());
		ed.borrar(ed.buscarPorId(id_Equipo_Borrar));
		System.out.println("Equipo borrado");

		System.out.println("------BUSCAR LA PLANTILLA DE UN EQUIPO------");
		System.out.println("Dime el id del equipo que quieras buscar");
		int id_Equipo_Plantilla = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < ed.seleccionarPlantilla(ed.buscarPorId(id_Equipo_Plantilla)).size(); i++) {

			System.out.println(ed.seleccionarPlantilla(ed.buscarPorId(id_Equipo_Plantilla)).get(i));

		}

		System.out.println("------CREAR JUGADORES------");
		Jugador leBron = new Jugador("LeBron", "James", "The King", (byte) 6, 44.47f, "ALERO", 136);
		jd.insertar(leBron);
		Jugador aD = new Jugador("Anthony", "Davis", "The Brow", (byte) 3, 37.98f, "ALAPIVOT", 136);
		jd.insertar(aD);
		Jugador joelEmbiid = new Jugador("Joel", "Embiid", "Troell", (byte) 21, 33.61f, "PIVOT", 137);
		jd.insertar(joelEmbiid);
		Jugador jamesHarden = new Jugador("James", "Harden", "The Beard", (byte) 1, 33f, "ESCOLTA", 137);
		jd.insertar(jamesHarden);

		for (int o = 0; o < jd.buscarTodos().size(); o++) {
			System.out.println(jd.buscarTodos().get(o));
		}

		System.out.println("------SELECCIONAR UN JUGADOR POR ID------");

		System.out.println("Dime el id del jugador que quieras buscar");
		int id_Jugador = Integer.parseInt(sc.nextLine());
		System.out.println(jd.buscarPorId(id_Jugador));

		System.out.println("------BORRAR UN JUGADOR POR ID------");
		System.out.println("Dime el id del jugador que quieras borrar");
		int id_Jugador_Borrar = Integer.parseInt(sc.nextLine());
		jd.borrar(jd.buscarPorId(id_Jugador_Borrar));
		System.out.println("Jugador borrado");

		System.out.println("------BORRAR POR EQUIPO------");

		System.out.println("Dime el id del equipo cuya plantilla quieras borrar");
		int id_Plantilla_A_Borrar = Integer.parseInt(sc.nextLine());
		jd.borrarPorEquipo(id_Plantilla_A_Borrar);

		
	}

}
