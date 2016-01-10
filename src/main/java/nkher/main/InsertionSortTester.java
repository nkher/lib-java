package nkher.main;

import nkher.algorithms.sorting.InsertionSort;
import nkher.algorithms.sorting.Sorting;

public class InsertionSortTester {

	public static void main(String[] args) {
		
		int ia[] = {90, 1, 5, 3, 2, 100, 50, 45, 60};
		
		InsertionSort.sort(ia, Sorting.ORDER_ASC);
				
		for (Integer i : ia) {
			System.out.println(i);
		}
		
		System.out.println("\n ------ \n");
		
		InsertionSort.sort(ia, Sorting.ORDER_DESC);
		
		for (Integer i : ia) {
			System.out.println(i);
		}
	}

}
