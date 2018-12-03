package se.hig.aod.lab2;

/**
 * An interface for a list. This interface extends the {@link List} interface. It adds
 * the capabilities to insert, remove and fetch elements at any position in the list.
 * @author Thomas Lundgren, Niklas Nordgren
 *
 * @param <E>
 */
public interface ExtendedList<E> extends List<E> {
	
	/**
	 * Insert an element into the {@code List} at the specified index.
	 * @param e The element to insert.
	 * @param index The index at which to insert the element.
	 * @throws {@link IndexOutOfBoundsException}
	 */
	public void insert(E e, int index);
	
	/**
	 * Removes an element from the {@code List} at a specified index.
	 * @param index The index of the element.
	 * @return the removed element.
	 * @throws {@link IndexOutOfBoundsException}
	 */
	public E remove(int index);
	
	/**
	 * Returns the element at the specified index.
	 * @param index The index of the element.
	 * @return the element at the specified index.
	 * @throws {@link IndexOutOfBoundsException}
	 */
	public E get(int index);
	
}
