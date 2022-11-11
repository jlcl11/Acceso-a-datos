package pojo;

public class Jugador {
	private int jugador_id;
	private String nombre;
	private String apellido;
	private String apodo;
	private byte dorsal;
	private float salario;
	private String posicion;
	private byte nominacionesAllStar;
	private byte anillosCampeon;

	public Jugador(int jugador_id, String nombre, String apellido, String apodo, byte dorsal, float salario,
			String posicion, byte nominacionesAllStar, byte anillosCampeon) {
		super();
		this.jugador_id = jugador_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
		this.dorsal = dorsal;
		this.salario = salario;
		this.posicion = posicion;
		this.nominacionesAllStar = nominacionesAllStar;
		this.anillosCampeon = anillosCampeon;
	}

	public Jugador(String nombre, String apellido, String apodo, byte dorsal, float salario, String posicion,
			byte nominacionesAllStar, byte anillosCampeon) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
		this.dorsal = dorsal;
		this.salario = salario;
		this.posicion = posicion;
		this.nominacionesAllStar = nominacionesAllStar;
		this.anillosCampeon = anillosCampeon;
	}

	public int getJugador_id() {
		return jugador_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public byte getDorsal() {
		return dorsal;
	}

	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public byte getNominacionesAllStar() {
		return nominacionesAllStar;
	}

	public void setNominacionesAllStar(byte nominacionesAllStar) {
		this.nominacionesAllStar = nominacionesAllStar;
	}

	public byte getAnillosCampeon() {
		return anillosCampeon;
	}

	public void setAnillosCampeon(byte anillosCampeon) {
		this.anillosCampeon = anillosCampeon;
	}

	@Override
	public String toString() {

		if (anillosCampeon > 0) {
			return "El jugador " + nombre + "'" + apodo + "'" + apellido + " juega con el dorsal " + dorsal
					+ " en la posición de " + posicion + ", cobra " + salario + " millones de dólares,ha conseguido "
					+ nominacionesAllStar + " nominaciones al All Star y ha conseguido " + anillosCampeon
					+ " anillos de campeón";
		} else {
			return "El jugador " + nombre + "'" + apodo + "'" + apellido + " juega con el dorsal " + dorsal
					+ " en la posición de " + posicion + ", cobra " + salario + " millones de dólares,ha conseguido "
					+ nominacionesAllStar
					+ " nominaciones al All Star y ha conseguido,pero no ha conseguido el anillo de campeón";
		}

	}

}
