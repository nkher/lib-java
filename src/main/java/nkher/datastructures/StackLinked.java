package nkher.datastructures;

import nkher.Interfaces.MyStack;
import nkher.exception.DataStructureEmptyException;

public class StackLinked<T> implements MyStack<T> {

	private int size = 0;
	private Node<T> top;
	private Node<T> bottom;
	
	public StackLinked() {}
	
	protected static class Node<T> {
		
		Node<T> above;
		Node<T> below;
		T data;
		
		public Node() {
			above = below = null;
		}
		
		public Node(T data) {
			this.data = data;
			above = below = null;
		}
		
		public Node(Node<T> above, Node<T> below, T data) {
			this.data = data;
			this.above = above;
			this.below = below;
		}
	}
	
	
	public int size() {
		return this.size;
	}

	public T peek() {
		if (size == 0) {
			throw new DataStructureEmptyException("Stack is currently empty !! Cannot peek from empty stack.");
		}
		return top.data;
	}

	public T pop() {
		if (size == 0) {
			throw new DataStructureEmptyException("Stack is currently empty !! Cannot pop from empty stack.");
		}
		size--;
		Node<T> ptop = this.top;		
		if (size == 0) { // means there was only a single node in the tree
			top = bottom = null;
		}
		else {
			top = top.below;
			top.above = null;
		}
		return ptop.data;
	}

	public void push(T element) {
		Node<T> new_node = new Node<T>(element);
		size++;
		if (size == 1) { // first node in the stack
			bottom = new_node;
			top = bottom;
			return;
		}
		// If this is second, third ... element in the stack
		top.above = new_node;
		new_node.below = top;
		top = new_node;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public String toString() {
		if (isEmpty()) {
			return "[ ]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> temp = bottom;
		while (temp != top) {
			sb.append(temp.data.toString() + ", ");
			temp = temp.above;
		}
		sb.append(temp.data.toString());
		sb.append("]");
		return sb.toString();
	}
	
	/***
	 * A recursive O(N^2) algorithm to reverse the stack in-place in ascending order.
	 */
	public void reverse() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot Sort and empty stack !");
		}
		reverseUtil();
	}
	
	/***
	 * Utility function to reverse the stack.
	 */
	private void reverseUtil() {
		if (!isEmpty()) {
			T element = pop();
			reverseUtil();
			insertUtil(element);
		}
	}
	
	/***
	 * Utility function 2 to reverse the stack.
	 */
	private void insertUtil(T element) {
		if (isEmpty()) {
			push(element);
		}
		else {
			T x = pop();
			insertUtil(element);
			push(x);
		}
	}
	
	/***
	 * A recursive O(N^2) algorithm to sort the stack in ascending order.
	 */
	public void sort(int sortOrder) {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot Sort and empty stack !");
		}
		sortUtil(sortOrder);
	}
	
	/***
	 * Utility function to reverse the stack.
	 */
	private void sortUtil(int sortOrder) {
		if (!isEmpty()) {
			T element = pop();			
		}
	}

}
