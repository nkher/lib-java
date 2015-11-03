package nkher;

import nkher.Interfaces.MyList;
import nkher.exception.DataStructureEmptyException;

/***
 * This class demonstrates the singly linked list implementation.
 * The inner data representation is a Node<T> which has pointers to forwad elements.
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class SinglyLinkedList<T> implements MyList<T> {

	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public SinglyLinkedList() {
		size = 0;
	}
	
	protected static class Node<T> {
		T data;
		Node<T> next;
		
		public Node() {}
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public String toString() {
			if(data == null) return "";
			return data.toString();
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
		return this.tail.data;
	}
	
	public int size() {
		return size;
	}

	/***
	 * Checks if the singly linked list is empty or not.
	 * Returns true if the list is empty else false
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/***
	 * Inserts the passed element at the tail of the singly linked list.
	 */
	public void insert(T element) {
		size++;
		if (head == null) {
			head = tail = new Node<T>(element);
			return;
		}
		Node<T> new_node = new Node<T>(element);
		tail.next = new_node;
		tail = new_node;
	}
	
	/***
	 * Inserts the node to the linked list
	 * 
	 * @param node
	 */
	public void insert(Node<T> node) {
		
	}
	
	/***
	 * Inserts the new element at the head.
	 */
	public void insertAtHead(T element) {
		size++;
		if (head == null) {
			head = tail = new Node<T>(element);
			return;
		}
		Node<T> new_node = new Node<T>(element, head);
		head = new_node;
	}

	/***
	 * Searches for the passed element and returns true if the 
	 * element was successfully found and then deleted.
	 * If the element was not found then returns false.
	 * This function removes the first occurrence of the element from the linked list.
	 * 
	 */
	public boolean remove(T element) {
		if (head == null) {
			throw new DataStructureEmptyException("Singly Linked list is empty");
		}
		boolean found = false;
		Node<T> itr = head, prev = null;
		while (itr != tail) {
			if (itr.data.equals(element)) {
				size--;
				if (itr == head) {
					head = head.next;
				}
				else {
					prev.next = itr.next; //  change the pointers properly
					itr.next = null;
				}
				break;
			}
			prev = itr;
			itr = itr.next;
		}
		if (itr == tail && itr.data.equals(element)) { // If the data is the last element in the list
			tail = prev;
			size--;
		}
		if (size == 1) tail = head;
		if (found) {
			return true;
		}
		return false;
	}

	/***
	 * Searches for the element at the passed index and deletes
	 * the element, then adjusts the pointers and returns.
	 * If the length of the singly linked list is shorter than the passed index.
	 * It throws an error.
	 * 
	 */
	public void removeAt(int index) {
		if (head == null) {
			throw new DataStructureEmptyException("Singly Linked list is empty");
		}
		else if (index > size-1) {
			throw new DataStructureEmptyException("Linked List length is shorter than passed Index. Index out of bounds at : " + index);
		}
		size--;
		if (index == 0) { // deletion is at the head
			head = head.next;
		}
		else {
			Node<T> itr = head, prev = null;
			int i = 0;
			while (i < index) {
				prev = itr;
				itr = itr.next;
				i++;
			}
			prev.next = itr.next; // adjusting the pointers appropriately
			itr.next = null;
			if (itr == tail) { // update the tail
				tail = prev;
			}
		}
		if (size == 1) tail = head;
	}
	
	/***
	 * Returns the elements of the Singly Linked List in a String for printing and viewing. 
	 */
	public String toString() {
		if (isEmpty()) {
			return new String("[ ]");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> itr = head;
		while (itr != tail) {
			sb.append(itr.data.toString() + ", "); 
			itr = itr.next;
		}
		sb.append(itr.data.toString()); // appending the data to the StringBuilder
		sb.append("]");
		return sb.toString();
	}
	
	/***
	 * Appends the passed linked list at the tail of this linked list
	 * 
	 * @param linkedlist
	 */
	public void append(SinglyLinkedList<T> linkedlist) {
		if (linkedlist.isEmpty() || linkedlist.head() == null) {
			return;
		}
		if (head == null) { // this linked list is empty
			Node<T> itr = linkedlist.head;
			while (itr != tail) {
				
				itr = itr.next;
			}
		}
	}
	
	/***
	 * Function to clone a linked list.
	 */
	public SinglyLinkedList<T> clone() {
		if (head == null) {
			return new SinglyLinkedList<T>();
		}
		SinglyLinkedList<T> clone_list = new SinglyLinkedList<T>();
		Node<T> itr = head;
		while (itr != tail) {
			clone_list.insert(itr.data);
			itr = itr.next;
		}
		clone_list.insert(itr.data);
		return clone_list;
	}
}
