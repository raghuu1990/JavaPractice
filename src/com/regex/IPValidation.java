package com.regex;

// https://www.hackerrank.com/challenges/java-regex/problem

import java.util.Scanner;

public class IPValidation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new MyRegex().pattern));
		}
		in.close();
	}
}

class MyRegex {
	String ipNodeRegex = "([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
	String pattern = "^" + ipNodeRegex + "\\." + ipNodeRegex + "\\." + ipNodeRegex + "\\." + ipNodeRegex + "$";
}