package com.string;

import java.io.IOException;
import java.util.Scanner;
/*
1226#24#
1226#24#(3)
1(2)23(2)

*/
public class FrequecyOfCharaters{
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String _s = in.nextLine();
        int[] res = frequency(_s);
        for(int res_i=0; res_i < res.length; res_i++) {
           System.out.println(res[res_i]);
        }
        in.close();
    }
	
	static int[] frequency(String s) {
		int[] result = new int[26];
		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}
		
		int size = s.length();
		for (int i = 0; i < size;) {
			int a = (int)(s.charAt(i))-48;
			i++;
			int b = -1;
			int freq = 1;
			if(((i+1)<size) && (s.charAt(i+1)=='#')) {
				b = (int)s.charAt(i)-48;
				i=i+2;
			}
            if((i<size) &&(s.charAt(i)=='(')) {
                int k = s.indexOf(')',i);
                freq = Integer.parseInt(s.substring(i+1, k));
                i=k+1;
            }
			
			if(b>-1) {
				a=a*10+b;
			}
			result[a-1] += freq;
		}
		return result;
    }
}