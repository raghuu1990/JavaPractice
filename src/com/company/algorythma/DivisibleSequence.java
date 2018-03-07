package com.company.algorythma;

import java.math.BigInteger;
import java.util.Scanner;

public class DivisibleSequence {
	private static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			sc.nextInt();
			String str = sc.next();
			getCount(str, "", 0, false);
			System.out.println(count);
			count = 0;
		}
		sc.close();
	}

	private static void getCount(String str, String s1, int index, boolean flag) {
		if(flag && isD(s1)) {
			count++;
		}
		if(index==str.length()) {
			return;
		}
		getCount(str, s1+str.charAt(index), index+1, true);
		getCount(str, s1, index+1, false);
	}

	private static boolean isD(String str) {
		if(str.equalsIgnoreCase("")) {
			return false;
		}
		BigInteger b = new BigInteger(str);
		if(b.mod(new BigInteger("101")).equals(new BigInteger("0"))) {
			return true;
		}
		return false;
	}
}
