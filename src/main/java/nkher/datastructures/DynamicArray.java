package nkher.datastructures;

import java.util.ArrayList;
import java.util.List;

import nkher.Interfaces.MyList;
import nkher.exception.DataStructureEmptyException;

/***
 * This class is an implementation of the array class and provides a useful set of API for insertion, deletion, searching of elements and much more. 
 * The implementation is done using an array. The data structure is not thread safe. Synchronization has to be handled by the programmer.
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class DynamicArray<T> implements MyList<T> {
	
	public static int DEFAULT_CAPACITY = 10;
	public static int SCALE_FACTOR = 2;
	private static int MAX_SIZE = Integer.MAX_VALUE - 10;
	
	private int size = 0;
	private int capacity;
	private int writeIndex = 0;
	private Object[] data;
	
	
	/***
	 * Creates an empty array with default capacity as 10.
	 */
	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}
	
	/***
	 * Constructor that creates and empty array of size = capacity
	 * 
	 * @param capacity
	 */
	public DynamicArray(int capacity) {
		this.capacity = capacity;
		this.data = new Object[capacity];
	}
	
	/***
	 * Constructor that initializes the array with an existing array.
	 * 
	 * @param data
	 */
	public DynamicArray(T[] data) {
		this.data = data;
		this.size = data.length;
	}
	
	/***
	 * Inserts a new element at the tail of the array.
	 * 
	 * @param element
	 */
	public void insert(T element) {
		if (isFull()) { 
			resize();
		}
		data[writeIndex++] = element;
		size++;
	}
	
	/***
	 * Deletes the first occurrence of the specified element from the array. 
	 * Returns true if deletion was successful and false if no element was deleted.
	 * 
	 * @param element
	 * @return
	 */
	public boolean remove(T element) {
		if (isEmpty()) {
			throw new DataStructureEmptyException();
		}
		
		int ind = -1;
		boolean found = false;
		for (int i=0; i<size; i++) {
			if (data[i].equals(element)) {
				found = true; // element found
				ind = i;
				break;
			}
		}
		if (found) {
			removeAt(ind);
			writeIndex--;
			size--;
			return true;
		}
		return false;
	}
	
	/***
	 * Deletes the element at the specified index from the dynamic array. 
	 * Returns true if deletion was successful and false if no element was deleted.
	 *
	 * @param index
	 * @return
	 */
	public void removeAt(int index) throws ArrayIndexOutOfBoundsException {
		if (isEmpty() || index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int copyLength = size - index + 1;
		System.arraycopy(data, index+1, data, index, copyLength);
		writeIndex--;
		size--;
	}
	
	public void insertAtHead(T element) {
		if (isFull()) {
			resize();
		}
		size++;
		if (isFull()) {
			resize();
		}
		System.arraycopy(data, 0, data, 1, size-1); // shift the elements by 1
		data[0] = element;
		writeIndex++;
	}
	
	private void resize() {
		int new_capacity = this.size * SCALE_FACTOR;
		Object new_data[] = new Object[new_capacity];
		
		for (int i=0; i<size; i++) {
			new_data[i] = data[i];
		}
		
		/* Re assign the variables */
		capacity = new_capacity;
		data = new_data;
	}
	
	/***
	 * Gets the element at the specified index from the dynamic array.
	 * 
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getAt(int index) {
		if (isEmpty() || index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return (T) data[index];
	}
	
	/***
	 * Sets the element at the specified index in the dynamic array. Throws index-out-of-bounds if 
	 * an element is set at an index greater than the vectors capacity at that instant.
	 * To be able to set an element at an index the array must be of at least the size of the index.
	 * 
	 * @param index
	 * @param element
	 */
	public void setAt(int index, T element) {
		if (isEmpty() || index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		data[index] = element;
	}
	
	public int size() {
		return this.size;
	}
	
	
	/***
	 * Returns the last occurrence index of the element that is passed to the function.
	 * Throws VectorEmptyException is the dynamic array is empty.
	 * 
	 * @param element
	 * @return
	 */
	public int lastIndexOf(T element) {
		int lastIndex = -1;
		if (isEmpty()) {
			throw new DataStructureEmptyException();
		}
		
		for (int i=0; i<size; i++) {
			if (data[i].equals(element)) {
				lastIndex = i;
			}
		}
		return lastIndex;
	}
	
	/***
	 * 
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> subList(int fromIndex, int toIndex) {
		if (fromIndex > size-1) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds at fromIndex : " + fromIndex);
		}
		if (toIndex > size-1) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds at toIndex : " + toIndex);
		}
				
		List<T> list = new ArrayList<T>(toIndex - fromIndex);
		for (int i=fromIndex; i<=toIndex; i++) {
			list.add((T) data[i]);
		}
		
		return list;
	}
	
	/***
	 * Returns the last element in the dynamic array else throws empty array exception.
	 * 
	 * @return last element of the array
	 */
	
	public T getLast() {
		return getAt(this.size-1);
	}
	
	/***
	 * Returns the first element in the dynamic array else throws empty array exception.
	 * 
	 * @return first element of array
	 */
	public T getFirst() {
		return getAt(0);
	}
	
	/***
	 * Returns an array of all the elements in the dynamic array.
	 * If the array is empty the function returns an empty array. 
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		Object[] array;
		if (size == 0) {
			array = new Object[0];
			return (T[]) array;
		}
		array = new Object[size];
		for (int i=0; i<size; i++) {
			array[i] = data[i];
		}
		return (T[]) array;
	}
	
	/***
	 * Removes all elements from the array by setting each element to null
	 * and sets the capacity to the default capacity and size to zero.
	 */
	public void removeAllElements() {
		if (isEmpty()) {
			throw new DataStructureEmptyException();
		}
		for (int i=0; i<size; i++) {
			data[i] = null;
		}
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
 	
	/***
	 * Checks if the array is full. 
	 * Returns true if yes and false if not empty. this function is used for internal resizing purposes.
	 * 
	 * @return
	 */
	private boolean isFull() {
		return this.size == this.capacity;
	}
	
	/***
	 * Checks if the array is empty.
	 * Returns true if yes and false if not empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	public String toString() {
		if (isEmpty()) {
			return "[ ]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i=0; i<size; i++) {
			if (i <= size-2) sb.append(data[i].toString() + ", ");
			else sb.append(data[i].toString());	 
		}
		sb.append("]");
		return sb.toString();
	}
	
}
