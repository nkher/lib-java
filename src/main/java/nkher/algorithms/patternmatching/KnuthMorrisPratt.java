package nkher.algorithms.patternmatching;

import java.util.ArrayList;

/***
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * https://www.quora.com/Stringology/How-does-Knuth%E2%80%93Morris%E2%80%93Pratt-string-search-algorithm-work
 * 
 * @author nameshkher
 *
 */
public class KnuthMorrisPratt {

	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. It does this search based on some pre-processing and saving
	 * a some state/information of the pattern to reduce the time during the actual search.
	 * The extra information helps in skipping characters in the main pattern which eventually 
	 * reduces the time for search. The extra information saved is called the LPS array which is
	 * an integer array. <br><br>
	 * 
	 * LPS here stands for the longest shortest prefix that is also the suffix. We try and identify such 
	 * patterns in the pattern and make the LPS array.<br><br>
	 * For example consider the pattern 'abababca'. Then we fill create lps array ({@code int} array) equal
	 * to the length of the pattern. The value at index 'i' represents the lps value for the character at that 
	 * index in the pattern. If we consider cell 4 we have the sub pattern as "ababa" (start index  = 0). <br><br>
	 * 
	 * Proper Prefixes -> { abab, aba, ab, a } <br>
	 * Proper Suffixes -> { baba, aba, ba, a } <br><br>
	 * 
	 * From the above we observe that the longest suffix that matches the longest prefix is "aba" and its length = 3.
	 * Therefore the value of lps array at index 4 would be 3 OR lps[4] = 3. This is how the calculation is done. <br><br>
	 * 
	 * Worst Case Time Complexity - O(n), where n is the length of the text <br>
	 * 
	 * NOTE : Performs a case sensitive match
	 * 
	 * @param text - a text of type {@code String} in which we search for the pattern 
	 * @param pat - a pattern of type {@code String} which is to be searched
	 * @return - an {@code ArrayList<Integers>} with index at which match occurred
	 */
	public static ArrayList<Integer> searchPattern(String text, String pat) {
		return searchPattern(text.toCharArray(), pat.toCharArray());
	}
	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. It does this search based on some pre-processing and saving
	 * a some state/information of the pattern to reduce the time during the actual search.
	 * The extra information helps in skipping characters in the main pattern which eventually 
	 * reduces the time for search. The extra information saved is called the LPS array which is
	 * an integer array. <br><br>
	 * 
	 * LPS here stands for the longest shortest prefix that is also the suffix. We try and identify such 
	 * patterns in the pattern and make the LPS array.<br><br>
	 * For example consider the pattern 'abababca'. Then we fill create lps array ({@code int} array) equal
	 * to the length of the pattern. The value at index 'i' represents the lps value for the character at that 
	 * index in the pattern. If we consider cell 4 we have the sub pattern as "ababa" (start index  = 0). <br><br>
	 * 
	 * Proper Prefixes -> { abab, aba, ab, a } <br>
	 * Proper Suffixes -> { baba, aba, ba, a } <br><br>
	 * 
	 * From the above we observe that the longest suffix that matches the longest prefix is "aba" and its length = 3.
	 * Therefore the value of lps array at index 4 would be 3 OR lps[4] = 3. This is how the calculation is done. <br><br>
	 * 
	 * Worst Case Time Complexity - O(n), where n is the length of the text <br>
	 * 
	 * NOTE : Performs a case sensitive match
	 * 
	 * @param text - a text array of type {@code char[]} in which we search for the pattern 
	 * @param pat - a pattern array of type {@code char[]} which is to be searched
	 * @return - an {@code ArrayList<Integers>} with index at which match occurred
	 */
	public static ArrayList<Integer> searchPattern(char[] text, char pat[]) {
		
		if (null == text || null == pat) throw new IllegalArgumentException("One or both the arguements passed are null.");
		
		int n=text.length, m=pat.length;
		if (n == 0 || m == 0)  throw new IllegalArgumentException("One or both the arguements passed are empty.");
		
		if (m > n) throw new IllegalArgumentException("Pattern length greater than text length.");
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		/** STEP 1 : COMPUTE THE LPS ARRAY */
		int lps[] = new int[m];
		computeLPSArray(pat, lps, m);
		
		/** STEP 2 : USE THE LPS ARRAY TO PERFORM THE PATTERN SEARCHING */
		int i=0, j=0; 
		while (i < n) {
			if (text[i] == pat[j]) {
				i++; j++;
			}
			if (j == m) { // pattern found 
				result.add(i-j); 
				j = lps[j-1]; // adjust 'j'
			}
			else if (i < n && pat[j] != text[i]) {
				if (j != 0) {
					j = lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		return result;
	}
	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. It does this search based on some pre-processing and saving
	 * a some state/information of the pattern to reduce the time during the actual search.
	 * The extra information helps in skipping characters in the main pattern which eventually 
	 * reduces the time for search. The extra information saved is called the LPS array which is
	 * an integer array. <br><br>
	 * 
	 * LPS here stands for the longest shortest prefix that is also the suffix. We try and identify such 
	 * patterns in the pattern and make the LPS array.<br><br>
	 * For example consider the pattern 'abababca'. Then we fill create lps array ({@code int} array) equal
	 * to the length of the pattern. The value at index 'i' represents the lps value for the character at that 
	 * index in the pattern. If we consider cell 4 we have the sub pattern as "ababa" (start index  = 0). <br><br>
	 * 
	 * Proper Prefixes -> { abab, aba, ab, a } <br>
	 * Proper Suffixes -> { baba, aba, ba, a } <br><br>
	 * 
	 * From the above we observe that the longest suffix that matches the longest prefix is "aba" and its length = 3.
	 * Therefore the value of lps array at index 4 would be 3 OR lps[4] = 3. This is how the calculation is done. <br><br>
	 * 
	 * Worst Case Time Complexity - O(n), where n is the length of the text <br>
	 * 
	 * NOTE : Performs a case insensitive match
	 * 
	 * @param text - a text of type {@code String} in which we search for the pattern 
	 * @param pat - a pattern of type {@code String} which is to be searched
	 * @return - an {@code ArrayList<Integers>} with index at which match occurred
	 */
	public static ArrayList<Integer> searchPatternCaseInSensitive(String text, String pattern) {
		return searchPattern(text.toLowerCase().toCharArray(), pattern.toLowerCase().toCharArray());
	}
	
	/****
	 * Function to calculate the LPS[] integer array that helps in searching faster.<br>
	 * 
	 * @param pat - a pattern array of type {@code char[]} for which the lps array is to be built
	 * @param lps - a lps array of type {@code int[]} which represents the lps array
	 * @param m - length of the pattern string which is of type {@code int}
	 */
	private static void computeLPSArray(char[] pat, int[] lps, int m) {
		
		int i=1, len=0; // we start from 1
		lps[0] = 0; // start of lps is always set to 0
		
		while (i < m) {
			if (pat[i] == pat[len]) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if (len != 0) {
					len = lps[len-1];
				}
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}
}
