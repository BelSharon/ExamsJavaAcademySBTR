package com.curso.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.springdemo.entity.Arbol;

@Repository
public class ArbolDAOJpa implements ArbolDAO {
	
    //INTERFAZ PARA INTERACCION CON PERSIST
    private EntityManager entityManager;
    
    // INYECTAMOS POR CONSTRUCTOR
    @Autowired
    public ArbolDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Arbol> getArboles() {
		// create a query
        TypedQuery<Arbol> theQuery = entityManager.createQuery("from Arbol", Arbol.class);

        // execute query and get result list
        List<Arbol> arboles = theQuery.getResultList();

        //System.out.println("Pasó por JPA");
        // return the results
        return arboles;
	}

	@Override
	public Arbol saveArbol(Arbol elArbol) {
		Arbol arbol = entityManager.merge(elArbol);
		return arbol;
	}

	@Override
	public Arbol getArbol(int theId) {
		Arbol elArbol = entityManager.find(Arbol.class, theId);
		return elArbol;
	}

	@Override
	public void deleteArbol(int theId) {
		Arbol elArbol = entityManager.find(Arbol.class, theId);
        entityManager.remove(elArbol);
		
	}

}
