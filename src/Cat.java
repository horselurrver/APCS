/**
 * Cat subclass of Pet
 * @author Spoorthi Jakka, Amy Wang
 *
 */
public class Cat extends Pet{
	private String hairLength;
	public Cat(String name, String ownerName, String ownerEmail, String color, String hairLength, String gender, String imageFileName){
		super(name, ownerName, ownerEmail, color, gender, imageFileName);
		this.hairLength = hairLength;
	}
	
	/**
	 * Gets the size of the dog
	 * @return
	 */
	public String getHairLength(){
		return hairLength;
	}
	
	/**
	 * Returns information about cat
	 */
	public String toString(){
		String result = super.toString() + "\n";
		result += "Hair length: " + this.getHairLength() + " cm";
		return result;
	}
}