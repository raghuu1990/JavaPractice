package com.company.uber;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		List<Node> list = new ArrayList<Node>();
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new Node(x, y));
		}
		int result = getMinTime(list);
		System.out.println(result);
		in.close();
	}
	
	private static int getMinTime(List<Node> list) {
		int result = 0;
		Collections.sort(list);
		for (int i = list.size()-1; i > 0; i--) {
			Node node1 = list.get(i);
			Node node2 = list.get(i-1);
			if(node2.end<node1.start) {
				result +=  Math.abs(node1.end-node1.start)+1;
			}else if(node2.end>=node1.start) {
				node2.start = Math.min(node2.start, node1.start);
				node2.end = node1.end;
				list.remove(i);
			}
		}
		result += Math.abs(list.get(0).end-list.get(0).start)+1;
		return result;
	}
}

class Node implements Comparable<Node>{
	Integer start;
	Integer end;
	
	Node(int start, int end){
		this.start = start;
		this.end = end;		
	}

	@Override
	public int compareTo(Node o) {
		return this.end.compareTo(o.end);
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

	public Reader(String file_name) throws IOException {
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public void nextLine() throws IOException {
		byte[] buf = new byte[1024]; // line length
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
	}
	
	public String nextString() throws IOException {
		byte[] buf = new byte[1024]; // line length support till 10^6 char
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n')    // 10
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}
	
	public String nextWord() throws IOException {
		byte[] buf = new byte[1024];
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == ' ')  // 32
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
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

	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

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