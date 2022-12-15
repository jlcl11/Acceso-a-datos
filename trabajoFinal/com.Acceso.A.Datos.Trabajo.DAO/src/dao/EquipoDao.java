package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Equipo;
import pojo.Jugador;

/**
 * DAO de equipo,contiene todos los métodos que usarán los métodos para utilizar
 * los registros de la tabla equipos en la bbdd.Hereda de la clase ObjetoDao
 * para poder contar con sus métodos openConnection() y closeConnection()
 * 
 * @author jcorr
 *
 */
public class EquipoDao extends ObjetoDao {
	/**
	 * Variable que usaremos para abrir conexiones
	 */
	private static Connection connection;

	/**
	 * Método que devuelve todos los equipos indiscriminadamente de la bbdd
	 * 
	 * @return todos todos los equipos de la bbdd
	 */
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

	/**
	 * Método que devuelve los jugadores que pertenecen a un equipo
	 * 
	 * @param id identificador del equipo cuya plantilla queremos imprimir por
	 *           pantalla
	 * @return ArrayList de los jugadores que pertenecen al equipo identificado por
	 *         el argumento que hemos pasado por parámetros
	 */
	public ArrayList<Jugador> seleccionarPlantilla(int id) {

		ArrayList plantilla = new ArrayList<>();

		int eq_id = 2;

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

	/**
	 * Método que devuelve un único equipo cuyo id usamos como elemento
	 * diferenciador a la hora de seleccionar el equipo indicado
	 * 
	 * @param id id del equipo a buscar
	 * @return equipo buscado
	 */
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

	/**
	 * Función que inserta el equipo pasado por parámetros en la bbdd
	 * 
	 * @param t equipo a insertar en la bbdd
	 */
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

	/**
	 * Método que modifica un registro ya existente de un jugador en la bbdd
	 * 
	 * @param t jugador que va a quedar reflejado en la bbdd,este deberá tener el
	 *          mismo id que el jugador que queremos modificar y los nuevos valores
	 *          de los campos que queramos modificar
	 */
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

	/**
	 * Método que borra un registro ya existente de un equipo en la bbdd
	 * 
	 * @param id identificador del equipo a borrar
	 */
	public void borrar(int id) {

		JugadorDao jd = new JugadorDao();
		jd.borrarPorEquipo(id);

		connection = openConnection();

		String query = "DELETE FROM equipos WHERE eq_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	/**
	 * Método que saca los equipos distinguidos por conferencia ,este método será
	 * útil mayoritariamente para el trabajo de Desarrollo de interfaces
	 * 
	 * @param conf valor true o false que nos ayudará a distinguir entre conferencia
	 *             este u oeste
	 * @return devuelve un ArrayList<Equipo> con todos los equipos de la conferencia
	 *         seleccionada
	 */
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
