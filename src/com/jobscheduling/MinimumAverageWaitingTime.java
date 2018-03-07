package com.jobscheduling;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/minimum-average-waiting-time/problem
// you should not wait if you have any order in queue.

public class MinimumAverageWaitingTime {
	public static void main(String[] args) {
		PriorityQueue<ArrivalTime> ordersSortedByArrivalTime = new PriorityQueue<ArrivalTime>();

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int arrivalTime = in.nextInt();
			int cookingTime = in.nextInt();
			ordersSortedByArrivalTime.add(new ArrivalTime(arrivalTime, cookingTime));
		}
		System.out.println(findMinAvgTime(ordersSortedByArrivalTime));
		in.close();
	}

	private static long findMinAvgTime(PriorityQueue<ArrivalTime> ordersSortedByArrivalTime) {
		PriorityQueue<CookingTime> ordersSortedByCookingTime = new PriorityQueue<CookingTime>();
		int totalOrders = ordersSortedByArrivalTime.size();
		int size = 0;
		long currentTime = 0;
		long waitingTime = 0;

		while (size <= totalOrders && size != totalOrders) {
			while (ordersSortedByCookingTime.size() == 0 || (!ordersSortedByArrivalTime.isEmpty()
					&& currentTime >= ordersSortedByArrivalTime.peek().arrivalTime)) {
				ArrivalTime order = ordersSortedByArrivalTime.poll();
				ordersSortedByCookingTime.add(new CookingTime(order.arrivalTime, order.cookingTime));
			}

			CookingTime order = ordersSortedByCookingTime.poll();
			if (order.arrivalTime > currentTime) {
				currentTime = order.arrivalTime;
			}
			currentTime += order.cookingTime;
			waitingTime += (currentTime - order.arrivalTime);
			size++;
		}
		return (waitingTime / totalOrders);
	}
}

class ArrivalTime implements Comparable<ArrivalTime> {
	int arrivalTime;
	int cookingTime;

	public ArrivalTime(int arrivalTime, int cookingTime) {
		this.arrivalTime = arrivalTime;
		this.cookingTime = cookingTime;
	}

	@Override
	public int compareTo(ArrivalTime obj) {
		if (this.arrivalTime > obj.arrivalTime) {
			return 1;
		}
		return -1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.arrivalTime != ((ArrivalTime) obj).arrivalTime
				|| this.cookingTime != ((ArrivalTime) obj).cookingTime) {
			return false;
		}
		return true;
	}
}

class CookingTime implements Comparable<CookingTime> {
	int arrivalTime;
	int cookingTime;

	public CookingTime(int arrivalTime, int cookingTime) {
		this.arrivalTime = arrivalTime;
		this.cookingTime = cookingTime;
	}

	@Override
	public int compareTo(CookingTime obj) {
		if (this.cookingTime > obj.cookingTime) {
			return 1;
		}
		return -1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.arrivalTime != ((CookingTime) obj).arrivalTime
				|| this.cookingTime != ((CookingTime) obj).cookingTime) {
			return false;
		}
		return true;
	}
}