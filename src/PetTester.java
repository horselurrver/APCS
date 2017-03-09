import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class
 *
 */
public class PetTester {
	public PetTester(){
		try {
			AnimalHospital h = new AnimalHospital("petData.txt");//file not found?
			ArrayList<Pet> hospital = h.getHospital();
			for(Pet p : hospital)
			{
				
				System.out.println("******************************************");
				if (p instanceof Cat)
				{
					System.out.println("CAT: ");
				}
				else if (p instanceof Dog)
				{
					System.out.println("DOG: ");
					
				}
				else if (p instanceof Bird)
				{
					System.out.println("BIRD");
				}
				
				System.out.println(p.toString());
				System.out.println("******************************************");
				
			}
		} catch (IllegalEmailException i){
			System.out.println(i.getMessage());
		} catch (FileNotFoundException f){
			System.out.println(f.getMessage());
		}
	}
	
	public static void main(String[] args){
		new PetTester();
	}
}
