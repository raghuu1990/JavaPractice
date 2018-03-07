package com.hackerrank.hiringtest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(arrange(str));
		in.close();
	}

	static String arrange(String sentence) {
		sentence = sentence.substring(0, sentence.length()-1);
		String[] words = sentence.split(" ");
		words[0] = words[0].toLowerCase();
		List<Node> list = new LinkedList<Node>();
		for (int i = 0; i < words.length; i++) {
			list.add(new Node(i, words[i]));
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Node node : list) {
			if(first) {
				sb.append((node.word.charAt(0)+"").toUpperCase()+node.word.substring(1));
				first = false;
			}else {
				sb.append(node.word);
			}
			sb.append(" ");
		}
		sentence = sb.toString();
		sentence = sentence.substring(0, sentence.length()-1);
		return sentence+".";
	}
	
	static class Node implements Comparable<Node>{
		Integer index;
		String word;
		
		Node(int index, String word){
			this.index = index;
			this.word = word;
		}

		@Override
		public int compareTo(Node node) {
			if(!this.word.equalsIgnoreCase(node.word)) {
				return ((Integer)this.word.length()).compareTo(node.word.length());
			}
			return this.index.compareTo(node.index);
		}
	}
}

