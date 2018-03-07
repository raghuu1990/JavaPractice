package com.search;

public class KMP {
	public static void main(String args[]) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		// String pat = "AAACAAAA";
		search(pat, txt);
	}

	public static void search(String pat, String txt) {
		int lps[] = computeLPSArray(pat);

		int M = pat.length();
		int N = txt.length();

		int i = 0;
		int l = 0;

		while (i < N) {
			if (pat.charAt(l) == txt.charAt(i)) {
				l++;
				i++;
			}
			if (l == M) {
				System.out.println("Found pattern " + "at index " + (i - l));
				l = lps[l - 1];
			} else if (i < N && pat.charAt(l) != txt.charAt(i)) {
				if (l != 0) {
					l = lps[l - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}

	public static int[] computeLPSArray(String pat) {
		int size = pat.length();
		int lps[] = new int[size];
		int l = 0;
		lps[0] = l;

		int i = 1;
		while (i < size) {
			if (pat.charAt(i) == pat.charAt(l)) {
				l++;
				lps[i] = l;
				i++;
			} else {
				if (l != 0) { // AAACAAAA and i = 7
					l = lps[l - 1];
				} else {
					lps[i] = l; // 0
					i++;
				}
			}
		}
		return lps;
	}
}