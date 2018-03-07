package com.basics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		//07:05:45PM
		String str = in.next();
        str = str.substring(0, 10);
        boolean isAM = str.contains("AM");
		
        int HH = Integer.parseInt(str.substring(0, 2));
		int MM = Integer.parseInt(str.substring(3, 5));
		int SS = Integer.parseInt(str.substring(6, 8));
		
		if(!isAM){
			if(HH<12){
				HH+=12;
			}
		}else{
			if(HH==12){
				HH=0;
			}
		}
		
		str = str.substring(0,8);
		DecimalFormat myFormatter = new DecimalFormat("00");
		String hh = myFormatter.format(HH);
		str = hh+str.substring(2, 8);
		
		System.out.println(str);
	}
}
