/**
 * Driver class
 * @author amywang
 *
 */
public class PetTester {
	public PetTester(){
		AnimalHospital h = new AnimalHospital("petData.txt");//file not found?
	}
	
	public static void main(String[] args){
		new PetTester();
	}
}
