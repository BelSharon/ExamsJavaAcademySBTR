package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
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
	
	//IMPLEMENTANDO LOMBOK PODEMOS AHORRANOS CÓDIGO EN GETTERS Y SETTERS


}





