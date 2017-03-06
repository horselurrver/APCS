/**
 * Blueprint for residential animals
 *
 */
public class Pet {
	private String name;
	private String ownerName;
	private String color;
	private String ownerEmail;
	protected int gender;
	
	public Pet(String name, String ownerName, String ownerEmail, String color){
		this.name = name;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.color = color;
	}
	
	/**
	 * Returns pet name
	 * @return
	 */
	public String getPetName(){
		return name;
	}
	
	/**
	 * Returns owner name
	 * @return
	 */
	public String getOwnerName(){
		return ownerName;
	}
	
	/**
	 * Returns color of pet
	 * @return
	 */
	public String getColor(){
		return color;
	}
	
	/**
	 * Sets the gender of the pet
	 * @param genderId
	 */
	public void setGender(int genderId){
		gender = genderId;
	}
	
	/**
	 * Need to fix this method, not sure of what id maps to what gender
	 * @return
	 */
	public String getGender(){
		return "";
	}
	
	/**
	 * Returns owner email
	 * @return
	 */
	public String getEmail(){
		return ownerEmail;
	}
	
	/**
	 * Need to fix this method, not sure what information this is supposed to return
	 */
	public String toString(){
		return "";
	}
}
