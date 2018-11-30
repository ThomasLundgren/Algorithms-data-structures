package se.hig.aod.lab2;

/**
 * A Java interfave for the Abstract Data Type Indexed list (the position into
 * the list can be given by an integer index).
 * 
 * @author Magnus Blom
 * @author Anders Jackson
 * @author Peter Jenke
 * @version 2013-02-06
 */

public interface IndexedList<T> extends List<T>
{
	/**
	 * Add the element at the given index in the list.
	 * 
	 * @param t
	 *            the object to add.
	 * @param pos
	 *            the index.
	 */
	public void insert (T t, int pos);

	/**
	 * Remove the element from the given index in the list.
	 * 
	 * @return the element from the given index in the list.
	 */
	public T remove (int pos);

	/**
	 * Get the element that is stored at the given index without removing it.
	 * 
	 * @return the element at the given index in the list.
	 */
	public T get (int pos);
}
