package prZoologicoDAO;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		try {
			Animal a = new Animal("Ardilla", "Bosque", 0.1);
			Animal k = new Animal("Kakapoo", "Bosque", 7.6);
			AnimalDAO.insertAnimal(a);
			AnimalDAO.insertAnimal(k);
			AnimalDAO.deleteAnimales();
			AnimalDAO.deleteAnimal("Ardilla");
			Animal b;
			b = AnimalDAO.findById(11);
			System.out.println(b);
			System.out.println(AnimalDAO.findAllAnimals());
			Animal e = new Animal(1, "Paneque", "Agua", 4.6);
			AnimalDAO.updateAnimal(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
