package se.hig.aod.lab2;

public class ArrayStackEmptyException extends RuntimeException{

	private static final long serialVersionUID = 8138756910486179287L;

	public ArrayStackEmptyException(String message) {
		super(message);
	}
}
