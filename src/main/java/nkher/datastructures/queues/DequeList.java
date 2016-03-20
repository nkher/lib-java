package nkher.datastructures.queues;

import java.util.Iterator;

import nkher.exception.DataStructureEmptyException;
import nkher.interfaces.MyQueue;

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
public class DequeList<T> extends AbstractQueue<T> implements MyQueue<T>, Iterable<T> {
	
	public static class DequeueNode<T> {
		T data;
		DequeueNode<T> next;
		
		public DequeueNode(T data) {
			this.data = data;
		}
		
		public void setNextNode(DequeueNode<T> node) {
			next = node;
		}
	}
	
	private int size;
	
	private DequeueNode<T> front = null; 
	private DequeueNode<T> rear = null;
	
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

	public void enqueue(T element) {
		size++;
		if (size == 1) { // first element
			front = rear = new DequeueNode<T>(element);
		} else {
			rear.next = new DequeueNode<T>(element);
			rear = rear.next;
		}
	}
	
	public void enqueueAtHead(T element) {
		size++;
		if (size == 1) { // first element
			front = rear = new DequeueNode<T>(element);
		} else {
			DequeueNode<T> newNode = new DequeueNode<T>(element);
			DequeueNode<T> temp = front;
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
			DequeueNode<T> newRear = front;
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
		return null;
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
		return false;
	}
	
	

}
