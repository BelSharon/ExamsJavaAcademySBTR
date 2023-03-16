package com.curso.springdemo.dao;

import java.util.List;

import com.curso.springdemo.entity.Arbol;

public interface ArbolDAO {

	public List<Arbol> getArboles();

	public Arbol saveArbol(Arbol theCustomer);

	public Arbol getArbol(int theId);

	public void deleteArbol(int theId);
	
}
