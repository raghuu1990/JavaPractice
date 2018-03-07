package com.hackerrank.hourrank25;

import java.util.Scanner;

// https://www.hackerrank.com/contests/hourrank-25/challenges/maximum-palindromes

public class MaximumPalindromes {
	private static int mod = 1000000007;
	private static long fact[] = new long[100001];
	public static int[][] map;

	static void initialize(String s) {
		map = new int[26][s.length()+1];
		for (int j = 1; j <= s.length(); j++) {
			for (int i = 0; i < 26; i++) {
				map[i][j] = map[i][j-1];
			}
			map[s.charAt(j-1)-'a'][j]++;
		}

		fact[0] = 1;
		for (int i = 1; i <= 100000; i++) {
			fact[i] = (fact[i - 1] * i) % mod;
		}
	}

	static long answerQuery(String s, int l, int r) {
		int odd = findNoOFOdd(l, r);
		int size = r-l+1-odd;
		long res = fact[size/2];
		long div = 1;
		for (int i = 0; i < 26; i++) {
			if((map[i][r]-map[i][l-1])>3) {
				int num = (map[i][r]-map[i][l-1])/2;
				div=(div*fact[num])%mod;
			}
		}
		// a^-1 ≡ a^(m-2) (mod m) , if m is prime
		res = (res*modInverse(div, mod-2, mod))%mod;
		if(odd>0) {
			return (odd*res)%mod;
		}
		return res;
	}

	public static long modInverse(long base, int exp, int mod) {
		if (exp == 0 || base==1) {
			return 1;
		}

		long p = modInverse(base, exp / 2, mod);
		p = (p * p) % mod;
		return (exp % 2 == 0) ? p : (base * p) % mod;
	}

	private static int findNoOFOdd(int l, int r) {
		int count = 0;
		for (int i = 0; i < 26; i++) {
			count+=(map[i][r]-map[i][l-1])%2;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		initialize(s);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int l = in.nextInt();
			int r = in.nextInt();
			long result = answerQuery(s, l, r);
			System.out.println(result);
		}
		in.close();
	}
}