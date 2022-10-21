package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AnimalDAO {

	private static Connection connection;

	public static void updateAnimal(Animal animal) throws SQLException {

		connection = openConnection();
		String query = "update animales set nombre='" + animal.getNombre() + "',peso_aproximado="
				+ animal.getPeso_aproximado() + ",habitat='" + animal.getHabitat() + "' where id=" + animal.getId()
				+ ";";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		closeConnection();
	}

	public static ArrayList<Animal> findAllAnimals() throws SQLException {

		connection = openConnection();
		ArrayList<Animal> aR = new ArrayList<Animal>();
		String query = "select * from animales";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		Animal animal = null;
		while (rs.next()) {
			animal = new Animal(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"),
					rs.getDouble("peso_aproximado"));
			aR.add(animal);
		}

		closeConnection();

		return aR;

	}

	// buscar un animal por id
	public static Animal findById(int id) {
		connection = openConnection();

		String query = "select * from animales where id = ?";
		Animal animal = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				animal = new Animal(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"),
						rs.getDouble("peso_aproximado"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return animal;
	}

	public static void deleteAnimal(String nombre) throws SQLException {
		connection = openConnection();
		String query = "delete from animales where nombre=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, nombre);
		preparedStatement.executeUpdate();
		closeConnection();
	}

	public static void deleteAnimales() throws SQLException {

		connection = openConnection();

		String query = "delete from animales";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.executeUpdate(query);
		closeConnection();

	}

	public static void insertAnimal(Animal animal) {
		connection = openConnection();

		String query = "insert into animales (nombre, habitat, " + "peso_aproximado) values (?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setDouble(3, animal.getPeso_aproximado());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}

	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
