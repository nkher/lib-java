package nkher.datastructures.map;

import java.util.LinkedList;
import java.util.Queue;

import nkher.interfaces.MyMap;

/***
 * An implementation of a HashMap that uses the LinearProbing method for resolving collisions.
 * The API is very simple and it basically is similar to the API of java.util.HashMap. It uses a 
 * Singly Linked List from within which stores key value pairs and each bucket or index within this
 * implementation is a Singly Linked List of such a type.
 * 
 * @author nameshkher
 *
 * @param <K>
 * @param <V>
 */
public class HashMapLP<K, V> implements MyMap<K, V> {

	private static final int DEFAULT_CAP = 10;
	private int N; // total number of key value pairs 
	private int M; // total table size
	private K[] keys; // array of keys 
	private V[] values; // array of values
	
	private int mask = 0x7fffffff; // for getting the hashcode and masking against it
	
	public HashMapLP() {
		this(DEFAULT_CAP);
	}
	
	@SuppressWarnings("unchecked")
	public HashMapLP(int capacity) {
		M = capacity;
		keys = (K[]) new Object[M];
		values = (V[]) new Object[M];
	}
	
	
	@Override
	public void put(K key, V value) {
		if (value == null) {
			remove(key);
			return;
		}
		/** Checking the size of the table and increase if needed */
		if (N > M / 2) { // increasing when the table is half full
			resize(2*M);
		}
		int i;
		for (i=hash(key); keys[i]!=null; i=(i+1)%M) {
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	@Override
	public V get(K key) {
		int i;
		for (i=hash(key); keys[i] != null; i=(i+1)%M) {
			if (keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public boolean containsKey(K key) {
		return get(key) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		N = 0;
		M = DEFAULT_CAP;
		keys = (K[]) new Object[M];
		values = (V[]) new Object[M];
	}
	
	@Override
	public void remove(K key) {
		if (!containsKey(key)) {
			return;
		}
		int index;
		for (index = hash(key); keys[index] != null; index = (index+1)%M) {
			if (keys[index].equals(key)) break; // found key in table
		}
		
		keys[index] = null;
		values[index] = null;
		
		/** Performing rehashing of all the keys in the same cluster */
		index = (index+1)%M;
		while (keys[index] != null) {
			K tempKey = keys[index];
			V tempValue = values[index];
			keys[index] = null;
			values[index] = null;
			N--;
			put(tempKey, tempValue); // put the key and value again
			index = (index+1)%M;
		}
		N--; // decreasing the table size
		if (N > 0 && N < M/6) { // downsizing policy can be subjective
			resize(M/2);
		}
	}
	
	@Override
	public Iterable<K> keySet() {
		Queue<K> iterable = new LinkedList<K>();
		for (int i=0; i<M; i++) {
			if (keys[i] != null) {
				iterable.add(keys[i]);
			}
		}
		return iterable;
	}
	
	/** Using a simple hashing function here - java's hashCode() */
	private int hash(K key) {
		return (key.hashCode() & mask) % M;
	}
	
	private void resize(int newsize) {
		HashMapLP<K, V> temp = new HashMapLP<>(newsize);
		for (int i=0; i<M; i++) {
			if (keys[i] != null) {
				temp.put(keys[i], values[i]);
			}
		}
		keys = temp.keys;
		values = temp.values;
		M = temp.M;
	}
}
