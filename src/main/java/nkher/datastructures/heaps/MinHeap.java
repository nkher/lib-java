package nkher.datastructures.heaps;

import java.util.HashMap;

import nkher.datastructures.lists.DynamicArray;
import nkher.exception.DataStructureEmptyException;
import nkher.api.MyHeap;

/****
 * A simple implementation of a MinHeap data structure. This class extends the MyHeap<T>
 * interface and provides useful API for inserting, deleting and searching through
 * the heap all in logarithmic time complexity. It uses a dynamic array internally.
 * This heap is augmented to store keys in a HashMap of the java.util collection. 
 * This helps in having functions like contains in the heap which tells us if the heap contains a particular object.
 * 
 * Time Complexity for insertion and deletion - O(log N)
 * Time Complexity for insertion and deletion - O(N)
 * Time Complexity for building a heap of N elements - O(log N)
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> implements MyHeap<T> {

	private int size;
	private DynamicArray<T> heapArr;
	private HashMap<T, Integer> keys; // maps the keys to their spots in the array
	
	/***
	 * Creates an empty heap.
	 */
	public MinHeap() {
		size = 0;
		heapArr = new DynamicArray<T>();
		keys = new HashMap<T, Integer>();
	}
	
	/***
	 * Creates a heap from the elements of the array. The elements 
	 * from the array are entered into the heap starting from 0 to the last index.
	 * @param dArray - An array of type - {@code DynamicArray<T>}
	 */
	public MinHeap(DynamicArray<T> dArray) {
		
	}
	
	public void insert(T t) {
		size++;
		heapArr.insert(t);
		int ind = size-1;
		keys.put(t, ind);
		
		/** CODE TO SIFT UP */
		/** Now start fixing the max heap property by checking in bottom up manner in the tree */
		while (ind != 0 && heapArr.getAt(ind).compareTo(heapArr.getAt(parent(ind))) < 0) { // until the current node has a value greater than its parent or it is not the root
			swap(ind, parent(ind));
			ind = parent(ind);
		}
	}
	
	/***
	 * Returns the index to the parent of the current node.
	 * @param ind
	 * @return
	 */
	private int parent(int ind) {
		return (ind-1)/2;
	}
	
	/***
	 * Returns the index to the left child of the current node.
	 * @param ind
	 * @return
	 */
	private int left(int ind) {
		return (2*ind + 1);
	}
	
	/***
	 * Returns the index to the right child of the current node.
	 * @param ind
	 * @return
	 */
	private int right(int ind) {
		return (2*ind + 2);
	}

	/****
	 * Returns the element at the head of the heap tree but does not remove it. If the heap does not have any elements then this method returns null.
	 * <br><br>
	 * @return - Element at the root of the heap tree which is of type {@code T}
	 */
	public T peek() {
		if (isEmpty()) return null;
		return heapArr.getAt(0);
	}

	public T remove() {
		return extractMin();
	}
	
	/***
	 * Removes element at the head of the heap tree. If the heap does not have any elements then this method returns null.
	 * <br><br>
	 * @return - Element at the root of the heap tree which is of type {@code T}
	 */
	public T extractMin() {
		if (isEmpty()) return null;
		T root = heapArr.getAt(0);
		heapArr.replaceAt(0, heapArr.getAt(size-1));
		size--;
		minHeapify(0);
		heapArr.removeAt(heapArr.size()-1);
		return root;
	}

	/***
	 * This method is used to remove an element from the heap.
	 * It returns true if the element is successfully found and deleted and
	 * false if not found. If the heap is empty then the function throws a 
	 * DataStructureEmptyException(). <br><br>
	 */
	public boolean remove(T key) {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot delete from empty heap.");
		}
		// Find the node in the heap
		if (!keys.containsKey(key)) { return false; } // element not found
		int ind = keys.get(key);
		
		if (ind == size-1) { // if the element is the last node
			heapArr.removeAt(size-1);
			size--;
			keys.remove(key);
			return true;
		}
		
		/** Replace the node with the last node */
		swap(ind, size-1);
		heapArr.removeAt(size-1); // remove the last element
		size--;
		
		/** Now perform the max-heapify operation */
		minHeapify(ind);
		keys.remove(key);
		
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void clear() {
		size = 0;
		heapArr.clear();
	}
	
	/***
	 * A method used for checking if the heap property is getting violated at any node and fixes it.
	 * This is used when the heap is modified. For example when elements are added or removed from
	 * the heap. <br><br>
	 * 
	 * @param index
	 */
	private void minHeapify(int index) {
		int left = left(index);
		int right = right(index);
		int smallest = index;
		
		while (left < size && (heapArr.getAt(left).compareTo(heapArr.getAt(smallest)) < 0)) {
			smallest = left;
		}
		
		while (right < size && (heapArr.getAt(right).compareTo(heapArr.getAt(smallest)) < 0)) {
			smallest = right;
		}
		
		if (smallest != index) {
			swap(smallest, index);
			minHeapify(smallest);
		}
	}
	
	/***
	 * A utility function to swap to elements in the heap.
	 * @param ind1
	 * @param ind2
	 */
	private void swap(int ind1, int ind2) {
		swapKeyIndices(heapArr.getAt(ind1), heapArr.getAt(ind2));
		T temp = heapArr.getAt(ind1);
		heapArr.replaceAt(ind1, heapArr.getAt(ind2));
		heapArr.replaceAt(ind2, temp);
	}
	
	/***
	 * Utility method to swap indices in the keys hashmap when ever swap happens
	 * within the main heap data structure.
	 * 
	 * @param ind1
	 * @param ind2
	 */
	private void swapKeyIndices(T e1, T e2) {
		int ind_e1 = keys.get(e1);
		int ind_e2 = keys.get(e2);
		keys.put(e1, ind_e2);
		keys.put(e2, ind_e1);
	}
	
	/***
	 * A function to check if the key is present in the heap or not.
	 * 
	 * @param key
	 * @return
	 */
	public boolean contains(T key) {
		return keys.containsKey(key);
	}

	@Override
	public boolean add(T elem) {
		return true;
	}

	public Object[] toArray() {
		return heapArr.toArray();
	}
}
