/**
 * Cat subclass of Pet
 * @author amywang
 *
 */
public class Cat extends Pet{
	private String hairLength;
	public Cat(String name, String ownerName, String ownerEmail, String color, String hairLength, String gender){
		super(name, ownerName, ownerEmail, color, gender);
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
		String result = super.toString();
		result += "Hair length: " + this.getHairLength() + "cm\n";
		return result;
	}
}