import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.DateTime;
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
	public AnimalHospital(String inputFile) throws IllegalEmailException, FileNotFoundException {
		hospital = new ArrayList<>();
		scan = new Scanner(new File(inputFile));
		while (scan.hasNextLine()){//beginning to scan in information until the end
			scan.useDelimiter("\n");
			String animal = scan.next();
			//System.out.println("Animal type: " + animal);
			String name = scan.next();
			//System.out.println("Animal name: " + name);
			String ownerName = scan.next();
			//System.out.println("Onwer name: " + ownerName);
			String ownerEmail = scan.next();
			//System.out.println("Owner email: " + ownerEmail);
			
			if (!(ownerEmail.matches(EMAIL_REGEX))){//validate user email
				throw new IllegalEmailException();
			}
			String color = scan.next();
			//System.out.println("Animal color: " + color);
			String gender = scan.next();
			//System.out.println("Gender: " + gender);
			
			scan.useDelimiter("\\W");
			int startMonth = scan.nextInt();
			//System.out.println("Start month: " + startMonth);
			int startDay = scan.nextInt();
			//System.out.println("Start day: " + startDay);
			int startYear = scan.nextInt();
			//System.out.println("Start year: " + startYear);
			
			int endMonth = scan.nextInt();
			//System.out.println("End month: " + startMonth);
			int endDay = scan.nextInt();
			//System.out.println("End month: " + startMonth);
			int endYear = scan.nextInt();
			//System.out.println("End month: " + startMonth);
			
			//validate dates, possibly throw illegaldateexception here. make sure start is before end.
			
			if (animal.equals("DOG")){
				scan.useDelimiter("\n");
				String size = scan.next();
				//System.out.println("Size: " + size);
				if (dog_count == DOG_LIMIT)//check if limit has been reached
					continue;
				else{
					dog_count++;
					Dog d = new Dog(name, ownerName, ownerEmail, color, size, gender);
					d.setBoardStart(startMonth, startDay, startYear);
					d.setBoardEnd(endMonth, endDay, endYear);
					hospital.add(d);//adding the dog
				}
			} else if (animal.equals("CAT")){
				String hairLength = scan.next();
				//System.out.println("Hair length: " + hairLength);
				if (cat_count == CAT_LIMIT)
					continue;
				else{
					cat_count++;
					Cat c = new Cat(name, ownerName, ownerEmail, color, hairLength, gender);
					c.setBoardStart(startMonth, startDay, startYear);
					c.setBoardEnd(endMonth, endDay, endYear);
					hospital.add(c);
				}
			} else if (animal.equals("BIRD")){
				if (bird_count == BIRD_LIMIT)
					continue;
				else {
					bird_count++;
					Bird b = new Bird(name, ownerName, ownerEmail, color, gender);
					b.setBoardStart(startMonth, startDay, startYear);
					b.setBoardEnd(endMonth, endDay, endYear);
					hospital.add(b);
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

	/**
	 * Returns Arraylist of pets in the animal hospital
	 * @return
	 */
	public ArrayList<Pet> getHospital(){
		return hospital;
	}
}
