package nkher.sorting;

import java.util.ArrayList;
import java.util.Arrays;

import nkher.datastructures.DynamicArray;
import nkher.utils.ArrayUtility;

public class BubbleSort<T extends Comparable<T>> {
	
	/***
	 * Sorts the incoming array in ascending order using the bubble sort algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.
	 * 
	 * Time complexity is O(n ^ 2) where n is the total number of elements. 
	 * 
	 * @param array - a {@code T} type array to be sorted
	 */
	public void bubblesortASC(T array[]) {
		
		int n = array.length, i=0, j=0; 
		for (i=0; i<n; i++) {
			for (j=0; j<n-i-1; j++) {
				
				T t_j = array[j];
				T t_jplus1 = array[j+1];

				if (t_j.compareTo(t_jplus1) == 1) { // swap
					array[j] = t_jplus1;
					array[j+1] = t_j;
				}
			}
		}
	}
	
	/***
	 * Sorts the incoming Dynamic Array in ascending order using the bubble sort sorting algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.
	 * 
	 * Time complexity is O(n ^ 2) where n is the total number of elements.
	 * 
	 * 
	 * @param dArray - a {@code T} type dynamic array to be sorted
	 */
	public void bubblesortASC(DynamicArray<T> dArray) {
		T[] array = dArray.toArray();
		bubblesortASC(array);
	}
	
	
	/***
	 * Sorts the incoming Array List in ascending order using the bubble sort sorting algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.
	 * 
	 * Time complexity is O(n ^ 2) where n is the total number of elements.
	 * 
	 * 
	 * @param arrayList - a {@code T} type array list to be sorted
	 */
	@SuppressWarnings("unchecked")
	public void bubblesortASC(ArrayList<T> arrayList) {
		Object[] array = arrayList.toArray();
		bubblesortASC((T[]) array);
	}
	
	/***
	 * Sorts the incoming array in descending order using the bubble sort algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.
	 * 
	 * Time complexity is O(n ^ 2) where n is the total number of elements. 
	 * 
	 * @param array - a {@code T} type array to be sorted
	 */
	public void bubblesortDESC(T array[]) {
		
		int n = array.length, i=0, j=0; 
		for (i=0; i<n; i++) {
			for (j=0; j<n-i-1; j++) {
				
				T t_j = array[j];
				T t_jplus1 = array[j+1];

				if (t_j.compareTo(t_jplus1) < 1) { // swap
					array[j] = t_jplus1;
					array[j+1] = t_j;
				}
			}
		}
	}
	
	/***
	 * Sorts the incoming Dynamic Array in descending order using the bubble sort sorting algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.
	 * 
	 * 
	 * Time complexity is O(n ^ 2) where n is the total number of elements.
	 * 
	 * 
	 * @param dArray - a {@code T} type dynamic array to be sorted
	 */
	public void bubblesortDESC(DynamicArray<T> dArray) {
		T[] array = dArray.toArray();
		bubblesortASC(array);
	}
	
	/***
	 * Sorts the incoming Array List in descending order using the bubble sort sorting algorithm.
	 * If the incoming array is of a complex type (object), then it sorts the array based on the 
	 * implementation of the compareTo() method of the object (if the incoming object type's extends the Comparable interface.) 
	 * Else if the array is of a primitive type {any one of Integer, String, Double, Float, Double, Long etc.} then 
	 * sorting is done on the based on the primitive type.
	 * 
	 * Time complexity is O(n ^ 2) where n is the total number of elements.
	 * 
	 * 
	 * @param arrayList - a {@code T} type array list to be sorted
	 */
	@SuppressWarnings("unchecked")
	public void bubblesortDESC(ArrayList<T> arrayList) {
		Object[] array = arrayList.toArray();
		bubblesortASC((T[]) array);
	}
	
	@SuppressWarnings("unchecked")
	public void bubblesortASC(int[] array) {
		Integer[] objArr = ArrayUtility.toObjectArray(array);
		bubblesortASC((T[]) objArr);
		ArrayUtility.arrayCopy(objArr, array);
	}
	
	public void bubblesortASC(char[] array) {
		
	}
	
	public void bubblesortASC(double[] array) {
			
		}
	
	public void bubblesortASC(float[] array) {
		
	}
	
	public void bubblesortASC(byte[] array) {
		
	}
	
	public void bubblesortASC(short[] array) {
		
	}
	
	public void bubblesortASC(long[] array) {
		
	}
	
}
