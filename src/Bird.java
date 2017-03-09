/**
 * Dog subclass of Pet
 * @author amywang
 *
 */
public class Bird extends Pet{
	private boolean featherClipped;
	public Bird(String name, String ownerName, String ownerEmail, String color){
		super(name, ownerName, ownerEmail, color);
	}
	
	/**
	 * Whether or not feathers are clipped
	 * @return
	 */
	public boolean clipped(){
		return featherClipped;
	}
	
	/**
	 * Sets bird to feathers clipped
	 */
	public void setClipped(){
		featherClipped = true;
	}
	
	/**
	 * Work on this method.
	 */
	public String toString(){
		String result = super.toString();
		result += "Feathers clipped: " + this.clipped() + "cm\n";
		return result;
	}
}