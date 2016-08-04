package nkher.datastructures.map;

import java.util.LinkedList;
import java.util.Queue;

import nkher.api.MyMap;

/***
 * An implementation of a HashMap that uses the SeparateChaining method for resolving collisions.
 * The API is very simple and it basically is similar to the API of java.util.HashMap. It uses a 
 * Singly Linked List from within which stores key value pairs and each bucket or index within this
 * implementation is a Singly Linked List of such a type.
 * 
 * @author nameshkher
 *
 * @param <K>
 * @param <V>
 */
public class HashMapSC<K, V> implements MyMap<K, V>{
	
	private static final int DEFAULT_CAP = 10;
	
	private int M; // size of the table
	private int N; // number of key value pairs in the hashmap
	private int mask = 0x7fffffff;
	private HashLinkedList<K, V>[] table;
	
	public HashMapSC() {
		this(DEFAULT_CAP);
	}
	
	@SuppressWarnings("unchecked")
	public HashMapSC(int capacity) {
		this.M = capacity;
		table = new HashLinkedList[capacity];
		for (int i=0; i<capacity; i++) {
			table[i] = new HashLinkedList<K, V>();
		}
	}
	
	public int size() {
		return N;
	}

	public void put(K key, V value) {
		if (value == null) {
			remove(key);
			return;
		}
		int index = hash(key);
		if (!table[index].contains(key)) N++; // important step
		table[index].insert(key, value);
		// resizing if load factor is greater than 10
		if (N/M >= 10) resize(2 * M);
	}
	
	/***
	 * Utility function to resize the array, hence maintaining the load factor.
	 */
	private void resize(int size) {
		HashMapSC<K, V> new_map = new HashMapSC<K, V>(size);
		for (int i=0; i<M; i++) { // go over each bucket
			for (K key : table[i].keys()) { // go over each key within the bucket
				new_map.put(key, table[i].get(key));
			}
		}
		/** Do the reference changing for M, N and table */
		this.M = new_map.M;
		this.N = new_map.N;
		this.table = new_map.table;
	}

	/***
	 * Function to get a value from the table of the key that is passed to the function
	 * is present in the hashmap. The function returns null if the key is not present in the hashmap.
	 * 
	 */
	public V get(K key) {
		int index = hash(key);
		return table[index].get(key);
	}
	
	public boolean contains(K key) {
		return (get(key) == null);
	}

	public void remove(K key) {
		int index = hash(key);
		if (table[index].contains(key)) N--;  // reduce the key value pairs only if the hashmap contains the particular key 
		table[index].delete(key);
		// downsize if the load factor is less than 3
		if (M > DEFAULT_CAP && N/M < 3) resize(M/2);
	}
	
	/***
	 * A quick version that does a slight modification of the simple division 
	 * method used for hashing. The Max Integer value is used as the mask over the
	 * hashcode of the key which is calculated using java's hashcode method.
	 * This value is mapped to the size of the table by dividing it with M and
	 * getting the remainder.
	 * 
	 * @param key
	 * @return
	 */
	private int hash(K key) {
		return (key.hashCode() & mask) % M;
	}

	public boolean isEmpty() {
		return (N == 0);
	}

	public boolean containsKey(K key) {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		this.N = 0;
		this.M = DEFAULT_CAP;
		this.table = new HashLinkedList[M];
		for (int i=0; i<M; i++) {
			table[i] = new HashLinkedList<K, V>();
		}
	}
	
	/***
	 * A function to return all the keys within the hashmap. It iterates over all the keys and
	 * adds them to a queue of type {@code java.util.queue} which implements the Iterable 
	 * interface in java.
	 * 
	 * @return
	 */
	public Iterable<K> keySet() {
		Queue<K> queue = new LinkedList<K>();
		for (int i=0; i<M; i++) {
			for (K key : table[i].keys()) {
				queue.add(key);
			}
		}
		return queue;
	}
	
	// to fix
	public String toString() {
		if (isEmpty()) return "[ ]";
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		int i;
		for (i=0; i<M; i++) {
			if (!table[i].isEmpty()) {
				sb.append(table[i].toString());
				sb.append("\n"); // append a new line
			}
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	public double loadFactor() {
		return (N / M);
	}
}
