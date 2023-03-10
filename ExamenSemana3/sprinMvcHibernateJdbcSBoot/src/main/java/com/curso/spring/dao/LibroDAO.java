package com.curso.spring.dao;

import java.util.List;

import com.curso.spring.entity.Libro;

public interface LibroDAO {

	public List<Libro> getLibros();

	public void saveLibro(Libro elLibro);

	public Libro getLibro(int theId);

	public void deleteLibro(int theId);
	
}
