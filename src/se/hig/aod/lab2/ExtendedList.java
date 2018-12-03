package se.hig.aod.lab2;

/**
 * An interface for a list. This interface extends the {@link List} interface. It adds
 * the capabilities to insert, remove and fetch elements at any position in the list.
 *
 * @param <E> The type of objects to store in the {@code ExtendedList}.
 * @author Thomas Lundgren, Niklas Nordgren
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ExtendedList<E> extends List<E> {
	
	/**
	 * Insert an element into the {@code ExtendedList} at the specified index.
	 * @param e The element to insert.
	 * @param index The index at which to insert the element.
	 * @throws {@code IndexOutOfBoundsException} if the specified index points to an index outside
	 * the list.
	 */
	public void insert(E e, int index);
	
	/**
	 * Removes an element from the {@code ExtendedList} at a specified index.
	 * @param index The index of the element.
	 * @return the removed element.
	 * @throws {@code IndexOutOfBoundsException} if the specified index points to an index outside
	 * the list.
	 * @throws {@link MyListEmptyException} if the list is empty.
	 */
	public E remove(int index);
	
	/**
	 * Returns the element at the specified index.
	 * @param index The index of the element.
	 * @return the element at the specified index.
	 * @throws {@code IndexOutOfBoundsException} if the specified index points to an index outside
	 * the list.
	 * @throws {@link MyListEmptyException} if the list is empty.
	 */
	public E get(int index);
	
}
