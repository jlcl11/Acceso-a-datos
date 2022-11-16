package main;

import dao.EquipoDao;
import pojo.Equipo;

public class Main {

	public static void main(String[] args) {
	
		EquipoDao ed=new EquipoDao();
		Equipo lakers= new Equipo("Lakers", "Los Ángeles", "Rob Pelinka", "Jeanie Buss", false);
		
		
		ed.insertar(lakers);
		ed.modificar(lakers);
	}

}
