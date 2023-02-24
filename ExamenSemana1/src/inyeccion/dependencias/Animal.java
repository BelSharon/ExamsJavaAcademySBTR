/*TENEMOS UNA GRANJA CON VARIOS ANIMALES
 * PUEDES ESCUCHAR LOS SONIDOS QUE HACEN E INTENTAR ACARICIARLOS
 * */
package inyeccion.dependencias;

//ESTA ES LA CLASE PADRE
public interface Animal {
	
	//METODOS SIN COMPORTAMIENTO
	void getSound();
	
	void pet();

}//class Animal