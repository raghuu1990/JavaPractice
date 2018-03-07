package com.hackerrank.hiringcontest;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/contests/hackerrank-hiring-contest/challenges/programming-competition

public class ProgrammingCompetition {
	public static void main(String[] args) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int d = in.nextInt();
            int j = in.nextInt();
            queue.add(new Node(name, d, j, j-d, i+1));
        }
        System.out.println(queue.peek().name);
        in.close();
    }
}

class Node implements Comparable<Node>{
	String name;
	Integer i;
	int a;
	int b;
	Integer diff;
	
	public Node(String name, int a, int b, int d, int i) {
		this.name = name;
		this.a=a;
		this.b=b;
		this.diff=d;
		this.i=i;
	}

	@Override
	public int compareTo(Node o) {
		if(this.diff!=o.diff) {
			return o.diff.compareTo(this.diff);
		}
		return this.i.compareTo(o.i);
	}
}