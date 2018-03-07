package com.hackerrank.weekofcode35;

import java.util.Scanner;

public class LuckyPurchase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		String lowestPriceLaptopName = "";
		int lowestPrice = Integer.MAX_VALUE;
		for (int a0 = 0; a0 < n; a0++) {
			String laptopName = in.next();
			int laptopPrice = in.nextInt();
			int noOfEqualFourAndSeven = getEqualFourAndSeven(laptopPrice);
			if(noOfEqualFourAndSeven!=0) {
				if(laptopPrice<lowestPrice) {
					lowestPrice = laptopPrice;
					lowestPriceLaptopName = laptopName;
				}
			}
		}
		
		if(!"".equalsIgnoreCase(lowestPriceLaptopName)) {
			System.out.println(lowestPriceLaptopName);
		} else {
			System.out.println(-1);
		}
		in.close();
	}

	private static int getEqualFourAndSeven(int laptopPrice) {
		if(laptopPrice<1) {
			return 0;
		}
		int tempPrice = laptopPrice;
		int countFour = 0;
		int countSeven = 0;
		
		while(tempPrice>0) {
			int digit = tempPrice%10;
			tempPrice = tempPrice/10;
			if(digit==4) {
				countFour++;
			}else if (digit==7) {
				countSeven++;
			}else {
				return 0;
			}
		}
		
		if(countFour==countSeven && countFour!=0) {
			return countFour;
		}
		return 0;
	}
}