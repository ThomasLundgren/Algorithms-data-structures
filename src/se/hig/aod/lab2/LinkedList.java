package se.hig.aod.lab2;

/**
 * A linked list of arbitrary size that stores objects. Objects kan be inserted and removed
 * from any position in the list.
 * @author Thomas Lundgren, Niklas Nordgren
 * @version 1.0.0
 * @since 1.0.0
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
		if(index == 0) {
			insertFirst(e);
		}
		else {
			ListNode tempNode = getListNode(index - 1);
			if(tempNode == null) {
				throw new IndexOutOfBoundsException("The specified index is out of bounds!");
			}
			ListNode newNode = new ListNode(e);
			newNode.next = tempNode.next;
			tempNode.next = newNode;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(int index) {
		if(this.isEmpty()) {
			throw new MyListEmptyException("The list is empty!");
		}
		ListNode tempNode = getListNode(index - 1);
		E objectToReturn;
		
		if(index == 0) {
			objectToReturn = removeFirst();
		}
		else if(index == size - 1) {
			objectToReturn = tempNode.next.heldObject;
			tempNode.next = null;
		}
		else if(tempNode == null || tempNode.next == null) {
			throw new IndexOutOfBoundsException("The specified index is out of bounds!");
		}
		else {
			objectToReturn = tempNode.next.heldObject;
			tempNode.next = tempNode.next.next;
		}
		
		return objectToReturn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E get(int index) {
		if(this.isEmpty()) {
			throw new MyListEmptyException("The list is empty!");
		}
		ListNode listNodeAtIndex = getListNode(index);
		if(listNodeAtIndex == null) {
			throw new IndexOutOfBoundsException("The specified index is out of bounds!");
		}
		E object = listNodeAtIndex.heldObject;
		return object;
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
	
	private ListNode getListNode(int index) {
		ListNode searchedNode = head;
		if(index < 0) {
			searchedNode = null;
		}
		else {
			for (int i = 0; i < index; i++) {
				if(searchedNode.next != null) {
					searchedNode = searchedNode.next;
				}
				else {
					searchedNode = null;
					break;
				}
			}
		}
		return searchedNode;
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
