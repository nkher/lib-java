package nkher.api;

public interface MyQueue<T> extends MyCollection<T> {
	
	
	/***
	 * It is similar to the peekFirst method of the java API. It returns the element
	 * that was inserted the first in the deque but does not remove it. 
	 * The peek() and the head() method are the same. (This is to be changed)
	 * 
	 * @return element at the front or the head of the queue
	 */
	T head();
	
	/***
	 * Returns the element that was first inserted into the queue. 
	 * Also removes that element from the queue.
	 * Removes and returns the element at the head of the queue.
	 * Follows the FIFO principle where the element that came in first
	 * goes out first.
	 * 
	 * @return removes and returns the element from the head of the queue
	 */
	T dequeue();
	
	/***
	 * It is similar to the peekFirst method of the java API. It returns the element
	 * that was inserted the first in the deque but does not remove it. 
	 * The peek() and the head() method are the same. (This is to be changed)
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
