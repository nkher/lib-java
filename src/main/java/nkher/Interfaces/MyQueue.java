package nkher.Interfaces;

public interface MyQueue<T> {
	
	/***
	 * Returns the size of the queue
	 * 
	 * @return
	 */
	int size();
	
	/***
	 * Returns the first inserted element of the queue.
	 * 
	 * @return
	 */
	T head();
	
	/***
	 * Returns the first inserted element from the queue. 
	 * Also deletes the element from the queue.
	 * 
	 * @return
	 */
	T dequeue();
	
	/***
	 * Returns the first inserted element from the queue but does not delete the element.
	 * @return
	 */
	T peek();
	
	/***
	 * Pushes an element onto the queue.
	 * 
	 * @param element - data to be inserted
	 */
	void enqueue(T element);
	
	/***
	 * Returns true if the stack is empty else false.
	 * 
	 * @return
	 */
	boolean isEmpty();
	
	
	/***
	 * Clears the dequeue array and sets the size to the default capacity.
	 */
	void clear();
}
