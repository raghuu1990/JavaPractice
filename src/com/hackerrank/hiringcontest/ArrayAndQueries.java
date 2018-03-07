package com.hackerrank.hiringcontest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ArrayAndQueries {
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

			if (oldNum != newNum) {
				if (map.get(oldNum).freq == 1) {
					temp += delete(map.get(oldNum));
					map.remove(oldNum);
				} else {
					temp += decrease(map.get(oldNum));
					map.get(oldNum).freq--;
				}

				if (map.containsKey(newNum)) {
					temp += increase(map.get(newNum));
					map.get(newNum).freq++;
				} else {
					Node4 node = new Node4(1, newNum);
					map.put(newNum, node);
					temp += added(node);
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