package nkher.interfaces;

/***
 * An interface that defines the methods for a randomized binary search tree called the Treap.
 * An ADT for a {@code Treap} data structure.
 * 
 * @author nameshkher
 *
 * @param <K> - Key on which the search tree is ordered.
 * @param <V> - Value of the treap node.
 * The concrete implementation would include a random numeric value that determines the priority of insertion for the treap.
 */
public interface MyTreap<K, V> {
	
	/**
	 * A method to insert a Key, Value into the treap.
	 * 
	 * @param key - Key of type {@code K}
	 * @param val - Value of type {@code V}
	 */
	void insert(K key, V val);
	
	/***
	 * A method to remove a treap node from the treap where key is the passed key.
	 * 
	 * @param key - Key of type {@code K}
	 */
	void remove(K key);
	
	/***
	 * A method to check if a particular treap node exists in the treap based on the key.
	 * 
	 * @param key - Key of type {@code K}
	 * @return - A {@code boolean} value
	 */
	boolean exists(K key);
	
	/**
	 * A method to return the smallest key in the treap.
	 * 
	 * @return - A {@code K} value
	 */
	K minKey();
	
	/**
	 * A method to return the smallest value in the treap.
	 * 
	 * @return - A {@code V} value
	 */
	V minVal();
	
	/**
	 * A method to return the largest key in the treap.
	 * 
	 * @return - A {@code K} value
	 */
	K maxKey();
	
	/**
	 * A method to return the largest value in the treap.
	 * 
	 * @return - A {@code V} value
	 */
	V maxVal();
	
	/***
	 * A method the clear the treap and remove all the elements from it.
	 */
	void clear();
	
	/***
	 * A method that returns the size of the treap.
	 * 
	 * @return  - A {@code int} value
	 */
	int size();
	
	/***
	 * A method to check if the treap is empty. Returns true if empty, else false.
	 * 
	 * @return - A {@code boolean} value
	 */
	boolean isEmpty();
}
