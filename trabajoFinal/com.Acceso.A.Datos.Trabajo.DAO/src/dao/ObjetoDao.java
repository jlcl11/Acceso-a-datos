package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DatabaseConnection;

/**
 * Clase de la que posteriormente heredarán los dao para que puedan abrir y
 * cerrar conexiones en sus diferentes métodos,además,crea y borra las tablas
 * necesarias para que se reestablezcan los id auoincrementales
 * 
 * @author jcorr
 *
 */
public class ObjetoDao {
	/*
	 * variable que usaremos para crear y cerrar conexiones
	 */
	private static Connection connection;

	/*
	 * Método que usamos para abrir conexiones con la bbdd
	 */
	protected static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}

	/**
	 * Método que usamos para cerrar conexiones con la bbdd
	 */
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que usaremos al final del main para borrar las tablas
	 */
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

	/*
	 * Método que usaré al principio del main para crear las tablas que usaremos en
	 * el programa
	 */
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

		String query2 = "CREATE TABLE jugadores(\r\n" + "jugador_id int PRIMARY KEY auto_increment,\r\n"
				+ "nombre varchar(20),\r\n" + "apellido varchar(20),\r\n" + "apodo varchar(20),\r\n"
				+ "dorsal numeric(2),\r\n" + "CONSTRAINT dorsalValido CHECK (dorsal between 0 AND 99),\r\n"
				+ "salario numeric(4,2),\r\n" + "posicion ENUM('BASE','ESCOLTA','ALERO','ALAPIVOT','PIVOT'),\r\n"
				+ "eq_id int ,\r\n" + "CONSTRAINT FK_equipo FOREIGN KEY (eq_id) REFERENCES equipos(eq_id)\r\n" + ");";
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
