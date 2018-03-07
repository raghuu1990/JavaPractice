package com.hackerrank.weekofcode35;

import java.util.Scanner;

// https://www.hackerrank.com/contests/w35/challenges/highway-construction/problem

public class HighwayConstruction {
	static long MOD = (long) 1e9 + 9;
	static long[][] cs = new long[1010][1010];
	static long[] invs = new long[1010];
	static long[] bs = new long[1010];

	static long power(long num, long power) {
		if (power == 0) {
			return 1L;
		}
		if (power == 1) {
			return num;
		}
		long result = power(num, power / 2);
		result = result * result % MOD;
		if (power % 2 == 1) {
			result = result * num % MOD;
		}
		return result;
	}

	static long inverse(long num) {
		return power(num, MOD - 2);
	}

	static long highwayConstruction(long num, int pow) {
		if (--num == 0) {
			return 0;
		}
		num %= MOD;
		long result = 0;
		long tempNum = num;

		for (int i = pow; i >= 0; --i) {
			long temp = cs[pow + 1][i] * bs[i] % MOD * tempNum % MOD;
			tempNum = tempNum * num % MOD;
			result = (result + temp) % MOD;
		}
		result = result * invs[pow + 1] % MOD;
		return (result + MOD - 1) % MOD;
	}

	public static void main(String[] args) {
		preProcess();
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			long num = in.nextLong();
			int power = in.nextInt();
			long result = highwayConstruction(num, power);
			System.out.println(result);
		}
		in.close();
	}

	static void preProcess() {
		for (int i = 0; i < 1010; ++i) {
			cs[i][0] = cs[i][i] = 1;
			for (int j = 1; j < i; ++j) {
				cs[i][j] = (cs[i - 1][j] + cs[i - 1][j - 1]) % MOD;
			}
		}

		invs[1] = 1;
		for (int i = 2; i < 1010; ++i) {
			invs[i] = inverse(i);
		}

		bs[0] = 1;
		for (int i = 1; i <= 1000; ++i) {
			long tv = i + 1;
			for (int j = 0; j < i; ++j) {
				tv = tv - cs[i + 1][j] * bs[j] % MOD;
			}
			tv %= MOD;
			if (tv < 0)
				tv += MOD;
			tv = tv * invs[i + 1] % MOD;
			bs[i] = tv;
		}
	}
}