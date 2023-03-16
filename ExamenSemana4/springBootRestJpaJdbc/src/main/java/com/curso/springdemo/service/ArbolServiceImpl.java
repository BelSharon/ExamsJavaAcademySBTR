package com.curso.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.springdemo.dao.ArbolDAOJdbc;
import com.curso.springdemo.dao.ArbolDAOJpa;
import com.curso.springdemo.entity.Arbol;

@Service
public class ArbolServiceImpl implements ArbolService {

	@Autowired
	private ArbolDAOJpa arbolDAO; //JPA
	//private ArbolDAOJdbc arbolDAO; //JDBC
	
	@Override
	@Transactional
	public List<Arbol> getArboles() {
		return arbolDAO.getArboles();
	}

	@Override
	@Transactional
	public Arbol saveArbol(Arbol elArbol) {
		Arbol arbol = arbolDAO.saveArbol(elArbol);
		return arbol;
	}

	@Override
	@Transactional
	public Arbol getArbol(int theId) {
		
		return arbolDAO.getArbol(theId);
	}

	@Override
	@Transactional
	public void deleteArbol(int theId) {
		
		arbolDAO.deleteArbol(theId);
	}
}





