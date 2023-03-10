package com.curso.reduce;

public class Principal {

	public static void main(String[] args) {
		
		//ARREGLO DE PRUEBA
		int[] numsArray= new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		//lambda es una SUMA (z ,w) -> z + w
		int sumaTotal = reducir(numsArray, (z ,w) -> z + w, 0);//iniciamos en cero
		//mostramos resultado
		System.out.println("La suma total es: " + sumaTotal);//45
		
		
		//lambda es una MULTIPICACIÓN (z ,w) -> z * w
		int multiTotal = reducir(numsArray, (z ,w) -> z * w, 1); //iniciamos en 1
		//mostramos resultado
		System.out.println("La multiplicación total es: " + multiTotal);//45

	}

	//IMITAMOS LA FUNCIÓN REDUCE
	//recibe un arreglo, una operación LAMBDA a aplicar, numero inicial
			static int reducir(int[] numeros, OperacionBin ope, int inicio) {
				int acumulado = inicio;
				
				for(int numero: numeros) {
					acumulado = ope.ejecutar(numero,acumulado);
				}
				
				return acumulado;
			}
}

//https://www.youtube.com/watch?v=nviddDswadc&ab_channel=CodigoMorsa