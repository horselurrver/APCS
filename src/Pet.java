/**
 * Blueprint for residential animals
 *
 */
public class Pet implements Boardable{
	private String name;
	private String ownerName;
	private String color;
	private String ownerEmail;
	protected int gender;
	//variable to store start date
	//variable to store end date
	//source: https://www.tutorialspoint.com/java/java_date_time.htm
	
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
	
	//are we generating these randomly or taking these in from the input file?
	public void setBoardStart(int month, int day, int year){
		
	}
	
	public void setBoardEnd(int month, int day, int year){
		
	}
	
	public boolean boarding(int month, int day, int year){
		return false;//dummy variable until we finish this
	}
}
