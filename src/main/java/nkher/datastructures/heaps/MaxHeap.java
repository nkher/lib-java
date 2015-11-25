package nkher.datastructures.heaps;

import nkher.Interfaces.MyHeap;
import nkher.datastructures.lists.DynamicArray;

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
	
	public T extractMax() {
		if (isEmpty()) return null;
		if (size == 1) {
			size--;
			return heapArr.getAt(0);
		}
		T root = heapArr.getAt(0);
		heapArr.setAt(0, heapArr.getAt(size-1));
		size--;
		maxHeapify(0);
		
		return root;
	}

	public T peek() {
		if (isEmpty()) return null;
		else return heapArr.getAt(0);
	}

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

	public void clear() {
		
	}
	
	private int parent(int ind) {
		return (ind-1)/2;
	}
	
	private int left(int ind) {
		return (2*ind + 1);
	}
	
	private int right(int ind) {
		return (2*ind + 2);
	}
	
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
	
	private void swap(int ind1, int ind2) {
		T temp = heapArr.getAt(ind1);
		heapArr.setAt(ind1, heapArr.getAt(ind2));
		heapArr.setAt(ind2, temp);
	}
}
