package com.curso.springdemo.service;

import java.util.List;

import com.curso.springdemo.entity.Arbol;

public interface ArbolService {

	public List<Arbol> getArboles();

	public Arbol saveArbol(Arbol theCustomer);

	public Arbol getArbol(int theId);

	public void deleteArbol(int theId);
	
}
