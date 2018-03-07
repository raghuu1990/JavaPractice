package com.bit;

public class BitUtils {
	private static long computeXORZeroToN(long n) {
		if (n % 4 == 0)
			return n;

		if (n % 4 == 1)
			return 1;

		if (n % 4 == 2)
			return n + 1;

		return 0;
	}

	private static long findNoOfZero(long x) {
		long count = 0;
		for (int i = 62; i >= 0; i--) {
			if ((((long) 1) << i) < x) {
				if (((((long) 1) << i) & x) == 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static int indexOfFirstOneBitFromLeft(long n) {
        for (int i = 62; i >= 0; i--) {
            if (((1<<i) & n) == (1<<i)) {
                return i;
            }
        }
        return -1;
    }
	
	private static int indexOfFirstZeroBitFromLeft(long x) {
		for (int i = 62; i >= 0; i = i--) {
			if ((((long) 1) << i) < x) {
				if (((((long) 1) << i) & x) == 0) {
					return i;
				}
			}
		}
		return -1;
	}

	private static long flip(Long n) {
		for (int i = 31; i >= 0; i--) {
			n = n^((long)1<<i); 
		}
		return n;
	}
}