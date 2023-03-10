package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Libro;
import com.luv2code.springdemo.service.LibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {

	// need to inject our customer service
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/list")
	public String listLibros(Model theModel) {
		
		// get customers from the service
		List<Libro> losLibros = libroService.getLibros();
				
		// add the customers to the model
		theModel.addAttribute("libros", losLibros);
		
		return "list-libros";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Libro elLibro = new Libro();
		
		theModel.addAttribute("libro", elLibro);
		
		return "libro-form";
	}
	
	@PostMapping("/saveLibro")
	public String saveLibro(@ModelAttribute("libro") Libro elLibro) {
		
		// save the customer using our service
		libroService.saveLibro(elLibro);
		
		return "redirect:/libro/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("libroId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Libro elLibro = libroService.getLibro(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("libro", elLibro);
		
		// send over to our form		
		return "libro-form";
	}
	
	@GetMapping("/delete")
	public String deleteLibro(@RequestParam("libroId") int theId) {
		
		// delete the customer
		libroService.deleteLibro(theId);
		
		return "redirect:/libro/list";
	}
}