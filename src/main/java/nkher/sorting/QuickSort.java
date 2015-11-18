package nkher.sorting;

import nkher.datastructures.lists.DynamicArray;
import nkher.utils.ArrayUtility;

public class QuickSort extends Sorting {

	public static <T extends Comparable<T>> void sort(DynamicArray<T> dArray, int sortOrder) {
		if (null == dArray || dArray.size() == 0) return;
		quicksort(dArray, sortOrder, 0, dArray.size()-1);
	}
	
	private static <T extends Comparable<T>> void quicksort(DynamicArray<T> dArray, int sortOrder, int low, int high) {
		if (high > low) {
			int partitionInd = pIndex(dArray, sortOrder, low, high);
			quicksort(dArray, sortOrder, low, partitionInd - 1);
			quicksort(dArray, sortOrder, partitionInd+1, high);
		}
	}
	
	private static <T extends Comparable<T>> int pIndex(DynamicArray<T> dArray, int sortOrder, int left, int right) {
		int pIndex = left;
		T pivot = dArray.getAt(right);
		
		for (int i=left; i<right; i++) {
			
			T curr = dArray.getAt(i);
			
			if (sortOrder == ORDER_ASC && curr.compareTo(pivot) < 0) { // curr is less than the pivot
				swap(dArray, i, pIndex++);
			}
			else if (sortOrder == ORDER_DESC && curr.compareTo(pivot) > 0) {
				swap(dArray, i, pIndex++);
			}
		}
		
		// Now swap the pIndex and the pivot
		dArray.setAt(right, dArray.getAt(pIndex));
		dArray.setAt(pIndex, pivot);
		
		return pIndex;
	}
	
	/***
	 * @param array - {@code Object} array in which indexes are to be swapped
	 * @param index1 - index1 to be swapped {@code int}
	 * @param index2 - index2 to be swapped {@code int}
	 * @param sortOrder
	 */
	private static <T extends Comparable<T>> void swap(DynamicArray<T> dArray, int index1, int index2) {
		T temp = dArray.getAt(index1);
		dArray.setAt(index1, dArray.getAt(index2));
		dArray.setAt(index2, temp);
	}
	
	/***
	 * Sorts the Integer[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(Integer[] iArray, int sortOrder) {
		DynamicArray<Integer> dArray = new DynamicArray<Integer>();
		dArray.fill(iArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, iArray);
	}

}
