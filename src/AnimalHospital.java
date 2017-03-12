import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Days;
/**
 * Read in boarding pets from a file and execute different methods
 *
 */
public class AnimalHospital{
	private Scanner scan;
	private ArrayList<Pet> hospital;
	private String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; //regex for email validation
	//source for regex: https://ww-w.tutorialspoint.com/javaexamples/regular_email.htm
	private final int CAT_LIMIT = 5;//arbitrary limits in terms of housing for specific species
	private final int DOG_LIMIT = 5;
	private final int BIRD_LIMIT = 5;
	private int cat_count = 0;//keep track of number of pets in hospital
	private int dog_count = 0;
	private int bird_count = 0;
	public AnimalHospital(String inputFile) throws IllegalEmailException, IllegalDateException, FileNotFoundException {
		hospital = new ArrayList<>();
		scan = new Scanner(new File(inputFile));
		while (scan.hasNextLine()){//beginning to scan in information until the end
			scan.useDelimiter("\n");
			String animal = scan.next();
			//System.out.println("Animal type: " + animal);
			String name = scan.next();
			//System.out.println("Animal name: " + name);
			String ownerName = scan.next();
			//System.out.println("Owner name: " + ownerName);
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
			if (!(startMonth >=1 && startMonth <= 12) | !(endMonth >=1 && endMonth <= 12) | 
					!(startYear >= 2000 && startYear <= 2016) | !(endYear >= 2000 && endYear <= 2016)
					| !(endDay >= 0 && endDay <= 31) | !(startDay >= 0 && startDay <= 31))
				throw new IllegalDateException();
			
			DateTime start = new DateTime(startYear, startMonth, startDay, 0, 0);
			DateTime end = new DateTime(endYear, endMonth, endDay, 0, 0);
			int days = Days.daysBetween(start.toLocalDate(), end.toLocalDate()).getDays();
			
			if (!(start.compareTo(end) < 0))
				throw new IllegalDateException();
			
			if (animal.equals("DOG")){
				scan.useDelimiter("\n");
				String size = scan.next();
				//System.out.println("Size: " + size);
				if (dog_count == DOG_LIMIT)//check if limit has been reached
					continue;
				else{
					dog_count++;
					Dog d = new Dog(name, ownerName, ownerEmail, color, size, gender);
					d.setBoardStart(startYear,startMonth, startDay);
					d.setBoardEnd(endYear, endMonth, endDay);
					d.calcBoardingPrice(days);
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
					c.setBoardStart(startYear,startMonth, startDay);
					c.setBoardEnd(endYear, endMonth, endDay);
					c.calcBoardingPrice(days);
					hospital.add(c);
				}
			} else if (animal.equals("BIRD")){
				if (bird_count == BIRD_LIMIT)
					continue;
				else {
					bird_count++;
					Bird b = new Bird(name, ownerName, ownerEmail, color, gender);
					b.setBoardStart(startYear,startMonth, startDay);
					b.setBoardEnd(endYear, endMonth, endDay);
					b.calcBoardingPrice(days);
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
		System.out.println("Pets named " + name);
		System.out.println("******************************************");
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
		System.out.println("******************************************");
	}
	
	/**
	 * Searches the list of pets for pets owned by given
	 * person and prints the information using toString() 
	 * method
	 * @param name
	 */
	public void printPetInfoByOwner(String name){
		System.out.println("Pets owned by " + name);
		System.out.println("******************************************");
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
		System.out.println("******************************************");
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
		boolean found = false;
		String year2 = ("" + year).substring(("" + year).length() -2);
		System.out.printf("Pets boarding on %d/%d/%s\n", month, day, year2);
		System.out.println("******************************************");
		for (Pet a : hospital){
			if (a.boarding(year, month, day)){
				System.out.println(a.toString());
				found = true;
			}
		}
		if (!found)
			System.out.printf("No pets boarding on %d/%d/%s were found\n", month, day, year2);
		System.out.println("******************************************");
	}

	/**
	 * Returns Arraylist of pets in the animal hospital
	 * @return
	 */
	public ArrayList<Pet> getHospital(){
		return hospital;
	}
}
