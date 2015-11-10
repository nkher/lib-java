package nkher.sorting;

import nkher.datastructures.DynamicArray;

/****
 * Implementation of the classic merge sort algorithm. 
 * Works well for large array sizes.
 * 
 * RunTime = O(N * logN)
 * 
 * @author nameshkher
 *
 * @param <Object>
 */
public class MergeSort extends Sorting {
	
	/***
	 * Sorts the passed array in ascending order using the bubble sort algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.	  
	 * 
	 * @param array - a {@code T} type array to be sorted
	 * @param sortOrder - {@code int} flag representing order in which you want to sort {0 for ascending and 1 for descending}, can also use BubbleSort.ORDER_ASC and BubbleSort.ORDER_DESC
	 */
	public static <T extends Comparable<T>> void sort(DynamicArray<T> dArray, int sortOrder) {
		if (null == dArray) return;
		
		int len = dArray.size();
		if (len == 1) return;
		
		int mid = (dArray.size()/2);
		DynamicArray<T> left = new DynamicArray<T>();
		DynamicArray<T> right = new DynamicArray<T>();
		
		/** Fill both the arrays */
		int i;
		for(i=0; i<mid; i++) {
			left.insert(dArray.getAt(i));
		}
		for (i=mid; i<len; i++) {
			right.insert(dArray.getAt(i));
		}
		
		/** Recurse on the left and right sub array */
		sort(left, sortOrder);
		sort(right, sortOrder);
		
		/** Merge the left and right sub arrays */
		merge(left, right, dArray, sortOrder);
	}
	
	private static <T extends Comparable<T>> void merge(DynamicArray<T> left, DynamicArray<T> right, DynamicArray<T> dArray, int sortOrder) {
		int i=0, j=0, k=0;
		int lLen = left.size(), rLen = right.size();
		
		/** Fill in the arrays by comparison */
		while (i < lLen && j < rLen) {
			
			if (sortOrder == ORDER_ASC) {
				if (right.getAt(j).compareTo(left.getAt(i)) > 0 ) { // right is greater
					dArray.setAt(k++, left.getAt(i++));
				}
				else {
					dArray.setAt(k++, right.getAt(j++));
				}
			}
			
			else if (sortOrder == ORDER_DESC){
				if (left.getAt(i).compareTo(right.getAt(j)) > 0 ) { // right is greater
					dArray.setAt(k++, left.getAt(i++));
				}
				else {
					dArray.setAt(k++, right.getAt(j++));
				}
			}
		}
		
		/** One of the arrays from left of right might not have reached the end */
		while (i < lLen) {
			dArray.setAt(k++, left.getAt(i++));
		}
		
		while (j < rLen) {
			dArray.setAt(k++, right.getAt(j++));
		}
	}
}
