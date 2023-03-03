package com.exam.jdbc;

public class Estudiante {

	private int id;
	private String nombre;
	private String apellido;
	private String casa;
	private String mascota;
	

	public Estudiante(String nombre, String apellido, String casa, String mascota) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.casa = casa;
		this.mascota = mascota;
	}

	public Estudiante(int id, String nombre, String apellido, String casa, String mascota) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.casa = casa;
		this.mascota = mascota;
	}
	
	public Estudiante(int id, String nombre, String apellido, String mascota) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mascota = mascota;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getMascota() {
		return mascota;
	}

	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	
	

		
}
