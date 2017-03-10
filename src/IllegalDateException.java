/**
 * Custom exception for improper dates
 * @author amywang
 *
 */
public class IllegalDateException extends Exception {
	public IllegalDateException(){
		super("Month, day, or year not in valid range, "
				+ "or start and end dates not valid ranges.");
	}
}
