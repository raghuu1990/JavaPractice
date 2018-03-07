package com.maths;

// https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/

//(a+b)%M=(a%M+b%M)%M
//(a−b)%M=(a%M−b%M)%M

public class ModularMultiplicativeInverse {
	public static int power(int base, int exp, int mod) {
		if (exp == 0 || base == 1) {
			return 1;
		}

		int p = power(base, exp / 2, mod);
		p = (p * p) % mod;
		return (exp % 2 == 0) ? p : (base * p) % mod;
	}

	// O(n)
	// x = (1/a)%m -->  (x*a)%m = 1%m
	public static int modInverse(int a, int m) {
		a = a % m;
		for (int x = 1; x < m; x++) {
			if ((a * x) % m == 1) {
				return x;
			}
		}
		return 1;
	}
	
	//  Extended Euclid Algorithm  O(nlog(n)), a and n are relatively_prime/coprime,
	//  ax + by = gcd(a, b) , if a and b are coprime
	//  ax + my = 1         , if b = m
	//  ax + my ≡ 1 (mod m) , mod m both side
	//  ax(mod m)  ≡ 1 (mod m) 
			  
	public static int modInverse1(int a, int m)
    {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;
     
        if (m == 1)
        return 0;
     
        while (a > 1)
        {
            // q is quotient
            q = a / m;
     
            t = m;
     
            // m is remainder now, process 
            // same as Euclid's algo
            m = a % m; a = t;
     
            t = x0;
     
            x0 = x1 - q * x0;
     
            x1 = t;
        }
     
        // Make x1 positive
        if (x1 < 0)
        x1 += m0;
     
        return x1;
    }
}
