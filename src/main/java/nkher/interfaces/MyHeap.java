package nkher.interfaces;

public interface MyHeap<T> extends MyCollection<T> {
	
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
	
}
