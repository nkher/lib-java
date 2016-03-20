package nkher.interfaces;

public interface MyQueue<T> extends MyCollection<T> {
	
	
	/***
	 * Returns the first inserted element of the queue or the head of the queue.
	 * 
	 * @return
	 */
	T head();
	
	/***
	 * Returns the element that was first inserted into the queue. 
	 * Also removes that element from the queue.
	 * Removes and returns the element at the head of the queue.
	 * Follows the FIFO principle where the element that came in first
	 * goes out first.
	 * 
	 * @return returns the element from the head of the queue
	 */
	T dequeue();
	
	/***
	 * Returns the element at the front or the head or the queue or in other words
	 * the first inserted element from the queue but does not delete the element.
	 * 
	 * @return element at the front or the head of the queue
	 */
	T peek();
	
	/***
	 * Pushes an element onto the tail of the rear end of the queue.
	 * 
	 * @param element - data to be inserted
	 */
	void enqueue(T element);
	
}
