package com.examen.camilo.dao;

import java.util.Iterator;
import java.util.List;

import com.examen.camilo.model.Usuario;
import com.examen.camilo.model.Usuariopelicula;



public class UsuarioDaoImpl extends AbstractSession implements UsuarioDao {

	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		getSession().persist(usuario);
	}

	public void deleteUsuarioById(int idUsuario) {
		// TODO Auto-generated method stub
		Usuario usuario = findById(idUsuario);
		if (usuario != null) {
			Iterator<Usuariopelicula> i = usuario.getUsuariopeliculas().iterator();
			while (i.hasNext()) {
				Usuariopelicula usuariopelicula = i.next();
				i.remove();
				getSession().delete(usuariopelicula);
			}
			usuario.getUsuariopeliculas().clear();
			getSession().delete(usuario);
		}
	}

	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		getSession().update(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Usuario").list();
	}

	public Usuario findById(int idUsuario) {
		// TODO Auto-generated method stub
		return (Usuario) getSession().get(Usuario.class, idUsuario);
	}


}
