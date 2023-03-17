package com.curso.clientrest.service;

import java.util.List;

import com.curso.clientrest.entity.Cliente;

public interface ClienteService {

	public List<Cliente> getClientes();

	public void guardarCliente(Cliente elCliente);

	public Cliente getCliente(int theId);

	public void eliminarCliente(int theId);
	
}
