package com.curso.springmvc.service;

import java.util.List;

import com.curso.springmvc.entity.Libro;

public interface LibroService {

	public List<Libro> getLibros();

	public void saveLibro(Libro elLibro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
