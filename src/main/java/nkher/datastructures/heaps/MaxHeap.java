package nkher.datastructures.heaps;

import nkher.Interfaces.MyHeap;
import nkher.datastructures.lists.DynamicArray;

/****
 * A simple implementation of a MaxHeap data structure. This class extends the MyHeap<T>
 * interface and provides useful api() for inserting, deleting and searching through
 * the heap all in logarithmic time complexity.
 * 
 * Time Complexity - O(log N)
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> implements MyHeap<T> {

	private int size;
	DynamicArray<T> heapArr;
	
	/***
	 * Creates an empty heap.
	 */
	public MaxHeap() {
		size = 0;
		heapArr = new DynamicArray<T>();
	}
	
	/***
	 * Creates a heap from the elements of the array. The elements 
	 * from the array are entered into the heap starting from 0 to the last index.
	 * @param dArray - An array of type - {@code DynamicArray<T>}
	 */
	public MaxHeap(DynamicArray<T> dArray) {
		this.size = dArray.size();
	}
	
	public void insert(T t) {
		size++;
		heapArr.insert(t); // insert the element in the array
		int ind = size-1;
		
		/** Now start fixing the max heap property by checking in bottom up manner in the tree */
		while (ind != 0 && heapArr.getAt(parent(ind)).compareTo(heapArr.getAt(ind)) < 0) { // until the parent has a value lesses than the child
			swap(ind, parent(ind)); // swap at the current index and its parent index and make the parent as the current
			ind = parent(ind); 
		}
	}
	
	/***
	 * Removes element at the head of the heap tree. If the heap does not have any elements then this method returns null.
	 * <br><br>
	 * @return - Element at the root of the heap tree which is of type {@code T}
	 */
	public T extractMax() {
		if (isEmpty()) return null;
		T root = heapArr.getAt(0);
		heapArr.setAt(0, heapArr.getAt(size-1));
		size--;
		maxHeapify(0);
		heapArr.removeAt(heapArr.size()-1);
		
		return root;
	}

	/****
	 * Returns the element at the head of the heap tree but does not remove it. If the heap does not have any elements then this method returns null.
	 * <br><br>
	 * @return - Element at the root of the heap tree which is of type {@code T}
	 */
	public T peek() {
		if (isEmpty()) return null;
		else return heapArr.getAt(0);
	}

	/***
	 * Removes the root of the heap tree. Works similar to the extract max function.
	 */
	public T remove() {
		return extractMax();
	}
	
	public T remove(T key) {
		return null;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}

	/***
	 * Clears all the elements in the heap and resets heap size to 0.
	 */
	public void clear() {
		heapArr.clear();
		this.size = 0;
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
	
	/***
	 * A method used for checking if the heap property is getting violated at any node and fixes it.
	 * This is used when the heap is modified. For example when elements are added or removed from
	 * the heap. <br><br>
	 * 
	 * @param index
	 */
	private void maxHeapify(int index) {
		int left = left(index);
		int right = right(index);
		int largest = index;
		
		while (left  < this.size && ( heapArr.getAt(left).compareTo(heapArr.getAt(largest)) > 0 )) {
			largest = left;
		}
		
		while (right < this.size && ( heapArr.getAt(right).compareTo(heapArr.getAt(largest)) > 0)) {
			largest = right;
		}
		
		if (largest != index) {
			swap(largest, index);
			maxHeapify(largest);
		}
	}
	
	/***
	 * A utility function to swap to elements in the heap.
	 * @param ind1
	 * @param ind2
	 */
	private void swap(int ind1, int ind2) {
		T temp = heapArr.getAt(ind1);
		heapArr.setAt(ind1, heapArr.getAt(ind2));
		heapArr.setAt(ind2, temp);
	}
	
	public String toString() {
		return heapArr.toString();
	}
}
