package com.bit;

import java.math.BigInteger;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/aorb

// TODO :

public class AorB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		long[] k = new long[q];
		String[] a = new String[q];
		String[] b = new String[q];
		String[] c = new String[q];

		for (int i = 0; i < q; i++) {
			k[i] = in.nextLong();
			in.nextLine();
			a[i] = in.nextLine();
			b[i] = in.nextLine();
			c[i] = in.nextLine();
		}
		for (int i = 0; i < q; i++) {
			aorb(k[i], a[i], b[i], c[i]);
		}
		in.close();
	}

	private static void aorb(long k, String a, String b, String c) {
		char[] AA = hexToBinary(a);
		char[] BB = hexToBinary(b);
		char[] CC = hexToBinary(c);
		long used = 0;

		int maxLength = Math.max(AA.length, Math.max(CC.length, BB.length));

		char[] A = copy(AA, maxLength);
		char[] B = copy(BB, maxLength);
		char[] C = copy(CC, maxLength);

		for (int i = 0; (i < maxLength) && (used <= k); i++) {
			if (used > k) {
				System.out.println(-1);
				return;
			}
			if (C[i] == '1') {
				if (A[i] == '0' && B[i] == '0') {
					used++;
					B[i] = '1';
				}
			} else {
				if (B[i] == '1') {
					used++;
					B[i] = '0';
				}

				if (A[i] == '1') {
					used++;
					A[i] = '0';
				}
			}
		}
		if (used > k) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < maxLength && used < k; i++) {
			if (C[i] == '1') {
				if (A[i] == '1' && B[i] == '0' && k - used >= 2) {
					A[i] = '0';
					B[i] = '1';
					used++;
					used++;
				}
				if (A[i] == '1' && B[i] == '1') {
					used++;
					A[i] = '0';
				}
			}
		}

		System.out.println(binaryToHex(A));
		System.out.println(binaryToHex(B));
	}

	private static char[] hexToBinary(String a) {
		return decimalToBinary(hexToDecimal(a));
	}

	private static String binaryToHex(char[] a) {
		return decimalToHex(binaryToDecimal(a));
	}

	private static BigInteger hexToDecimal(String a) {
		BigInteger num = new BigInteger("0");
		long l = a.length();
		for (int i = 0; i < l; i++) {
			num = num.add(new BigInteger(getStringToHax(a.charAt(i)) + "")
					.multiply(new BigInteger(16 + "").pow((int) (l - 1 - i))));
		}
		return num;
	}

	private static BigInteger binaryToDecimal(char[] a) {
		BigInteger num = new BigInteger("0");
		long l = a.length;
		for (int i = 0; i < l; i++) {
			num = num.add(new BigInteger(a[i] + "").multiply(new BigInteger(2 + "").pow((int) (l - 1 - i))));
		}
		return num;
	}

	private static char[] decimalToBinary(BigInteger num) {
		String binary = "";
		if (num.compareTo(new BigInteger("0")) == 0) {
			binary = "0";
		}
		while (num.compareTo(new BigInteger("0")) == 1) {
			BigInteger r = num.remainder(new BigInteger(2 + ""));
			binary = r + binary;
			num = num.subtract(r);
			num = num.divide(new BigInteger(2 + ""));
		}
		return binary.toCharArray();
	}

	private static String decimalToHex(BigInteger num) {
		String hex = "";
		if (num.compareTo(new BigInteger("0")) == 0) {
			hex = "0";
		}
		while (num.compareTo(new BigInteger("0")) == 1) {
			BigInteger r = num.remainder(new BigInteger(16 + ""));
			hex = getHaxString(r) + hex;
			num = num.subtract(r);
			num = num.divide(new BigInteger(16 + ""));
		}
		return hex;
	}

	private static String getHaxString(BigInteger r) {
		if (r.compareTo(new BigInteger("15")) == 0) {
			return "F";
		}
		if (r.compareTo(new BigInteger("14")) == 0) {
			return "E";
		}
		if (r.compareTo(new BigInteger("13")) == 0) {
			return "D";
		}
		if (r.compareTo(new BigInteger("12")) == 0) {
			return "C";
		}
		if (r.compareTo(new BigInteger("11")) == 0) {
			return "B";
		}
		if (r.compareTo(new BigInteger("10")) == 0) {
			return "A";
		}
		return r + "";
	}

	private static int getStringToHax(char c) {
		if (c == 'F') {
			return 15;
		}
		if (c == 'E') {
			return 14;
		}
		if (c == 'D') {
			return 13;
		}
		if (c == 'C') {
			return 12;
		}
		if (c == 'B') {
			return 11;
		}
		if (c == 'A') {
			return 10;
		}
		return Integer.parseInt(c + "");
	}

	private static char[] copy(char[] arr, int size) {
		char[] result = new char[size];
		int countrer = arr.length - 1;
		for (int i = size - 1; i >= 0; i--) {
			if (countrer < 0) {
				result[i] = '0';
			} else {
				result[i] = arr[countrer];
			}
			countrer--;
		}
		return result;
	}
}