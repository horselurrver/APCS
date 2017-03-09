/**
 * Custom exception for improper dates
 * @author amywang
 *
 */
public class IllegalDateException extends Exception {
	public IllegalDateException(){
		super("Month and day are not in valid range. Year is not between 2000 and 2016, "
				+ "or start and end dates are not valid ranges.");
	}
}
