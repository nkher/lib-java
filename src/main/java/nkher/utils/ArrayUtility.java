package nkher.utils;

import java.util.HashSet;
import java.util.Set;

import nkher.datastructures.lists.DynamicArray;


/****
 * This class provides some helper methods on arrays.
 * Inspired by the apache commons-lang jar. Specific classes referred are: ArrayUtils.java
 * The code logic is from the ArrayUtils class.
 * 
 * Reference : https://github.com/apache/commons-lang/blob/master/src/main/java/org/apache/commons/lang3/ArrayUtils.java
 * 
 * @author nameshkher
 *
 */
public class ArrayUtility {

	// To make the class uninstantiable
	private ArrayUtility() {
		throw new AssertionError();
	}
	
	public static final Integer INTEGER_OBJ_ARR[] = new Integer[0];
	
	public static final Character CHARACTER_OBJ_ARR[] = new Character[0];
	
	public static final Byte BYTE_OBJ_ARR[] = new Byte[0];
	
	public static final Long LONG_OBJ_ARR[] = new Long[0];
	
	public static final Float FLOAT_OBJ_ARR[] = new Float[0];
	
	public static final Double DOUBLE_OBJ_ARR[] = new Double[0];
	
	public static final Short SHORT_OBJ_ARR[] = new Short[0];
		
	/*************************************************************************************************************************
	 * RETURNS AN OBJECT ARRAY OF THE SAME PRIMITIVE TYPE PASSED WITH CONTENT SAME AS THAT OF THE PRIMITIVE TYPE ARRAYS
	 *************************************************************************************************************************/
	
	
	/***
	 * Utility method to convert a primitive type int[] array into an Integer[] object array.
	 * 
	 * @param array a {@code int} array
	 * @return a {@code Integer} array, {@code null} if null array input
	 */
	public static Integer[] toObjectArray(int array[]) {
		if (null == array) {
			return null;
		}
		else if (array.length == 0) {
			return INTEGER_OBJ_ARR;
		}
		final Integer[] arr = new Integer[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
		return arr;
	}
	
	/***
	 * Utility method to convert a primitive type char[] array into an Character[] object array.
	 * 
	 * @param array a {@code char} array
	 * @return a {@code Char} array, {@code null} if null array input
	 */
	public static Character[] toObjectArray(char array[]) {
		if (null == array) {
			return null;
		}
		else if (array.length == 0) {
			return CHARACTER_OBJ_ARR;
		}
		final Character[] arr = new Character[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
		return arr;
	} 
	
	/***
	 * Utility method to convert a primitive type byte[] array into an Byte[] object array.
	 * 
	 * @param array a {@code byte} array
	 * @return a {@code Byte} array, {@code null} if null array input
	 */
	public static Byte[] toObjectArray(byte array[]) {
		if (null == array) {
			return null;
		}
		else if (array.length == 0) {
			return BYTE_OBJ_ARR;
		}
		final Byte[] arr = new Byte[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
		return arr;
	} 
	
	/***
	 * Utility method to convert a primitive type long[] array into an Long[] object array.
	 * 
	 * @param array a {@code long} array
	 * @return a {@code Long} array, {@code null} if null array input
	 */
	public static Long[] toObjectArray(long array[]) {
		if (null == array) {
			return null;
		}
		else if (array.length == 0) {
			return LONG_OBJ_ARR;
		}
		final Long[] arr = new Long[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
		return arr;
	} 
	
	/***
	 * Utility method to convert a primitive type float[] array into an Float[] object array.
	 * 
	 * @param array a {@code float} array
	 * @return a {@code Float} array, {@code null} if null array input
	 */
	public static Float[] toObjectArray(float array[]) {
		if (null == array) {
			return null;
		}
		else if (array.length == 0) {
			return FLOAT_OBJ_ARR;
		}
		final Float[] arr = new Float[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
		return arr;
	} 
	
	/***
	 * Utility method to convert a primitive type double[] array into an Double[] object array.
	 * 
	 * @param array a {@code double} array
	 * @return a {@code Double} array, {@code null} if null array input
	 */
	public static Double[] toObjectArray(double array[]) {
		if (null == array) {
			return null;
		}
		else if (array.length == 0) {
			return DOUBLE_OBJ_ARR;
		}
		final Double[] arr = new Double[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
		return arr;
	} 
	
	/***
	 * Utility method to convert a primitive type short[] array into an Short[] object array.
	 * 
	 * @param array a {@code short} array
	 * @return a {@code Short} array, {@code null} if null array input
	 */
	public static Short[] toObjectArray(short array[]) {
		if (null == array) {
			return null;
		}
		else if (array.length == 0) {
			return SHORT_OBJ_ARR;
		}
		final Short[] arr = new Short[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
		return arr;
	}
	
	/***
	 * Copies everything from the Integer[] object array to the primitive array.
	 * 
	 * 
	 * @param array a {@code Integer} array
	 * @param arr a {@code int} array
	 */
	public static void arrayCopy(Integer[] array, int[] arr) {
		if (null == array) return;
		if (null == arr) arr = new int[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
	
	/***
	 * Copies everything from the Character[] object array to the primitive char array.
	 * 
	 * 
	 * @param array a {@code Character} array
	 * @param arr a {@code char} array
	 */
	public static void arrayCopy(Character[] array, char[] arr) {
		if (null == array) return;
		if (null == arr) arr = new char[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
	
	/***
	 * Copies everything from the Byte[] object array to the primitive byte[] array.
	 * 
	 * 
	 * @param array a {@code Byte} array
	 * @param arr a {@code byte} array
	 */
	public static void arrayCopy(Byte[] array, byte[] arr) {
		if (null == array) return;
		if (null == arr) arr = new byte[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
	
	/***
	 * Copies everything from the Long[] object array to the primitive long[] array.
	 * 
	 * 
	 * @param array a {@code Long} array
	 * @param arr a {@code long} array
	 */
	public static void arrayCopy(Long[] array, long[] arr) {
		if (null == array) return;
		if (null == arr) arr = new long[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
	
	/***
	 * Copies everything from the Float[] object array to the primitive float[] array.
	 * 
	 * 
	 * @param array a {@code Float} array
	 * @param arr a {@code float} array
	 */
	public static void arrayCopy(Float[] array, float[] arr) {
		if (null == array) return;
		if (null == arr) arr = new float[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
	
	/***
	 * Copies everything from the Double[] object array to the primitive double[] array.
	 * 
	 * 
	 * @param array a {@code Double} array
	 * @param arr a {@code double} array
	 */
	public static void arrayCopy(Double[] array, double[] arr) {
		if (null == array) return;
		if (null == arr) arr = new double[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
	
	/***
	 * Copies everything from the Short[] object array to the primitive short[] array.
	 * 
	 * 
	 * @param array a {@code Short} array
	 * @param arr a {@code short} array
	 */
	public static void arrayCopy(Short[] array, short[] arr) {
		if (null == array) return;
		if (null == arr) arr = new short[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
	
	/********************************************************************
	 * FILLS THE DYNAMIC ARRAY WITH CONTENT OF THE PRIMITIVE TYPE ARRAYS
	 ********************************************************************/
	
	/***
	 * Fills the Dynamic Array with the elements of the int[] array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(int[] array, DynamicArray<Integer> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the char array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(char[] array, DynamicArray<Character> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the long array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(long[] array, DynamicArray<Long> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the boolean array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(boolean[] array, DynamicArray<Boolean> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the float array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(float[] array, DynamicArray<Float> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the double array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(double[] array, DynamicArray<Double> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the short array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(short[] array, DynamicArray<Short> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the byte array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(byte[] array, DynamicArray<Byte> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	/***
	 * Fills the Dynamic Array with the elements of the String array
	 *  
	 * @param array
	 * @param dArray
	 */
	public static void getDArray(String[] array, DynamicArray<String> dArray) {
		if (null == array) return;
		if (array.length == 0) return;
		for (int i=0; i<array.length; i++) {
			dArray.insert(array[i]);
		}
	}
	
	
	/***
	 * Fills the Integer[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Integer> dArray, Integer[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Byte[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Byte> dArray, Byte[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Float[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Float> dArray, Float[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Double[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Double> dArray, Double[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	/***
	 * Fills the Boolean[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Boolean> dArray, Boolean[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Short[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Short> dArray, Short[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Long[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Long> dArray, Long[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Character[] array with the elements of the Dynamic Array
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Character> dArray, Character[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	
	/*****************************************************************
	 * FILLS THE PRIMITIVE ARRAY WITH CONTENT OF THE DYNAMIC ARRAYS
	 *****************************************************************/
	
	/***
	 * Fills the Integer[] array with the elements of the Dynamic Array.
	 * int[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Integer> dArray, int[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Byte[] array with the elements of the Dynamic Array.
	 * byte[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Byte> dArray, byte[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Float[] array with the elements of the Dynamic Array.
	 * float[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Float> dArray, float[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Double[] array with the elements of the Dynamic Array.
	 * double[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Double> dArray, double[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	/***
	 * Fills the Boolean[] array with the elements of the Dynamic Array.
	 * boolean[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Boolean> dArray, boolean[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Short[] array with the elements of the Dynamic Array.
	 * short[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Short> dArray, short[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Long[] array with the elements of the Dynamic Array.
	 * long[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Long> dArray, long[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the Character[] array with the elements of the Dynamic Array.
	 * char[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<Character> dArray, char[] array) {
		if (null == dArray) return;
		if (dArray.size() == 0) return;
		for (int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/***
	 * Fills the String[] array with the elements of the Dynamic Array.
	 * String[] array must be the size of dArray
	 * 
	 * @param dArray
	 * @param array
	 */
	public static void fillArray(DynamicArray<String> dArray, String[] array) {
		if(null == dArray) return;
		if(dArray.size() == 0) return;
		for(int i=0; i<dArray.size(); i++) {
			array[i] = dArray.getAt(i);
		}
	}
	
	/*******
	 * UTILITY TO REVERSE PRIMITIVE TYPE ARRAYS
	 ********/
	
	/***
	 * Utility function reverse a {@code char} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(char[] array) {
		reverse(array, 0, array.length-1);
	}
	
	/***
	 * Utility function reverse a {@code char} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(char[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			char temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function reverse a {@code int} completely.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(int[] array) {
		reverse(array, 0, array.length-1);
	}
	
	/***
	 * Utility function reverse a {@code int} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(int[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			int temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function reverse a {@code byte} completely.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(byte[] array) {
		reverse(array, 0, array.length-1);
	}
	
	/***
	 * Utility function reverse a {@code byte} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(byte[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			byte temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function reverse a {@code short} completely.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(short[] array) {
		reverse(array, 0, array.length-1);
	}
	
	/***
	 * Utility function reverse a {@code short} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(short[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			short temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function reverse a {@code double} completely.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(double[] array) {
		reverse(array, 0, array.length-1);
	}
	
	/***
	 * Utility function reverse a {@code double} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(double[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			double temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function reverse a {@code float} completely.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(float[] array) {
		reverse(array, 0, array.length-1);
	}

	/***
	 * Utility function reverse a {@code float} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(float[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			float temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function reverse a {@code long} completely.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(long[] array) {
		reverse(array, 0, array.length-1);
	}
	
	/***
	 * Utility function reverse a {@code long} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(long[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			long temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function reverse a {@code boolean} completely.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(boolean[] array) {
		reverse(array, 0, array.length-1);
	}
	
	/***
	 * Utility function reverse a {@code boolean} array starting from indices 'fromIndex' until 'toIndex'.
	 * 
	 * @param array
	 * @param fromIndex
	 * @param toIndex
	 */
	public static void reverse(boolean[] array, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			boolean temp = array[fromIndex];
			array[fromIndex] = array[toIndex];
			array[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
	
	/***
	 * Utility function to swap 2 elements in an array.
	 * @param array
	 * @param index2
	 * @param index2
	 */
	public static void swap(Object[] array, int index1, int index2) {
		assert index1 < array.length;
		assert index2 < array.length;
		Object temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	/***
	 * Utility function remove duplicates from an array. It returns the size of the new array.
	 * @param array
	 * @return
	 */
	public static int unique(Object[] array) {
		assert null != array;
		int i = 0, len = array.length, ind = 0;
		assert array.length > 0 : "Array is empty";
		Set<Object> set = new HashSet<>();
		while (i < len) {
			if (null == array[i]) break;
			if (set.add(array[i]))
				array[ind++] = array[i];
			i++;
		}
		return ind;
	}
	
}
