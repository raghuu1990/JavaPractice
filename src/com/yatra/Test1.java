package com.yatra;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test1 {

	public static void main(String args[]) throws Exception {
		// 8 17 25 33 41 49
		// 00012345
		String detailInteractionId = "22122016-24122016-11bzzzz-12bczzz-00zzzzz-00zzzzz-00022731:39691";
		String searchInteractionId = "10012017-13012017-11fzzzz-00zzzzz-00zzzzz-00zzzzz:39341";
		
		System.out.println("detailInteractionId has searchCriteria " + " : " + isParentIdHasSearchCriteria(detailInteractionId));
		System.out.println("detailInteractionId has VendorId " + " : " + isParentIdHasVendorId(detailInteractionId));
		System.out.println("searchInteractionId from detailInteractionId " + " : " + removeHotelIdFromDetailHashKey(detailInteractionId));
		System.out.println("New detailInteractionId " + " : " + updateTimeStampOfHashKey(detailInteractionId));
		
		System.out.println("HotelId from detailInteractionId " + " : " + getHotelIdFromDetailHashKey(detailInteractionId));
		
		System.out.println("searchInteractionId has searchCriteria " + " : " + isParentIdHasSearchCriteria(searchInteractionId));
		System.out.println("searchInteractionId has VendorId " + " : " + isParentIdHasVendorId(searchInteractionId));
		System.out.println("Vendor added in  searchInteractionId " + " : " + addHotelIdAndUpdateTimeStampInSearchHashKey(searchInteractionId, "TGR-00012345"));
		System.out.println("New searchInteractionId " + " : " + updateTimeStampOfHashKey(searchInteractionId));
	}
	
	public static boolean isParentIdHasSearchCriteria(String parentPageId){
		if(parentPageId.length()> 49 && parentPageId.charAt(8)=='-' && parentPageId.charAt(17)=='-' && parentPageId.charAt(25)=='-' && 
				parentPageId.charAt(33)=='-' && parentPageId.charAt(41)=='-'){
			return true;
		}
		return false;
	}
	
	public static boolean isParentIdHasVendorId(String parentPageId){
		if(parentPageId.length()> 59 && parentPageId.charAt(8)=='-' && parentPageId.charAt(17)=='-' && parentPageId.charAt(25)=='-' && 
				parentPageId.charAt(33)=='-' && parentPageId.charAt(41)=='-' && parentPageId.charAt(49)=='-' &&
				 parentPageId.charAt(58)==':'){
			return true;
		}
		return false;
	}
	
	public static String updateTimeStampOfHashKey(String hashKey) {
		int index = hashKey.indexOf(':');
		return hashKey.replace(hashKey.substring(index+1, index+6), getRandomKey());
	}
	
	public static String removeHotelIdFromDetailHashKey(String hashKey) {
		return hashKey.replace(hashKey.substring(49,58), "");
	}
	
	public static String addHotelIdInSearchHashKey(String hashKey, String hotelId) {
		hotelId = hotelId.replace("TGR-", "");
		String timestamp = getTimeStampFromSearchHashKey(hashKey);
		return hashKey.replace(hashKey.substring(49,55), "-"+hotelId+":"+timestamp);
	}
	
	public static String addHotelIdAndUpdateTimeStampInSearchHashKey(String hashKey, String hotelId) {
		hotelId = hotelId.replace("TGR-", "");
		String randomkey = getRandomKey();
		return hashKey.replace(hashKey.substring(49,55), "-"+hotelId) + ":" + randomkey;
	}
	
	public static String getTimeStampFromSearchHashKey(String hashKey) {
		int index = hashKey.indexOf(':');
		return hashKey.substring(index+1,index+6);
	}
	
	public static String getHotelIdFromDetailHashKey(String hashKey) {
		return hashKey.substring(50, 58);
	}
	
	public static String getRandomKey(){
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = dateFormat.format(date).replace(":", "");
		DecimalFormat randomKeyFormatter = new DecimalFormat("00000");
		
		time =  ""+(Integer.parseInt(time.substring(0, 2))*3600 + Integer.parseInt(time.substring(2, 4))*60 +
				Integer.parseInt(time.substring(4, 6)) + new Random().nextInt(1000));
		
		return randomKeyFormatter.format(Integer.parseInt(time));
	}

}