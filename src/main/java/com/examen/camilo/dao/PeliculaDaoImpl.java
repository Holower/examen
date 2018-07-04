package com.examen.camilo.dao;

import java.util.Iterator;
import java.util.List;

import com.examen.camilo.model.Pelicula;
import com.examen.camilo.model.Usuario;
import com.examen.camilo.model.Usuariopelicula;



public class PeliculaDaoImpl extends AbstractSession implements PeliculaDao {

	public void savePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		getSession().persist(pelicula);
	}

	public void deletePeliculaById(int idPelicula) {
		// TODO Auto-generated method stub
		Pelicula pelicula = findById(idPelicula);
		if (pelicula != null) {
			Iterator<Usuariopelicula> i = pelicula.getUsuariopeliculas().iterator();
			while (i.hasNext()) {
				Usuariopelicula usuariopelicula = i.next();
				i.remove();
				getSession().delete(usuariopelicula);
			}
			pelicula.getUsuariopeliculas().clear();
			getSession().delete(pelicula);
		}
	}

	public void updatePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		getSession().update(pelicula);
	}

	public List<Pelicula> findAllPeliculas() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Pelicula").list();
	}

	public Pelicula findById(int idPelicula) {
		// TODO Auto-generated method stub
		return (Pelicula) getSession().get(Pelicula.class, idPelicula);
	}

	public Pelicula findByName(String nombre) {
		// TODO Auto-generated method stub
		return (Pelicula) getSession().createQuery("from Pelicula where nombre = :nombre ").setParameter("pelicula", nombre)
				.uniqueResult();
	}

}
