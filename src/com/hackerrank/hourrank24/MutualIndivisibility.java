package com.hackerrank.hourrank24;

import java.util.Scanner;

// https://www.hackerrank.com/contests/hourrank-24/challenges/mutual-indivisibility
// https://www.geeksforgeeks.org/discrete-mathematics-the-pigeonhole-principle/

public class MutualIndivisibility {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int x = in.nextInt();
			findSet1(a, b, x);
		}
		in.close();
	}
	
	public static void findSet1(int a, int b, int x) {
		int m = Math.min(b - a + 1, (b + 1) / 2);
        if(x > m) {
            System.out.println(-1);
        } else {
            for(int i = b; i > b - x; i--) {
            	 System.out.print(i+" ");
            }
            System.out.println();
        }
	}

	public static void findSet(int a, int b, int x) {
		int[] skills = new int[b - a + 1];
		int teamSize = 0;
		for (int i = b; i >= a; i--) {
			teamSize++;

			int multiple = i * 2;
			int count = 2;

			while (multiple <= b) {
				// strike out the multiple, hence decrease team size
				skills[multiple - a] = 1;
				teamSize--;

				count++;
				multiple = i * count;
			}

			// break as needed team size is reached
			if (teamSize == x) {
				break;
			}
		}

		if (teamSize >= x) {
			int i = skills.length - 1;
			while (i >= 0 && x > 0) {
				if (skills[i] == 0) {
					System.out.print(i + a);
					System.out.print(" ");
					x--;
				}
				i--;
			}
			System.out.println("");
		} else {
			System.out.println(-1);
		}
	}
}