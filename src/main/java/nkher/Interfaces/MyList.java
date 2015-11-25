package nkher.Interfaces;

public interface MyList<T> {
	
	/***
	 * Returns the size of the list.
	 * 
	 * @return number of elements in the list
	 */
	int size();
	
	/***
	 * Checks if the list is empty of not.
	 * 
	 * @return true if the list is empty else false
	 */
	boolean isEmpty();
	
	/***
	 * Inserts the element at the tail of the list.
	 * 
	 * @param element
	 */
	void insert(T element);
	
	/***
	 * Insert the element at the head of the list
	 * 
	 * @param element
	 */
	void insertAtHead(T element);
	
	/***
	 * Removes the specified element.
	 * 
	 * @param element
	 * @return
	 */
	boolean remove(T element);
	
	/***
	 * Removes element at the specified index.
	 * 
	 * @param index
	 */
	void removeAt(int index);
	
	
	/***
	 * Clears the list by removing all the elements from it.
	 */
	void clear();
	
	/***
	 * Returns an array containing all the elements.
	 * 
	 * @return
	 */
	Object[] toArray();
}
