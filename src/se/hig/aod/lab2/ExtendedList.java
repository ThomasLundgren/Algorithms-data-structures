package se.hig.aod.lab2;

public interface ExtendedList<E> extends List<E> {
	
	/**
	 * Insert an object into the {@codeList} at the specified index.
	 * @param e The object to insert.
	 * @param index The index at which to insert the object.
	 */
	public void insert(E e, int index);
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index);
	public E get(int index);
	
}
