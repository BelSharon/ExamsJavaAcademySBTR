/*TENEMOS UNA GRANJA CON VARIOS ANIMALES
 * PUEDES ESCUCHAR LOS SONIDOS QUE HACEN E INTENTAR ACARICIARLOS
 * */
package polimorfismosimple;

//ESTA ES LA CLASE PADRE
public class Animal {
	
	//ME´TODOS
	void getSound() {
		System.out.println("Algún sonido");
	}//getSound
	
	void pet() {
		System.out.println("Alguna reacción");
	}//pet

}//class Animal