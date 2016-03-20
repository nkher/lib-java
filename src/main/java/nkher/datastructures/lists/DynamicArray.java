package nkher.datastructures.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import nkher.exception.DataStructureEmptyException;
import nkher.interfaces.MyList;
import nkher.utils.ArrayUtility;

/***
 * This class is an implementation of the array class and provides a useful set of API for insertion, deletion, searching of elements and much more. 
 * The implementation is done using an array. The data structure is not thread safe. Synchronization has to be handled by the programmer.
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class DynamicArray<T> implements MyList<T>, Iterable<T> {
	
	public static int DEFAULT_CAPACITY = 10;
	public static int SCALE_FACTOR = 2;
	public static int REDUCE_FACTOR = 2;
	public static int MIN = 0;
	// private static int MAX_SIZE = Integer.MAX_VALUE - 10;
	
	private int size = 0;
	private int capacity;
	private int writeIndex = 0;
	private Object[] data;
	private Random r; // initialized only when needed - lazy initialization
	
	
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
	 * Constructor that initializes the array with an existing DynamicArray.
	 * @param dArray
	 */
	public DynamicArray(DynamicArray<T> dArray) {
		this(DEFAULT_CAPACITY);
		for (T element : dArray) {
			insert(element);
		}
	}
	
	/***
	 * Constructor that initializes the array with an existing List of type {@code java.util.List}.
	 * @param dArray
	 */
	public DynamicArray(List<T> list) {
		this(DEFAULT_CAPACITY);
		for (T element : list) {
			insert(element);
		}
	}
	
	/***
	 * Returns the capacity of the DynamicArray.
	 * @return
	 */
	public int capacity() {
		return this.capacity;
	}
	
	/***
	 * Inserts a new element at the tail of the array.
	 * 
	 * @param element
	 */
	public void insert(T element) {
		if (isFull()) { 
			resize(size * SCALE_FACTOR);
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
			if (data.length > DEFAULT_CAPACITY && data.length > (size * 2) && (data.length/REDUCE_FACTOR > size)) { // resizing appropriately
				resize(data.length/REDUCE_FACTOR);
			}
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
		int copyLength = size - index - 1;
		System.arraycopy(data, index+1, data, index, copyLength);
		writeIndex--;
		size--;
		if (data.length > DEFAULT_CAPACITY && data.length > (size * 2) && (data.length/REDUCE_FACTOR > size)) { // resizing appropriately
			resize(data.length/REDUCE_FACTOR);
		}
	}
	
	/***
	 * Deletes the element from the tail of the dynamic array. 
	 *
	 * @param index
	 * @return
	 */
	public void remove() {
		removeAt(size-1);
	}
	
	public void insertAtHead(T element) {
		if (isFull()) {
			resize(size * SCALE_FACTOR);
		}
		size++;
		if (isFull()) {
			resize(size * SCALE_FACTOR);
		}
		System.arraycopy(data, 0, data, 1, size-1); // shift the elements by 1
		data[0] = element;
		writeIndex++;
	}
	
	private void resize(int new_cap) {
		Object new_data[] = new Object[new_cap];
		
		for (int i=0; i<size; i++) {
			new_data[i] = data[i];
		}
		
		/* Re assign the variables */
		capacity = new_cap;
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
	 * an element is set at an index greater than the array's capacity at that instant.
	 * No shifting is done here. The previous element at this index gets replaced by the new element.
	 * To be able to set an element at an index the array must be of at least the size of the index.
	 * 
	 * @param index
	 * @param element
	 */
	public void replaceAt(int index, T element) {
		if (isEmpty() || index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		data[index] = element;
	}
	
	public int size() {
		return this.size;
	}
	
	public void addAt(int index, T element) {
		if (isEmpty() || index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (isFull()) { resize(size * SCALE_FACTOR); }
		System.arraycopy(data, index, data, index+1, (size-index));
		data[index] = element;
		size++;
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
	 * Returns an object array of all the elements in the dynamic array.
	 * If the array is empty the function returns an empty array. 
	 * 
	 * @return array of {@code Object} type
	 */
	public Object[] toArray() {
		Object[] array;
		if (size == 0) {
			array = new Object[0];
			return array;
		}
		array = new Object[size];
		for (int i=0; i<size; i++) {
			array[i] = data[i];
		}
		return array;
	}
	
	@SuppressWarnings({ "unchecked"})
	public <E> E[] toArray(E[] e) {
		if (e.length < size) {
			return (E[]) Arrays.copyOf(data, size, e.getClass());
		}
		System.arraycopy(data, 0, e, 0, size);
		if (e.length > size)
            e[size] = null;
        return e;
	}
	
	
	/***
	 * Removes all elements from the array by setting each element to null
	 * and sets the capacity to the default capacity and size to zero.
	 */
	public void removeAllElements() {
		for (int i=0; i<size; i++) {
			data[i] = null;
		}
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
	
	/***
	 * Fills the Dynamic Array with the passed array.
	 * This would remove the existing elements from the DArray
	 * 
	 * @param array
	 */
	public void fill(T[] array) {
		if (null == array) return;
		clear(); // clear the dynamic array
		for (int i=0; i<array.length; i++) {
			data[i] = array[i];
			size++;
		}
		writeIndex = size; // adjusting the writeIndex
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> toArrayList() {
		if (size == 0) {
			return new ArrayList<T>();
		}
		ArrayList<T> list = new ArrayList<T>();
		for (int i=0; i<this.size; i++) {
			list.add((T) data[i]);
		}
		return list;
	}
	
	/***
	 * Clears the dynamic array to the initial state.
	 *  by making everything currently in the array to null.
	 * 
	 */
	public void clear() {
		if (size == 0) return;
		for (int i=0; i<size; i++) {
			data[i] = null;
		}
		this.size = 0;
		this.capacity = DEFAULT_CAPACITY;
		this.writeIndex = 0;
		data = new Object[DEFAULT_CAPACITY];
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
	 * Returns the index of the first occurrence of the element from the array.
	 * If the Array is empty then this function throws a DataStructureEmptyException().
	 * If the element is not found then it returns -1.
	 * 
	 * @param elem
	 * @return
	 */
	public int search(T elem) {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot search in an empty array.");
		}
		for (int i=0; i<size; i++) {
			if (data[i].equals(elem)) {
				return i;
			}
		}
		return -1;
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

	public Iterator<T> iterator() {
		return new DIterator();
	}
	
	private class DIterator implements Iterator<T> {

		int currentPointer = 0;
				
		public boolean hasNext() {
			return (currentPointer != size);
		}

		@SuppressWarnings("unchecked")
		public T next() {
			if (!hasNext()) {
				return null; 
			}
			Object[] data = DynamicArray.this.data;
			return (T) data[currentPointer++];
		}
	}
	
	/***
	 * Function to clone this DynamicArray and returned the cloned
	 * copy of the new DynamicArray.
	 * @return
	 */
	public DynamicArray<T> clone() {
		DynamicArray<T> cloneDArr = new DynamicArray<T>(this);
		return cloneDArr;
	}
	
	/***
	 * Returns the a new copy (object) of the DynamicArray reversed.
	 * Returns null if the array was null initially.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DynamicArray<T> getReverseArray() {
		assert this.size > 0 : "DynamicArray is Empty.";
		DynamicArray<T> reversedDArray = new DynamicArray<T>();
		int i = size-1;
		while (i >= 0) {
			reversedDArray.insert((T) data[i]);
			i--;
		}
		return reversedDArray;
	}
	
	/***
	 * Reverses the array in place. If the array is empty nothing happens.
	 * @return
	 */
	public void reverse() {
		assert this.size > 0 : "DynamicArray is Empty.";
		int start = 0, end = size-1;
		while (start <= end) {
			Object temp = data[start];
			data[start] = data[end];
			data[end] = temp;
			start++; end--;
		}
	}
	
	/***
	 * Gets a random element from within the array.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getRandomElement() {
		if (isEmpty()) return null;
		r = new Random();
		int ind = randomNumberInBetweenIncluding(MIN, size-1);
		return (T) data[ind];
	}
	
	/***
	 * Shuffles an array in place.
	 */
	public void shuffle() {
		assert this.size > 0 : "DynamicArray is Empty.";
		r = new Random();
		int ind;
		for (int i=0; i<size; i++) {
			ind = randomNumberInBetweenIncluding(MIN, i);
			ArrayUtility.swap(data, i, ind);
		}
	}
	
	/***
	 * Removes duplicates from the dynamic array and returns only unique elements from the array.
	 * Shrink the array with appropriate conditions.
	 */
	public void uniqueArray() {
		size = ArrayUtility.unique(data);
		if (data.length > DEFAULT_CAPACITY && data.length > (size * 2) && (data.length/REDUCE_FACTOR > size)) { // resizing appropriately
			resize(data.length/REDUCE_FACTOR);
		}
	}

	/***
	 * Utility function get a random number in between a low and a high, including the low and the high.
	 * @param low
	 * @param high
	 * @return
	 */
	private int randomNumberInBetweenIncluding(int low, int high) {
		return r.nextInt(high - low + 1) + low;
	}
}