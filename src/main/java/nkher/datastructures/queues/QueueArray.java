package nkher.datastructures.queues;

import java.util.Iterator;

import nkher.Interfaces.MyQueue;
import nkher.exception.DataStructureEmptyException;

/***
 * A simple array based implementation of the Queue Data Structure. Exposes a nice API
 * for manipulating the queue and using it under different use cases and scenarios. It 
 * implements the MyQueue<T> interface that exposes standard queue functions. It uses
 * an Object array from within for the same purpose.
 * 
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class QueueArray<T> implements MyQueue<T>, Iterable<T> {
	
	public static final int DEFAULT_CAPACITY = 10;
	public static final int k_SCALE_FACTOR = 3; // will increase storage by 3 times
	
	private int size;
	private Object data[];
	private int front = 0, rear = 0;
	
	public QueueArray() {
		size = 0;
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
		return (T) data[rear];
	}

	/***
	 * Removes and returns the element at the head of the queue.
	 */
	public T dequeue() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty queue");
		}
		@SuppressWarnings("unchecked")
		T ret = (T) data[front];
		front = (front+1) % data.length;
		size--;
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
			resize();
		}
		size++;
		data[rear] = element;
		rear = (rear+1) % data.length;
	}
	
	private boolean isFull() {
		return (rear == data.length-1);		
	}
	
	private void resize() {
		int new_cap = size * k_SCALE_FACTOR;
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
			for (i=rear; i<front; i++) {
				new_data[ind++] = data[i];
			}
		}
		data = new_data;
		front = 0;
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
			for (i=front; i<data.length; i++) {
				sb.append(data[i] + ", ");
			}
			for (i=rear; i<front-1; i++) {
				sb.append(data[i] + ", ");
			}
			sb.append(data[i]);
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
			for (i=front;i<data.length; i++) {
				array[ind++] = data[i];
			}
		}
		else {
			for (i=front; i<data.length; i++) {
				array[ind++] = data[i];
			}
			for (i=rear; i<front; i++) {
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
	

}
