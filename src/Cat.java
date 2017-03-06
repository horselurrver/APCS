/**
 * Cog subclass of Pet
 * @author amywang
 *
 */
public class Cat extends Pet{
	private String hairLength;
	public Cat(String name, String ownerName, String ownerEmail, String color, String hairLength){
		super(name, ownerName, ownerEmail, color);
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
	 * Work on this method.
	 */
	public String toString(){
		return "";
	}
}