package com.curso.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springdemo.entity.Arbol;
import com.curso.springdemo.service.ArbolService;

@RestController
@RequestMapping("/rest")
public class ArbolController {

	// PARA INYECCION DE CustomerService
	@Autowired
	private ArbolService arbolService;
	
	@GetMapping("/arboles")
	public List<Arbol> findAll() {
		return arbolService.getArboles();
	}
	
	@GetMapping("/arboles/{arbolId}")
	public Arbol getCustomer(@PathVariable int arbolId) throws Exception {
		
		Arbol elArbol = arbolService.getArbol(arbolId);
		
		if (elArbol == null) {
			throw new Exception("No se encontró id de registro - " + arbolId);
		}
		
		return elArbol;
	}
	
	@PostMapping("/arboles")
	public Arbol addCustomer(@RequestBody Arbol elArbol) {
			
		elArbol.setId(0);
		
		Arbol agregarArbol = arbolService.saveArbol(elArbol);
		
		return agregarArbol;
	}
	
	@PutMapping("/arboles")
	public Arbol updateCustomer(@RequestBody Arbol elArbol) {
		
		Arbol Arbol = arbolService.saveArbol(elArbol);
		
		return Arbol;
	}
	
	@DeleteMapping("/arboles/{arbolId}")
	public String deleteCustomer(@PathVariable int arbolId) {
		
		Arbol tempArbol = arbolService.getArbol(arbolId);
		
		// EXCEPCION SI NO LO ENCUENTRA
		if (tempArbol == null) {
			throw new RuntimeException("No se encontró id de registro - " + arbolId);
		}
		
		arbolService.deleteArbol(arbolId);
		
		return "Deleted customer id - " + arbolId;
	}
	
	
}










