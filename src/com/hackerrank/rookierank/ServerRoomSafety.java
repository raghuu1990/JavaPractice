package com.hackerrank.rookierank;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/contests/rookierank-4/challenges/server-room-safety/problem

public class ServerRoomSafety {

	static String checkAll(int n, int[] height, int[] position) {
		Rack[] rackes = new Rack[n];
		for (int i = 0; i < n; i++) {
			rackes[i] = new Rack(position[i], height[i]);
		}
		Arrays.sort(rackes);
		boolean right = false;
		int max = rackes[0].position + rackes[0].height;
		int i = 0;
		for (; rackes[i].position <= max && i < n - 1; i++) {
			if (rackes[i].position + rackes[i].height >= rackes[n - 1].position) {
				right = true;
				break;
			}
			max = Math.max(max, rackes[i].position + rackes[i].height);
		}
		i--;
		boolean left = false;
		int min = rackes[n - 1].position - rackes[n - 1].height;
		int j = n - 1;
		for (; rackes[j].position >= min && j >= 1; j--) {
			if (rackes[j].position - rackes[j].height <= rackes[0].position) {
				left = true;
				break;
			}
			min = Math.min(min, rackes[j].position - rackes[j].height);
		}
		j++;
		if (right && left) {
			return "BOTH";
		} else if (left) {
			return "LEFT";
		} else if (right) {
			return "RIGHT";
		} else {
			if(i>=j) {
				return "BOTH";
			}
			return "NONE";
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] position = new int[n];
		for (int position_i = 0; position_i < n; position_i++) {
			position[position_i] = in.nextInt();
		}
		int[] height = new int[n];
		for (int height_i = 0; height_i < n; height_i++) {
			height[height_i] = in.nextInt();
		}
		String ret = checkAll(n, height, position);
		System.out.println(ret);
		in.close();
	}
}

class Rack implements Comparable<Rack> {
	Integer position;
	Integer height;

	Rack(Integer position, Integer height) {
		this.position = position;
		this.height = height;
	}

	@Override
	public int compareTo(Rack o) {
		return this.position.compareTo(o.position);
	}
}