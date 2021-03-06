package nkher.algorithms.sorting;

import nkher.datastructures.lists.DynamicArray;
import nkher.utils.ArrayUtility;

/****
 * Implementation of the classic bubble sort algorithm. It works well for array sizes
 * less than 50.
 * 
 * @author nameshkher
 *
 * @param <Object>
 */
public class BubbleSort extends Sorting {
	
	/***
	 * Sorts the passed array in order provided by the sort order parameter using the bubble sort algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.	  
	 * 
	 * @param array - a {@code T} type array to be sorted
	 * @param sortOrder - {@code int} flag representing order in which you want to sort {0 for ascending and 1 for descending}, can also use Sorting.ORDER_ASC and Sorting.ORDER_DESC
	 */
	public static <T extends Comparable<T>> void sort(DynamicArray<T> dArray, int sortOrder) {
		if (null == dArray) return;
		int n = dArray.size(), i=0, j=0; 
		for (i=0; i<n; i++) {
			for (j=0; j<n-i-1; j++) {
				if (sortOrder == ORDER_ASC && dArray.getAt(j+1).compareTo(dArray.getAt(j)) < 1) {
					swap(dArray, j, j+1);
				}
				else if (sortOrder == ORDER_DESC && dArray.getAt(j).compareTo(dArray.getAt(j+1)) < 1) {
					swap(dArray, j, j+1);
				}
			}
		}
	}
	
	/***
	 * Sorts the Integer[] array using the bubble sort algorithm.
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
	 * Sorts the Character[] array using the bubble sort algorithm.
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
	 * Sorts the Short[] array using the bubble sort algorithm.
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
	 * Sorts the Long[] array using the bubble sort algorithm.
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
	 * Sorts the Byte[] array using the bubble sort algorithm.
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
	 * Sorts the Double[] array using the bubble sort algorithm.
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
	 * Sorts the Float[] array using the bubble sort algorithm.
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
	 * Sorts the int[] array using the bubble sort algorithm.
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
	 * Sorts the float[] array using the bubble sort algorithm.
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
	 * Sorts the char[] array using the bubble sort algorithm.
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
	 * Sorts the short[] array using the bubble sort algorithm.
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
	 * Sorts the long[] array using the bubble sort algorithm.
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
	 * Sorts the String[] array using the bubble sort algorithm.
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
