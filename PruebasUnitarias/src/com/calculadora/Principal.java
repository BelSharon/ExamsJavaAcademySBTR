package com.calculadora;

public class Principal {

	public static void main(String[] args) {
		
		Operacion resultado = new Resta(156.8,133.5);
		System.out.println(resultado.ejecuta());
	}

}
