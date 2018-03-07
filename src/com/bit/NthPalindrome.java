package com.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NthPalindrome {
	private static ArrayList<Long> pal;
	private static HashMap<Long, Long> palGroup = new HashMap<Long, Long>();


	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] input = new long[t];
		long max = 0;
		for (int i = 0; i < t; i++) {
			long num = in.nextInt();
			if (max < num) {
				max = num;
			}
			input[i] = num;
		}
		createPals(max);
		for (int i = 0; i < t; i++) {
			System.out.println(pal.get((int) (input[i] - 1)));
		}
		
		createGroup(max);
		for (int i = 0; i < input.length; i++) {
			printNthPalindrome(input[i]);
		}
	
		in.close();
		*/
		
		createPals(50000l);
		createGroup(50000l);
		
		for (long i = 1; i < 49990l; i++) {
			System.out.println(i);
			printNthPalindrome(i);
			System.out.println(pal.get((int) (i-1)));
			System.out.println();
		}
		
	}

	public static void createPals(long max) {
		pal = new ArrayList<Long>();
		long count = 0;
		long num = 1;
		while (count < max) {
			if (isPalindrom(num)) {
				pal.add(num);
				count++;
			}
			num++;
		}
	}
	
	public static void printNthPalindrome(long n) {
		long group = getGroup(n);
		if(group==-1) {
			System.out.println("-1");
		}else {
			getNthPalindrome(group+1, n-(long)palGroup.get(group));
		}
	}
	
	private static void getNthPalindrome(long l, long n) {
		if(l==1) {
			System.out.println(1);
			return;
		}
		if(l==2) {
			System.out.println(3);
			return;
		}

		long result = (long) Math.pow(2, (l-1)) + 1;
		l-=2;
		n-=1;
		if(l%2==0) {
			l = l/2;
			for (long i = 0; i < l; i++) {
				if((n & ((long)1<<i))==((long)1<<i)) {
					result += ((long)1<<(l+1+i)) + ((long)1<<(l-i));
				}
			}
		}else {
			l = (l-1)/2;
			result +=(n & 1)<<(l+1);
			for (long i = 1; i <= l; i++) {
				if((n & ((long)1<<i))==((long)1<<i)) {
					result += ((long)1<<(l+1+i)) + ((long)1<<(l-i+1));
				}
			}
		}
		System.out.println(result);
	}

	public static long getGroup(long n) {
		for (long i : palGroup.keySet()) {
			if((Long)palGroup.get(i)>=n) {
				return i-1;
			}
		}
		return -1; 
	}

	public static void createGroup(long n) {
		palGroup.put(0l, 0l);
		long value = 0;
		for (long i = 1; i <= n && value < n; i++) {
			value = getNoOfPallindromWithDigit((long) (i - 1)) + getNoOfPallindromWithDigit(i);
			palGroup.put((long) i, value);
		}
	}

	public static long getNoOfPallindromWithDigit(Long key) {
		if(palGroup.containsKey(key)) {
			return (Long)palGroup.get(key);
		}
		if(key==1) {
			palGroup.put(1l, 1l);
			return 1;
		}
		if(key==2) {
			palGroup.put(2l, 1l);
		} else {
			palGroup.put(key, (long) (Math.pow(2, (int)((key-1)/2))));
		}
		return (Long)palGroup.get(key);
	}

	public static boolean isPalindrom(long num) {
		int l = getMaxBit(num);
		for (int i = 0; i <= l / 2; i++) {
			int rightBit = ((num & (((long) 1) << i)) == (((long) 1) << i)) ? 1 : 0;
			int leftBit = ((num & (((long) 1) << (l - i))) == (((long) 1) << (l - i))) ? 1 : 0;
			if (rightBit != leftBit) {
				return false;
			}
		}
		return true;
	}

	public static int getMaxBit(long num) {
		for (int i = 62; i >= 0; i--) {
			if ((num & ((long) 1 << i)) == ((long) 1 << i)) {
				return i;
			}
		}
		return -1;
	}
}