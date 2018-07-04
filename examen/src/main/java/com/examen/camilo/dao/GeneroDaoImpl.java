package com.examen.camilo.dao;

import java.util.Iterator;
import java.util.List;

import com.examen.camilo.model.Genero;
import com.examen.camilo.model.Pelicula;




public class GeneroDaoImpl extends AbstractSession implements GeneroDao {

	public void saveGenero(Genero genero) {
		// TODO Auto-generated method stub
		getSession().persist(genero);
	}

	public void deleteGeneroById(int idGenero) {
		// TODO Auto-generated method stub
		Genero genero = findById(idGenero);
		if (genero != null) {
			Iterator<Pelicula> i = genero.getPeliculas().iterator();
			while (i.hasNext()) {
				Pelicula pelicula = i.next();
				i.remove();
				getSession().delete(pelicula);
			}
			genero.getPeliculas().clear();
			getSession().delete(genero);
		}
	}

	public void updateGenero(Genero genero) {
		// TODO Auto-generated method stub
		getSession().update(genero);
	}

	@SuppressWarnings("unchecked")
	public List<Genero> findAllGeneros() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Genero").list();
	}

	public Genero findById(int idGenero) {
		// TODO Auto-generated method stub
		return (Genero) getSession().get(Genero.class, idGenero);
	}

}
