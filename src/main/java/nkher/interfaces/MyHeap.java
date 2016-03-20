package nkher.interfaces;

public interface MyHeap<T> {
	
	/***
	 * Inserts the element T into the heap.
	 * 
	 * @param element
	 */
	void insert(T t);
	
	/***
	 * Returns the element at the head of the heap.
	 * 
	 * @return
	 */
	T peek();
	
	/***
	 * Removes the element at the root of the heap.
	 * 
	 * @return
	 */
	T remove();
	
	/***
	 * Searches for the kay and removes it from the heap.
	 * @param key
	 * @return
	 */
	boolean remove(T key);
	
	/***
	 * Returns the size of the heap.
	 * 
	 * @return number of elements in the heap
	 */
	int size();
	
	/***
	 * Checks if the heap is empty of not.
	 * 
	 * @return true if the heap is empty else false
	 */
	boolean isEmpty();
	
	/***
	 * Removes all the elements from the heap.
	 */
	void clear();
}
