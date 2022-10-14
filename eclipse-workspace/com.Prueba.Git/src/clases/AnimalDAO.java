package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.Database;

public abstract class AnimalDAO {

	private static Connection connection;

	public static void insertAnimal(Animal animal) throws ClassNotFoundException, SQLException {
		connection = openConnection();

		String query = "Insert into animales(nombre,habitat,peso_aprox) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, animal.getNombre());
		preparedStatement.setString(2, animal.getHabitat());
		preparedStatement.setDouble(2, animal.getPeso_aprox());
		
		preparedStatement.executeUpdate();
		
		closeConnection();
	}

	private static Connection openConnection() throws ClassNotFoundException, SQLException {
		Database dbConnection = new Database(connection);
		return connection = dbConnection.getConnection();
	}

	private static void closeConnection() throws SQLException {
		connection.close();
		connection = null;
	}

}
