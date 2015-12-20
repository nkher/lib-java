package nkher.datastructures.map;

import java.util.LinkedList;
import java.util.Queue;

/****
 * This is an implementation of a Linked List which has key value pair 
 * within it and used for the building the Separate Chaining HashMaps.
 * This is essentially the structure that is stored in a bucket inside
 * the Sequential Search HashMap.
 * 
 * @author nameshkher
 *
 * @param <K>
 * @param <V>
 */
public class HashLinkedList<K, V> {
	
	private int N; // number of key value pairs
	private HashListNode start; // the head of this linked list
	
	private class HashListNode {
		private K key;
		private V value;
		private HashListNode next;
		
		public HashListNode(K key, V value, HashListNode next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public String toString() {
			return "[key->" + key.toString() + ",val->" + value + "]";
		}
	}
	
	public HashLinkedList() {} // default cons
	
	public int size() {
		return N;
	}
	
	/***
	 * Function to get the value of a particular key.
	 * This does a sequential search of the linked list.
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		HashListNode temp = start;
		while (temp != null) {
			if (temp.key.equals(key)) return temp.value;
			temp = temp.next;
		}
		return null;
	}
	
	/***
	 * Searches for the element in the linked list and returns true if found else false.
	 * @param key
	 * @return
	 */
	public boolean contains(K key) {
		return (get(key) != null);
	}
	
	/***
	 * A function to insert an element at the tail of the Hash linked list.
	 * 
	 * @param key
	 * @param value
	 */
	public void insert(K key, V value) {
		if (value == null) { // if value is null then remove the key from the linked list
			delete(key);
			return;
		}
		HashListNode temp = start;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new HashListNode(key, value, null);
	}
	
	/***
	 * A function to delete a key from the HashLinkedList.
	 * 
	 * @param key
	 */
	public void delete(K key) {
		HashListNode temp = start, prev = null;
		while (temp != null) {
			if (temp.key.equals(key)) {
				if (temp == start) {
					start = start.next;
					return;
				}
				else {
					prev.next = temp.next;
				}
			}
			prev = temp;
			temp = temp.next;
		}
	}
	
	public boolean isEmpty() {
		return (N == 0);
	}
	
	/***
	 * Returns the keys for this bucket.
	 * @return
	 */
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedList<K>();
		HashListNode temp = start;
		while (temp != null) {
			queue.add(temp.key);
			temp = temp.next;
		}
		return queue;
	}
	
	public String toString() {
		if (size() == 0) {
			return "{ }";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		HashListNode temp = start;
		while (temp != null) {
			sb.append(temp.toString() + " ");
		}
		sb.append("}");
		return sb.toString();
	}
}
