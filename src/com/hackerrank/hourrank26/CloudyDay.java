package com.hackerrank.hourrank26;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

// https://www.hackerrank.com/contests/hourrank-26/challenges/cloudy-day

public class CloudyDay {
	 public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		int n = sc.nextInt();
		
		long population = 0;
		long cloudUncover = 0;
		long cloudCover = 0;
		TreeMap<Long, City> map = new TreeMap<Long, City>();
		HashMap<Long, Boolean> covered = new HashMap<Long, Boolean>();
		
		long[] p = new long[n];
		for (int i = 0; i < n; i++) {
			long p1 = sc.nextLong();
			population = (population + p1);
			p[i] = p1;
		}

		for (int i = 0; i < n; i++) {
			long x1 = sc.nextLong();
			covered.put(x1, false);
			if(map.containsKey(x1)) {
				map.get(x1).p+=p[i];
			}else {
				map.put(x1, new City(x1, p[i]));
			}
		}

		int m = sc.nextInt();
		long[] y = new long[m];
		for (int i = 0; i < m; i++) {
			y[i] = sc.nextLong();
		}

		long[] r = new long[m];

		for (int i = 0; i < m; i++) {
			r[i] = sc.nextLong();
			long min = y[i] - r[i];
			long max = y[i] + r[i];
			Long j = map.higherKey(min-1);
			while (j!=null && j>=min && j<=max) {
				map.get(j).count++;
				if (!covered.get(j)) {
					cloudCover = (cloudCover + map.get(j).p);
					covered.put(j, true);
				}
				j = map.higherKey(j);
			}
		}

		for (int i = 0; i < m; i++) {
			long min = y[i] - r[i];
			long max = y[i] + r[i];
			long uncover = 0;
			Long j = map.higherKey(min-1);
			while (j!=null && j>=min && j<=max) {
				if(map.get(j).count==1) {
					uncover = (uncover + map.get(j).p);
				}
				j = map.higherKey(j);
			}
			cloudUncover = Math.max(cloudUncover, uncover);
		}
		System.out.println(population - cloudCover + cloudUncover);
	}
}

class City {
	Long i;
	Long p;
	int count;

	City(Long i, Long p) {
		this.i = i;
		this.p = p;
	}
}

class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
			while (c <= ' ')
				c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}