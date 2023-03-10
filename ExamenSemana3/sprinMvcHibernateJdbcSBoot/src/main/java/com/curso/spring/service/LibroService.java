package com.curso.spring.service;

import java.util.List;

import com.curso.spring.entity.Libro;

public interface LibroService {

	public List<Libro> getLibros();

	public void saveLibro(Libro elLibro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
