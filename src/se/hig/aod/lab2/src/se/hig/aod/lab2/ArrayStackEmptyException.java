package se.hig.aod.lab2;

/**
 * Thrown when an application attemps to access an object on an {@link ArrayStack} when it is empty.
 * @author Thomas Lundgren, Niklas Nordgren
 * @version 1.0.0
 * @since 1.0.0
 */
public class ArrayStackEmptyException extends RuntimeException{

	private static final long serialVersionUID = 8138756910486179287L;

	/**
	 * Creates an {@code ArrayStackEmptyException}.
	 * @param message The message to be shown when the {@code ArrayStackEmptyException} is thrown.
	 */
	public ArrayStackEmptyException(String message) {
		super(message);
	}
}
