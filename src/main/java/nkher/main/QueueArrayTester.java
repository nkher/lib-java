package nkher.main;

import java.util.Iterator;

import nkher.datastructures.queues.QueueArray;

public class QueueArrayTester {

	public static void main(String[] args) {
		
		QueueArray<Integer> qa = new QueueArray<Integer>();		
		
		Object[] arr;
				
		qa.enqueue(10);
		qa.enqueue(20);
		qa.enqueue(5);
		qa.enqueue(40);		
		System.out.println("tail : " + qa.tail());
		System.out.println(qa.size() + " " + qa.toString());

		qa.enqueue(30);
		qa.enqueue(7);
		qa.enqueue(50);
		qa.enqueue(32);
		qa.enqueue(3);
		
		System.out.println("tail : " + qa.tail());
		System.out.println(qa.size() + " " + qa.toString());
		
		qa.enqueue(77);
		
		System.out.println("tail : " + qa.tail());
		System.out.println(qa.size() + " " + qa.toString());
		
		qa.enqueue(87656);
		qa.enqueue(34);
		qa.enqueue(98);
		qa.enqueue(8765);
		
		System.out.println("tail : " + qa.tail());
		System.out.println("head : " + qa.head());
		System.out.println(qa.size() + " " + qa.toString());
		System.out.println("capacity : "  + qa.capacity());
		
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		
		System.out.println("tail : " + qa.tail());
		System.out.println("head : " + qa.head());
		System.out.println(qa.size() + " " + qa.toString());
		System.out.println("capacity : "  + qa.capacity());
		
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		
		System.out.println("tail : " + qa.tail());
		System.out.println("head : " + qa.head());
		System.out.println(qa.size() + " " + qa.toString());
		System.out.println("capacity : "  + qa.capacity());


		qa.enqueue(12);
		qa.enqueue(12);
		qa.enqueue(12);
		System.out.println("tail : " + qa.tail());
		System.out.println("head : " + qa.head());
		System.out.println(qa.size() + " " + qa.toString());
		System.out.println("capacity : "  + qa.capacity());
		
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		System.out.println("tail : " + qa.tail());
		System.out.println("head : " + qa.head());
		System.out.println(qa.size() + " " + qa.toString());
		System.out.println("capacity : "  + qa.capacity());		

		
//		
//		// using the iterator
//		Iterator<Integer> itr = qa.iterator();
//		
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
	}

}
