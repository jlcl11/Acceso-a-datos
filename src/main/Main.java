package main;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		Serie d = new Serie("The mandalorian", 12, "Amazon Prime");

		SerieDao serieDao = new SerieDao();

		// serieDao.insertar(d);

		Serie seriote = serieDao.buscarPorId(1);

		TemporadaDao temporadaDao = new TemporadaDao();

		Temporada seasonada = new Temporada(1, "Temporada 1", seriote);

		temporadaDao.insertar(seasonada);

	}

}
