package main;

import dao.SerieDao;
import pojo.Serie;

public class Main {

	public static void main(String[] args) {
		
		Serie d=new Serie("The mandalorian",2,"Amazon Prime");
		
		SerieDao serieDao=new SerieDao();
		
		serieDao.insertar(d);
	}

}
