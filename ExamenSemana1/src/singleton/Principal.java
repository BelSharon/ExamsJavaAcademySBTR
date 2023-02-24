package singleton;

public class Principal {

	public static void main(String[] args) {

		SolicitudHeroe solicitud1 = SolicitudHeroe.getHeroe("Calle 3, no. 25", "Ladrón de tienda");
		System.out.println(solicitud1.toString());
		
		SolicitudHeroe solicitud2 = SolicitudHeroe.getHeroe("Avenida 2, no. 16", "Incendio");

		
		//PODEMOS COMPROBAR QUE EL CONTADOR SE QUEDA EN 1
		System.out.println(SolicitudHeroe.contador);
	}

}