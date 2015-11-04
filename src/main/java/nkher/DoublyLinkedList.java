package nkher;

import nkher.Interfaces.MyList;

/***
 * This class demonstrates the doubly linked list implementation.
 * The inner data representation is a DoublyNode<T> which has pointers to forward elements.
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class DoublyLinkedList<T> implements MyList<T> {

	private int size;
	private DoublyNode<T> head;
	private DoublyNode<T> tail;
	
	public DoublyLinkedList() {
		this.size = 0;
	}

	protected static class DoublyNode<T> {
		T data;
		DoublyNode<T> next;
		DoublyNode<T> prev;
		
		public DoublyNode() {}
		
		public DoublyNode(T data) {
			this.data = data;
			next = prev = null;
		}
		
		public DoublyNode(T data, DoublyNode<T> next, DoublyNode<T> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		public String toString() {
			if (data == null) return "";
			else return data.toString();
		}
	}
	
	/***
	 * Returns the head of the linked list.
	 * 
	 * @return data at the head of the linked list
	 */
	public T head() {
		if (head == null) return null;
		return this.head.data;
	}
	
	/***
	 * Returns the tail of the linked list.
	 * 
	 * @return data at the tail of the linked list
	 */
	public T tail() {
		if (head == null) return null;
		return this.head.data;
	}
	
	/***
	 * Returns the current size of the linked list.
	 */
	public int size() {
		return this.size;
	}

	/***
	 * Checks if the singly linked list is empty or not.
	 * Returns true if the list is empty else false
	 */
	public boolean isEmpty() {
		return (this.size == 0);
	}

	/***
	 * Inserts the passed element at the tail of the doubly linked list.
	 */
	public void insert(T element) {
		size++;
		if (head == null) {
			head = tail = new DoublyNode<T>(element, null, null);
			return;
		}
		DoublyNode<T> new_node = new DoublyNode<T>(element);
		tail.next = new_node;
		new_node.prev = tail;
		tail = new_node;
	}
	
	/***
	 * Inserts the passed node to the doubly linked list.
	 * 
	 * @param node
	 */
	public void insert(DoublyNode<T> node) {
		size++;
		if (head == null) {
			head = tail = node;
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
	}

	/***
	 * Inserts the new element at the head.
	 */
	public void insertAtHead(T element) {
		size++;
		if (head == null) {
			head = tail = new DoublyNode<T>(element);
			return;
		}
		DoublyNode<T> new_node = new DoublyNode<T>(element, head, null);
		head.prev = new_node;
		head = new_node;
	}
	
	/***
	 * Searches for the passed element and returns true if the 
	 * element was successfully found and then deleted. Only the first occurrence is deleted.
	 * If the element was not found then returns false.
	 * This function removes the first occurrence of the element from the linked list.
	 * 
	 */
	public boolean remove(T element) {
		return false;
	}
	
	/***
	 * Searches for the element at the passed index and deletes
	 * the element, then adjusts the pointers and returns.
	 * If the length of the length linked list is shorter than the passed index.
	 * It throws an error.
	 * 
	 */
	public void removeAt(int index) {
		
	}

	public String toString() {
		return "";
	}
	
}
