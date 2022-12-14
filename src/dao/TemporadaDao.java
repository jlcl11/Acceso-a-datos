package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.openmbean.OpenMBeanConstructorInfo;

import com.mysql.cj.x.protobuf.MysqlxCursor.Open;

import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao extends ObjetoDao implements Interfazdao<Temporada> {

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

		connection = openConnection();
		String query = "DELETE FROM temporadas where id=?;";
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
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {

		return null;
	}

	public void borrarPorSerie(int serie_id) {
		connection = openConnection();
		String query = "Delete from temporadas where serie_id=?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

}
