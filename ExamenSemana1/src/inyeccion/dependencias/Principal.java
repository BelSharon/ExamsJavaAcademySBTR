package inyeccion.dependencias;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Animal animal; //NO SE INSTANCIA LAS INTERFASES
		Scanner in = new Scanner(System.in); //PARA RECIBIR Y LEER DATOS
		
		//IMPRIMIMOS BIENVENIDA Y OPCIONES
		System.out.println("¡Bienvenido a mi granja!");
		System.out.println("Aquí hay varios animales con los que puedes interactuar");
		
		int o = 1;
		
		do {
			System.out.println("Selecciona uno: \n 1. Gato \n 2. Gallo \n 3. Perro \n 4. Vaca \n 5. Salir\n");
			int op = in.nextInt();
			animal = Inyector.InyectarAnimal(op);
			accionAnimal(animal,in);
			o = verOtro(in);
		} while (o == 1);
		System.out.println("Bueno, adiós.");
		
		
	}//main

	
	//FUNCION INTERACCION CON ANIMAL
	private static void accionAnimal(Animal a, Scanner in) {
		System.out.println(a.getClass().getSimpleName() + ":\n");
		a.getSound();
		System.out.println("¿Quieres intentar acariciarlo? \t presiona 1 para Si, 2 para No \n");
		int op2 = in.nextInt();
		if (op2 == 1)
			a.pet();
	}
	
	
	//FUNCION PARA ELEGIR OTRO ANIMAL
	private static int verOtro(Scanner in) {
		System.out.println("\n ¿Quieres ir con otro animal? \t (1 para Si, 2 para No)\n");
		int otro = in.nextInt();
		return otro;
	}
	
	
}//class Principal