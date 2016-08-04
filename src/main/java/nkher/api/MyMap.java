package nkher.api;

public interface MyMap<K, V> {
	
	
	/***
	 * Function to add a key and a value into the map
	 * 
	 * @param key
	 * @param value
	 */
	void put(K key, V value);
	
	/***
	 * Function to get the value for the associated key.
	 * 
	 * @param key of type {@code K}
	 * @return value of type {@code V}
	 */
	V get(K key);
	
	/***
	 * Function to check if the map is empty.
	 * 
	 * @return true if the map is empty else false
	 */
	boolean isEmpty();
	
	/***
	 * Returns the size of the map.
	 * @return
	 */
	int size();
	
	/***
	 * Function to check if the map contains the passed key
	 * 
	 * @param key of type {@code K}
	 * @return true if key is present in the map else false
	 */
	boolean containsKey(K key);
	
	/***
	 * A function for clearing all the key value pairs from the hashmap.
	 */
	void clear();
	
	/***
	 * Removes the key and value for the passed key from the hashmap.
	 * @param key
	 */
	void remove(K key);
	
	/***
	 * A method to get all the keys from the hashmap in an iterable collction.
	 * @return
	 */
	Iterable<K> keySet();
}
