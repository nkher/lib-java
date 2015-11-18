package nkher.main;

import java.util.Arrays;

import nkher.sorting.BubbleSort;

public class BubbleSortTester {

	public static void main(String[] args) {
		
		int ia[] = {90, 1, 5, 3, 2, 100, 50, 45, 60};
		String sa[] = {"a", "wqdkjn", "ggr", "khqwbdq", "jwkbdhqw"};
		double da[] = {10.09, 2.67, 78.06, 1.99909, 4.22, 23.45};
		
		Integer[] a = {90, 1, 5, 3, 2, 100, 50, 45, 60};
		
		for (int i : a) {
			System.out.println(i);
		}
		
		System.out.println();
		BubbleSort.sort(a, BubbleSort.ORDER_ASC);
				
		for (int i : a) {
			System.out.println(i);
		}
		
		char b[] = {'g', 'a', 'e', 'y', 'z', 'c'};
		
		BubbleSort.sort(b, BubbleSort.ORDER_ASC);
		
		System.out.println(Arrays.toString(b));
		
		// DynamicArray<Integer> darray = new DynamicArray<Integer>();
		
//		darray.fill(a);
//		System.out.println(darray.toString());
//		
//		BubbleSort.sort(darray, BubbleSort.ORDER_ASC);
//		
//		System.out.println(darray.toString());
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(0);
//		
//		System.out.println(Arrays.toString(list.toArray(new Integer[1])));
	}

}
