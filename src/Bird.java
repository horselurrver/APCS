/**
 * Dog subclass of Pet
 * @author Spoorthi Jakka, Amy Wang
 *
 */
public class Bird extends Pet{
	private boolean featherClipped;
	public Bird(String name, String ownerName, String ownerEmail, String color, String gender, String imageFileName){
		super(name, ownerName, ownerEmail, color, gender, imageFileName);
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
	 * Returns information about bird
	 */
	public String toString(){
		String result = super.toString();
		result += "Feathers clipped: " + this.clipped() + "cm";
		return result;
	}
}