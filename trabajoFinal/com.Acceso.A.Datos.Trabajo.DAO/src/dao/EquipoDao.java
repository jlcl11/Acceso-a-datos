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

		String query = "INSERT INTO equipos(nombre,ciudadlocal,generalManager,propietario,conferencia) VALUES('"
				+ t.getNombre() + "','" + t.getCiudadLocal() + "','" + t.getGeneralManager() + "','"
				+ t.getPropietario() + "'," + t.isConferencia() + ");";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

//			ps.setString(1, t.getNombre());
//			ps.setString(2, t.getCiudadLocal());
//			ps.setString(3, t.getGeneralManager());
//			ps.setString(4, t.getPropietario());
//			ps.setBoolean(5, t.isConferencia());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Equipo t) {
		int eq_id = t.getEq_id();
		String nombre = t.getNombre();
		String ciudadLocal = t.getCiudadLocal();
		String gm = t.getGeneralManager();
		String propietario = t.getPropietario();
		boolean conferencia = t.isConferencia();

		connection = openConnection();

		String query = "UPDATE equipos SET nombre='?',ciudadLocal='?',generalManager='?',propietario='?',conferencia=? WHERE eq_id=?;";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, ciudadLocal);
			ps.setString(3, gm);
			ps.setString(4, propietario);
			ps.setBoolean(5, conferencia);
			ps.setInt(6, eq_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	@Override
	public void borrar(Equipo t) {

		int eq_id = t.getEq_id();
		// jugador

	}

}
