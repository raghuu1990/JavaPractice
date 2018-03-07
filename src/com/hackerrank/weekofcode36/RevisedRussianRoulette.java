package com.hackerrank.weekofcode36;

import java.util.Scanner;

//  https://www.hackerrank.com/contests/w36/challenges/revised-russian-roulette

public class RevisedRussianRoulette {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int i = 0; i < n; i++){
            doors[i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        in.close();
    }

    static int[] revisedRussianRoulette(int[] doors) {
		int min = 0;
		int max = 0;
		boolean isLastUnlocked = false;
		for (int i = 0; i < doors.length; i++) {
			if(doors[i]==1) {
				max++;
				if(!isLastUnlocked) {
					min++;
					isLastUnlocked = true;
				}else {
					isLastUnlocked = false;
				}
			}else {
				isLastUnlocked = false;
			}
		}
		return new int[] {min, max};
    }
}