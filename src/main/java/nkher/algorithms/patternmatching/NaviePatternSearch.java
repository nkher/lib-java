package nkher.algorithms.patternmatching;

import java.util.ArrayList;

/***
 * REFERENCE : http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
 * 
 * @author nameshkher
 *
 */
public class NaviePatternSearch {
	
	/***
	 * Returns an ArrayList of all the indices in the text where a match is found for the pattern.
	 * Throws Exceptions with appropriate messages arguments passed are incorrect. 
	 * The worst case time complexity is bounded by the maximum number of comparisons that can take place.
	 * Hence the worst case time complexity is :
	 * <br><br>
	 * Big O ( pattern_length * ( text_length - pattern_length + 1 )) 
	 * 
	 * @param text
	 * @param pat
	 */
	public static ArrayList<Integer> simpleMatch(String text, String pat) {
		
		if (null == text || null == pat) throw new IllegalArgumentException("One or both the arguements passed are null.");
		
		int n=text.length(), m=pat.length();
		if (n == 0 || m == 0)  throw new IllegalArgumentException("One or both the arguements passed are empty.");
		
		if (m > n) throw new IllegalArgumentException("Pattern length greater than text length.");
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int i, j;
		for (i=0; i<=n-m; i++) {
			for (j=0; j<m; j++) {
				if (text.charAt(i+j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	/***
	 * Returns an ArrayList of all the indices in the text where a match is found for the pattern.
	 * Throws Exceptions with appropriate messages arguments passed are incorrect. This algorithm is
	 * optimized for the case where the pattern passed for searching has all unique characters. This means 
	 * that there are no two characters. The efficiency is introduced by the fact that, when we search for patterns
	 * in the text and say after a certain number of matches (say j) we find a mismatch then instead of sliding our 
	 * window by 1 from current position, we slide by it by 'j' as we are guaranteed that there are no matching patterns 
	 * that exist in the text starting anywhere between the (current pos) and (current pos + j) indices. This is becuase
	 * our pattern is unique. Hence we can safely start searching after 'j' indices.
	 * <br><br>
	 * The worst case time complexity still remains the same and is bounded by the maximum number of comparisons that can take place.
	 * Hence the worst case time complexity is :
	 * <br>
	 * Big O ( pattern_length * ( text_length - pattern_length + 1 )) 
	 * 
	 * @param text
	 * @param pat
	 */
	public static ArrayList<Integer> simpleMatchEffUniquePattern(String text, String pat) {
		
		if (null == text || null == pat) throw new IllegalArgumentException("One or both the arguements passed are null.");
		
		int n=text.length(), m=pat.length();
		if (n == 0 || m == 0)  throw new IllegalArgumentException("One or both the arguements passed are empty.");
		
		if (m > n) throw new IllegalArgumentException("Pattern length greater than text length.");
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int i, j;
		for (i=0; i<=n-m; i++) {
			for (j=0; j<m; j++) {
				if (text.charAt(i+j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				result.add(i);
				i += m;
			}
			else {
				i = (j == 0) ? i++ : i+j;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		// System.out.println(simpleMatch("rtyuio9", "rtyuio9").toString());
		
		System.out.println(simpleMatchEffUniquePattern("ABCEABCDABCEABCD", "ABCD").toString());
	}

}
