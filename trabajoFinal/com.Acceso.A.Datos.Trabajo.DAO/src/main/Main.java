package main;

import dao.EquipoDao;
import pojo.Equipo;

public class Main {

	public static void main(String[] args) {
	
		EquipoDao ed=new EquipoDao();
		Equipo lakers= new Equipo("Clippers", "Un random", "Rob Pelinka", "Steve Balmer", false);
		
		System.out.println(ed.buscarTodos());
		//ed.insertar(lakers);
		//ed.modificar(lakers);
	}

}
