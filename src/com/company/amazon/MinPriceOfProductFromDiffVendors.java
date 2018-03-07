package com.company.amazon;

import java.util.*;

class Vendors{
	int start;
	int end;
	int price;
	public Vendors(int start, int end, int price) {
		super();
		this.start = start;
		this.end = end;
		this.price = price;
	}
	
}

	/*
	3
	1 5 20
	3 8 15
	7 10 8
	
	2
	1 2 20
	3 5 8
	*/

public class MinPriceOfProductFromDiffVendors {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Vendors[] arr = new Vendors[N];
        int maxTime  = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	int c = in.nextInt();
        	maxTime = Math.max(maxTime, b);
        	Vendors v = new Vendors(a,b,c);
            arr[i] = v;
        }
        getMaxNumber(arr, maxTime);
        in.close();
    }

    public static void getMaxNumber(Vendors[] vendors, int maxTime){
    	Vendors[] time = new Vendors[maxTime-1];

    	for (int i = 0; i < maxTime-1; i++) {
    		time[i] = new  Vendors(i+1, i+2, Integer.MAX_VALUE);
		}

    	for (int i = 0; i < vendors.length; i++) {
    		Vendors v = vendors[i];
    		for (int j = v.start-1; j < v.end-1; j++) {
				if(time[j].price > v.price) {
					time[j].price = v.price;
				}
			}
		}
	
    	for (int i = 0; i < time.length; i++) {
    		if(time[i].price == Integer.MAX_VALUE) {
    			time[i].price = 0;
    		}
		}
    	
    	for (int i = 0; i < time.length; i++) {
    		Vendors v = time[i];
    		System.out.println(v.start + " " +v.end+" " + v.price);
		}
    	
    	ArrayList<Vendors> result = new ArrayList<Vendors>();
    	int start = time[0].start;
    	int end = time[0].end;
    	int price = time[0].price;
    	for (int i = 1; i < time.length; i++) {
    		Vendors v = time[i];
    		if(price != v.price) {
    			result.add(new Vendors(start, end, price));
    			start = v.start;
    			end = v.end;
    			price = v.price;
    		}else {
    			end = v.start;
    		}
		}
    	result.add(new Vendors(start, end+1, price));
    	
    	System.out.println();
    	for (int i = 0; i < result.size(); i++) {
    		Vendors v = result.get(i);
    		System.out.println(v.start + " " +v.end+" " + v.price);
		}
    }
}