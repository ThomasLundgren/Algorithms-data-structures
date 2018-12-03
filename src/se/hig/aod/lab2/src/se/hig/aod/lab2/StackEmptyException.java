package se.hig.aod.lab2;

public class StackEmptyException extends RuntimeException {

	private static final long serialVersionUID = 128794327153689640L;

	public StackEmptyException(String message) {
		super(message);
	}
}
