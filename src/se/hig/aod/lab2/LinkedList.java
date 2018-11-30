package se.hig.aod.lab2;

/**
 * A linked list of arbitrary size that stores objects. Objects kan be inserted and removed
 * from any position in the list.
 * @author Thomas Lundgren
 *
 * @param <E> elements stored in the list.
 */

public class LinkedList<E> implements ExtendedList<E> {
	private ListNode head = null;
	private int size = 0;
	
	/**
	 * Creates a linked list.
	 */
	public LinkedList() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(E e, int index) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int numberOfElements() {
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertFirst(E e) {
		if(e == null) {
			throw new NullReferenceException("A null object cannot be inserted into a LinkedList!");
		}
		else {
			ListNode newFirstNode = new ListNode(e);
			newFirstNode.next = head;
			head = newFirstNode;
			size++;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertLast(E e) {
		if(e == null) {
			throw new NullReferenceException("A null object cannot be inserted into a LinkedList!");
		}
		else {
			ListNode insertedNode = new ListNode(e);
			if(this.isEmpty()) {
				insertFirst(e);
			}
			else {
				getLastNode().next = insertedNode;
				size++;
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E removeFirst() {
		if(!this.isEmpty()) {
			ListNode removedHead = head;
			head = head.next;
			size--;
			return removedHead.heldObject;
		}
		else {
			throw new MyListEmptyException("removeFirst cannot be called on an empty LinkedList!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E removeLast() {
		if(!this.isEmpty()) {
			ListNode removedNode = getLastNode();
			E objectToReturn = removedNode.heldObject;
			
			size--;
			if(removedNode == head)
				head = null;
			removedNode = null;
			return objectToReturn;
		}
		else {
			throw new MyListEmptyException("removeFirst cannot be called on an empty LinkedList!");
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E getFirst() throws MyListEmptyException {
		if(!this.isEmpty()) {
			return head.heldObject;
		}
		else {
			throw new MyListEmptyException("getFirst cannot be used on an empty list!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E getLast() {
		if(!this.isEmpty()) {
			return getLastNode().heldObject;
		}
		else {
			throw new MyListEmptyException("getLast cannot be used on an empty list!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(E e) {
		if(!this.isEmpty() && e != null) {
			ListNode currentNode = head;
			
			for (int i = 0; i < size; i++) {
				if(currentNode.heldObject.equals(e)) {
					return true;
				}
				currentNode = currentNode.next;
			}
		}
		
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printList() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printListR() {
		String formattedString = allNodesToString(head);
		formattedString = formattedNodeString(formattedString);
		System.out.print(formattedString);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reversePrintList() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return (head == null);
	}
	
	private ListNode getLastNode() {
		if(!this.isEmpty()) {
			ListNode lastNode = head;
			for(int i = 0; i < size - 1; i++) {
				lastNode = lastNode.next;
			}
			return lastNode;
		}
		else {
			return null;
		}
	}
	
	private String allNodesToString(ListNode node) {
		if(node == null) {
			return "";
		}
		return node.heldObject.toString() + " " + allNodesToString(node.next);	
	}
	
	private String formattedNodeString(String nodeString) {
		String formattedString = nodeString.trim();
		formattedString = formattedString.replaceAll("\\s", ", ");
		
		return formattedString;
	}
	
	private class ListNode {
		private E heldObject = null;
		private ListNode next = null;
		
		private ListNode(E e) {
			heldObject = e;
		}
	}
}
