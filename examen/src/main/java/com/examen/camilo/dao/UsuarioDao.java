package com.examen.camilo.dao;

import java.util.List;

import com.examen.camilo.model.Usuario;




public interface UsuarioDao {
	
 void saveUsuario(Usuario usuario);
 
 void deleteUsuarioById(int idUsuario);
 
 void updateUsuario(Usuario usuario);
 
 List<Usuario> findAllUsuarios();
 
 Usuario findById(int idUsuario);
 
}
