package nkher.main;

import nkher.datastructures.heaps.MaxHeap;

public class MaxHeapTester {

	public static void main(String[] args) {
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		maxHeap.insert(5);
		maxHeap.insert(7);
		
		System.out.println(maxHeap);
		
		maxHeap.remove(7);
		
		System.out.println(maxHeap);
		
		maxHeap.insert(1);
		maxHeap.insert(9);
		maxHeap.insert(4);
		maxHeap.insert(2);
		maxHeap.insert(20);
		maxHeap.insert(7);
						
		System.out.println(maxHeap);
				
//		while (maxHeap.size() > 0) {
//			System.out.println("Max : " + maxHeap.extractMax());
//			System.out.println(maxHeap);
//			System.out.println("size : " + maxHeap.size());
//		}
		
	}

}
