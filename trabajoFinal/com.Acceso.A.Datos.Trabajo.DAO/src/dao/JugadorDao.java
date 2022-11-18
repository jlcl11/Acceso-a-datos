package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Equipo;
import pojo.Jugador;

public class JugadorDao extends ObjetoDao implements InterfazDao<Jugador> {

	private static Connection connection;

	@Override
	public ArrayList<Jugador> buscarTodos() {

		ArrayList todosLosJugadores = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM jugadores";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Jugador aux = new Jugador(rs.getString("nombre"), rs.getString("apellido"), rs.getString("apodo"),
						(byte) rs.getByte("dorsal"), rs.getFloat("salario"), rs.getString("posicion"),
						rs.getInt("eq_id"));
				todosLosJugadores.add(aux);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return todosLosJugadores;
	}

	@Override
	public Jugador buscarPorId(int i) {
		Jugador aux = null;

		connection = openConnection();

		String query = "SELECT * FROM jugadores WHERE jugador_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				aux = new Jugador(rs.getString("nombre"), rs.getString("apellido"), rs.getString("apodo"),
						(byte) rs.getByte("dorsal"), rs.getFloat("salario"), rs.getString("posicion"),
						rs.getInt("eq_id"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return aux;
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

		connection = openConnection();
		String query = "UPDATE jugadores SET nombre=?,apellido=?,apodo=?,dorsal=?,salario=?,posicion=?,eq_id=? WHERE jugador_id=?";

		String nombre = t.getNombre();
		String apellido = t.getApellido();
		String apodo = t.getApodo();
		byte dorsal = t.getDorsal();
		float salario = t.getSalario();
		String posicion = t.getPosicion();
		int eq_id = t.getEq_id();
		int jugador_id = t.getJugador_id();

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, apodo);
			ps.setByte(4, dorsal);
			ps.setFloat(5, salario);
			ps.setString(6, posicion);
			ps.setInt(7, eq_id);
			ps.setInt(8, jugador_id);
			;
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	@Override
	public void borrar(Jugador t) {
		// TODO Auto-generated method stub

	}

}
