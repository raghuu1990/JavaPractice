package com.hackerrank.hack101;

// https://www.hackerrank.com/contests/101hack53/challenges/cut-board/

// TODO :

public class CutBoard {

	static void fillBoard(int n, int m, int x, int y) {
		int k = ((n * m) - x - y);
		if (k % 2 == 1) {
			System.out.println("NO");
		} else {
            k/=2;
			if(x+y==m) {
				
			} else {
				
			}
			
			System.out.println("YES");
			System.out.println(k);
			for (int i = x+1; i <= k; i++) {
				System.out.println(((i/n)+1) +" "+(((i)%1)+1) + " " +(((i+1)/2)+1) +" "+(((i+1)%m)+1));
			}
		}

	}
}