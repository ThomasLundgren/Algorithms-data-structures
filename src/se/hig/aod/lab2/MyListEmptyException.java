package se.hig.aod.lab2;

/**
 * Thrown when an application attemps to access an object on a {@link LinkedList} when it is empty.
 * @author Thomas Lundgren, Niklas Nordgren
 * @version 1.0.0
 * @since 1.0.0
 */
public class MyListEmptyException extends RuntimeException {
	
	/**
	 * Creates a {@code MyListEmptyException}.
	 * @param message The message to be shown when the {@code MyListEmptyException} is thrown.
	 */
	public MyListEmptyException(String message) {
		super(message);
	}
	
}
