package com.curso.saludo.v1;

public class Principal {

	public static void main(String[] args) {
				//(parámetro) -> {funcion lambda}
		Hola l1 = (nombre) -> {System.out.println("¡Hola mundo! ¡Hola "+ nombre + "!");};
		//LLAMADO AL MÉTODO ABSTRACTO
		l1.saluda("Academia Java");

	}

}
