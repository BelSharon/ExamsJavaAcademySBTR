package com.curso.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.springrest.entity.Cliente;

@Repository
public class ClienteDAOJpa implements ClienteDAO {
	
    // definimos el entitymanager
    private EntityManager entityManager;
    
    // inyectamos por constructor
    @Autowired
    public ClienteDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Cliente> getClientes() {
		// create a query
        TypedQuery<Cliente> theQuery = entityManager.createQuery("from Cliente", Cliente.class);

        // execute query and get result list
        List<Cliente> clientes = theQuery.getResultList();

        // return the results
        return clientes;
	}

	@Override
	public Cliente guardarCliente(Cliente elCliente) {
		Cliente cliente = entityManager.merge(elCliente);
		return cliente;
	}

	@Override
	public Cliente getCliente(int elId) {
		Cliente elCliente = entityManager.find(Cliente.class, elId);
		return elCliente;
	}

	@Override
	public void eliminarCliente(int elId) {
		Cliente elCliente = entityManager.find(Cliente.class, elId);
        entityManager.remove(elCliente);
		
	}

}
