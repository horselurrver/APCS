/**
 * Dog subclass of Pet
 * @author amywang
 *
 */
public class Dog extends Pet{
	private String size;
	public Dog(String name, String ownerName, String ownerEmail, String color, String size){
		super(name, ownerName, ownerEmail, color);
		this.size = size;
	}
	
	/**
	 * Gets the size of the dog
	 * @return
	 */
	public String getSize(){
		return size;
	}
	
	/**
	 * Work on this method.
	 */
	public String toString(){
		return "";
	}
}