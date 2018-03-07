package com.company.oyo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KMostFrequent {
	public static PriorityQueue<Element> maxQueue = new PriorityQueue<Element>(new Comparator<Element>() {
  		public int compare(Element a, Element b) {
 			return -1 * ((Integer)a.freq).compareTo((Integer)b.freq); 
  		} 
 	});

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		int k = 2;
		arr = kMostFrequent(arr, k);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static int[] kMostFrequent(int [] arr, int k) {
		HashMap<Integer, Element> hm = new HashMap<Integer, Element>();
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i];
			if(hm.containsKey(arr[i])) {
				Element e = hm.get(key);
				e.freq++;
			}else {
				Element e = new Element(key, 1);
				hm.put(arr[i], e);
				maxQueue.add(e);
			}
		}

		int result [] = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = (int) maxQueue.poll().key;
		}
		return result;
	}
	
	static class Element{
		int key;
		int freq;
		public Element(int key, int freq) {
			super();
			this.key = key;
			this.freq = freq;
		}
	}
}
