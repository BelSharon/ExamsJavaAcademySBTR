package polimorfismo.abstracto;

public class Gallo implements Animal{
	
	public void getSound() {
		System.out.println("¡Quiquiriquiii!");
	}//getSound
	
	public void pet() {
		System.out.println("\n ¡Auch! \nTe llevaste un picotazo.");
	}//pet
}// class Gallo
