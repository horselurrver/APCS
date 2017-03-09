import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read in boarding pets from a file and execute different methods
 *
 */
public class AnimalHospital{
	Scanner scan;
	ArrayList<Pet> hospital;
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; //regex for email validation
	//source for regex: https://ww-w.tutorialspoint.com/javaexamples/regular_email.htm
	final int CAT_LIMIT = 5;//arbitrary limits in terms of housing for specific species
	final int DOG_LIMIT = 5;
	final int BIRD_LIMIT = 5;
	int cat_count = 0;//keep track of number of pets in hospital
	int dog_count = 0;
	int bird_count = 0;
	public AnimalHospital(String inputFile) throws IllegalEmailException {
		hospital = new ArrayList<>();
		scan = new Scanner(inputFile);
		while (!(scan.next().equals("END"))){//beginning to scan in information until the end
			String animal = scan.next();
			String name = scan.next();
			String ownerName = scan.next();
			String ownerEmail = scan.next();
			if (!(ownerEmail.matches(EMAIL_REGEX))){//validate user email
				throw new IllegalEmailException();
			}
			String color = scan.next();
			if (animal.equals("DOG")){
				String size = scan.next();
				if (dog_count == DOG_LIMIT)//check if limit has been reached
					continue;
				else{
					dog_count++;
					hospital.add(new Dog(name, ownerName, ownerEmail, color, size));//adding the dog
				}
			} else if (animal.equals("CAT")){
				String hairLength = scan.next();
				if (cat_count == CAT_LIMIT)
					continue;
				else {
					cat_count++;
					hospital.add(new Cat(name, ownerName, ownerEmail, color, hairLength));//or adding the cat
				}
			} else if (animal.equals("BIRD")){
				if (bird_count == BIRD_LIMIT)
					continue;
				else {
					bird_count++;
					hospital.add(new Bird(name, ownerName, ownerEmail, color));//or adding the bird
				}
			}
		}
	}
	
	/**
	 * Searches the list of pets for every pet of given name
	 * and prints information using toString() method
	 * @param name
	 */
	public void printPetInfoByName(String name){
		boolean found = false;
		for (Pet p : hospital){
			if (p.getPetName().equals(name)){
				found = true;
				if (p.getClass() == Dog.class)
					System.out.println(((Dog)p).toString());
				else if (p.getClass() == Bird.class)
					System.out.println(((Bird)p).toString());
				else if (p.getClass() == Cat.class)
					System.out.println(((Cat)p).toString());
			}
		}
		if (!(found))
			System.out.println("Pet with name " + name + " not found.");
	}
	
	/**
	 * Searches the list of pets for pets owned by given
	 * person and prints the information using toString() 
	 * method
	 * @param name
	 */
	public void printPetInfoByOwner(String name){
		boolean found = false;
		for (Pet p : hospital){
			if (p.getOwnerName().equals(name)){
				found = true;
				if (p.getClass() == Dog.class)
					System.out.println(((Dog)p).toString());
				else if (p.getClass() == Bird.class)
					System.out.println(((Bird)p).toString());
				else if (p.getClass() == Cat.class)
					System.out.println(((Cat)p).toString());
			}
		}
		if (!(found))
			System.out.println("Pet with owner " + name + " not found.");
	}
	
	/**
	 * Searches the list of pets for every pet boarding 
	 * at the given time and prints the information using
	 * toString()
	 * @param month
	 * @param day
	 * @param year
	 */
	public void printPetsBoarding(int month, int day, int year){
		
	}

}
