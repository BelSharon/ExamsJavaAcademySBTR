package com.calculadora;

import java.math.BigDecimal;

public class Resta extends Operacion{

	//CONSTRUCTOR HEREDA DE OPERACION
	public Resta(double x, double y) {
		super(x, y);
	}

	//BIGDECIMAL NO ACEPTA OPERADORES +, -, *, /
	@Override
	double ejecuta() {
		return x-y;
	}
}
