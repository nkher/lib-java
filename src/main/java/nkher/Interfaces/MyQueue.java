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
	 * Removes the first inserted element from the queue. 
	 * 
	 * @return
	 */
	T dequeue();
	
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
}
