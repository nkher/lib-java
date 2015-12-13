package nkher.datastructures.queues;

import java.util.Iterator;

import nkher.Interfaces.MyQueue;
import nkher.exception.DataStructureEmptyException;

/***
 * A simple array based implementation of the Queue Data Structure. Exposes a nice API
 * for manipulating the queue and using it under different use cases and scenarios. It 
 * implements the MyQueue<T> interface that exposes standard queue functions. It uses
 * an Object array from within for the same purpose. In this implementation an element
 * is added through the rear pointer and deleted from the front pointer. At the start the
 * read and front both point to zero. At any point of time the rear points to the index 
 * in the array[] where an element is to be added. Once the element is added into the 
 * array the pointers rear and front are incremented using appropriate logic. 
 * 
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class QueueArray<T> implements MyQueue<T>, Iterable<T> {
	
	public static final int DEFAULT_CAPACITY = 10;
	public static final int k_SCALE_FACTOR = 3; // will increase storage by 3 times
	public static final int k_REDUCE_FACTOR = 2; // will reduce the storage by 2 times
	
	private int size;
	private int capacity;
	private Object data[];
	private int front = 0, rear = 0;
	
	public QueueArray() {
		size = 0;
		capacity = DEFAULT_CAPACITY;
		initQueueArray(DEFAULT_CAPACITY);
	}
	
	public QueueArray(QueueArray<T> qa) {
		this.size = qa.size;
		initQueueArray(size);
		for (T elem : qa) {
			enqueue(elem);
		}
	}
	
	private void initQueueArray(int size) {
		data = new Object[size];
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return capacity;
	}

	@SuppressWarnings("unchecked")
	public T head() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot get head of an empty queue");
		}
		return (T) data[front];
	}
	
	@SuppressWarnings("unchecked")
	public T tail() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot get tail of an empty queue");
		}
		if (rear == 0 && size > 0) {
			return (T) data[size-1];
		}
		return (T) data[rear-1];
	}

	/***
	 * Removes and returns the element at the head of the queue.
	 * Follows the FIFO principle where the element that came in first
	 * goes out first.
	 */
	public T dequeue() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty queue");
		}
		@SuppressWarnings("unchecked")
		T ret = (T) data[front];
		front = (front+1) % data.length;
		size--;
		if (data.length > DEFAULT_CAPACITY && data.length > (size * 2) && (data.length/k_REDUCE_FACTOR > size)) {
			resize(data.length/k_REDUCE_FACTOR);
		}
		return ret;
	}
	
	/***
	 * Returns the element at the head of the queue without removing it.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot peek from an empty queue.");
		}
		return (T) data[front];
	}

	public void enqueue(T element) {
		if (isFull()) {
			resize(data.length * k_SCALE_FACTOR);
		}
		size++;
		//System.out.println("rear : " + rear + ", front : " + front);
		data[rear] = element;
		rear = (rear+1) % data.length;
	}
	
	private boolean isFull() {
		return (size == data.length);		
	}
	
	/***
	 * We grow when </br>
	 * 	1. The size of the array equals the length of the Object Array	
	 * We shrink when</br>
	 * 	1. The object array is greater than the defined DEFAULT_CAPACITY </br>
	 * 	2. The number of elements are less than half the capacity of the Object array.</br>
	 */
	private void resize(int new_cap) {
		Object new_data[] = new Object[new_cap];		
		int i;
		/* Fill the data */
		int ind = 0;
		if (front < rear) {
			for (i=front; i<rear; i++) {
				new_data[ind++] = data[i];
			}
		}
		else {
			for (i=front; i<data.length; i++) {
				new_data[ind++] = data[i];
			}
			for (i=0; i<rear; i++) {
				new_data[ind++] = data[i];
			}
		}
		data = new_data;
		front = 0;
		rear = size;
		capacity = new_cap;
	}
	

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public String toString() {
		if (isEmpty()) {
			return "[ ]";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		sb.append("[ ");
		if (front < rear) {
			for (i=front; i<rear-1; i++) {
				sb.append(data[i] + ", ");
			}
			sb.append(data[i]);
		}
		else {
			for (i=front; i<data.length-1; i++) {
				sb.append(data[i] + ", ");
			}
			
			sb = (rear == 0) ? sb.append(data[i]) : sb.append(data[i] + ", ");
			
			if (rear > 0) {
				for (i=0; i<rear-1; i++) {
					sb.append(data[i] + ", ");
				}
				sb.append(data[i]);
			}
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	public Object[] toArray() {
		Object[] array;
		if (isEmpty()) {
			array = new Object[1];
			return array;
		}
		array = new  Object[size];
		int i, ind = 0;		
		if (front < rear) {
			for (i=front;i<rear; i++) {
				array[ind++] = data[i];
			}
		}
		else {
			for (i=front; i<data.length; i++) {
				array[ind++] = data[i];
			}
			for (i=0; i<rear; i++) {
				array[ind++] = data[i];
			}
		}
		return array;
	}
	
	public void clear() {
		initQueueArray(DEFAULT_CAPACITY);
		this.size = 0;
		front = rear = 0;
	}

	public Iterator<T> iterator() {
		return new QIterator();
	}
	
	private class QIterator implements Iterator<T> {
		
		private int ind = 0;
		private int currentFront = QueueArray.this.front;
		private int currentRear = QueueArray.this.rear;
		private Object[] data = QueueArray.this.data;
		private T t;
		
		public boolean hasNext() {
			return (ind != size);
		}

		@SuppressWarnings("unchecked")
		public T next() {
			if (!hasNext()) {
				return null;
			}
			
			if (currentFront < currentRear) {
				t = (T) data[currentFront++];
			}
			else {
				if (currentFront < data.length) {
					t = (T) data[currentFront++];
				}
				else {
					t = (T) data[currentRear++];
				}
			}
			ind++;
			return t;
		}
		
	}
	
	/***
	 * Function to swap the contents of this queue with the passed queue.
	 */
	public void swap(QueueArray<T> queue) {
		if (null == queue) {
			throw new IllegalArgumentException("Cannot swap with a non initialized queue.");
		}
		QueueArray<T> temp = new QueueArray<T>(queue);
		queue = this;
		copy(temp);
	}
	
	/*** 
	 * Copies another queue into this queue.
	 * @param q
	 */
	private void copy(QueueArray<T> q) {
		this.data = q.data;
		this.front = q.front;
		this.rear = q.rear;
		this.size = q.size;
	}
	
	public QueueArray<T> clone(QueueArray<T> queue) {
		QueueArray<T> clonedQueue = new QueueArray<T>(queue);
		return clonedQueue;
	}	
}





