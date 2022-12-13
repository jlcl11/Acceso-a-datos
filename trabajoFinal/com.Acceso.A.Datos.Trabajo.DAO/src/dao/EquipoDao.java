package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Equipo;
import pojo.Jugador;

public class EquipoDao extends ObjetoDao {
	private static Connection connection;

	public ArrayList<Jugador> buscarPlantilla(Equipo eq) {
		ArrayList<Jugador> todosLosJugadores = new ArrayList<>();

		connection = openConnection();

		int eq_id = eq.getEq_id();
		System.out.println(eq_id);
		String query = "SELECT * FROM jugadores where eq_id=" + eq_id + ";";

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

	public ArrayList<Equipo> buscarTodos() {

		ArrayList<Equipo> todos = new ArrayList<>();
		connection = openConnection();

		String query = "SELECT * FROM equipos";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Equipo actual = new Equipo(rs.getInt("eq_id"), rs.getString("nombre"), rs.getString("ciudadLocal"),
						rs.getString("generalManager"), rs.getString("propietario"), rs.getBoolean("conferencia"));
				todos.add(actual);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return todos;
	}

	public ArrayList<Jugador> seleccionarPlantilla(Equipo t) {

		ArrayList plantilla = new ArrayList<>();

		int eq_id = t.getEq_id();

		connection = openConnection();

		String query = "SELECT * FROM jugadores where eq_id=?;";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eq_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Jugador aux = new Jugador(rs.getString("nombre"), rs.getString("apellido"), rs.getString("apodo"),
						(byte) rs.getByte("dorsal"), rs.getFloat("salario"), rs.getString("posicion"),
						rs.getInt("eq_id"));
				plantilla.add(aux);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return plantilla;
	}

	public Equipo buscarPorId(int id) {
		// TODO Auto-generated method stub
		connection = openConnection();

		Equipo equipoBuscado = null;

		String query = "select * from equipos where eq_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				equipoBuscado = new Equipo(rs.getInt("eq_id"), rs.getString("nombre"), rs.getString("ciudadLocal"),
						rs.getString("generalManager"), rs.getString("propietario"), rs.getBoolean("conferencia"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return equipoBuscado;
	}

	public void insertar(Equipo t) {

		connection = openConnection();
		String query = "INSERT INTO equipos(nombre,ciudadlocal,generalManager,propietario,conferencia) values(?,?,?,?,?)";

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

	public void modificar(Equipo t) {
		int eq_id = t.getEq_id();
		String nombre = t.getNombre();
		String ciudadLocal = t.getCiudadLocal();
		String gm = t.getGeneralManager();
		String propietario = t.getPropietario();
		boolean conferencia = t.isConferencia();

		connection = openConnection();

		String query = "UPDATE equipos SET nombre=?,ciudadLocal=?,generalManager=?,propietario=?,conferencia=? WHERE eq_id=?;";

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

	public void borrar(Equipo t) {

		int eq_id = t.getEq_id();

		JugadorDao jd = new JugadorDao();
		jd.borrarPorEquipo(eq_id);

		connection = openConnection();

		String query = "DELETE FROM equipos WHERE eq_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eq_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	public ArrayList<Equipo> buscarPorConferencia(boolean conf) {

		ArrayList<Equipo> todos = new ArrayList<>();
		connection = openConnection();

		String query = "SELECT * FROM equipos where conferencia=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setBoolean(1, conf);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Equipo actual = new Equipo(rs.getInt("eq_id"), rs.getString("nombre"), rs.getString("ciudadLocal"),
						rs.getString("generalManager"), rs.getString("propietario"), rs.getBoolean("conferencia"));
				todos.add(actual);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return todos;
	}

}
