package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao implements Dao<Temporada> {

	private Connection connection;

	public TemporadaDao() {
		
	}
	
	@Override
	public void insertar(Temporada t) {
		connection = DatabaseConnection.openConnection();
		String query = ("insert into temporadas(id,num_temporada,titulo,serie_id) values (?,?,?,?)");

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.setInt(2, t.getNum_temporadas());
			ps.setString(3, t.getTitulo());
			ps.setInt(4, t.getSerie().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DatabaseConnection.closeConnection();

	}

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Temporada> buscarTodos(Temporada t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {

		return null;
	}

}
