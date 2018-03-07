package com.graph;

//  O(n + alhpa) time where n is number of given words and alpha is number of characters in given alphabet.

class FindPrecedenceCharacters {
	public static void main(String[] args) {
		String words[] = {"caa", "aaa", "aab"};
		int uniqueChars = 3;
		printOrder(words, words.length, uniqueChars);
	}

	private static void printOrder(String[] words, int N, int uniqueChars) {
		DirectedGraph g = new DirectedGraph(uniqueChars);
		for (int i = 0; i < N - 1; i++) {
			String word1 = words[i], word2 = words[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					g.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}
		g.topologicalSortCharPrint();
	}
}