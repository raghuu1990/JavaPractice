package com.hackerrank.hiringcontest;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

public class WinningLotteryTicket {
    static int n;
	static int max = 1023;
	static long pairCount = 0;
	static int countT = 0;
	static int completeCountT = 0;

	static HashMap<Integer, StringNode> ticketsMap = new HashMap<Integer, StringNode>();

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		n = in.nextInt();

		StringNode[] tickets = new StringNode[n];
		for (int i = 0; i < n; i++) {
			StringNode num = parse(in.nextString());
			if (num != null) {
				tickets[countT++]= num;
			}
		}
		winningLotteryTicket(tickets);
		System.out.println(pairCount);
		in.close();
	}

	private static StringNode parse(String str) {
		boolean[] t = new boolean[10];
		int num = 0;
		StringNode node = null;
		for (int i = 0; i < str.length(); i++) {
			if (!t[str.charAt(i) - 48]) {
				t[str.charAt(i) - 48] = true;
				num += Math.pow(2, str.charAt(i) - 48);
			}
		}

		if (num == max) {
			completeCountT++;
			pairCount += n - completeCountT;
			return null;
		}
		if (ticketsMap.containsKey(num)) {
			ticketsMap.get(num).freq++;
            return null;
		} else {
			node = new StringNode(1, num, str);
			ticketsMap.put(num, node);
		}

		return node;
	}

	static void winningLotteryTicket(StringNode[] t) {
		for (int i = 0; i < countT; i++) {
			for (int j = i + 1; j < countT; j++) {
				if ((t[i].num | t[j].num) == max) {
					pairCount+= t[i].freq * t[j].freq ;
				}
			}
		}
	}
}

class StringNode {
	public StringNode(int freq, int num, String str) {
		this.t = str;
		this.freq = freq;
		this.num = num;
	}

	int freq;
	int num;
	String t;
}


class Reader {
	final private int BUFFER_SIZE = 1 << 17;
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

	public String nextString() throws IOException {
		byte[] buf = new byte[10]; // line length support till 10^6 char
		boolean[] freq = new boolean[10];
		int cnt = 0, c;
		while ((c = read()) >= '0' && c <= '9') {
			if(!freq[c-48]) {
				buf[cnt++] = (byte) c;
				freq[c-48] = true;
			}
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
}
