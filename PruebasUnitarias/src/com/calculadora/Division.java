package com.calculadora;

public class Division extends Operacion{

	//CONSTRUCTOR HEREDA DE OPERACION
	public Division(double x, double y) {
		super(x, y);
	}

	//BIGDECIMAL NO ACEPTA OPERADORES +, -, *, /
	@Override
	double ejecuta() {
		return x/y;
	}
}