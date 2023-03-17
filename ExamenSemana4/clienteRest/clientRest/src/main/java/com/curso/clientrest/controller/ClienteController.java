package com.curso.clientrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.clientrest.entity.Cliente;
import com.curso.clientrest.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	// need to inject our customer service
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/list")
	public String listClientes(Model theModel) {
		
		// get customers from the service
		List<Cliente> losClientes = clienteService.getClientes();
				
		// add the customers to the model
		theModel.addAttribute("clientes", losClientes);
		
		return "list-clientes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Cliente elCliente = new Cliente();
		
		theModel.addAttribute("cliente", elCliente);
		
		return "cliente-form";
	}
	
	@PostMapping("/guardarCliente")
	public String guardarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		
		// save the customer using our service
		clienteService.guardarCliente(elCliente);	
		
		return "redirect:/cliente/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("clienteId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Cliente elCliente = clienteService.getCliente(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("cliente", elCliente);
		
		// send over to our form		
		return "cliente-form";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int theId) {
		
		// delete the customer
		clienteService.eliminarCliente(theId);
		
		return "redirect:/cliente/list";
	}
}










