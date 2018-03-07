package com.bit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class NthPalindrome2 {
	private static HashMap<Long, Long> palGroup = new HashMap<Long, Long>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] input = new long[t];
		long max = 0;
		for (int i = 0; i < t; i++) {
			long num = in.nextLong();
			if (max < num) {
				max = num;
			}
			input[i] = num;
		}
		createGroup(max);
		for (int i = 0; i < input.length; i++) {
			getNthPalindrome(input[i]);
		}
		/*
		//long max = 1000000000000000000l;
		//long max = 100l;
		createGroup(max);
		for (long i = 1; i < max; i++) {
			System.out.print(i+" : ");
			getNthPalindrome(i);
		}
		*/
		
		
		in.close();
	}
	
	private static void getNthPalindrome(long j) {
		long group = getGroup(j);
		if(group==-1) {
			System.out.println("-1");
			return;
		}
		
		long l = group+1;
		long n = j-(long)palGroup.get(group);
		
		if(l==1) {
			System.out.println(1);
			return;
		}
		if(l==2) {
			System.out.println(3);
			return;
		}
		BigDecimal result = new BigDecimal((long)( Math.pow(2, (l-1)) + 1));
		//long result = (long) Math.pow(2, (l-1)) + 1;
		l-=2;
		n-=1;
		if(l%2==0) {
			l = l/2;
			for (long i = 0; i < l; i++) {
				if((n & ((long)1<<i))==((long)1<<i)) {
					result = result.add(new BigDecimal(((long)1<<(l+1+i)) + ((long)1<<(l-i))));
					//result += ((long)1<<(l+1+i)) + ((long)1<<(l-i));
				}
			}
		}else {
			l = (l-1)/2;
			result = result.add(new BigDecimal((long)(n & 1)<<(l+1)));
			//result +=(n & 1)<<(l+1);
			for (long i = 1; i <= l; i++) {
				if((n & ((long)1<<i))==((long)1<<i)) {
					result = result.add(new BigDecimal(((long)1<<(l+1+i)) + ((long)1<<(l-i+1))));
					//result += ((long)1<<(l+1+i)) + ((long)1<<(l-i+1));
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
}