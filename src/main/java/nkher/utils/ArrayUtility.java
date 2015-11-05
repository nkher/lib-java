package nkher.utils;

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
	
	public static final Integer INTEGER_OBJ_ARR[] = new Integer[0];
	
	public static final Character CHARACTER_OBJ_ARR[] = new Character[0];
	
	public static final Byte BYTE_OBJ_ARR[] = new Byte[0];
	
	public static final Long LONG_OBJ_ARR[] = new Long[0];
	
	public static final Float FLOAT_OBJ_ARR[] = new Float[0];
	
	public static final Double DOUBLE_OBJ_ARR[] = new Double[0];
	
	public static final Short SHORT_OBJ_ARR[] = new Short[0];
		
	
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
	 * @param array
	 * @param arr
	 */
	public static void arrayCopy(Integer[] array, int[] arr) {
		if (null == array) return;
		if (null == arr) arr = new int[array.length];
		for (int i=0; i<array.length; i++) {
			arr[i] = array[i];
		}
	}
}
