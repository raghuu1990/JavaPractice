package com.company.joveo;

import java.util.Scanner;

// Check a string can be created using concatenate using 2 string from set of string 
class StringCreationCheck {
     public static void main(String args[] ) throws Exception {
         Scanner s = new Scanner(System.in);
            int N = s.nextInt();
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = s.next();
            }
            int Q = s.nextInt();
            String[] result = new String[Q];
            for (int i = 0; i < Q; i++) {
                result[i] = isPossible(s.next(), arr );
            }
            for (int i = 0; i < Q; i++) {
               System.out.println(result[i]);
            }
            s.close();
     }
        
    private static String isPossible(String str, String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(str.startsWith(arr[i])) {
				for (int j = 0; j < arr.length; j++) {
					if(str.substring(arr[i].length()).equalsIgnoreCase(arr[j])) {
						 return "Yes";
					}
				}
			}
		}
		return "No";
	}
}