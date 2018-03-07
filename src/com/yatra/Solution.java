package com.yatra;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int mod = 1000000007;
	private static long count = 0;
	static TreeMap<Integer, Node4> map = new TreeMap<Integer, Node4>();

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}

		parse(A);

		int q = in.nextInt();
		int[][] queries = new int[q][2];
		for (int i = 0; i < q; i++) {
			queries[i][0] = (in.nextInt() - 1);
			queries[i][1] = in.nextInt();
		}
		long result = arrayAndQueries(A, queries);
		System.out.println(result);
		in.close();
	}

	static long processCount() {
		Set<Map.Entry<Integer, Node4>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Node4>> keys = set.iterator();
		Node4 lastNode = ((Map.Entry<Integer, Node4>) keys.next()).getValue();
		count = lastNode.freq;
		while (keys.hasNext()) {
			Node4 node = (Node4) ((Map.Entry<Integer, Node4>) keys.next()).getValue();
			if (node.num == (lastNode.num + 1)) {
				if (node.freq > lastNode.freq) {
					count = (count + node.freq - lastNode.freq) % mod;
				}
			} else {
				count = (count + node.freq) % mod;
			}
			lastNode = node;
		}
		return count;
	}

	static long arrayAndQueries(int[] A, int[][] queries) {
		processCount();
		long result = 0;
		for (int i = 0; i < queries.length; i++) {
			int temp = 0;
			int index = queries[i][0];
			int newNum = queries[i][1];
			int oldNum = A[index];
			A[index] = newNum;
            boolean flag = false; 
            if(map.size()>1000){
                flag= true;
            }
			if (oldNum != newNum) {
				if (map.get(oldNum).freq == 1) {
                    if(flag){
					   temp += delete(map.get(oldNum));
                    }else{
                        processCount();
                    }
					
					map.remove(oldNum);
				} else {
                    if(flag){
					   temp += decrease(map.get(oldNum));
                    }else{
                        processCount();
                    }
					
					map.get(oldNum).freq--;
				}

				if (map.containsKey(newNum)) {
                   if(flag){
					   temp += increase(map.get(newNum));
                    }else{
                        processCount();
                    }
					
					map.get(newNum).freq++;
				} else {
					Node4 node = new Node4(1, newNum);
					map.put(newNum, node);
                    if(flag){
					   temp += added(node);
                    }else{
                        processCount();
                    }
				}
				count = (count + temp) % mod;
			}
			result = (result + ((count) * (i + 1)) % mod) % mod;
		}
		return result % mod;
	}

	private static int decrease(Node4 node) {
		int temp = 0;
		if (map.lowerKey(node.num) == null) { // isFirst
			if (map.higherEntry(node.num) != null) {
				if (map.higherEntry(node.num).getValue().num != (node.num + 1)) { // notHasRight
					temp--;
				} else if (map.higherEntry(node.num).getValue().freq < node.freq) { // hasright & higher
					temp--;
				}
			} else {
				temp--;
			}
		} else if (map.higherKey(node.num) == null) { // isLast
			if (map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // notHasLeft
				temp--;
			} else if (map.lowerEntry(node.num).getValue().freq < node.freq) { // hasleft & higher
				temp--;
			}
		} else if (map.higherKey(node.num) != null && map.lowerKey(node.num) != null) { // ismiddle
			if (map.higherEntry(node.num).getValue().num == (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num == (node.num - 1)) { // hasBoth
				if (map.higherEntry(node.num).getValue().freq > node.freq
						&& map.lowerEntry(node.num).getValue().freq > node.freq) { // bothGreater
					temp++;
				} else if (map.higherEntry(node.num).getValue().freq == node.freq
						&& map.lowerEntry(node.num).getValue().freq == node.freq) { // bothEqual
					temp++;
				} else if (map.higherEntry(node.num).getValue().freq < node.freq
						&& map.lowerEntry(node.num).getValue().freq < node.freq) { // bothLess
					temp--;
				}
			} else if (map.higherEntry(node.num).getValue().num != (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // hasNotBoth
				temp--;
			} else { // hasOne Only
				if (map.higherEntry(node.num).getValue().num == (node.num + 1)) { // hasRight
					if ((map.higherEntry(node.num).getValue().freq < node.freq)) { // greaterAndEqual to Right
						temp--;
					}
				} else if (map.lowerEntry(node.num).getValue().num == (node.num - 1)) { // hasLeft
					if ((map.lowerEntry(node.num).getValue().freq < node.freq)) { // greaterAndEqual to left
						temp--;
					}
				}
			}
		}
		return temp;
	}

	private static int increase(Node4 node) {
		int temp = 0;
		if (map.lowerKey(node.num) == null) { // isFirst
			if (map.higherEntry(node.num) != null) {
				if (map.higherEntry(node.num).getValue().num != (node.num + 1)) { // hasNoRight
					temp++;
				} else if (!(map.higherEntry(node.num).getValue().freq > node.freq)) { // hasright & lower
					temp++;
				}
			} else {
				temp++;
			}
		} else if (map.higherKey(node.num) == null) { // isLast
			if (map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // hasNoLeft
				temp++;
			} else if (!(map.lowerEntry(node.num).getValue().freq > node.freq)) { // hasLeft & lower
				temp++;
			}
		} else if (map.higherKey(node.num) != null && map.lowerKey(node.num) != null) { // ismiddle
			if (map.higherEntry(node.num).getValue().num == (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num == (node.num - 1)) { // hasBoth
				if (map.higherEntry(node.num).getValue().freq > node.freq
						&& map.lowerEntry(node.num).getValue().freq > node.freq) { // bothGreater
					temp--;
				} else if (map.higherEntry(node.num).getValue().freq == node.freq
						&& map.lowerEntry(node.num).getValue().freq == node.freq) { // bothEqual
					temp++;
				} else if (map.higherEntry(node.num).getValue().freq < node.freq
						&& map.lowerEntry(node.num).getValue().freq < node.freq) { // bothLess
					temp++;
				}
			} else if (map.higherEntry(node.num).getValue().num != (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // hasNotBoth
				temp++;
			} else { // hasOne Only
				if (map.higherEntry(node.num).getValue().num == (node.num + 1)) { // hasRight
					if (!(map.higherEntry(node.num).getValue().freq > node.freq)) { // greaterAndEqual to Right
						temp++;
					}
				} else if (map.lowerEntry(node.num).getValue().num == (node.num - 1)) { // hasLeft
					if (!(map.lowerEntry(node.num).getValue().freq > node.freq)) { // greaterAndEqual to left
						temp++;
					}
				}
			}
		}
		return temp;
	}

	private static int added(Node4 node) {
		int temp = 0;
		if (map.lowerKey(node.num) == null) { // isFirst
			if (map.higherEntry(node.num) != null) {
				if (map.higherEntry(node.num).getValue().num != (node.num + 1)) { // not has next
					temp++;
				}
			} else {
				temp++;
			}
		} else if (map.higherKey(node.num) == null) { // isLast
			if (map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // not has previous
				temp++;
			}
		} else if (map.higherKey(node.num) != null && map.lowerKey(node.num) != null) { // ismiddle
			if (map.higherEntry(node.num).getValue().num == (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num == (node.num - 1)) { // hasBoth
				temp--;
			} else if (map.higherEntry(node.num).getValue().num != (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // hasNotBoth
				temp++;
			}
		}
		return temp;
	}

	private static int delete(Node4 node) {
		int temp = 0;
		if (map.lowerKey(node.num) == null) { // isFirst
			if (map.higherEntry(node.num) != null) {
				if (map.higherEntry(node.num).getValue().num != (node.num + 1)) { // not has next
					temp--;
				}
			} else {
				temp--;
			}
		} else if (map.higherKey(node.num) == null) { // isLast
			if (map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // not has previous
				temp--;
			}
		} else if (map.higherKey(node.num) != null && map.lowerKey(node.num) != null) { // ismiddle
			if (map.higherEntry(node.num).getValue().num == (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num == (node.num - 1)) { // hasBoth
				temp++;
			} else if (map.higherEntry(node.num).getValue().num != (node.num + 1)
					&& map.lowerEntry(node.num).getValue().num != (node.num - 1)) { // hasNotBoth
				temp--;
			}
		}
		return temp;
	}

	private static void parse(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int num = A[i];
			if (map.containsKey(num)) {
				map.get(num).freq++;
			} else {
				Node4 node = new Node4(1, num);
				map.put(num, node);
			}
		}
	}
}

class Node4 {
	int freq;
	Integer num;

	public Node4(int freq, Integer num) {
		this.freq = freq;
		this.num = num;
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

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}