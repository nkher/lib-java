package nkher.datastructures.queues;

import java.util.Iterator;

import nkher.Interfaces.MyQueue;
import nkher.datastructures.lists.DynamicArray;
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
	
	private int size;
	private Object data[];
	private int head = 0, tail = 0;
	
	public QueueArray() {
		size = 0;
		initQueueArray();
	}
	
	public QueueArray(QueueArray<T> qa) {
		this.size = qa.size;
		data = new Object[size];
		for (T elem : qa) {
			enqueue(elem);
		}
	}
	
	private void initQueueArray() {
		data = new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}

	public T head() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot get head of an empty queue");
		}
		return (T) data[head];
	}

	public T dequeue() {
		return null;
	}

	/***
	 * The resizing is handled by the dynamic array internally.
	 */
	public void enqueue(T element) {
		
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public String toString() {
		return null;
	}
	
	public Object[] toArray() {
		return null;
	}
	
	public void clear() {
		
	}

	public Iterator<T> iterator() {
		return null;
	}
	
	private class QIterator implements Iterator<T> {

		public boolean hasNext() {
			return false;
		}

		public T next() {
			return null;
		}
		
	}
	

}
