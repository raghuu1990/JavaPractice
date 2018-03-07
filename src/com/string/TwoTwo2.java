package com.string;

import java.math.BigInteger;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class TwoTwo2 {
	private static LinkedList<String> powerOfTwo = new LinkedList<String>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String[] input = new String[t];
		for (int i = 0; i < t; i++) {
			input[i] = in.nextLine();
		}

		preparePowerOfTwo(800);
		for (int i = 0; i < t; i++) {
			System.out.println(find(input[i]));
		}
		in.close();
	}

	public static int find(String input) {
		int count = 0;
		for (String power : powerOfTwo) {
			if(power.length()<=input.length()) {
				count+=StringUtils.countMatches(input, power);
			}
		}
		return count;
	}

	public static LinkedList<String> preparePowerOfTwo(int n) {
		BigInteger fact = new BigInteger("1");
		powerOfTwo.add(fact+"");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(2 + ""));
			powerOfTwo.add(fact+"");
		}
		return powerOfTwo;
	}
}