package nkher.utils;

/***
 * A String API that provides useful functions for String compression.
 * 
 * @author nameshkher
 *
 */
public class StringUtility {
	
	// TO IMPLEMENT
	// 1. SUBSTRING
	// 2. STR_REPLACE
	// 3. ADD 2 Strings
	// 4. Multiply 2 Strings
	
	/***
	 * An efficient method for compressing a String using Run Length Encoding.
	 * It optimizes for single char sequences by only appending the char and not the count (1). 
	 * Internally uses a StringBuilder for forming the compression String.
	 * These work good for Strings that have no numerics in them.
	 * Example : The String should not contain [0 - 9]
	 * 
	 * @param str - input of type {@code String}
	 * @return - {@code String}
	 */
	public static String runLengthEncoding(String str) {
		
		if (null == str) return null;
		int n = str.length();
		if (n == 0) return str;
		
		int sizeAfterCompression = compressionSize(str);
		
		/** Return the String if its compression length is greater than its original length */
		if (sizeAfterCompression > n) return str;
		
		int count = 1;
		char prev = str.charAt(0), ch;
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<n; i++) {
			ch = str.charAt(i);
			if (ch == prev) {
				count++;
			}
			else {
				sb.append(prev);
				if (count > 1) sb.append(count);
				prev = ch;
				count = 1;
			}
		}
		
		/** Appending the last character */
		sb.append(prev);
		if (count > 1) sb.append(count);
		
		return sb.toString();
	}
	
	
	/***
	 * Calculates and returns the size of the compressed String without actually performing the compression.
	 * This helps in determining whether or not compression should be performed. The Algorithm is to count the 
	 * number of character sequences and every character sequence has another number after it which gives its count.
	 * The total length is the compression size. For example if str = 'aabeedbbbesssff' then the size after compression
	 * returned by the following function would be 13. This method optimizes for character sequences occurring only once
	 * in a consecutive sequence by not appending its occurrence. 
	 * 
	 * @param str - input of type {@code String}
	 * @return - {@code String}
	 */
	private static int compressionSize(String str) {
		
		char prev = str.charAt(0);
		int compSize = 0;
		int count = 1;
		
		char ch;
		for (int i=1; i<str.length(); i++) {
			ch = str.charAt(i);
			if (ch == prev) {
				count++;
			}
			else {
				compSize += (count == 1)  ? 1 : (1 + String.valueOf(count).length());
				prev = ch;
				count = 1;
			}
		}
		
		compSize += (count == 1)  ? 1 : (1 + String.valueOf(count).length());
		return compSize;
	}
	
	/***
	 * Returns the de-compressed String for the passed String which has been previously compressed 
	 * using the runLengthEncoding method of this class. This decompress function is guaranteed to 
	 * work appropriately if the String is compressed by the above compressing function.
	 * 
	 * @param str - input of type {@code String}
	 * @return - {@code String}
	 */
	public static String decompress(String str) {
		
		if (null == str) return null;
		int n = str.length();
		if (n == 0) return str;
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		char prev = str.charAt(0);
		
		for (int i=1; i<n; i++) {			
			if (Character.isDigit(str.charAt(i))) {					
				while ((i <= n-1) && Character.isDigit(str.charAt(i))) {
					count += (count * 10) + (str.charAt(i) - '0');
					i++;
				}
				if (i == n-1) break;
				i--;
			}
			else {
				if (isNotDigit(str.charAt(i-1))) { // means prev seen digit was a number
					sb.append(str.charAt(i-1));
				}
				else {					
					while (count > 0) {
						sb.append(prev);
						count--;
					}
				}
				prev = str.charAt(i);
			}
		}
		while (count > 0) {
			sb.append(prev);
			count--;
		}
		if (count == 0) sb.append(prev);
		return sb.toString();
	}
	
	private static boolean isNotDigit(char ch) {
		int n = (ch - '0');
		return (n < 0 || n > 9);
	}
	
	/***
	 * Reverses the passed String and returns the reversed one.
	 * 
	 * @param str - input of type {@code String}
	 * @return - {@code String}
	 */
	public static String reverse(String str) {
		
		if (null == str) return null;
		int n = str.length();
		if (n == 0) return str;
		
		char[] arr = str.toCharArray();
		int start = 0, end = n-1;
		
		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
		return new String(arr);
	}
	
	/***
	 * Checks whether a String is a palindrome  or not. True indicates that the String is a palindrome
	 * and false means it is not. Performs a case sensitive match.
	 * 
	 * @param str - input of type {@code String}
	 * @return - a {@code boolean} value 
	 */
	public static boolean isPalindrome(String str) {
		
		if (null == str) return false;
		int n = str.length();
		if (n == 0) return true; // empty string is a palindrome
		
		char[] arr = str.toCharArray();
		int start = 0, end = n-1;
		
		while (start < end) {
			if (arr[start] != arr[end]) return false;
			start++;
			end--;
		}
		return true;
	}
	
	/***
	 * Checks whether a String is a palindrome  or not. True indicates that the String is a palindrome
	 * and false means it is not. Performs a case in-sensitive match.
	 * 
	 * @param str - input of type {@code String}
	 * @return - a {@code boolean} value 
	 */
	public static boolean isPalindromeCaseInsensitive(String str) {
		return isPalindrome(str.toLowerCase());
	}
	
	/***
	 * Converts a String into Integer (primitive int) and returns the integer.
	 * If null or empty String is passed then an exception of type - 
	 * IllegalArgumentException() is thrown with appropriate message.
	 * 
	 * @param str - input of type {@code String}
	 * @return - a {@code int} value
	 */
	public static int stoi(String str) {
		
		if (null == str) {
			throw new IllegalArgumentException("Cannot convert null String to Integer.");
		}
		int n = str.length();
		if (n == 0) {
			throw new IllegalArgumentException("Cannot convert zero length String to Integer.");
		}
		
		/** Check for negative numbers */
		boolean neg = false;
		if (str.charAt(0) == '-') {
			neg = true;
			str = str.substring(1);
			n = n-1;
		}
		
		int num = 0;
		for (int i=0; i<n; i++) {
			num = (num * 10) + (str.charAt(i) - '0');
		}
		
		if (neg) {
			num = num * (-1);
		}
		
		return num;
	}
}
