package com.calculadora;

import java.math.BigDecimal;

public class Suma extends Operacion {
	
	//CONSTRUCTOR HEREDA DE OPERACION
	public Suma(double x, double y) {
		super(x, y);
	}

	@Override
	double ejecuta() {
		return x+y;
	}

}
