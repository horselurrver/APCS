import java.text.DecimalFormat;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

/**
 * Blueprint for residential animals
 * @author Spoorthi Jakka, Amy Wang
 */
public class Pet implements Boardable{
	private String name;
	private String ownerName;
	private String color;
	private String ownerEmail;
	protected String gender;
	private DateTime startDate;
	private DateTime endDate;
	private double boardingPrice;
	protected double boarding_rate = 38.60;//per night
	DecimalFormat df = new DecimalFormat("#.00"); 
	
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
		result += "Length of stay: " + this.getDays() + " days\n";
		result += "Total boarding price: $" + df.format(this.getBoardingPrice()) + "\n";
		result += "Owner's email: " + this.getEmail() + "\n";
		result += "Pet color: " + this.getColor() + "\n";
		result += "Gender: " + this.getGender();
		return result;
	}
	
	/**
	 * Sets the start boarding date for pet
	 */
	public void setBoardStart(int year, int month, int day){
		startDate = new DateTime(year, month, day, 0, 0);
	}
	
	/**
	 * Sets end boarding date for pet
	 */
	public void setBoardEnd(int year, int month, int day){
		endDate = new DateTime(year, month, day, 0, 0);
	}
	
	/**
	 * Checks if the given time is between the start and end date
	 */
	public boolean boarding(int year, int month, int day){
		Interval interval = new Interval(startDate, endDate);
		DateTime test = new DateTime(year, month, day, 0, 0);
		return interval.contains(test);
	}
	
	/**
	 * Get start date
	 */
	public DateTime getBoardStart(){
		return startDate;
	}
	
	/**
	 * Get end date
	 */
	public DateTime getBoardEnd(){
		return endDate;
	}
	
	/**
	 * Returns boarding price
	 */
	public double getBoardingPrice(){
		return boardingPrice;
	}
	
	/**
	 * Sets boarding price using number of days
	 */
	public void calcBoardingPrice(int days){
		boardingPrice = boarding_rate*days;
	}
	
	/**
	 * Sets boarding rate 
	 */
	public void setBoardingRate(double newRate){
		boarding_rate = newRate;
	}
	
	/**
	 * Get number of days of stay
	 */
	public int getDays(){
		return Days.daysBetween(startDate.toLocalDate(), endDate.toLocalDate()).getDays();
	}
}
