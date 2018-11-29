package se.hig.aod.lab2;

public class LinkedList<T> implements List<T> {

	private ListNode head;
	private int numberOfNodes;

	public LinkedList() {
		
	}

	@Override
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}

	@Override
	public void clear() {
		head = null;
		numberOfNodes = 0;
	}

	@Override
	public int numberOfElements() {
		return numberOfNodes;
	}

	@Override
	public void insertFirst(T t) {

		ListNode newNode = new ListNode(t);
		newNode.next = head;
		head = newNode;
		numberOfNodes++;

	}

	@Override
	public void insertLast(T t) {

		if(isEmpty()) {
			insertFirst(t);
		}else {
			ListNode temp = head;
			while(temp.next != null){
				temp = temp.next;
			}

			temp.next = new ListNode(t);
			numberOfNodes++;
		}
	}

	@Override
	public T removeFirst() {
		if(!isEmpty()) {
			ListNode temp = head;
			head = head.next;
			numberOfNodes--;
			return temp.data;
		}else
			throw new ListIsEmptyException("Unable to remove first element, list is empty.");
	}

	@Override
	public T removeLast() {

		if(isEmpty())
			throw new ListIsEmptyException("Unable to remove last element, list is empty.");

		if(numberOfNodes == 1)
			return removeFirst();
		else {
			ListNode temp = head;
			ListNode prev = null;

			while(temp.next != null){
				prev = temp;
				temp = temp.next;
			}

			prev.next = null;

			numberOfNodes--;
			return temp.data;
		}

	}

	@Override
	public T getFirst() {

		if(!isEmpty())
			return head.data;
		else
			throw new ListIsEmptyException("Unable to get first element, list is empty");

	}

	@Override
	public T getLast() {

		if(!isEmpty()) {
			ListNode temp = head;

			while(temp.next != null)
				temp = temp.next;

			return temp.data;

		}else
			throw new ListIsEmptyException("Unable to get last element, list is empty");

	}

	@Override
	public boolean contains(T t) {

		if(isEmpty())
			throw new ListIsEmptyException("Unable to check if element exists, list is empty");

		ListNode temp = head;

		while(temp.next != null) {
			if(temp.data.equals(t))
				return true;
			temp = temp.next;
		}

		if(getLast().equals(t))
			return true;
		else
			return false;

	}

	@Override
	public void printList() {

		ListNode temp = head;
		while(temp != null){

			System.out.println(temp.data);
			temp = temp.next;

		}

	}

	@Override
	public void printListR() {
		head.printRecursive(head);
	}

	@Override
	public void reversePrintList() {
		head.printRecursiveReverse(head);
	}

	//Inner class
	private class ListNode{

		private ListNode next;
		private T data;

		public ListNode(T data) {
			this.data = data;
		}

		public void printRecursive(ListNode listNode) {

			if(listNode == null)
				return;

			System.out.println(listNode.data.toString());
			listNode = listNode.next;
			printRecursive(listNode);

		}

		public void printRecursiveReverse(ListNode listNode) {

			if(listNode == null)
				return;

			printRecursiveReverse(listNode.next);
			System.out.println(listNode.data.toString());

		}

	}

}
