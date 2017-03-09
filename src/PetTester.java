/**
 * Driver class
 * @author amywang
 *
 */
public class PetTester {
	public PetTester(){
		try {
			AnimalHospital h = new AnimalHospital("petData.txt");//file not found?
		} catch (IllegalEmailException i){
			System.out.println(i.getMessage());
		}
	}
	
	public static void main(String[] args){
		new PetTester();
	}
}
