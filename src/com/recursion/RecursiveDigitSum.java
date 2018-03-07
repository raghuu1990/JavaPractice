package com.recursion;

import java.math.BigInteger;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/recursive-digit-sum

public class RecursiveDigitSum {
	
	/*public static void main(String[] args) {
        String arr[] = new Scanner(System.in).nextLine().split("[ ]");
        int output = (Integer.parseInt(arr[1])*new BigInteger(arr[0]).remainder(new BigInteger("9")).intValue())%9;
        System.out.println(output == 0 ? 9: output);
    }*/
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger a = new BigInteger(in.next());
		BigInteger b = new BigInteger(in.next());
		BigInteger c = recursiveDigitSum(a, b);
		in.close();
		System.out.println(c);
	}
	

	private static BigInteger recursiveDigitSum(BigInteger a, BigInteger b) {
		BigInteger sum = recursiveDigitSum(a);
		return recursiveDigitSum(sum.multiply(b));
	}

	private static BigInteger recursiveDigitSum(BigInteger a) {
		BigInteger sum = digitSum(a);
		while (sum.compareTo(new BigInteger("9"))==1) {
			sum = digitSum(sum);
		}
		return sum;
	}

	private static BigInteger digitSum(BigInteger a) {
		BigInteger sum = new BigInteger("0");
		while (a.compareTo(new BigInteger("0"))==1) {
			BigInteger reminder = a.remainder(new BigInteger("10"));
			sum =  sum.add(reminder);
			a = a.divide(new BigInteger("10"));
		}
		return sum;
	}
}