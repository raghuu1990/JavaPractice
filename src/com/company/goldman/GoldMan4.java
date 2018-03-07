package com.company.goldman;

import java.util.Arrays;
import java.util.Scanner;

public class GoldMan4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(getMaxGroceryItems(50, 3, 10, "22,12,1,2,5,4,8,6,14,18,7"));
		in.close();
	}

	static String getMaxGroceryItems(int salary, int itemsToBuyForCashback, int cashback, String priceString) {
		String[] stringPrices = priceString.split(",");
		Integer [] prices = new Integer[stringPrices.length];
		
		for (int i = 0; i < stringPrices.length; i++) {
			prices[i] = Integer.parseInt(stringPrices[i]);
		}
		int items = 0;
		
		Arrays.sort(prices);
	
		for (int i = 0; (i < prices.length && salary>0); i++) {
			if(salary>=prices[i]) {
				salary-= prices[i];
				items++;
			}else {
				break;
			}
			if(i==4) {
				salary+=10;
			}
			if((i+1)%itemsToBuyForCashback==0) {
				salary+=cashback;
			}
		}
		return items+" "+ salary;
	}
}