package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Equipo;

public class EquipoDao extends ObjetoDao implements InterfazDao<Equipo> {
	private static Connection connection;

	@Override
	public ArrayList<Equipo> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Equipo t) {

		connection = openConnection();

		String query = "INSERT INTO equipos(nombre,ciudadlocal,generalManager,propietario,conferencia) VALUES('?','?','?','?',?);";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getCiudadLocal());
			ps.setString(3, t.getGeneralManager());
			ps.setString(4, t.getPropietario());
			ps.setBoolean(5, t.isConferencia());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Equipo t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Equipo t) {
		// TODO Auto-generated method stub

	}

}
