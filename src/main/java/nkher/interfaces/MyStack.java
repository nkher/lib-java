package nkher.interfaces;

public interface MyStack<T> {
	
	/***
	 * Returns the size of the stack
	 * 
	 * @return
	 */
	int size();
	
	/***
	 * Returns the top most element (Last inserted element) of the stack.
	 * 
	 * @return
	 */
	T peek();
	
	/***
	 * Returns the top most element (Last inserted element) of the stack and removes it. 
	 * 
	 * @return
	 */
	T pop();
	
	/***
	 * Pushes an element into the stack
	 * 
	 * @param element - data to be inserted
	 */
	void push(T element);
	
	/***
	 * Returns true if the stack is empty else falses
	 * 
	 * @return
	 */
	boolean isEmpty();
}
