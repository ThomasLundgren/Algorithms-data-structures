package se.hig.aod.lab2;

/**
 * A linked list of arbitrary size that stores objects.
 * @author Thomas Lundgren
 *
 * @param <T> the type of objects stored in the list.
 */

public class LinkedList<T> implements List<T> {
	private ListNode head = null;
	private int size = 0;
	
	public LinkedList() {}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public int numberOfElements() {
		return size;
	}

	@Override
	public void insertFirst(T t) {
		if(t == null) {
			throw new NullReferenceException("A null object cannot be inserted into a LinkedList!");
		}
		else {
			ListNode newFirstNode = new ListNode(t);
			newFirstNode.next = head;
			head = newFirstNode;
			size++;
		}
	}

	@Override
	public void insertLast(T t) {
		if(t == null) {
			throw new NullReferenceException("A null object cannot be inserted into a LinkedList!");
		}
		else {
			ListNode insertedNode = new ListNode(t);
			if(this.isEmpty()) {
				insertFirst(t);
			}
			else {
				getLastNode().next = insertedNode;
				size++;
			}
			
		}
	}

	@Override
	public T removeFirst() {
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

	@Override
	public T removeLast() {
		if(!this.isEmpty()) {
			ListNode removedNode = getLastNode();
			T objectToReturn = removedNode.heldObject;
			
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

	@Override
	public T getFirst() throws MyListEmptyException {
		if(!this.isEmpty()) {
			return head.heldObject;
		}
		else {
			throw new MyListEmptyException("getFirst cannot be used on an empty list!");
		}
	}

	@Override
	public T getLast() {
		if(!this.isEmpty()) {
			return getLastNode().heldObject;
		}
		else {
			throw new MyListEmptyException("getLast cannot be used on an empty list!");
		}
	}

	@Override
	public boolean contains(T t) {
		if(!this.isEmpty() && t != null) {
			ListNode currentNode = head;
			
			for (int i = 0; i < size; i++) {
				if(currentNode.heldObject.equals(t)) {
					return true;
				}
				currentNode = currentNode.next;
			}
		}
		
		return false;
	}

	@Override
	public void printList() {
		
	}

	@Override
	public void printListR() {
		String formattedString = allNodesToString(head);
		formattedString = formattedNodeString(formattedString);
		System.out.print(formattedString);
	}

	@Override
	public void reversePrintList() {
		// TODO Auto-generated method stub
		
	}
	
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
		private T heldObject = null;
		private ListNode next = null;
		
		private ListNode(T t) {
			heldObject = t;
		}
	}
}
