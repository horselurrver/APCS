/**
 * Custom exception for invalid owner emails
 * @author Spoorthi Jakka, Amy Wang
 */
public class IllegalEmailException extends Exception{
	public IllegalEmailException(){
		super("Email is invalid.");
	}
}
