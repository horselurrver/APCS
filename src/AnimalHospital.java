/**
 * Read in boarding pets from a file and execute different methods
 * @author Spoorthi Jakka, Amy Wang
 *sources are in readME file
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.joda.time.DateTime;
import org.joda.time.Days;

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
			
			String name = scan.next();
			
			String ownerName = scan.next();
			
			String ownerEmail = scan.next();
			

			if (!(ownerEmail.matches(EMAIL_REGEX))){//validate user email
				throw new IllegalEmailException();
			}
			String color = scan.next();
			
			String gender = scan.next();
			
			
			scan.useDelimiter("\\W");
			int startMonth = scan.nextInt();
			
			int startDay = scan.nextInt();
			
			int startYear = scan.nextInt();
			
			
			int endMonth = scan.nextInt();
			
			int endDay = scan.nextInt();
			
			int endYear = scan.nextInt();
			

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
				
				String imageFileName = scan.next();
				
				if (dog_count == DOG_LIMIT)//check if limit has been reached
					continue;
				else{
					dog_count++;
					Dog d = new Dog(name, ownerName, ownerEmail, color, size, gender, imageFileName);
					d.setBoardStart(startYear,startMonth, startDay);
					d.setBoardEnd(endYear, endMonth, endDay);
					d.calcBoardingPrice(days);
					hospital.add(d);//adding the dog
				}
			} else if (animal.equals("CAT")){
				scan.useDelimiter("\n");
				String hairLength = scan.next();
				
				String imageFileName = scan.next();
				
				if (cat_count == CAT_LIMIT)
					continue;
				else{
					cat_count++;
					Cat c = new Cat(name, ownerName, ownerEmail, color, hairLength, gender, imageFileName);
					c.setBoardStart(startYear,startMonth, startDay);
					c.setBoardEnd(endYear, endMonth, endDay);
					c.calcBoardingPrice(days);
					hospital.add(c);
				}
			} else if (animal.equals("BIRD")){
				scan.useDelimiter("\n");
				String imageFileName = scan.next();

				if (bird_count == BIRD_LIMIT)
					continue;
				else {
					bird_count++;
					Bird b = new Bird(name, ownerName, ownerEmail, color, gender, imageFileName);
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
	 * and returns information using toString() method
	 * @param name
	 * @return String
	 */
	public String printPetInfoByName(String name){
		String temp = "Pets named " + name + "\n";
		temp = temp + "******************************************\n";
		boolean found = false;
		for (Pet p : hospital){
			if (p.getPetName().equals(name)){
				found = true;
				if (p.getClass() == Dog.class)
					temp = temp + ((Dog)p).toString() + "\n";
				else if (p.getClass() == Bird.class)
					temp = temp + ((Bird)p).toString() + "\n";
				else if (p.getClass() == Cat.class)
					temp = temp + ((Cat)p).toString() + "\n";
			}
		}
		if (!(found))
			temp = temp + "Pet with name " + name + " not found. " + "\n"; 
		temp = temp + "******************************************";
		return temp;
	}
	
	/**
	 * Searches the list of pets for every pet of given name
	 * and returns the actual pet
	 * @param name
	 * @return ArrayList<Pet>
	 */
	public ArrayList<Pet> getPetByName(String name){
		ArrayList<Pet> found = new ArrayList<>();
		for (Pet p : hospital){
			if (p.getPetName().equals(name)){
				found.add(p);
			}
		}
		return found;
	}
	
	/**
	 * Searches the list of pets for pets owned by given
	 * person and returns the information using toString() 
	 * method
	 * @param name
	 * @return String
	 */
	public String printPetInfoByOwner(String name){
		String temp = "Pets owned by " + name + "\n";
		temp = temp + "******************************************\n";
		boolean found = false;
		for (Pet p : hospital){
			if (p.getOwnerName().equals(name)){
				found = true;
				if (p.getClass() == Dog.class)
					temp = temp + ((Dog)p).toString();
				else if (p.getClass() == Bird.class)
					temp = temp + ((Bird)p).toString();
				else if (p.getClass() == Cat.class)
					temp = temp + ((Cat)p).toString();
			}
		}
		if (!(found))
			temp = temp + "Pet with owner " + name + " not found." + "\n";
		temp = temp + "\n******************************************";
		return temp;
	}
	
	/**
	 * Searches the list of pets for every pet with given owner
	 * and returns the actual pet
	 * @param name
	 * @return ArrayList<Pet>
	 */
	public ArrayList<Pet> getPetByOwnerName(String name){
		ArrayList<Pet> found = new ArrayList<>();
		for (Pet p : hospital){
			if (p.getOwnerName().equals(name)){
				found.add(p);
			}
		}
		return found;
	}
	
	/**
	 * Searches the list of pets for every pet boarding 
	 * at the given time and returns the information using
	 * toString()
	 * @param month
	 * @param day
	 * @param year
	 * @return String
	 */
	public String printPetsBoarding(int month, int day, int year){
		String temp = "";
		boolean found = false;
		String year2 = ("" + year).substring(("" + year).length() - 2);
		temp = "Pets boarding on " + month + "/" + day + "/" + year2 + "\n";
		temp = temp + "******************************************\n";
		for (Pet a : hospital){
			if (a.boarding(year, month, day)){
				temp = temp + a.toString() + "\n";
				found = true;
			}
		}
		if (!found)
			temp = temp + "No pets boarding on " + month + "/" + day + "/" + year2 + "\n";
		temp = temp + "******************************************";
		return temp;
	}
	
	/**
	 * Searches the list of pets for every pet currently boarding
	 * @param name
	 * @return ArrayList<Pet>
	 */
	public ArrayList<Pet> getPetByBoarding(int month, int day, int year){
		ArrayList<Pet> found = new ArrayList<>();
		for (Pet p : hospital){
			if (p.boarding(year, month, day)){
				found.add(p);
			}
		}
		return found;
	}

	/**
	 * Returns number of spaces available
	 * @return String
	 */
	public String printAvailable(){
		String temp = "";
		temp += DOG_LIMIT - dog_count + " spaces available for dogs\n";
		temp += CAT_LIMIT - cat_count + " spaces available for cats\n";
		temp += BIRD_LIMIT - bird_count + " spaces available for birds\n";
		return temp;
	}
	
	/**
	 * Returns Arraylist of pets in the animal hospital
	 * @return ArrayList<Pet>
	 */
	public ArrayList<Pet> getHospital(){
		return hospital;
	}
}
