package se.hig.aod.lab2;

/**
 * The {@code ArrayStack} class is a data structure that contains objects. Objects are added and removed
 * in LIFO-order (Last in, first out).
 * 
 * @param <E> The type of elements in this {@code ArrayStack}.
 * @author Thomas Lundgren, Niklas Nordgren
 * @version 1.0.0
 * @since 1.0.0
 */

public class ArrayStack<E> implements Stack<E> {
	
	private final int maxSize;
	private int topIndex = -1;
	private E[] array;
	
	/**
	 * Creates an {@code ArrayStack} object.
	 * @param stackMaxSize The maximum number of objects that the {@code ArrayStack} can hold.
	 */
	public ArrayStack(int stackMaxSize) {
		this.maxSize = stackMaxSize;
		array = (E[]) new Object[stackMaxSize];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		topIndex = -1;
		System.out.print("ArrayStack cleared!");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(E v) throws ArrayStackEmptyException{
		if(!this.isFull()) {
			topIndex++;
			array[topIndex] = v;
		}
		else {
			throw new ArrayStackFullException("Push on full stack not allowed!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E pop() throws ArrayStackEmptyException {
		if(!this.isEmpty()) {	
			E topObject = array[topIndex];
			topIndex--;
			return topObject;
		}
		else {
			throw new ArrayStackEmptyException("Pop on empty stack not allowed!");
		}
			 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E top() {
		if(!this.isEmpty()) {
			return array[topIndex];
		}
		else {
			throw new ArrayStackEmptyException("Top on empty stack not allowed!");
		}
	}
	
	/**
	 * Checks if the {@code ArrayStack} is full.
	 * @return {@code true} if the {@code ArrayStack} is full, otherwise {@code false}.
	 */
	public boolean isFull() {
		return topIndex == maxSize - 1;
	}
	
}
