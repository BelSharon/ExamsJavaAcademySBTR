package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Libro> getLibros() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		//query identifica nombre de la clase, no tabla
		Query<Libro> theQuery = 
				currentSession.createQuery("from Libro order by titulo",
											Libro.class);
		
		// execute query and get result list
		List<Libro> libros = theQuery.getResultList();
				
		// return the results		
		return libros;
	}

	@Override
	public void saveLibro(Libro elLibro) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(elLibro);
		
	}

	@Override
	public Libro getLibro(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Libro elLibro = currentSession.get(Libro.class, theId);
		
		return elLibro;
	}

	@Override
	public void deleteLibro(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Libro where id=:libroId");
		theQuery.setParameter("libroId", theId);
		
		theQuery.executeUpdate();		
	}

}











