package nkher.main;

import nkher.sorting.QuickSort;
import nkher.sorting.Sorting;

public class QuickSortTester {

	public static void main(String[] args) {
		
		Integer[] i = {19, 1, 3, 567, 34, 2, 87, 453, 23};
		
		for (int j=0; j<i.length; j++) {
			System.out.print(i[j] + ", ");
		}
		
		QuickSort.sort(i, Sorting.ORDER_DESC);
		
		System.out.println();
		
		for (int j=0; j<i.length; j++) {
			System.out.print(i[j] + ", ");
		}
	}

}
