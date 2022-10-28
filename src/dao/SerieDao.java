package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import util.DatabaseConnection;

public class SerieDao implements Dao<Serie> {

	Connection connection;

	@Override
	public void insertar(Serie t) {
		connection = DatabaseConnection.openConnection();
		String query = ("insert into series(titulo,edad,plataforma) values (?,?,?)");
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getTitulo());
			ps.setInt(2, t.getEdad());
			ps.setString(3, t.getPlataforma());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseConnection.closeConnection();

	}
	
	public SerieDao() {
		
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Serie> buscarTodos(Serie t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
