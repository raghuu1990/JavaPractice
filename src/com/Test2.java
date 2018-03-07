package com;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] output = new int[t];

		for (int i = 0; i < t; i++) {
			String str = in.next();
			output[i] = getlastIndex(str);
		}

		for (int i = 0; i < t; i++) {
			System.out.println(output[i]);
		}
		in.close();
	}

	static void fairRations(int[] B) {
		int count = 0;
		for (int i = 0; i < B.length-1; i++) {
			if(B[i]%2==1) {
				B[i+1]++;
			}
		}
		if(B[B.length-1]%2==1) {
			System.out.println("NO");
		}else {
			System.out.println(count);
		}
	}

	public static int getlastIndex(String str) {
		int l = str.length();
		for (int i = l - 1; i >= 0; i--) {
			if (str.charAt(i) == '1') {
				return i;
			}
		}
		return -1;
	}
}
