package com.calculadora;

import java.math.BigDecimal;

public abstract class Operacion {
	//NO SE PUEDEN CREAR OBJETOS DEL TIPO ABSTRACTO
	
	//LAS VARIABLES NO SE INICIALIZAN
	double x;
	double y;
	
	//CONSTRUCTOR
	public Operacion(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//LOS MÉTODOS ABTRACTOS NO TIENEN COMPORTAMMINETO 
	abstract double ejecuta();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() 
				+ " " + x + " + " + y + " = ";
	}
	
	
}
