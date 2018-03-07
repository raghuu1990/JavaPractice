package com.hackerrank.hiringtest;

import java.util.Scanner;

public class BuyingShowTickets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] tickets = new int[n];
		for (int i = 0; i < n; i++) {
			tickets[i] =  in.nextInt();
		}
		int p = in.nextInt();
		System.out.println(waitingTime(tickets, p));
		in.close();
	}

	static long waitingTime(int[] tickets, int p) {
		long result = 0;
		
		for (int i = 0; i < tickets.length; i++) {
			if(i<p) {
				result+= (long) Math.min(tickets[p], tickets[i]);
			}else if(i>p) {
				result+= (long) Math.min(tickets[p]-1, tickets[i]);
			}else {
				result+= (long) tickets[i];
			}
		}
		return result;
	}
}