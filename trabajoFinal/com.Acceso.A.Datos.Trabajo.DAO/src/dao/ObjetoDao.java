package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DatabaseConnection;

public class ObjetoDao {
	private static Connection connection;

	protected static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}

	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrarTablas() {
		connection = openConnection();
		String query = "DROP TABLE jugadores;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query2 = "DROP TABLE equipos;";
		try {
			PreparedStatement ps = connection.prepareStatement(query2);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	public void crearTablas() {
		connection = openConnection();
		String query = "CREATE TABLE equipos (\r\n" + "eq_id int PRIMARY KEY auto_increment,\r\n"
				+ "nombre VARCHAR(30),\r\n" + "ciudadlocal VARCHAR(200),\r\n" + "generalManager VARCHAR(200),\r\n"
				+ "propietario VARCHAR(200),\r\n" + "conferencia boolean\r\n" + ");";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query2 = "CREATE TABLE jugadores(\r\n"
				+ "jugador_id int PRIMARY KEY auto_increment,\r\n"
				+ "nombre varchar(20),\r\n"
				+ "apellido varchar(20),\r\n"
				+ "apodo varchar(20),\r\n"
				+ "dorsal numeric(2),\r\n"
				+ "CONSTRAINT dorsalValido CHECK (dorsal between 0 AND 99),\r\n"
				+ "salario numeric(4,2),\r\n"
				+ "posicion ENUM('BASE','ESCOLTA','ALERO','ALAPIVOT','PIVOT'),\r\n"
				+ "eq_id int ,\r\n"
				+ "CONSTRAINT FK_equipo FOREIGN KEY (eq_id) REFERENCES equipos(eq_id)\r\n"
				+ ");";
		try {
			PreparedStatement ps = connection.prepareStatement(query2);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

}
