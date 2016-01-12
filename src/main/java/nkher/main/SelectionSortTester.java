package nkher.main;

import nkher.algorithms.sorting.SelectionSort;
import nkher.algorithms.sorting.Sorting;

public class SelectionSortTester {

	public static void main(String[] args) {
		
		int ia[] = {90, 1, 5, 3, 2, 100, 50, 45, 60};
		
		SelectionSort.sort(ia, Sorting.ORDER_ASC);
		
		for (Integer i : ia) {
			System.out.println(i);
		}
		
		System.out.println("\n ----- \n");
		
		SelectionSort.sort(ia, Sorting.ORDER_DESC);
		
		for (Integer i : ia) {
			System.out.println(i);
		}
	}

}
