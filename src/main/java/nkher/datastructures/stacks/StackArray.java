package nkher.datastructures.stacks;

import nkher.Interfaces.MyStack;
import nkher.datastructures.lists.DynamicArray;
import nkher.exception.DataStructureEmptyException;

/***
 *	This class demonstrates the implementation of a Stack interface. The underlying implementation is an array.
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class StackArray<T> implements MyStack<T> {
	
	public static final int DEFAULT_CAPACITY = 10;
	
	private int size;
	private int capacity;
	private DynamicArray<T> dArray; // uses a dynamic array for implementation
	private int top = -1; // specifies the starting index of the stack
	
	public StackArray() {
		this(DEFAULT_CAPACITY);
	}
	
	/***
	 * Constructor to initialize a stack with a certain capacity
	 * @param capacity
	 */
	public StackArray(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		dArray = new DynamicArray<T>(capacity);
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	/***
	 * Returns the size of the stack
	 */
	public int size() {
		return this.size;
	}

	/***
	 * Returns the top most element of the stack.
	 * Returns null if the stack is empty.
	 */
	public T peek() {
		if (size == 0) return null;
		return dArray.getAt(top);
	}

	/***
	 * Returns the top most element of the stack and removes it.
	 * Returns null if the stack is empty.
	 */
	public T pop() {
		if (size == 0) {
			throw new DataStructureEmptyException("Stack is empty !!");
		}
		T elem = dArray.getAt(top);
		dArray.removeAt(top--);
		size--;
		return elem;
	}

	/***
	 * Inserts the element into the stack.
	 */
	public void push(T element) {
		dArray.insert(element);
		size++;
		top++;
	}

	/***
	 * Checks if the stack is empty or not
	 */
	public boolean isEmpty() {
		return dArray.isEmpty();
	}
	
	public String toString() {
		return dArray.toString();
	}
		
	/** Following are some more useful functions */
	
	/***
	 * 
	 */
	public void reverse() {
		if (size < 0) {
			throw new DataStructureEmptyException();
		}
		int start = 0, end = this.size-1;
		while (start < end) {
			T temp = dArray.getAt(start);
			dArray.replaceAt(start, dArray.getAt(end));
			dArray.replaceAt(end, temp);
			start++;
			end--;
		}
	}
}
