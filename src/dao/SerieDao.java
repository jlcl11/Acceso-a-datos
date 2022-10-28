package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import util.DatabaseConnection;

public class SerieDao implements Dao<Serie> {

	static Connection connection;

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

	public Serie buscarPorId(int i) {
		connection = connection = DatabaseConnection.openConnection();

		String query = "select * from series where id = ?";
		Serie serie = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getInt("edad"),
						rs.getString("plataforma"), null);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseConnection.closeConnection();

		return serie;
	}

}
