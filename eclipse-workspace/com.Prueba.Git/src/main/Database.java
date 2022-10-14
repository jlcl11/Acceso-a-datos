package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	Connection connection;

	public Database(Connection connection) throws ClassNotFoundException, SQLException {
		super();
		
		String dbName="zoo";
		String user="root";
		String pswd="admin";
		
		Class.forName("com.cj.jdbc.Driver");
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,user,pswd);
		
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	
}
