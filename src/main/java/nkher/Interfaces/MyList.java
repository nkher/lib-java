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
	 * Insert the element at the head of the list
	 * 
	 * @param element
	 */
	void insertAtHead(T element);
	
	/***
	 * Gets the element at the specified index.
	 * 
	 * @param index
	 * @return
	 */
	T getAt(int index);
	
	/***
	 * Sets the passed element at the specified index.
	 * 
	 * @param index
	 * @param element
	 */
	void setAt(int index, T element);
	
}
