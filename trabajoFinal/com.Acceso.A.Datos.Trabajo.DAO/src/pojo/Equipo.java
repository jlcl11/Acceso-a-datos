package pojo;

/**
 * POJO de equipo,representa a un equipo de la NBA
 * 
 * @author jcorr
 *
 */
public class Equipo {
	/*
	 * id del equipo en bbddd
	 */
	private int eq_id;
	/*
	 * Nombre del equipo
	 */
	private String nombre;
	/*
	 * Ciudad en la que juega el equipo(donde se sitúa el estadio vaya)
	 */
	private String ciudadLocal;
	/*
	 * Persona a cargo de los traspasos de jugadores y rondas de draft en el mercado
	 * de fichajes,básicamente maneja el proyecto deportivo de la franquicia
	 */
	private String generalManager;
	/*
	 * Dueño de la franquicia
	 */
	private String propietario;
	/*
	 * Conferencia en la que juega el equipo(puede ser este u oeste)
	 */
	private boolean conferencia;

	/*
	 * Constructor de equipo,a diferencia del presentado abajo,este presenta un id
	 * para poder posteriormente modificar un equipo previamente creado si se le
	 * hardcodea su id,esto porque el id se asigna de manera autoincremental en la
	 * bbdd a la hora de la inserción de nuevos registros
	 */
	public Equipo(int eq_id, String nombre, String ciudadLocal, String generalManager, String propietario,
			boolean conferencia) {
		super();
		this.eq_id = eq_id;
		this.nombre = nombre;
		this.ciudadLocal = ciudadLocal;
		this.generalManager = generalManager;
		this.propietario = propietario;
		this.conferencia = conferencia;
	}

	/*
	 * Constructor, esta vez sin id,de equipo.Es el más utilizado ya que no nos hace
	 * falta meter el id porque se incrementa automáticamente
	 */
	public Equipo(String nombre, String ciudadLocal, String generalManager, String propietario, boolean conferencia) {
		super();
		this.nombre = nombre;
		this.ciudadLocal = ciudadLocal;
		this.generalManager = generalManager;
		this.propietario = propietario;
		this.conferencia = conferencia;
	}

	/*
	 * Getter del id del equipo
	 */
	public int getEq_id() {
		return eq_id;
	}

	/*
	 * Getter del nombre del nombre
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
	 * Getter de la ciudad donde juega el equipo
	 */
	public String getCiudadLocal() {
		return ciudadLocal;
	}

	/*
	 * Setter de ciudadLocal
	 */
	public void setCiudadLocal(String ciudadLocal) {
		this.ciudadLocal = ciudadLocal;
	}

	/*
	 * Getter del GM
	 */
	public String getGeneralManager() {
		return generalManager;
	}

	/*
	 * Setter del GM
	 */
	public void setGeneralManager(String generalManager) {
		this.generalManager = generalManager;
	}

	/*
	 * Getter del propietario de la franquicia
	 */
	public String getPropietario() {
		return propietario;
	}

	/*
	 * Setter del propietario de la franquicia
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	/*
	 * Equivalente del getter de conferencia(como es boolean es con is)
	 */
	public boolean isConferencia() {
		return conferencia;
	}

	/*
	 * Equivalente del setter de conferencia(como es boolean es con is)
	 */
	public void setConferencia(boolean conferencia) {
		this.conferencia = conferencia;
	}

	/*
	 * Función que permite que al imprimir un equipo por consola,no se muestre un
	 * simple hash sino un texto en condiciones.En este caso, hace distinción entre
	 * si su conferencia es false o true para poder poner directamente como cadena
	 * de texto si juega en la conferencia este u oeste respectivamente
	 */
	@Override
	public String toString() {

		if (this.isConferencia() == true) {
			return "El equipo " + ciudadLocal + " " + nombre + " con id=" + eq_id
					+ " de la conferencia este ,pertenece a " + propietario + " y tiene como General Manager a "
					+ generalManager + "\n";
		} else {
			return "El equipo " + ciudadLocal + " " + nombre + " con id=" + eq_id
					+ " de la conferencia oeste ,pertenece a " + propietario + " y tiene como General Manager a "
					+ generalManager + "\n";
		}

	}

}
