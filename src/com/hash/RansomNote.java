package com.hash;

import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem

public class RansomNote {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        System.out.println(ransomNote(magazine, ransom));
        in.close();
    }
	
	private static String ransomNote(String[] magazine, String[] ransom) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < magazine.length; i++) {
			if(map.containsKey(magazine[i])) {
				map.put(magazine[i], map.get(magazine[i])+ 1);
			}else {
				map.put(magazine[i], 1);
			}
		}
		
		for (int j = 0; j < ransom.length; j++) {
			if(map.containsKey(ransom[j])) {
				if(map.get(ransom[j])>1) {
					map.put(ransom[j], map.get(ransom[j])- 1);
				}else {
					map.remove(ransom[j]);
				}
			}else {
				return "No";
			}
		}
		return "Yes";
	}
}