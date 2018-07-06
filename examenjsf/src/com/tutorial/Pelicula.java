package com.tutorial;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pelicula database table.
 * 
 */
@Entity
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ano;

	private int duracionmin;

	private int genero;

	private String idioma;

	private String nombre;

	private String resumen;

	//bi-directional many-to-one association to Usuariopelicula
	@OneToMany(mappedBy="peliculaBean")
	private List<Usuariopelicula> usuariopeliculas;

	public Pelicula() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getDuracionmin() {
		return this.duracionmin;
	}

	public void setDuracionmin(int duracionmin) {
		this.duracionmin = duracionmin;
	}

	public int getGenero() {
		return this.genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResumen() {
		return this.resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public List<Usuariopelicula> getUsuariopeliculas() {
		return this.usuariopeliculas;
	}

	public void setUsuariopeliculas(List<Usuariopelicula> usuariopeliculas) {
		this.usuariopeliculas = usuariopeliculas;
	}

	public Usuariopelicula addUsuariopelicula(Usuariopelicula usuariopelicula) {
		getUsuariopeliculas().add(usuariopelicula);
		usuariopelicula.setPeliculaBean(this);

		return usuariopelicula;
	}

	public Usuariopelicula removeUsuariopelicula(Usuariopelicula usuariopelicula) {
		getUsuariopeliculas().remove(usuariopelicula);
		usuariopelicula.setPeliculaBean(null);

		return usuariopelicula;
	}

}