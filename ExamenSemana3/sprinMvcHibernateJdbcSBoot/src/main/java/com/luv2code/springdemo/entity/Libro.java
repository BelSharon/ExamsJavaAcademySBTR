package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="titulo")//se cambia al nombre en la BD
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="editorial")
	private String editorial;
	
	//nueva columna
	@Column(name="disponible")
	private boolean disponible;
	
	public Libro() {
		}//constructor vacío

	public Libro(int id, String titulo, String autor, String editorial, boolean disponible) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.disponible = disponible;
	}

	public Libro(String titulo, String autor, String editorial, boolean disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.disponible = disponible;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	//is y set de nueva columna
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	//nuevo toString
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", disponible=" + disponible + "]";
	}

}





