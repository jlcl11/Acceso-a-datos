package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		/*
		 * Serie d = new Serie("The mandalorian", 12, "Amazon Prime");
		 * 
		 * SerieDao serieDao = new SerieDao();
		 * 
		 * serieDao.insertar(d);
		 * 
		 * 
		 * 
		 * TemporadaDao temporadaDao = new TemporadaDao();
		 * 
		 * 
		 * 
		 * //temporadaDao.insertar(seasonada);
		 * 
		 * Serie serie =serieDao.buscarPorId(1); System.out.println(serie);
		 * 
		 * SerieDao serieDao = new SerieDao(); Serie serie=serieDao.buscarPorId(1);
		 * serieDao.modificar(serie);
		 */

		SerieDao serieDao = new SerieDao();

		Serie losSimpson = serieDao.buscarPorId(1);
		/*
		 * losSimpson.setPlataforma("Netflix"); serieDao.modificar(losSimpson);
		 * 
		 * 
		 * ArrayList<Serie> series=serieDao.buscarTodos();
		 * 
		 * for(Serie serie:series) { System.out.println(serie); }
		 */

		/*
		 * ArrayList<Temporada> temporadas=serieDao.obtenerTemporadas(losSimpson);
		 * for(Temporada temporada:temporadas) { System.out.println(temporada); }
		 */
		Serie seriote = serieDao.buscarPorId(1);
		Temporada seasonada = new Temporada(1, "Temporada 1", seriote);
		TemporadaDao t = new TemporadaDao();
		t.borrar(seasonada);
		serieDao.borrar(seriote);
	}

}
