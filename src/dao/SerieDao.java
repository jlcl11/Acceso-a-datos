package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DatabaseConnection;

public class SerieDao extends ObjetoDao implements Interfazdao<Serie> {

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

	public ArrayList<Temporada> obtenerTemporadas(Serie serie) {
		ArrayList<Temporada> temporadas = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM temporadas WHERE serie_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Temporada temporada = new Temporada(rs.getInt("id"), rs.getInt("num_temporada"), rs.getString("titulo"),
						serie);

				temporadas.add(temporada);
			}
			serie.setTemporadas(obtenerTemporadas(serie));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeConnection();

		return temporadas;

	}

	@Override
	public void modificar(Serie t) {

		int id = t.getId();
		String titulo = t.getTitulo();
		int edad = t.getEdad();
		String plataforma = t.getPlataforma();

		connection = openConnection();
		String query = "UPDATE series SET titulo=?,edad=?,plataforma=? WHERE id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.setInt(2, edad);
			ps.setString(3, plataforma);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void borrar(Serie t) {

		TemporadaDao temp = new TemporadaDao();
		temp.borrarPorSerie(t.getId());

		connection = openConnection();
		String query = "DELETE FROM series where id=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		ArrayList<Serie> series = new ArrayList<>();
		connection = openConnection();
		String query = "Select * from series";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Serie serie = new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getInt("edad"),
						rs.getString("plataforma"), null);
				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return series;
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
			serie.setTemporadas(obtenerTemporadas(serie));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return serie;
	}

}
