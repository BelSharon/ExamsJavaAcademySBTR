package com.curso.clientrest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	private Double saldoPrestamo;
	
}





