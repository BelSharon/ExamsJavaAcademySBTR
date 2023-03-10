package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Libro;

public interface LibroService {

	public List<Libro> getLibros();

	public void saveLibro(Libro elLibro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
