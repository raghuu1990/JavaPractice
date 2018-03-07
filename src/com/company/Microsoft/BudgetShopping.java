package com.company.Microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Given cost of bundle at diffrent shops,
// and no of books in a bundle, can buy any no of bundles from any shop, make max books
public class BudgetShopping {
	static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
		List<Bundle> bundles = new ArrayList<Bundle>();
		for (int i = 0; i < bundleCosts.length; i++) {
			bundles.add(new Bundle(bundleQuantities[i], bundleCosts[i]));
		}
		Collections.sort(bundles);
		
		int count = 0;
		for (Bundle bundle : bundles) {
			if(n>0) {
				int temp =  n/bundle.cost;
				n-=temp*bundle.cost;
				count+=temp*bundle.quantity;
			}
		}
		return count;
	}
	
	static class Bundle implements Comparable<Bundle>{
		int quantity;
		int cost;
		
		Bundle(int quantity, int cost){
			this.cost = cost;
			this.quantity = quantity;
		}

		@Override
		public int compareTo(Bundle o) {
			return ((Double)Double.parseDouble(((double)this.quantity/(double)this.cost)+"")).compareTo(Double.parseDouble(((double)this.quantity/(double)this.cost)+""));
		}
	}
}