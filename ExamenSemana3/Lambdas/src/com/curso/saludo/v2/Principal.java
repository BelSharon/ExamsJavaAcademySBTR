package com.curso.saludo.v2;

public class Principal {

	public static void main(String[] args) {
		//cambiamos la forma de nuestra función
		Hola l1 = (nombre) -> {return "¡Hola mundo! ¡Hola "+ nombre + "!";}; 
		
		System.out.println(l1.saluda("Academia Java"));

	}

}
