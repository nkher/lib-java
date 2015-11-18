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
	
	/***
	 * Sorts the Character[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(Character[] cArray, int sortOrder) {
		DynamicArray<Character> dArray = new DynamicArray<Character>();
		dArray.fill(cArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, cArray);
	}
	
	/***
	 * Sorts the Short[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(Short[] sArray, int sortOrder) {
		DynamicArray<Short> dArray = new DynamicArray<Short>();
		dArray.fill(sArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, sArray);
	}
	
	/***
	 * Sorts the Long[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(Long[] lArray, int sortOrder) {
		DynamicArray<Long> dArray = new DynamicArray<Long>();
		dArray.fill(lArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, lArray);
	}
	
	/***
	 * Sorts the Byte[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(Byte[] bArray, int sortOrder) {
		DynamicArray<Byte> dArray = new DynamicArray<Byte>();
		dArray.fill(bArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, bArray);
	}
	
	/***
	 * Sorts the Double[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(Double[] doArray, int sortOrder) {
		DynamicArray<Double> dArray = new DynamicArray<Double>();
		dArray.fill(doArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, doArray);
	}
	
	/***
	 * Sorts the Float[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(Float[] fArray, int sortOrder) {
		DynamicArray<Float> dArray = new DynamicArray<Float>();
		dArray.fill(fArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, fArray);
	}
	
	/***
	 * Sorts the int[] array using the quick sort algorithm.
	 * 
	 * @param iArray
	 * @param sortOrder
	 */
	public static void sort(int[] iarray, int sortOrder) {
		DynamicArray<Integer> dArray = new DynamicArray<Integer>();
		ArrayUtility.getDArray(iarray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, iarray);
	}
	
	/***
	 * Sorts the float[] array using the quick sort algorithm.
	 * 
	 * @param farray
	 * @param sortOrder
	 */
	public static void sort(float[] farray, int sortOrder) {
		DynamicArray<Float> dArray = new DynamicArray<Float>();
		ArrayUtility.getDArray(farray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, farray);
	}
	
	/***
	 * Sorts the char[] array using the quick sort algorithm.
	 * 
	 * @param carray
	 * @param sortOrder
	 */
	public static void sort(char[] carray, int sortOrder) {
		DynamicArray<Character> dArray = new DynamicArray<Character>();
		ArrayUtility.getDArray(carray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, carray);
	}
	
	/***
	 * Sorts the short[] array using the quick sort algorithm.
	 * 
	 * @param sarray
	 * @param sortOrder
	 */
	public static void sort(short[] sarray, int sortOrder) {
		DynamicArray<Short> dArray = new DynamicArray<Short>();
		ArrayUtility.getDArray(sarray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, sarray);
	}
	
	
	/***
	 * Sorts the long[] array using the quick sort algorithm.
	 * 
	 * @param larray
	 * @param sortOrder
	 */
	public static void sort(long[] larray, int sortOrder) {
		DynamicArray<Long> dArray = new DynamicArray<Long>();
		ArrayUtility.getDArray(larray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, larray);
	}
	
	/***
	 * Sorts the boolean[] array using the bubble sort algorithm.
	 * 
	 * @param barray
	 * @param sortOrder
	 */
	public static void sort(boolean[] barray, int sortOrder) {
		DynamicArray<Boolean> dArray = new DynamicArray<Boolean>();
		ArrayUtility.getDArray(barray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, barray);
	}
	
	/***
	 * Sorts the String[] array using the quick sort algorithm.
	 * 
	 * @param sarray
	 * @param sortOrder
	 */
	public static void sort(String[] sarray, int sortOrder) {
		DynamicArray<String> dArray = new DynamicArray<String>();
		ArrayUtility.getDArray(sarray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, sarray);
	}

}
