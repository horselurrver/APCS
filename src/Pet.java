import org.joda.time.DateTime;

/**
 * Blueprint for residential animals
 *
 */
public class Pet implements Boardable{
	private String name;
	private String ownerName;
	private String color;
	private String ownerEmail;
	protected String gender;
	private DateTime startDate;
	private DateTime endDate;
	
	public Pet(String name, String ownerName, String ownerEmail, String color, String gender){
		this.name = name;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.color = color;
		this.gender = gender;
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
	public void setGender(String gender){
		this.gender = gender;
	}
	
	/**
	 * Need to fix this method, not sure of what id maps to what gender
	 * @return
	 */
	public String getGender(){
		return gender;
	}
	
	/**
	 * Returns owner email
	 * @return
	 */
	public String getEmail(){
		return ownerEmail;
	}
	
	/**
	 * Returns information about pet
	 */
	public String toString(){
		String result = "";
		result += this.getPetName() + " owned by " + this.getOwnerName() + "\n";
		result += "Owner's email: " + this.getEmail() + "\n";
		result += "Pet color: " + this.getColor() + "\n";
		result += "Gender: " + this.getGender() + "\n";
		return result;
	}
	
	/**
	 * Sets the start boarding date for pet
	 */
	public void setBoardStart(int month, int day, int year){
		startDate = new DateTime(year, month, day, 0, 0);
	}
	
	/**
	 * Sets end boarding date for pet
	 */
	public void setBoardEnd(int month, int day, int year){
		endDate = new DateTime(year, month, day, 0, 0);
	}
	
	/**
	 * Checks if the given time is between the start and end date
	 */
	public boolean boarding(int month, int day, int year){
		return false;//dummy variable until we finish this
	}
}
