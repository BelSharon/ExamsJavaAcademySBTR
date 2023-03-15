package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOJpa implements CustomerDAO {
	
    //INTERFAZ PARA INTERACCION CON PERSIST
    private EntityManager entityManager;
    
    // INYECTAMOS POR CONSTRUCTOR
    @Autowired
    public CustomerDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Customer> getCustomers() {
		// create a query
        TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        System.out.println("Pasó por JPA");
        // return the results
        return customers;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		Customer customer = entityManager.merge(theCustomer);
		return customer;
	}

	@Override
	public Customer getCustomer(int theId) {
		Customer theCustomer = entityManager.find(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Customer theCustomer = entityManager.find(Customer.class, theId);
        entityManager.remove(theCustomer);
		
	}

}
