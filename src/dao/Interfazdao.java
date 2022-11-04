package dao;

import java.util.ArrayList;

public interface Interfazdao<T> {
	/**
	 * Inserta el objeto recibido en la bbdd
	 * 
	 * @param t
	 */
	public void insertar(T t);

	/**
	 * Actualiza el objeto T de la bbdd
	 * 
	 * @param t el objeto de la bbdd
	 */
	public void modificar(T t);

	/**
	 * Elimina el objetp T de la bbdd
	 * @param t un objeto T
	 */
	public void borrar(T t);

	/**
	 * Muestra todos los objetos T de la base de datos
	 * 
	 * @param t
	 * @return un ArrayList<T> de objetos
	 */
	public ArrayList<T> buscarTodos();

	/**
	 * Muestra el objeto T de la bbdd con el id especificado
	 * 
	 * @param i el id del objeto T
	 * @return un objeto T
	 */
	public T buscarPorId(int i);
}
