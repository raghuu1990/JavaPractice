package com.basics;

// http://www.geeksforgeeks.org/fitting-shelves-problem/

// Second shelve is cheaper so it is preferred.

public class FittingShelvesProblem {

	public static void main(String[] args) {
		// int wall = 24, m = 3, n = 8;
		// minSpacePreferLarge(wall, m, n);
		minSpacePreferLarge(6, 3, 5);
		minSpacePreferLarge1(6, 3, 5);
		minSpacePreferLarge(9, 3, 5);
		minSpacePreferLarge1(9, 3, 5);
		minSpacePreferLarge(24, 3, 8);
		minSpacePreferLarge1(24, 3, 8);
		minSpacePreferLarge(24, 8, 3);
		minSpacePreferLarge1(24, 8, 3);

		minSpacePreferLarge(9, 3, 5);
		minSpacePreferLarge1(9, 3, 5);
		minSpacePreferLarge(10, 3, 5);
		minSpacePreferLarge1(10, 3, 5);
		minSpacePreferLarge(24, 3, 5);
		minSpacePreferLarge1(24, 3, 5);
		minSpacePreferLarge(72, 3, 5);
		minSpacePreferLarge1(72, 3, 5);
		
		minSpacePreferLarge(7, 3, 5);
		minSpacePreferLarge1(7, 3, 5);

		minSpacePreferLarge(8, 3, 7);
		minSpacePreferLarge1(8, 3, 7);
		
		minSpacePreferLarge(18, 5, 5);
		minSpacePreferLarge1(18, 5, 5);
		
		minSpacePreferLarge(18, 7, 17);
		minSpacePreferLarge1(18, 7, 17);
		
	}
	
	public static void minSpacePreferLarge1(int wall, int m, int n) {
		 int num_m = 0, num_n = wall/n, rem=wall%n, min_empty = wall%n;

		 while(rem!=0 && (wall%m ==0 || wall%(n+m)==0 || wall%m<rem)) {
			 if(rem%m==0) {
				 num_m = rem/m;
				 rem=0;
				 break;
			 }else if(rem<m){
				 rem = rem +n ;
				 num_n = num_n - 1;
			 }else if(rem>m && wall%m !=0) {
				 if(wall%n <= wall%m) {
					 rem = wall%n;
					 num_m = 0;
					 num_n = wall/n;
				 }else {
					 rem =  wall%m;
					 num_m = wall/m;
					 num_n = 0;
				 }
				 break;
			 }else if(rem >m) {
				 rem = rem +n ;
				 num_n = num_n - 1;
			 }
		 }
		 System.out.println(num_m + " " + num_n + " " + rem);
		 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void minSpacePreferLarge(int wall, int m, int n) {
		// for cases (wall<n, num_m = wall/m)
        int num_m = wall/m, num_n = 0, min_empty = wall%m;

        /*
        if(wall<n) {
        	System.out.println(wall/m + " " + 0 + " " + wall%m);
        }*/

        int p = 0, q = 0, rem=0;
		while (wall >= n) {
			// place one more shelf of length n
			q += 1;
			wall = wall - n;

			// place as many shelves of length m in the remaining part
			p = wall / m;
			rem = wall % m;

			// update output variablse if curr min_empty <= overall empty
			if (rem <= min_empty) {
				num_m = p;
				num_n = q;
				min_empty = rem;
			}
		}
        System.out.println(num_m + " " + num_n + " " + min_empty);
    }
}