package nkher.algorithms.sorting;

import nkher.datastructures.lists.DynamicArray;


public abstract class Sorting {
	
	protected static final int ORDER_ASC = 0;
	protected static final int ORDER_DESC = 1;		
	
	/***
	 * @param array - {@code Object} array in which indexes are to be swapped
	 * @param index1 - index1 to be swapped {@code int}
	 * @param index2 - index2 to be swapped {@code int}
	 * @param sortOrder
	 */
	protected static <T extends Comparable<T>> void swap(DynamicArray<T> dArray, int index1, int index2) {
		T temp = dArray.getAt(index1);
		dArray.replaceAt(index1, dArray.getAt(index2));
		dArray.replaceAt(index2, temp);
	}
}
