package inyeccion.dependencias;

//debe inyectar los animales al principal
public class Inyector {

	public static Animal InyectarAnimal (int opcion) {

		switch (opcion) {
		case 1:
			return new Gato();
			
		case 2:
			return new Gallo();

		case 3:
			return new Perro();

		case 4:
			return new Vaca();
			
		default:
			Animal a = null;
			return a;
			
		}
	}
	
	
	
	
}
