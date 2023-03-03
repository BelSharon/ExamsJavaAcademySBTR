package com.calculadora;

public class Multiplicacion extends Operacion{

	//CONSTRUCTOR HEREDA DE OPERACION
	public Multiplicacion(double x, double y) {
		super(x, y);
	}

	//BIGDECIMAL NO ACEPTA OPERADORES +, -, *, /
	@Override
	double ejecuta() {
		return x*y;
	}
}