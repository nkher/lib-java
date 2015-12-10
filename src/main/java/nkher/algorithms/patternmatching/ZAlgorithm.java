package nkher.algorithms.patternmatching;

import java.util.ArrayList;

/****
 * A linear time algorithm for pattern matching.
 * 
 * REFERENCE :  https://www.youtube.com/watch?v=CpZh4eF8QBw
 * 
 * @author nameshkher
 *
 */
public class ZAlgorithm {
	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. It does this search based on some preprocessing and saving
	 * a some state/information of the pattern to reduce the time during the actual search.
	 * Here the preprocessing is performed on a concatenated String of the form (pattern + '$' + text)
	 * and not alone on the text of the pattern. The extra information helps in skipping 
	 * characters in the main pattern which eventually reduces the time for search. 
	 * The extra information saved is called the Z array which is an integer array. <br><br>
	 * 
	 * Time Complexity : O(m+n) time where m = pattern length and n = text length. <br>
	 * 
	 * NOTE : Performs a case sensitive match
	 * 
	 * @param text
	 * @param pat
	 * @return
	 */
	public static ArrayList<Integer> zAlgoSearch(String text, String pat) {
		return zAlgoSearch(text.toCharArray(), pat.toCharArray());
	}
	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. It does this search based on some preprocessing and saving
	 * a some state/information of the pattern to reduce the time during the actual search.
	 * Here the preprocessing is performed on a concatenated String of the form (pattern + '$' + text)
	 * and not alone on the text of the pattern. The extra information helps in skipping 
	 * characters in the main pattern which eventually reduces the time for search. 
	 * The extra information saved is called the Z array which is an integer array. <br><br>
	 * 
	 * Time Complexity : O(m+n) time where m = pattern length and n = text length. <br>
	 * 
	 * NOTE : Performs a case insensitive match
	 * 
	 * @param text
	 * @param pat
	 * @return
	 */
	public static ArrayList<Integer> zAlgoSearchCaseInSensitive(String text, String pat) {
		return zAlgoSearch(text.toLowerCase().toCharArray(), pat.toLowerCase().toCharArray());
	}

	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. It does this search based on some preprocessing and saving
	 * a some state/information of the pattern to reduce the time during the actual search.
	 * Here the preprocessing is performed on a concatenated String of the form (pattern + '$' + text)
	 * and not alone on the text of the pattern. The extra information helps in skipping 
	 * characters in the main pattern which eventually reduces the time for search. 
	 * The extra information saved is called the Z array which is an integer array. <br><br>
	 * 
	 * Time Complexity : O(m+n) time where m = pattern length and n = text length. <br>
	 * 
	 * NOTE : Performs a case sensitive match
	 * 
	 * @param text
	 * @param pat
	 * @return
	 */
	public static ArrayList<Integer> zAlgoSearch(char text[], char pat[]) {
		
		if (null == text || null == pat) throw new IllegalArgumentException("One or both the arguements passed are null.");
		
		int n=text.length, m=pat.length;
		if (n == 0 || m == 0)  throw new IllegalArgumentException("One or both the arguements passed are empty.");
		
		if (m > n) throw new IllegalArgumentException("Pattern length greater than text length.");
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		char concatStr[] = new char[n+m+1]; // pattern + $ + text
		
		/** Forming the concat String */
		int i, wi=0;
		for (i=0; i<m; i++) {
			concatStr[wi++] = pat[i];
		}
		concatStr[wi++] = '$';
		for (i=0; i<n; i++) {
			concatStr[wi++] = text[i];
		}
		/** Forming the concat String */
		
		int zArray[] = new int[m+n+1]; // This is the array we need to fill
		
		/** Generating the zArray */
		formzArray(concatStr, zArray);
		
		/** Get the result from the zArray */
		for (i=0; i<(m+n+1); i++) {
			if (zArray[i] == m) {
				result.add(i - m - 1);
			}
		}
		
		return result;
	}
	
	/****
	 * 
	 * Function that builds the zArray used for pattern searching.
	 * 
	 * @param str
	 * @param zArray
	 */
	private static void formzArray(char str[], int[] zArray) {
		
		int n = str.length;
		int l, r, k;
		
		l = r = 0;
		int i;
		for (i=0; i<n; i++) {
			
			if (i > r) {
				l = r = i;
				// At the start r-l = 0, hence we start comparing from the first element in the array
				while (r < n && str[r-l] == str[r]) {
					r++;
				}
				zArray[i] = r-l;
				r--;
			}
			else {
				// this means we have a z window and 'k' is a number that matches in [l, r] interval
				k = i-l;
				
				/* check if z[k] is not overflowing out of the right bound of the current window. 
				   If not then z[i] will be equal to z[k] */
				if (zArray[k] < r-i+1) {
					zArray[i] = zArray[k];
				}
				else {
					l = i; // so that we get (r-l = 0) and start comparing again from the first element in the array as we did in the if case
					while (r < n && str[r-l] == str[r]) {
						r++;
					}
					zArray[i] = r-l;
					r--;
				}
			}
		}
	}
}
