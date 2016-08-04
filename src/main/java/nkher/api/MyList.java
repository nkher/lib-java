package nkher.api;

public interface MyList<T> extends MyCollection<T> {
	
	
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
	
}
