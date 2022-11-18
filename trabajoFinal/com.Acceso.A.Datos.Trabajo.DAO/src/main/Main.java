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
		
		Jugador lbj=new Jugador(2,"jojo", "R", null, (byte) 0, 0, null, 3);
		JugadorDao jd=new JugadorDao();
		
		//jd.insertar(lbj);
		
		jd.borrar(lbj);;
	}

}
