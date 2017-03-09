/**
 * Dog subclass of Pet
 * @author amywang
 *
 */
public class Dog extends Pet{
	private String size;
	public Dog(String name, String ownerName, String ownerEmail, String color, String size, String gender){
		super(name, ownerName, ownerEmail, color, gender);
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
	 * Returns information about dog
	 */
	public String toString(){
		String result = super.toString();
		result += "Size: " + this.getSize() + "\n";
		return result;
	}
}
