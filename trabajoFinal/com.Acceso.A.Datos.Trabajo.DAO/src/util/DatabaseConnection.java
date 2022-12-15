package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que establece la conexión con la base de datos
 * 
 * @author jcorr
 *
 */
public class DatabaseConnection {

	/*
	 * Variable interna que al inicializar creará la conexión
	 */
	Connection connection;

	/*
	 * Método al que accederemos para abrir desde openConnection()
	 */
	public Connection getConnection() {
		String dbName = "trabajoaccesoAdatos";
		String userName = "root";
		String password = "Administrador_0";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}
}
