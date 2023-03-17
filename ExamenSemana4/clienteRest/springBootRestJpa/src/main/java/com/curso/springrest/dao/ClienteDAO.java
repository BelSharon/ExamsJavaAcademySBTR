package com.curso.springrest.dao;

import java.util.List;

import com.curso.springrest.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getClientes();

	public Cliente guardarCliente(Cliente elCliente);

	public Cliente getCliente(int elId);

	public void eliminarCliente(int elId);
	
}
