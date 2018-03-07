package com.stock;

import java.util.PriorityQueue;

// http://www.geeksforgeeks.org/buy-maximum-stocks-stocks-can-bought-th-day/

// at most i stock on the ith day. If the customer has an amount of k amount of money initially,
// find out the maximum number of stocks a customer can buy.

public class StockBuyMaxIStocksOnIthDay {
	public static void main(String[] args) {
		int price[] = { 10, 7, 19 };
		int k = 45;
		System.out.println(buyMaxStocks(price, k));
	}

	private static int buyMaxStocks(int price[], int k) {
		if (k == 0 || price.length == 0) {
			return 0;
		}

		int count = 0;
		int n = price.length;

		PriorityQueue<Stock> minHeap = new PriorityQueue<Stock>();
		for (int i = 0; i < n; i++) {
			minHeap.add(new Stock(price[i], i+1));
		}
		
		while(!minHeap.isEmpty()) {
			Stock stock = minHeap.poll();
			int s = Math.min(stock.day, k/stock.price);
			count+=s;
			k-=s*stock.price;
		}

		return count;
	}
}

class Stock implements Comparable<Stock>{
	int price;
	int day;
	
	public Stock(int price, int day) {
		this.price=price;
		this.day=day;
	}

	@Override
	public int compareTo(Stock stock) {
		if(this.price>stock.price) {
			return 1;
		}else if (this.price<stock.price) {
			return -1;
		}else if(this.day>stock.day) {
			return 1;
		}else if (this.day<stock.day) {
			return -1;
		}
		return 0;
	}
}