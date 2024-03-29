package com.curso.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="arboles_viveros")
public class Arbol {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre_comun")
	private String nombreComun;
	
	@Column(name="nombre_cientifico")
	private String nombreCientifico;
	
	@Column(name="familia")
	private String familia;
	
	@Column(name="estatus_nom")
	private String estatus;
	
	
	//CON LOMBOK SE GENERAN SETTERS, GETTERS Y CONSTRUCTORES
	
}





