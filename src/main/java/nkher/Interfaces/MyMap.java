package nkher.Interfaces;

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
	 * Function to check if the map contains the passed key
	 * 
	 * @param key of type {@code K}
	 * @return true if key is present in the map else false
	 */
	boolean containsKey(K key);
	
	
}
