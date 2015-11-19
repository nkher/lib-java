package nkher.main;

import nkher.algorithms.sorting.MergeSort;
import nkher.algorithms.sorting.Sorting;
import nkher.datastructures.lists.DynamicArray;

public class TestMergeSortTester {
	
	public static void main(String args[]) {
		
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.insert(40);
		da.insert(23);
		da.insert(4);
		da.insert(1);
		da.insert(10);
		da.insert(8);
		da.insert(19);
		da.insert(3);
		da.insert(76);
		da.insert(112);
		da.insert(89);
		
		System.out.println(da);
		
		MergeSort.sort(da, 0);
		
		System.out.println(da);
		
		String[] arr = {"namesh", "utsav", "sarika", "eshan", "vikesh", "anshima", "amit"};
		
		for (String s : arr) {
			System.out.println(s);
		}
		
		MergeSort.sort(arr, Sorting.ORDER_DESC);
		System.out.println("After sorting.");
		
		for (String s : arr) {
			System.out.println(s);
		}
	}
}
