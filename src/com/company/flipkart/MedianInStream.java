package com.company.flipkart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MedianInStream {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		ArrayList<Integer> heap = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			int k = in.nextInt();
			heap.add(k);
			System.out.println(calculate(heap));
		}
		in.close();
	}

	private static double calculate(ArrayList<Integer> heap) {
		Collections.sort(heap);
		int l = heap.size();
		
		if(l%2==0){
			return ((double)heap.get(l/2-1)+(double)heap.get(l/2))/2;
		}else{
			return heap.get((l-1)/2);
		}
	}
}