/**
 * Driver class
 * @author amywang
 *
 */
public class PetTester {
	public PetTester(){
		try {
			AnimalHospital h = new AnimalHospital("petData.txt");//file not found?
			
			for(Pet p: h)
			{
				
				System.out.println("******************************************");
				if p instanceof Cat
				{
					System.out.println("CAT: ");
				}
				else if p instanceof Dog
				{
					System.out.println("DOG: ");
					
				}
				else if p instanceof Bird
				{
					System.out.println("BIRD");
				}
				
				System.out.println(p.toString);
				System.out.println("******************************************");
				
			}
		} catch (IllegalEmailException i){
			System.out.println(i.getMessage());
		}
	}
	
	public static void main(String[] args){
		new PetTester();
	}
}
