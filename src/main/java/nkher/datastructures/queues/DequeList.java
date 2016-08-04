package nkher.datastructures.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import nkher.exception.DataStructureEmptyException;
import nkher.api.MyQueue;

/***
 * A simple LinkedList based implementation of the Dequeue Data Structure. It is also called
 * the double ended queue as you can insert and remove elements from both ends of the data structure.
 * Exposes a nice, clean and a simple API for manipulating the queue and using it under different use cases and scenarios. It 
 * implements the MyQueue<T> interface that exposes standard queue functions. It uses
 * an Object array from within for the same purpose.
 * 
 * 
 * @author nameshkher
 *
 * @param <T>
 */
public class DequeList<T> implements MyQueue<T>, Iterable<T> {
	
	public static class DequeNode<T> {
		T data;
		DequeNode<T> next;
		
		public DequeNode(T data) {
			this.data = data;
		}
		
		public void setNextNode(DequeNode<T> node) {
			next = node;
		}
	}
	
	private int size;
	
	private DequeNode<T> front = null; 
	private DequeNode<T> rear = null;
	
	public DequeList() {
		size = 0;
	}
	
	public DequeList(DequeList<T> DequeList) {
		this.size = DequeList.size;
		for (T elem : DequeList) {
			enqueue(elem);
		}
	}
	
	public int size() {
		return size;
	}

	public T head() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		return front.data;
	}
	
	/***
	 * It is similar to the peekLast method of the java API. It returns the element
	 * that was inserted the last in the deque but does not remove it. 
	 * 
	 * @return element at the rear or the tail of the queue
	 */
	public T tail() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		return rear.data;

	}

	public void enqueue(T element) {
		size++;
		if (size == 1) { // first element
			front = rear = new DequeNode<T>(element);
		} else {
			rear.next = new DequeNode<T>(element);
			rear = rear.next;
		}
	}
	
	public void enqueueAtHead(T element) {
		size++;
		if (size == 1) { // first element
			front = rear = new DequeNode<T>(element);
		} else {
			DequeNode<T> newNode = new DequeNode<T>(element);
			DequeNode<T> temp = front;
			front = newNode;
			front.next = temp;
		}
	}
	
	public T dequeue() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		size--;
		T ret = front.data;
		if (size > 0){
			front = front.next;
		} else if (size == 0) {
			front = rear = null;
		}
		return ret;
	}
	
	public T deqeueAtTail() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		size--;
		T ret = rear.data;
		if (size > 0){ 
			DequeNode<T> newRear = front;
			while (newRear.next != rear) {
				newRear = newRear.next;
			}
			rear = newRear;
			
		} else if (size == 0) {
			front = rear = null;
		}
		return ret;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public T peek() {
		if (isEmpty()) {
			throw new DataStructureEmptyException("Cannot remove from an empty deque data structure !");
		}
		return front.data;
	}

	public Iterator<T> iterator() {
		return new DequeIterator();
	}

	@Override
	public void forEach(Consumer<? super T> action) {

	}

	private class DequeIterator implements Iterator<T> {

		DequeNode<T> curr = null;
		
		public boolean hasNext() {
			return (!DequeList.this.isEmpty() && curr != DequeList.this.rear);
		}

		public T next() {
			if (curr == null) {
				curr = front;
				return curr.data;
			}
			if (curr.next == null) {
				throw new NoSuchElementException();
			}
			curr = curr.next;
			return curr.data;
		}
	}

	public void clear() {
		this.size = 0;
		front = rear = null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public boolean contains(T elem) {
		if (!isEmpty()) {
			DequeNode<T> temp = front;
			while (temp != null) {
				if (temp.data.equals(elem)) {
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}

	@Override
	public boolean add(T elem) {
		return false;
	}

	@Override
	public boolean remove(T elem) {
		return false;
	}

}
