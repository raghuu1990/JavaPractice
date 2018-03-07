package com.company.goldman;

import java.util.Scanner;

public class GoldMan3 {
	public static int totalWays = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		noOfWaysToDrawTheGame(n);
		System.out.println(totalWays);
		in.close();
	}

	static int noOfWaysToDrawTheGame(int totalScore) {
		if(totalScore%2==1) {
			totalWays=0;
			return totalWays;
		}
		noOfWaysToDrawTheGame(totalScore, 2);
		noOfWaysToDrawTheGame(totalScore, 4);
		noOfWaysToDrawTheGame(totalScore, 6);
		return totalWays;
	}
	
	static void noOfWaysToDrawTheGame(int remaining, int num) {
		remaining = remaining - num; 
		if(remaining==0) {
			totalWays++;
		}
		if (remaining<=0) {
			return;
		}
		noOfWaysToDrawTheGame(remaining, 2);
		if (remaining<=2) {
			return;
		}
		noOfWaysToDrawTheGame(remaining, 4);
		if (remaining<=4) {
			return;
		}
		noOfWaysToDrawTheGame(remaining, 6);
	}
}
