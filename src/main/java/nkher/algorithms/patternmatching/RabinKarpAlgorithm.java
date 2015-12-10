package nkher.algorithms.patternmatching;

import java.util.ArrayList;

/***
 * A linear time algorithm for pattern matching.
 * 
 * Worst Case time complexity - O(n+m) where,
 * n is the length of the text and m is the length of the pattern
 * 
 * @author nameshkher
 *
 */
public class RabinKarpAlgorithm {
	
	/***
	 * Unique chars in ASCII (in the input)
	 */
	public static final int CHARS = 256; 
	public static final int PRIME_NUMBER = 101;
	
	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. The search is done by using the power of hashing. Each window 
	 * of the text is hashed where the window length is the length of the pattern. The pattern 
	 * is also hashed. The hashed value of each window of text is compared with the hash value
	 * of the pattern and if a match is found then a complete match is done for that window
	 * between the text and the pattern. A mismatch in the hash value ensures that the substring
	 * (in that particular window of text) does not match the pattern.<br><br>
	 * 
	 * Worst Case Time Complexity - O(n), where n is the length of the text <br>
	 * 
	 * NOTE : Performs a case sensitive match
	 * 
	 * @param text - a text of type {@code String} in which we search for the pattern 
	 * @param pat - a pattern of type {@code String} which is to be searched
	 * @return - an {@code ArrayList<Integers>} with index at which match occurred
	 */
	public static ArrayList<Integer> searchPattern(String text, String pattern) {
		return searchPattern(text.toCharArray(), pattern.toCharArray());
	}
	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. The search is done by using the power of hashing. Each window 
	 * of the text is hashed where the window length is the length of the pattern. The pattern 
	 * is also hashed. The hashed value of each window of text is compared with the hash value
	 * of the pattern and if a match is found then a complete match is done for that window
	 * between the text and the pattern. A mismatch in the hash value ensures that the substring
	 * (in that particular window of text) does not match the pattern.<br><br>
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
	
	/***
	 * Searches for a pattern in a text and returns the indices of the start positions 
	 * where the match occurs. The search is done by using the power of hashing. Each window 
	 * of the text is hashed where the window length is the length of the pattern. The pattern 
	 * is also hashed. The hashed value of each window of text is compared with the hash value
	 * of the pattern and if a match is found then a complete match is done for that window
	 * between the text and the pattern. A mismatch in the hash value ensures that the substring
	 * (in that particular window of text) does not match the pattern.<br><br>
	 * 
	 * Worst Case Time Complexity - O(n), where n is the length of the text <br>
	 * 
	 * NOTE : Performs a case sensitive match
	 * 
	 * @param text - a text of type {@code char[]} in which we search for the pattern 
	 * @param pat - a pattern of type {@code char[]} which is to be searched
	 * @return - an {@code ArrayList<Integers>} with index at which match occurred
	 */
	public static ArrayList<Integer> searchPattern(char[] text, char[] pattern) {
		
		if (null == text || null == pattern) throw new IllegalArgumentException("One or both the arguements passed are null.");
		
		int n=text.length, m=pattern.length;
		if (n == 0 || m == 0)  throw new IllegalArgumentException("One or both the arguements passed are empty.");
		
		if (m > n) throw new IllegalArgumentException("Pattern length greater than text length.");
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int patternHash = 0, textHash = 0, hash = 1;
		int i, j; // variables for looping
		
		/***  STEP - 1 :  CALCULATING THE hash value */
		for (i=0; i<m-1; i++) {
			hash = (hash * CHARS) % PRIME_NUMBER;
		}
		
		/*** STEP - 2 : CALCULATE THE patternHash value and textHash for the first window **/
		for (i=0; i<m; i++) {
			textHash = ( (textHash * CHARS) + text[i]) % PRIME_NUMBER;
			patternHash = ( (patternHash * CHARS) + pattern[i]) % PRIME_NUMBER;
		}
						
		/*** STEP - 3 : CALCULATE the hash for each window and check for exact matches when hash value is found same for any window */
		for (i=0; i<=n-m; i++) {
			
			// checking if pattern hash and text hash are matching
			if (patternHash == textHash) {
				for (j=0; j<m; j++) {
					if (text[i+j] != pattern[j]) {
						break;
					}
				}
				/** Checking for exact match */
				if (m == j) {
					result.add(i);
				}
			}
			
			/*** Here we calculate the textHash for the next window */
			if (i < n-m) {
				
				textHash = (CHARS * (textHash - text[i]*hash) + text[i+m]) % PRIME_NUMBER;
								
				// handling the cas where the hash value might become negative
				if (textHash < 0) {
					textHash += PRIME_NUMBER;
				}
			}
		}
		
		return result;
	}
}
