package com.string;

import java.math.BigInteger;
import java.util.Scanner;

public class TwoTwo {
	private static String[] powerOfTwoArr = new String[801];
	
	public static String[] preparePowerOfTwo(int n) {
		BigInteger fact = new BigInteger("1");
		powerOfTwoArr[0] = fact.toString();
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(2 + ""));
			powerOfTwoArr[i] = fact.toString();
		}
		return powerOfTwoArr;
	}

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
			find(t, input[i]);
		}
		in.close();
	}

	static void find(int t, String input) {
		int count = 0;
		for (int j = 0; j <= 800; j++) {
			String power = powerOfTwoArr[j];
			if(input.length()>=power.length()){
				String string = input;
				while(string.length()>=power.length()){
					if(string.contains(power)){
						count += 1;
						string = string.substring(string.indexOf(power)+1);
					}else {
						break;
					}
				}
			}else {
				break;
			}
		}
		System.out.println(count);
	}
}