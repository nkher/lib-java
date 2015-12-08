package nkher.main;

import java.util.Iterator;

import nkher.datastructures.queues.QueueArray;

public class QueueArrayTester {

	public static void main(String[] args) {
		
		QueueArray<Integer> qa = new QueueArray<Integer>();		
				
		qa.enqueue(10);
		qa.enqueue(20);
		qa.enqueue(5);
		qa.enqueue(40);		
		System.out.println(qa.size() + " " + qa.toString());

		qa.enqueue(30);
		qa.enqueue(7);
		qa.enqueue(50);
		qa.enqueue(32);
		qa.enqueue(3);
		
		System.out.println(qa.size() + " " + qa.toString());
		
		qa.enqueue(77);
		qa.enqueue(87656);
		qa.enqueue(34);
		
		System.out.println(qa.size() + " " + qa.toString());
		
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		qa.dequeue();
		
		System.out.println(qa.size() + " " + qa.toString());
		
		qa.enqueue(12);
		qa.enqueue(12);
		qa.enqueue(12);
		System.out.println(qa.size() + " " + qa.toString());
		
		// using the iterator
		Iterator<Integer> itr = qa.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
