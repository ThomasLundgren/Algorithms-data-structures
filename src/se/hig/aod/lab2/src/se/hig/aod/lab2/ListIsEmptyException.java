package se.hig.aod.lab2;

/**
 * Exception class that signals if an operation that is not allowed has been
 * done on an empty list.
 * 
 * @author Magnus Blom
 */
@SuppressWarnings ("serial")
public class ListIsEmptyException extends RuntimeException
{
	/**
	 * A constructor tha takes a message about which error has been generated.
	 * This can be written to the user when the exception is catched.
	 */
	public ListIsEmptyException (String message)
	{
		// Call the parents constructor.
		super (message);
	}
}
