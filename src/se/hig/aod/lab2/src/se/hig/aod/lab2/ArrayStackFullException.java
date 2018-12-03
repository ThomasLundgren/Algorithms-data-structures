package se.hig.aod.lab2;

/**
 * Thrown when an application tries to add elements to an {@link ArrayStack} that is full.
 * @author Thomas Lundgren, Niklas Nordgren
 * @version 1.0.0
 * @since 1.0.0
 */
public class ArrayStackFullException extends RuntimeException {

	private static final long serialVersionUID = 6308887704880955745L;

	/**
	 * Creates an {@code ArrayStackFullException}.
	 * @param message The message to be displayed when the {@code ArrayStackFullException} is thrown.
	 */
	public ArrayStackFullException(String message) {
		super(message);
	}
}
