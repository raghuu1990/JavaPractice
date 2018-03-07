package com.string;

import java.util.Arrays;
import java.util.Scanner;

public class Comparator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
		scan.close();
	}
}

class Checker implements java.util.Comparator<Player>{
	@Override
	public int compare(Player o1, Player o2) {
		if(o1.score==o2.score) {
			return o1.name.compareTo(o2.name);
		}
		return ((Integer)o2.score).compareTo((Integer)o1.score);
	}
}

class Player {
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
	String name;
	int score;
}
