/**
 * Custom exception for invalid owner emails
 *
 */
public class IllegalEmailException extends Exception{
	public IllegalEmailException(){
		super("Email is invalid.");
	}
}
