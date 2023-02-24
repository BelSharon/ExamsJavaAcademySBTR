package singleton;

public class SolicitudHeroe {
	
	//ENCAPSULAMOS LOS ATRIBUTOS
	private String calle;
	private String situacion;
	static int contador;
	//ATRIBUTO PRIVADO DE LA CLASE
	private static SolicitudHeroe solicitud;
	
	
	//CONSTRUCTOR PRIVADO
	private SolicitudHeroe(String calle, String situacion) {
		this.calle = calle;
		this.situacion = situacion;
		contador ++; //cada que se crea una conexión se incrementa
	}
	
	
	@Override
	public String toString() {
		return "Solicitud: " + calle + ", situacion=" + situacion + ", en camino.";
	}


	//METODO PUBLICO GETINSTANCE
	public static SolicitudHeroe getHeroe(String c, String s) {
		if (solicitud == null) {
			solicitud = new SolicitudHeroe(c,s);
			return solicitud;
		}else {
			return solicitud;
		}//else
	}//getH

}
