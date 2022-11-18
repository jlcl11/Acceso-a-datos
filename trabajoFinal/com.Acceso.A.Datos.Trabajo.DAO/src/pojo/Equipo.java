package pojo;

public class Equipo {
	private int eq_id;
	private String nombre;
	private String ciudadLocal;
	private String generalManager;
	private String propietario;
	private boolean conferencia;

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

	public Equipo(String nombre, String ciudadLocal, String generalManager, String propietario, boolean conferencia) {
		super();
		this.nombre = nombre;
		this.ciudadLocal = ciudadLocal;
		this.generalManager = generalManager;
		this.propietario = propietario;
		this.conferencia = conferencia;
	}

	public int getEq_id() {
		return eq_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudadLocal() {
		return ciudadLocal;
	}

	public void setCiudadLocal(String ciudadLocal) {
		this.ciudadLocal = ciudadLocal;
	}

	public String getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(String generalManager) {
		this.generalManager = generalManager;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public boolean isConferencia() {
		return conferencia;
	}

	public void setConferencia(boolean conferencia) {
		this.conferencia = conferencia;
	}

	@Override
	public String toString() {

		if (conferencia = false) {
			return "El equipo" + ciudadLocal + " " + nombre + ",con id=" + eq_id
					+ " de la conferencia este ,pertenece a " + propietario + " y tiene como General Manager a "
					+ generalManager+"\n";
		} else {
			return "El equipo" + ciudadLocal + " " + nombre + ",con id=" + eq_id
					+ " de la conferencia oeste ,pertenece a " + propietario + " y tiene como General Manager a "
					+ generalManager+"\n";
		}

	}

}
