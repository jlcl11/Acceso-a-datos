package main;

import java.sql.SQLException;

import clases.Animal;
import clases.AnimalDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Animal a=new Animal("Ardilla","Bosque",0.1);
			
			try {
				AnimalDAO.insertAnimal(a);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
