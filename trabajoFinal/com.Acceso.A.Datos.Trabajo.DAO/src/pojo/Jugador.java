package pojo;

/**
 * POJO de jugador,representa un jugador de la NBA
 * 
 * @author jcorr
 *
 */
public class Jugador {
	/*
	 * id del jugador en bbdd
	 */
	private int jugador_id;
	/*
	 * Nombre del jugador
	 */
	private String nombre;
	/*
	 * Apellido del jugador
	 */
	private String apellido;
	/*
	 * Apodo del jugador
	 */
	private String apodo;
	/*
	 * Número que representa al jugador en la camiseta
	 */
	private byte dorsal;
	/*
	 * Dinero que cobra de manera anual el jugador(en millones de dólares)
	 */
	private float salario;
	/*
	 * Posición en la que juega el jugador en
	 * cancha(BASE,ESCOLTA,ALERO,ALAPIVOT,PIVOT)
	 */
	private String posicion;
	/*
	 * id del equipo en el que juega(actúa de clave foránea)
	 */
	private int eq_id;

	/*
	 * Constructor de jugador,a diferencia del presentado abajo,este presenta un id
	 * para poder posteriormente modificar un jugador previamente creado si se le
	 * hardcodea su id,esto porque el id se asigna de manera autoincremental en la
	 * bbdd a la hora de la inserción de nuevos registros
	 */
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

	/*
	 * Constructor, esta vez sin id,de jugador.Es el más utilizado ya que no nos
	 * hace falta meter el id porque se incrementa automáticamente
	 */
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

	/*
	 * Getter del id del jugador
	 */
	public int getJugador_id() {
		return jugador_id;
	}

	/*
	 * Getter del nombre del jugador
	 */
	public String getNombre() {
		return nombre;
	}

	/*
	 * Setter del nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * Getter del apellido del jugador
	 */
	public String getApellido() {
		return apellido;
	}

	/*
	 * Setter del apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/*
	 * Getter del apodo del jugador
	 */
	public String getApodo() {
		return apodo;
	}

	/*
	 * Setter del apodo
	 */
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	/*
	 * Getter del dorsal del jugador
	 */
	public byte getDorsal() {
		return dorsal;
	}

	/*
	 * Setter del dorsal
	 */
	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}

	/*
	 * Getter del salario del jugador
	 */
	public float getSalario() {
		return salario;
	}

	/*
	 * Setter del salario
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}

	/*
	 * Getter de la posicion del jugador
	 */
	public String getPosicion() {
		return posicion;
	}

	/*
	 * Setter del posicion
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	/*
	 * Getter del id del equipo para el que juega el jugador actual
	 */
	public int getEq_id() {
		return eq_id;
	}

	/*
	 * Setter del id del equipo para el que juega el jugador actual
	 */
	public void setEq_id(int eq_id) {
		this.eq_id = eq_id;
	}

	/*
	 * Función que permite que al imprimir un jugador por consola,no se muestre un
	 * simple hash sino un texto en condiciones
	 */
	@Override
	public String toString() {

		return "El jugador " + nombre + " '" + apodo + "' " + apellido + " juega con el dorsal " + dorsal
				+ " en la posición de " + posicion + ", y cobra " + salario + " millones de dólares \n";

	}

}
