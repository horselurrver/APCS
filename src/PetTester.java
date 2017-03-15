/**
 * Driver class
 * @author Spoorthi Jakka, Amy Wang
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class PetTester {
	public PetTester(){
		try {
			AnimalHospital h = new AnimalHospital("petData.txt");
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
			System.out.println("******************************************");
			h.printAvailable();
			System.out.println("******************************************");
			System.out.println(h.printPetInfoByName("Akamaru"));
			System.out.println("******************************************");
			System.out.println(h.printPetInfoByOwner("Paulie Ann"));
			System.out.println("******************************************");
			System.out.println(h.printPetsBoarding(9, 15, 2001));
			System.out.println("********************************************");
			System.out.println(h.printPetsBoarding(12, 15, 2003));
		} catch (IllegalEmailException i){
			System.out.println(i.getMessage());
		} catch (FileNotFoundException f){
			System.out.println(f.getMessage());
		} catch (IllegalDateException i){
			System.out.println(i.getMessage());
		}
	}
	
	public static void main(String[] args){
		new PetTester();
	}
}
