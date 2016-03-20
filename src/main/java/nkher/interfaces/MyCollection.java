package nkher.interfaces;

public interface MyCollection<T> {
	
	/***
	 * Returns the size of the queue
	 * 
	 * @return
	 */
	int size();
	
	/***
	 * Returns true if the collection is empty else false.
	 * 
	 * @return
	 */
	boolean isEmpty();
	
	
	/***
	 * Clears the dequeue array and sets the size to the default capacity.
	 */
	void clear();
	
	/***
	 * This method returns an array of objects which contain the elements of the underlying 
	 * object. There is no specific order in which the elements are placed/ordered within the 
	 * array. If the underlying data structure itself imposes a gurantee on the ordering then
	 * the array contains elements in the order required. For most collections the order would
	 * be the order of insertions.
	 * 
	 * @return An Object type array containing the values of the underlying collection.
	 */
	Object[] toArray();
	
	/***
	 * A method to check if a particular element exists in a collection.
	 * 
	 * @param elem
	 * @return a {@code Boolean} value indicating whether the collections contains the element or not.
	 * 			True means the element exists.
	 */
	boolean contains(T elem);
}
