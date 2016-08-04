package nkher.api;

/***
 * This class represents a generic collection type and has the following methods/behaviours in it.
 *
 * @param <E> A collection of E type elemente. Here E is a raw type.
 */
public interface MyCollection<E> {
	
	/***
	 *
	 * This method returns the size of the collection as an integer value.
	 * 
	 * @return Returns the size of the collection.
	 */
	int size();
	
	/***
	 * This method checks if a collection is empty or not.
	 * A return value of true indicates that the collection is empty.
	 * 
	 * @return
	 */
	boolean isEmpty();
	
	
	/***
	 * This method clears the collection and sets the size to the default capacity.
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
	 * This method checks if a particular element exists in a collection.
	 * 
	 * @param elem Element {@code E} to be checked for existance in the collection.
	 * @return a {@code Boolean} value indicating whether the collections contains the element or not.
	 * 			Return value of true indicates that the element exists.
	 */
	boolean contains(E elem);

	/**
	 * This method adds the element into the collection.
	 *
	 * @param elem Element {@code E} to be added to the collection.
     */
	boolean add(E elem);

	/***
	 * This method removes the element E from the collection. The first instance of the element would be removed.
	 *
	 * @param elem Element {@code E} to be removed.
	 * @return Returns true if the element was removed.
     */
	boolean remove(E elem);
}
