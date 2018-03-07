package com.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class time {
	public static void main(String [] args) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateFormat.format(date));
		String time = dateFormat.format(date).replace(":", "");
		int hour = Integer.parseInt(time.substring(0, 2))*3600;
		int min = Integer.parseInt(time.substring(2, 4))*60;
		int sec = Integer.parseInt(time.substring(4, 6));
		
		int random = new Random().nextInt(1000);
		String searchHashKey = ""+(hour + min + sec + random);	
		
		System.out.println(hour);
		System.out.println(min);
		System.out.println(sec);
		System.out.println(random);
		System.out.println(searchHashKey);
	}
}
