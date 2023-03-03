package com.calculadora;

public class Division extends Operacion{

	//CONSTRUCTOR HEREDA DE OPERACION
	public Division(double x, double y) {
		super(x, y);
	}

	@Override
	double ejecuta() {
		return x/y;
	}
}