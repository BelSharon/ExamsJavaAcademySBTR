package com.luv2code.web.jdbc;

public class Student {

	private int id;
	private String nombre;
	private String apellido;
	private String casa;
	
	

	public Student(String nombre, String apellido, String casa) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.casa = casa;
	}

	public Student(int id, String nombre, String apellido, String casa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.casa = casa;
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

		
}
