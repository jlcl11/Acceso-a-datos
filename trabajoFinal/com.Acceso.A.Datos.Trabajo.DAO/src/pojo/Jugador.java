package pojo;

public class Jugador {
	private int jugador_id;
	private String nombre;
	private String apellido;
	private String apodo;
	private byte dorsal;
	private float salario;
	private String posicion;
	private int eq_id;

	public Jugador(int jugador_id, String nombre, String apellido, String apodo, byte dorsal, float salario,
			String posicion, int eq_id) {
		super();
		this.jugador_id = jugador_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
		this.dorsal = dorsal;
		this.salario = salario;
		this.posicion = posicion;
		this.eq_id = eq_id;
	}

	public Jugador(String nombre, String apellido, String apodo, byte dorsal, float salario, String posicion,
			int eq_id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
		this.dorsal = dorsal;
		this.salario = salario;
		this.posicion = posicion;
		this.eq_id = eq_id;
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

	public int getEq_id() {
		return eq_id;
	}

	public void setEq_id(int eq_id) {
		this.eq_id = eq_id;
	}

	@Override
	public String toString() {

		return "El jugador " + nombre + "'" + apodo + "'" + apellido + " juega con el dorsal " + dorsal
				+ " en la posición de " + posicion + ", y cobra " + salario + " millones de dólares";

	}

}
