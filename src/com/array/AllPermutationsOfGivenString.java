package com.array;

public class AllPermutationsOfGivenString {
	public static String swap(String str, int i, int j) {
		char[] charArray = str.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	private static void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i < r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	private static void permute(String str, String out) {
	    if (str.length() == 0) {
	    	System.out.println(out);
	    	return;
	    }
	 
	    for (int i = 0; i < str.length(); i++)  {
	        // Remove first character from str and add it to out
	    	char temp = str.charAt(0);
	        permute(str.substring(1, str.length()), out + temp);
	 
	        // Rotate string in a way second character moves to the beginning.
	        str = str.substring(1, str.length())+temp;
	    }
	}
 
	public static void main(String[] args) {
		String str = "def";
		int n = str.length();
		permute(str, 0, n);
		System.out.println();
		permute(str, "");
	}
}