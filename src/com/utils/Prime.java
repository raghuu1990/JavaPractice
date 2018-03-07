package com.utils;

import java.util.ArrayList;
import java.util.Collections;

public class Prime {

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// SieveOfEratosthenes
	public static ArrayList<Integer> getPrimeBeforeN(int n) {
        boolean prime[] = new boolean[n+1];
        for(int i=2;i<n;i++) {
            prime[i] = true;
        }
         
        for(int p = 2; p*p <=n; p++) {
            if(prime[p] == true) {
                for(int i = p*2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 2; i <= n; i++) {
            if(prime[i] == true) {
            	primes.add(i);
            }
        }
		return primes;
	}
	
	// TODO
	public static ArrayList<Integer> getFirstNPrimes(int n) {
        boolean prime[] = new boolean[n+1];
        ArrayList<Boolean> isPrime = new ArrayList<Boolean>();
        Collections.fill(isPrime, Boolean.FALSE);
        for(int i=2;i<n;i++) {
            prime[i] = true;
        }

        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int p = 2; p*p <=n; p++) {
            if(prime[p] == true) {
                for(int i = p*2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            if(prime[i] == true) {
            	primes.add(i);
            }
        }
		return primes;
	}

	public static ArrayList<Integer> getFirstNPrimes1(int n) {
		 ArrayList<Integer> primes = new ArrayList<Integer>();
		 int i = 2;
		 while(primes.size()<n) {
			 if(isPrime(i)) {
				 primes.add(i++);
			 }
		 }
		 return primes;
	}
}