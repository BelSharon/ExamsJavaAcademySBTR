package com.curso.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.springrest.dao.ClienteDAOJdbc;
import com.curso.springrest.dao.ClienteDAOJpa;
import com.curso.springrest.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	//private ClienteDAOJpa clienteDAO; //JPA
	private ClienteDAOJdbc clienteDAO; //JDBC
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {
		return clienteDAO.getClientes();
	}

	@Override
	@Transactional
	public Cliente guardarCliente(Cliente elCliente) {
		Cliente cliente = clienteDAO.guardarCliente(elCliente);
		return cliente;
	}

	@Override
	@Transactional
	public Cliente getCliente(int elId) {
		
		return clienteDAO.getCliente(elId);
	}

	@Override
	@Transactional
	public void eliminarCliente(int elId) {
		
		clienteDAO.eliminarCliente(elId);
	}
}





