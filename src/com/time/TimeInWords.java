package com.time;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/the-time-in-words/problem

public class TimeInWords {

	static String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
			"twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
			"twenty seven", "twenty eight", "twenty nine" };

	static void timeInWords(int h, int m) {
		if (m == 0) {
			System.out.println(numbers[h] + " o' clock");
		} else if (m == 15) {
			System.out.println("quarter past " + numbers[h]);
		} else if (m == 30) {
			System.out.println("half past " + numbers[h]);
		} else if (m == 45) {
			System.out.println("quarter to " + numbers[h+1]);
		} else if (m == 1) {
			System.out.println("one minute past " + numbers[h]);
		} else if (m < 30) {
			System.out.println(numbers[m] + " minutes past " + numbers[h]);
		} else if (m == 59) {
			System.out.println("one minute to " + numbers[h + 1]);
		} else if (m > 30) {
			System.out.println(numbers[60 - m] + " minutes to " + numbers[h + 1]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		timeInWords(h, m);
		in.close();
	}
}