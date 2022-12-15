package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Equipo;
import pojo.Jugador;

/**
 * DAO de jugador,contiene todos los métodos que usarán los métodos para
 * utilizar los registros de la tabla jugadores en la bbdd.Hereda de la clase
 * ObjetoDao para poder contar con sus métodos openConnection() y
 * closeConnection()
 * 
 * @author jcorr
 *
 */
public class JugadorDao extends ObjetoDao {

	/**
	 * Variable que usaremos para abrir conexiones
	 */
	private static Connection connection;

	/**
	 * Método que devuelve todos los jugadores indiscriminadamente de la bbdd
	 * 
	 * @return todosLosJugadores todos los jugadores de la bbdd
	 */
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

	/**
	 * Método que devuelve un único jugador cuyo id usamos como elemento
	 * diferenciador a la hora de seleccionar el jugador indicado
	 * 
	 * @param id id del jugador a buscar
	 * @return jugador buscado
	 */
	public Jugador buscarPorId(int id) {
		Jugador aux = null;

		connection = openConnection();

		String query = "SELECT * FROM jugadores WHERE jugador_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
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

	/**
	 * Función que inserta el jugador pasado por parámetros en la bbdd
	 * 
	 * @param t jugador a insertar en la bbdd
	 */
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

	/**
	 * Método que modifica un registro ya existente de un jugador en la bbdd
	 * 
	 * @param t jugador que va a quedar reflejado en la bbdd,este deberá tener el
	 *          mismo id que el jugador que queremos modificar y los nuevos valores
	 *          de los campos que queramos modificar
	 */
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
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	/**
	 * Método que borra un registro ya existente de un jugador en la bbdd
	 * 
	 * @param id identificador del jugador a borrar
	 */
	public void borrar(int id) {

		connection = openConnection();
		// int jugador_id = t.getJugador_id();
		String query = "DELETE  FROM jugadores WHERE jugador_id=?";

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
	 * Método que borra todos los jugadores de un equipo.Este método se puede usar
	 * por si queremos borrar un equipo y por deferencia también sus jugadores para
	 * cumplir las restricciones de la clave foránea,o bien si queremos "limpiar" la
	 * plantilla de un equipo sin necesariamente tener que borrar el equipo en sí
	 * 
	 * @param eq_id id del equipo cuyos jugadores vamos a borrar.
	 */
	public void borrarPorEquipo(int eq_id) {
		connection = openConnection();

		String query = "DELETE  FROM jugadores WHERE eq_id=?";

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

}
