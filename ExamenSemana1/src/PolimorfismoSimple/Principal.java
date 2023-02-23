package PolimorfismoSimple;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Animal animal = new Animal(); //CREAMOS UN OBJ DEL TIPO ANIMAL
		Scanner in = new Scanner(System.in); //PARA RECIBIR Y LEER DATOS
		
		//IMPRIMIMOS BIENVENIDA Y OPCIONES
		System.out.println("¡Bienvenido a mi granja!");
		System.out.println("Aquí hay varios animales con los que puedes interactuar");
		System.out.println("Selecciona uno: \n 1. Gato \n 2. Gallo \n 3. Perro \n 4. Vaca \n");
		
		int op = in.nextInt();
		
		switch (op) {
		case 1:
			animal = new Gato(); //NUEVO OBJ GATO
			getAnimal(animal);
			animal.getSound();
			System.out.println("¿Quieres intentar acariciarlo? \t presiona 1 para Si, 2 para No \n");
			int op2 = in.nextInt();
			if (op2 == 1)
				animal.pet();
			break;
		case 2:
			animal = new Gallo(); //NUEVO OBJ GALLO
			getAnimal(animal);
			animal.getSound();
			System.out.println("¿Quieres intentar acariciarlo? \t presiona 1 para Si, 2 para No \n");
			int op3 = in.nextInt();
			if (op3 == 1)
				animal.pet();
			break;
			
		case 3:
			animal = new Perro(); //NUEVO OBJ PERRO
			getAnimal(animal);
			animal.getSound();
			System.out.println("¿Quieres intentar acariciarlo? \t presiona 1 para Si, 2 para No \n");
			int op4 = in.nextInt();
			if (op4 == 1)
				animal.pet();
			break;
			
		case 4:
			animal = new Vaca(); //NUEVO OBJ VACA
			getAnimal(animal);
			animal.getSound();
			System.out.println("¿Quieres intentar acariciarlo? \t presiona 1 para Si, 2 para No \n");
			int op5 = in.nextInt();
			if (op5 == 1)
				animal.pet();
			break;
			
		default:
			break;
		}//switch
		
	}//main

	//CLASE PARA IMPRIMIR CLASE
	private static void getAnimal(Animal a) {
		System.out.println(a.getClass().getSimpleName() + ":");
	}//getAnimal
	
	
}//class Principal
