package com.examen.camilo.dao;

import java.util.List;

import com.examen.camilo.model.Pelicula;





public interface PeliculaDao {
	
 void savePelicula(Pelicula pelicula);
 
 void deletePeliculaById(int idPelicula);
 
 void updatePelicula(Pelicula pelicula);
 
 List<Pelicula> findAllPeliculas();
 
 Pelicula findById(int idPelicula);
 
}
