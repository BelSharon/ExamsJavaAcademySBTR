package com.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCalculadora {
	
	Operacion resultado;

	@Test
	void testSuma() {
		double x = 15.1;
		double y= 18.8;
				
		resultado =  new Suma(x,y);
		assertEquals(resultado.ejecuta(), x+y);
	}
	
	@Test
	void testResta() {
		double x = 156.8;
		double y= 133.5;
		
		resultado =  new Resta(x,y);
		assertEquals(resultado.ejecuta(), x-y);
	}
	
	@Test
	void testMultip() {
		double x = 5.5;
		double y= 32.1;
		
		resultado =  new Multiplicacion(x,y);
		assertEquals(resultado.ejecuta(), x*y);
	}
	
	
	@Test
	void testDiv() {
		double x = 56.3;
		double y= 14.3;
		
		resultado =  new Division(x,y);
		assertEquals(resultado.ejecuta(), x/y);
	}

}
