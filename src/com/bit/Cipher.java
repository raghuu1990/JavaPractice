package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/cipher

public class Cipher {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int k = in.nextInt();
		String str = in.next();
		char[] result = deCrypt(k, str.substring(0, s).toCharArray());
		for (int i = 0; i < s; i++) {
			System.out.print(result[i] + "");
		}
		in.close();
	}

	private static char[] deCrypt(int k, char[] bits) {
		char[] result = new char[bits.length];
		for (int i = 0; i < bits.length; i++) {
			if (i == 0) {
				result[0] = bits[0];
			} else if (i < k) {
			//  result[i]=bits[i]^bits[i-1];
				result[i] = (bits[i] == bits[i - 1]) ? '0' : '1';
			} else {
			//  result[i]=bits[i]^bits[i-1]^result[i-k];
				result[i] = (((bits[i] == bits[i - 1]) ? '0' : '1') == result[i - k]) ? '0' : '1';
			}
		}
		return result;
	}

	/*
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int k = in.nextInt();
		String str = in.next();
		long result = deCrypt(s, k, convertToBinary(str));
		printBinary(result, k);
		in.close();
	}
	
	private static long convertToBinary(String str) {
		long result = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='1') {
				result+= Math.pow(2, str.length()-1-i);
			}
		}
		return result;
	}

	private static void printBinary(long num, int k) {
		num = num>>k-1;
		String str = "";
		if(num==0) {
			str = "0";
		}
		while(num>0) {
			int r = (int)num%2;
			str=""+r+str;
			num-=r;
			num/=2;
		}
		System.out.println(str);
	}

	private static long deCrypt(int s, int k , long num) {
		if(k<2) {
			return num;
		}
		num = num^num>>1;
		return deCrypt(s, --k, num);
	}
	
*/	
}