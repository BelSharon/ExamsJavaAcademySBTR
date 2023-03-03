package com.calculadora;

public class Multiplicacion extends Operacion{

	//CONSTRUCTOR HEREDA DE OPERACION
	public Multiplicacion(double x, double y) {
		super(x, y);
	}

	
	@Override
	double ejecuta() {
		return x*y;
	}
}