package nkher.interfaces;

public interface MyStack<T> extends MyCollection<T> {
	
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
	
}
