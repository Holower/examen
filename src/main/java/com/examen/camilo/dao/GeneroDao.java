package com.examen.camilo.dao;

import java.util.List;

import com.examen.camilo.model.Genero;





public interface GeneroDao {
	
 void saveGenero(Genero genero);
 
 void deleteGeneroById(int idGenero);
 
 void updateGenero(Genero genero);
 
 List<Genero> findAllGeneros();
 
 Genero findById(int idGenero);
 
}
