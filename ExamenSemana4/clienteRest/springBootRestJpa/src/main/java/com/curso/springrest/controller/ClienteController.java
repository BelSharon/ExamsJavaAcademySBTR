package com.curso.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springrest.entity.Cliente;
import com.curso.springrest.service.ClienteService;

@RestController
@RequestMapping("/rest")
public class ClienteController {

	// need to inject our customer service
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> findAll() {
		return clienteService.getClientes();
	}
	
	@GetMapping("/clientes/{clienteId}")
	public Cliente getCustomer(@PathVariable int clienteId) throws Exception {
		
		Cliente elCliente = clienteService.getCliente(clienteId);
		
		if (elCliente == null) {
			throw new Exception("id de cliente no encontrado - " + clienteId);
		}
		
		return elCliente;
	}
	
	@PostMapping("/clientes")
	public Cliente addCustomer(@RequestBody Cliente elCliente) {
			
		elCliente.setId(0);
		
		Cliente addCustomer = clienteService.guardarCliente(elCliente);
		
		return addCustomer;
	}
	
	@PutMapping("/clientes")
	public Cliente updateCustomer(@RequestBody Cliente elCliente) {
		
		Cliente Cliente = clienteService.guardarCliente(elCliente);
		
		return Cliente;
	}
	
	@DeleteMapping("/clientes/{clienteId}")
	public String deleteCustomer(@PathVariable int clienteId) {
		
		Cliente tempCliente = clienteService.getCliente(clienteId);
		
		// throw exception if null
		
		if (tempCliente == null) {
			throw new RuntimeException("id de cliente no encontrado - " + clienteId);
		}
		
		clienteService.eliminarCliente(clienteId);
		
		return "Se eliminó cliente con id - " + clienteId;
	}
	
	
}










