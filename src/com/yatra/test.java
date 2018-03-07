package com.yatra;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class test {

	public static String addHotelIdInSearchHashKey(String hashKey, String hotelId) {
		hotelId = hotelId.replace("TGR-", "");
		return hashKey.replace(hashKey.substring(49,55), "-"+hotelId) + ":" + getRandomKey();
	}
	
	public static String getRandomKey(){
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = dateFormat.format(date).replace(":", "");
		DecimalFormat myFormatter = new DecimalFormat("00000");
		
		time =  ""+((1)*3600 + Integer.parseInt(time.substring(2, 4))*60 +
				Integer.parseInt(time.substring(4, 6)) + new Random().nextInt(1000));
		
		return myFormatter.format(Integer.parseInt(time));
	}
	
	public static void main(String[] args) {
		
		String hashKey= "08072015-10072015-10zzzzz-00zzzzz-00zzzzz-00zzzzz:94690";
		String hotelId = "TGR-1234565";
		
		System.out.println(addHotelIdInSearchHashKey(hashKey, hotelId));
		

        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        System.out.println(Double.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
	}
}
