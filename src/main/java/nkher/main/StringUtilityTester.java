package nkher.main;

import nkher.utils.StringUtility;

public class StringUtilityTester {

	public static void main(String[] args) {

		String str = "aabeedbbbesssffeh";
		System.out.println(StringUtility.runLengthEncoding(str));
		
		// System.out.println(decompress("a2be2db3es3f2").equals(str));
		
		System.out.println(StringUtility.decompress("a2be2db3es3f2eh").equals(str));
		
		System.out.println(StringUtility.isPalindromeCaseInsensitive("niTtin"));
		
		System.out.println(StringUtility.stoi("-17045733") - 10);
		
		// System.out.println(StringUtility.stoi(null));
	}

}
