package com.bit;

import java.util.Scanner;

/*
	  XOR(0 to n) f(x) = XOR(XOR(n-1),n)
i=0  -->  0 (n)	  --> 0*  (n)     0		  	(=0)	= 0	                        (Exception default 0)
i=1  -->  1 (1)	  --> 1   (1)	  0^1     	(=1)  	= 1
i=2  -->  3 (n+1) --> 3   (n+1)	  0^1^3   	(=2)	= 2
i=3  -->  0 (0)	  --> 0	  (0)     0^1^3^0 	(=2)	= 2
i=4  -->  4 (n)	  --> 4	  (n)     (2)^4          	= 6
i=5  -->  1 (1)	  --> 1   (1)	  (2)^4^1          	= 7
i=6  -->  7 (n+1) --> 7	  (n+1)   (2)^4^1^7         = 0
i=7  -->  0 (0)   --> 0	  (0)	  (2)^4^1^7^0		= 0
i=8  -->  8 (n)	  --> 8	  (n)
i=9  -->  1 (1)	  --> 1   (1)  
i=10 --> 11 (n+1) --> 11  (n+1)
i=11 --> 0  (0)	  --> 0	  (0)	  8^1^11^0  = 2
i=12 --> 12 (n)	  --> 12  (n)
i=13 --> 1  (1)	  --> 1	  (1)
i=14 --> 15 (n+1) --> 15  (n+1)
i=15 --> 0  (0)	  --> 0	  (0)	  12^1^15^0 = 2
i=16 --> 16 (n)	  --> 16  (n)
i=17 --> 1  (1)	  --> 1	  (1)
i=18 --> 19 (n+1) --> 19  (n+1)
i=19 --> 0 	(0)	  --> 0	  (0)	  16^1^19^0 = 2

*/

// https://www.hackerrank.com/challenges/xor-se
public class XORSequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] result = new long[t];

		for (int i = 0; i < t; i++) {
			long a = in.nextLong();
			long b = in.nextLong();
			result[i] = xorSequence(a, b);
		}
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static long xorSequence(long min, long max) {
		long minXor = computeXOR(min-1);   // a^a = 0 and 0^a = a 
		long maxXor = computeXOR(max);
		return minXor^maxXor;
	}
	
	private static long computeXOR(long x){
	    long a = x % 8;
	    if(a == 0 || a == 1) return x;
	    if(a == 2 || a == 3) return 2;
	    if(a == 4 || a == 5) return x+2;
	    if(a == 6 || a == 7) return 0;
	    return 0;
	}
}