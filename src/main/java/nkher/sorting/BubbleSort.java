package nkher.sorting;

import nkher.datastructures.DynamicArray;
import nkher.utils.ArrayUtility;

/****
 * Implementation of the classic bubble sort algorithm. It works well for array sizes
 * less than 50.
 * 
 * @author nameshkher
 *
 * @param <Object>
 */
public class BubbleSort {
	
	public static final int ORDER_ASC = 0;
	public static final int ORDER_DESC = 1;
		
	
	/***
	 * Sorts the passed array in ascending order.
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
		int n = dArray.size(), i=0, j=0; 
		for (i=0; i<n; i++) {
			for (j=0; j<n-i-1; j++) {
				if (sortOrder == ORDER_ASC && dArray.getAt(j+1).compareTo(dArray.getAt(j)) < 1) {
					swap(dArray, j, j+1);
				}
				else if (sortOrder == ORDER_DESC && dArray.getAt(j+1).compareTo(dArray.getAt(j)) > 1) {
					swap(dArray, j, j+1);
				}
			}
		}
	}
	
	public static void sort(Integer[] iArray, int sortOrder) {
		DynamicArray<Integer> dArray = new DynamicArray<Integer>();
		ArrayUtility.getDArray(iArray, dArray);
		sort(dArray, sortOrder);
		ArrayUtility.fillArray(dArray, iArray);
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
	
//	@SuppressWarnings("unchecked")
//	public static <T> void sort(char[] array, int sortOrder) {
//		Character[] objArray = ArrayUtility.toObjectArray(array);
//		sort((T[]) objArray, sortOrder);
//		ArrayUtility.arrayCopy(objArray, array);
//	}
//	
}
