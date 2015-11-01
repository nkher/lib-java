package nkher;

public class Vector<T> {
	
	public static int DEFAULT_CAPACITY = 10;
	public static int SCALE_FACTOR = 2;
	private static int MAX_SIZE = Integer.MAX_VALUE - 10;
	
	private int size = 0;
	private int capacity;
	private int writeIndex = 0;
	private Object[] data;
	
	
	/***
	 * Creates an empty vector with default capacity. 
	 * Default capacity is set to 10.
	 */
	public Vector() {
		this(DEFAULT_CAPACITY);
	}
	
	/***
	 * Constructor that creates and empty vector of size = capacity
	 * 
	 * @param capacity
	 */
	public Vector(int capacity) {
		this.capacity = capacity;
		this.data = new Object[capacity];
	}
	
	/***
	 * Constructor that initializes the vector with an existing vector.
	 * 
	 * @param data
	 */
	public Vector(T[] data) {
		this.data = data;
		this.size = data.length;
	}
	
	/***
	 * Inserts a new element at the tail of the vector.
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
	
	public void remove(T element) {
		
	}
	
	public boolean removeAt(int index) {
		if (isEmpty() || this.size < index+1) {
			return false;
		}
		// not done .. to be completed
		return true;
	}
	
	public void insertAtHead() {
		
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
	
	public T getElementAt(int index) {
		return null;
	}
	
	public void setElementAt(int index) {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isFull() {
		return this.size == this.capacity;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}

	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i=0; i<size; i++) {
			sb.append(data[i].toString() + " ");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
