package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Jugador;

public class JugadorDao extends ObjetoDao implements InterfazDao<Jugador> {

	private static Connection connection;

	@Override
	public ArrayList<Jugador> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jugador buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Jugador t) {
		connection = openConnection();

		String query = "INSERT INTO jugadores(nombre,apellido,apodo,dorsal,salario,posicion,eq_id) VALUES(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, t.getNombre());
			ps.setString(2, t.getApellido());
			ps.setString(3, t.getApodo());
			ps.setByte(4, t.getDorsal());
			ps.setFloat(5, t.getSalario());
			ps.setString(6, t.getPosicion());
			ps.setInt(7, t.getEq_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void modificar(Jugador t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Jugador t) {
		// TODO Auto-generated method stub

	}

}
