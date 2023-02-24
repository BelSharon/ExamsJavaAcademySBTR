package inyeccion.dependencias;

public class Perro implements Animal{

	public void getSound() {
		System.out.println("¡Guau guau!");
	}//getSound
	
	public void pet() {
		System.out.println("\n <<El perrito se tiró de panza>> \nQuiere que le rasques la panza");
	}//pet
}//class Perro
