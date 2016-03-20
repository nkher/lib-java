package nkher.datastructures.queues;

import java.util.Iterator;

import nkher.interfaces.MyQueue;

/***
 * A simple array based implementation of the Dequeue Data Structure. Exposes a nice API
 * for manipulating the queue and using it under different use cases and scenarios. It 
 * implements the MyQueue<T> interface that exposes standard queue functions. It uses
 * an Object array from within for the same purpose.
 * 
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class DequeArray<T> implements MyQueue<T>, Iterable<T> {
	
	public static final int DEFAULT_CAPACITY = 10;
	public static final int k_SCALE_FACTOR = 3; // will increase storage by 3 times
	
	private int size;
	private Object data[];
	private int front = 0, rear = 0;
	
	public DequeArray() {
		size = 0;
		initDeQueueDataArray(DEFAULT_CAPACITY);
	}
	
	public DequeArray(DequeArray<T> dequeArray) {
		this.size = dequeArray.size;
		initDeQueueDataArray(size);
		for (T elem : dequeArray) {
			enqueue(elem);
		}
	}
	
	public void initDeQueueDataArray(int size) {
		data = new Object[size];
	}
	
	public int size() {
		return 0;
	}

	public T head() {
		return null;
	}

	public T dequeue() {
		return null;
	}

	public void enqueue(T element) {
		
	}
	
	public T deqeueBack() {
		return null;
	}
	
	public void enqueueBack() {
		
	}

	public boolean isEmpty() {
		return false;
	}

	public T peek() {
		return null;
	}

	public Iterator<T> iterator() {
		return null;
	}

	public void clear() {
		initDeQueueDataArray(DEFAULT_CAPACITY);
		this.size = 0;
		front = rear = 0;
	}
	
	

}
