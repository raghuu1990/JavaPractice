package com.hackerrank.weekofcode36;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.io.Reader;

public class ExpertComputation {
	private static Integer mod = 1000000007;

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] z = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			y[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			z[i] = in.nextInt();
		}
		int result = compute(x, y, z);
		System.out.println(result);
		in.close();
	}

	private static int compute(int[] x, int[] y, int[] z) {
		TreeMap<Node, Integer> maxMap = new TreeMap<Node, Integer>();
		int n = x.length;
		int[] h = new int[n];
		int[] c = new int[n];
		int[] l = new int[n];
		long[] f = new long[n];
		int[] g = new int[n];

		h[0] = x[0];
		c[0] = y[0];
		l[0] = z[0];
		f[0] = 0;
		g[0] = 0;

		Node node0 = new Node(h[0], c[0], 0);
		maxMap.put(node0, 0);
		Node[] arr = new Node[n];
		arr[0]= node0;
		
		for (int i = 1; i < n; i++) {
			h[i] = x[i] ^ g[i - 1];
			c[i] = y[i] ^ g[i - 1];
			l[i] = z[i] ^ g[i - 1];

			long max = Long.MIN_VALUE;
			Node node = new Node(h[i], c[i], i);
			maxMap.put(node, i);
			arr[i]= node;
			
			List<Node> list = Arrays.asList(arr).subList(0, i - l[i]+1);
			
			Collections.sort(list);
			Object[] arr1 = list.toArray();
			if(((Node)arr1[arr1.length-1]).compareTo(node)<0) {
				for (int j = arr1.length-1; j>=0 ; j--) {
					max = Math.max(max, (long)c[i] * (long)h[((Node)arr1[j]).i] -(long)c[((Node)arr1[j]).i] * (long)h[i]);
					if(((Node)arr1[arr1.length-1]).compareTo(node)>0) {
						break;
					}
				}
			}else {
				for (Node n1 : list) {
					max = Math.max(max, (long)c[i] * (long)h[n1.i] -(long)c[n1.i] * (long)h[i]);
				}
			}

			f[i] = max;
			g[i] = mod(g[i - 1] + f[i]);
		}
		return g[n-1];
	}
	
	private static int mod(long i) {
		if(i>=0) {
			return (int) (i%mod);
		}
		while(i<0) {
			i+=mod;
		}
		return (int) (i%mod);
	}
}

class Node implements Comparable<Node> {
	Integer h;
	Integer c;
	Integer i;

	Node(Integer h, Integer c, Integer i) {
		this.h = h;
		this.c = c;
		this.i = i;
	}

	@Override
	public boolean equals(Object o1) {
		return this.i == ((Node) o1).i && this.h == ((Node) o1).h && this.c == ((Node) o1).c;
	}

	@Override
	public int compareTo(Node o) {
		if(((double) this.h / (double) this.c)==((double) o.h / (double) o.c)) {
			return ((Double) ((double) this.h / (double) this.c)).compareTo((Double) ((double) o.h / (double) o.c));
		}
		return this.i.compareTo(o.i);
	}
}