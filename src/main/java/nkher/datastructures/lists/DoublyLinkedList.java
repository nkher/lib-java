package nkher.datastructures.lists;

import nkher.exception.DataStructureEmptyException;
import nkher.exception.DataStructureSmallerException;
import nkher.exception.InvalidIndexException;
import nkher.interfaces.MyList;

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

	/***
	 * Represents the node of a doubly linked list. It contains a data element,
	 * a pointer to the next node and a pointer to the previous node.
	 * 
	 * @author nameshkher
	 *
	 * @param <T>
	 */
	public static class DoublyNode<T> {
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
		return this.tail.data;
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
		if (head == null) {
			throw new DataStructureEmptyException("Doubly Linked list is empty");
		}
		boolean found = false;
		DoublyNode<T> itr = head;
		while (itr != tail) {
			if (itr.data.equals(element)) { // element found hence change the pointers
				found = true;
				size--; // decrement the size of the list
				if (itr == head) {
					head = head.next;
					head.prev = null; // very important
				}
				else {
					DoublyNode<T> prev = itr.prev;
					prev.next = itr.next;
					itr.next.prev = prev;
				}
				break;
			}
			if (itr == tail && itr.data.equals(element)) { // data is the last element
				DoublyNode<T> last = tail;
				tail = tail.prev;
				tail.next = null;
				last.prev = null;
				found = true;
				size--;
			}
			if (size == 1) tail = head;
			if (found) {
				return true;
			}
			return false;
		}
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
		if (head == null) {
			throw new DataStructureEmptyException("Doubly Linked list is empty");
		}
		else if (index > size - 1) {
			throw new DataStructureSmallerException("Linked List Length is shorter than passed index.");
		}
		else if (index < 0) {
			throw new InvalidIndexException("Cannot access negative index : " + index);
		}
		size--;
		if (index == 0) { // deletion is at the end
			DoublyNode<T> next = head.next;
			if (next != null) {
				next.prev = null;
				head.next = null;
				head = next;
			}
		}
		else {
			DoublyNode<T> itr = head;
			int i = 0;
			while (i < index) {
				itr = itr.next;
				i++;
			}
			DoublyNode<T> prev = itr.prev, next = itr.next;
			if (null == itr.next) { // itr is the last node
				prev.next = null;
				itr.prev = null;
				tail = prev; // update the tail
				return;
			}
			// if it is not the last node
			prev.next = next;
			next.prev = prev;
			itr.prev = null;
			itr.next = null;
		}
		if (size == 1) tail = head;
	}

	/***
	 * Returns the elements of the Doubly Linked List in a String for printing and viewing. 
	 */
	public String toString() {
		if (isEmpty()) {
			return new String("[ ]");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		DoublyNode<T> itr = head;
		while (itr != tail) {
			sb.append(itr.data.toString() + ", ");
			itr = itr.next;
		}
		sb.append(itr.data.toString());
		sb.append("]");
		return sb.toString();
	}
	
	/***
	 * Removes all the elements from the SinglyLinkedList.
	 */
	public void clear() {
		if (isEmpty()) return;
		head = null;
		tail = null;
		size = 0;
	}

	/***
	 * Returns an Object[] array containing all the elements of the DoublyLinkedList.
	 */
	public Object[] toArray() {
		if (isEmpty()) {
			return new Object[1];
		}
		Object[] result = new Object[size];
		DoublyNode<T> itr = head;
		int i=0;
		while (itr != tail) {
			result[i++] = itr.data;
			itr = itr.next;
		}
		result[i] = itr.data;
		return result;
	}
	
	/***
	 * Appends the passed doubly linked list at the tail of this doubly linked list.
	 * This does not create new memory for the nodes that are being appended.
	 * But it uses the existing nodes from the linked list which is to be appended.
	 * 
	 * @param linkedlist - a doubly linked list
	 */
	public void append(DoublyLinkedList<T> linkedlist) {
		if (linkedlist.isEmpty() || linkedlist.head == null) { // nothing to append
			return;
		}
		DoublyNode<T> itr = head;
		while (itr != tail) {
			itr = itr.next;
		}
		DoublyNode<T> itr2 = linkedlist.head;
		while (itr2 != linkedlist.tail) {
			insert(itr2);
			itr2 = itr2.next;
		}
		insert(itr2); // insert the tail as well
	}
	
	/***
	 * Function to clone a doubly linked list.
	 */
	public DoublyLinkedList<T> clone() {
		if (head == null) {
			return new DoublyLinkedList<T>();
		}
		DoublyLinkedList<T> clone_list = new DoublyLinkedList<T>();
		DoublyNode<T> itr = head;
		while (itr != tail){
			clone_list.insert(itr.data);
			itr = itr.next;
		}
		clone_list.insert(itr);
		return clone_list;
	}

	@Override
	public boolean contains(T elem) {
		if (!isEmpty()) {
			DoublyNode<T> temp = head;
			while (temp != null || temp != tail) {
				if (temp.equals(elem)) return true;
			}
			temp = temp.next;
		}
		return false;
	}
}
