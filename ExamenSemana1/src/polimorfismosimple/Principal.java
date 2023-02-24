package polimorfismosimple;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Animal animal = new Animal(); //CREAMOS UN OBJ DEL TIPO ANIMAL
		Scanner in = new Scanner(System.in); //PARA RECIBIR Y LEER DATOS
		
		//IMPRIMIMOS BIENVENIDA Y OPCIONES
		System.out.println("¡Bienvenido a mi granja!");
		System.out.println("Aquí hay varios animales con los que puedes interactuar");
		
		int o = 1;
		
		do {
			System.out.println("Selecciona uno: \n 1. Gato \n 2. Gallo \n 3. Perro \n 4. Vaca \n 5. Salir\n");
			int op = in.nextInt();
			switch (op) {
			case 1:
				animal = new Gato(); //NUEVO OBJ GATO
				accionAnimal(animal,in);
				o = verOtro(in);
				break;
				
			case 2:
				animal = new Gallo(); //NUEVO OBJ GALLO
				accionAnimal(animal,in);
				o = verOtro(in);
				break;
				
			case 3:
				animal = new Perro(); //NUEVO OBJ PERRO
				accionAnimal(animal,in);
				o = verOtro(in);
				break;
				
			case 4:
				animal = new Vaca(); //NUEVO OBJ VACA
				accionAnimal(animal,in);
				o = verOtro(in);
				break;
				
			default:
				System.out.println("¡On no, las cabras se volvieron locas! ¡Correeee!");
				o = 0;
			}//switch
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