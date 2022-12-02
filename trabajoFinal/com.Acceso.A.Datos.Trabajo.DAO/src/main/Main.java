package main;

import dao.EquipoDao;
import dao.JugadorDao;
import pojo.Equipo;
import pojo.Jugador;

public class Main {

	public static void main(String[] args) {
	
		EquipoDao ed=new EquipoDao();
		Equipo lakers= new Equipo("Clippers", "Un random", "Rob Pelinka", "Steve Balmer", false);
		
		//System.out.println(ed.buscarPorId(3));
		//ed.insertar(lakers);
		//ed.modificar(lakers);
		
		Jugador prueba = new Jugador("Kevin", "Durant", "Slim Reaper", (byte) 7, 42, "ALERO", 2);
		JugadorDao jd=new JugadorDao();
		
		//jd.insertar(lbj);
		
		jd.insertar(prueba);
	}

}
