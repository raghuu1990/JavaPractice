package com.stock;

import java.util.ArrayList;

// http://www.geeksforgeeks.org/stock-buy-sell/

// Day prices are given, Allowed to make at most 2 transactions in a day, 
// where as second transaction can only start after first one is complete (Sell->buy->sell->buy)

public class StockMaxProfitAnyNoOfTransactions {
	public static void main(String[] args) {
		// long price[] = { 2, 30, 15, 10, 8, 25, 80 };
		// long price[] = {10, 22, 5, 75, 65, 80};
		// long price[] = {100, 30, 15, 10, 8, 25, 80};
		// long price[] = { 90, 80, 70, 60, 50 };
		// long price[] = {100, 180, 260, 310, 40, 535, 695};
		
		long price[] = {1, 2, 10, 0, 30, 35};
		
		System.out.println(getMaxProfit(price));
	}

	public static long getMaxProfit(long[] price) {
		if (price.length == 1) {
			return 0;
		}
		
		int i = 0;
		long count = 0;
		long profit = 0;
		int n = price.length;
		ArrayList<Interval> sol = new ArrayList<Interval>();
		
		while (i < n - 1) {
			// Find Local Minima. Note that the limit is (n-2) as we are comparing present element to the next element.
			while ((i < n - 1) && (price[i + 1] <= price[i])) {
				i++;
			}

			// If we reached the end, break as no further solution possible
			if (i == n - 1) {
				break;
			}

			Interval pair = new Interval();
			
			// Store the index of minima
			pair.buy = i++;

			// Find Local Maxima. Note that the limit is (n-1) as we are comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1])) {
				i++;
			}

			// Store the index of maxima
			pair.sell = i - 1;
			sol.add(pair);
			profit+=price[pair.sell] - price[pair.buy];
			count++;
		}

		if (count == 0) {
				//	System.out.println("There is no day when buying the stock will make profit");
		} else {
			for (int j = 0; j < count; j++) {
				//	profit += price[sol.get(j).sell] - price[sol.get(j).buy];
				System.out.println("Buy on day : " + sol.get(j).buy + ", Sell on day : " + sol.get(j).sell);
			}
		}
		return profit;
	}
}

class Interval {
	int buy, sell;
}