package nkher.datastructures.queues;

import nkher.exception.DataStructureEmptyException;
import nkher.interfaces.MyQueue;

public class CircularBuffer<T> implements MyQueue<T> {
	
	private static int DEFAULT_CAPACITY = 10;
	
	private int fixedCapacity;
	private int size = 0;

	private int writeIndex = 0;
	private int readIndex = 0;
	private Object[] data;
	
	public CircularBuffer() {
		this(DEFAULT_CAPACITY);
	}
	
	public CircularBuffer(int fixedCapacity) {
		this.fixedCapacity = fixedCapacity;
		data = new Object[fixedCapacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == fixedCapacity);
	}

	@Override
	public void clear() {
		this.size = 0;
		data = new Object[fixedCapacity];
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public boolean contains(T elem) {
		if (!isEmpty()) {
			
		}
		return false;
	}

	@Override
	public T head() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		return (T) data[readIndex];
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		T ret = (T) data[readIndex];
		readIndex = (readIndex + 1) % fixedCapacity;
		size--;
		return ret;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		return (T) data[readIndex];
	}

	/***
	 * Pushes an element onto the tail of the rear end of the queue. 
	 * As the circular buffer does not grow itself in size (expands)
	 * a write after the buffer is full happens on the head of the queue.
	 * The element that was written previously at the head gets overridden
	 * by the new element.
	 * 
	 * @param element - data to be inserted
	 */
	@Override
	public void enqueue(T element) {
		data[writeIndex] = element;
		writeIndex = (writeIndex + 1) % fixedCapacity;
		if (isFull()) { // condition for override
			readIndex++;
			return;
		}
		size++;
	}
	
}
