package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.LibroDAO;
import com.luv2code.springdemo.entity.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	// need to inject customer dao
	@Autowired
	@Qualifier("libroDAOJdbc")
	private LibroDAO libroDAO;
	
	@Override
	@Transactional
	public List<Libro> getLibros() {
		return libroDAO.getLibros();
	}

	@Override
	@Transactional
	public void saveLibro(Libro elLibro) {

		libroDAO.saveLibro(elLibro);
	}

	@Override
	@Transactional
	public Libro getLibro(int theId) {
		
		return libroDAO.getLibro(theId);
	}

	@Override
	@Transactional
	public void deleteLibro(int theId) {
		
		libroDAO.deleteLibro(theId);
	}
}





