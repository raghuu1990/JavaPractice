package com.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-dequeue/problem

public class Dequeue {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
        	deque.addLast(num);
        	if(map.containsKey(num)) {
        		map.put(num, map.get(num)+1);
        	}else {
        		map.put(num, 1);
        	}
        	if(deque.size()>m) {
        		int d = deque.removeFirst();
        		if(map.get(d)!=1) {
        			map.put(d, map.get(d)-1);
            	}else {
            		map.remove(d);
            	}
        	}
        	max = Math.max(map.size(), max);
        }
        System.out.println(max);
        in.close();
    }
}