/**
 * Dog subclass of Pet
 * @author Spoorthi Jakka, Amy Wang
 *
 */
public class Dog extends Pet{
	private String size;
	public Dog(String name, String ownerName, String ownerEmail, String color, String size, String gender, String imageFileName){
		super(name, ownerName, ownerEmail, color, gender, imageFileName);
		this.size = size;
		if (size.equals("small"))
			setBoardingRate(30.60);
		else if (size.equals("medium"))
			setBoardingRate(34.60);
		else if (size.equals("large"))
			setBoardingRate(38.60);
		else if (size.equals("very large"))
			setBoardingRate(42.60);
	}
	
	/**
	 * Gets the size of the dog
	 * @return
	 */
	public String getSize(){
		return size;
	}
	
	/**
	 * Returns information about dog
	 */
	public String toString(){
		String result = super.toString() + "\n";
		result += "Size: " + this.getSize() + "";
		return result;
	}
	
}
