package com.yatra;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;

import com.utils.StringUtils;

public class HotelUtils {
	public static String appType = "HOMESTAY";
	public static String source = "HOMESTAY_CHAT";
	public static String tenant = "HSTAYS_B2C";
	public static String targetTo = "room";
	public static String excludeHotelTax = "true";

	public static void main(String args[]) throws Exception {
		// Constants :

		JSONObject otherDetails = null;
		HashMap<String, String> requestMap = null;

		// Case 1 : Call from Apps
		otherDetails = new JSONObject();
		requestMap = new HashMap<String, String>();
		String pageId = "03022017-04022017-10zzzzz-11czzzz-00zzzzz-00zzzzz-00077349:55404";
		otherDetails.put("pageId", pageId);
		otherDetails.put("vendorId", "00077349");
		otherDetails.put("city", "New Delhi");
		
		//processOtherDetails(otherDetails);
		//System.out.println(otherDetails);

		// Case 2 : Call from Web
		otherDetails = new JSONObject();
		requestMap = new HashMap<String, String>();
		String srpUrl = "//homestays.yatra.com/homestay-search/domhs/search?source=HOMESTAY_CHAT&city.name=New Delhi&city.code=New Delhi&checkinDate=03/02/2017&checkoutDate=04/02/2017&roomRequests[0].noOfAdults=1&roomRequests[1].noOfChildren=1&roomRequests[1].id=2&roomRequests[0].id=1&roomRequests[0].noOfChildren=0&roomRequests[1].noOfAdults=1&roomRequests[1].childrenAge[0]=2&appType=HOMESTAY";
		String rUrl = "//homestays.yatra.com/homestay-search/domhs/details?source=HOMESTAY_CHAT&tenant=HSTAYS_B2C&city.name=New Delhi&"
				+ "city.code=New Delhi&checkinDate=11/02/2017&checkoutDate=12/02/2017&appType=HOMESTAY&roomRequests[0].noOfChildren=0&"
				+ "roomRequests[0].id=1&roomRequests[0].noOfAdults=1&hotelId=00077349&excludeHotelTax=true&targetTo=room";
		otherDetails.put("rUrl", rUrl);
		otherDetails.put("srpUrl", srpUrl);

		processOtherDetails(otherDetails);
		System.out.println(otherDetails);
	}

	public static HashMap<String, String> processOtherDetails(JSONObject otherDetails) {
		HashMap<String, String> requestMap = new HashMap<String, String>();
		try {
			if (otherDetails != null && otherDetails.containsKey("rUrl") && otherDetails.containsKey("srpUrl")) {
				String rUrl = (String) otherDetails.get("rUrl");
				String srpUrl = (String) otherDetails.get("srpUrl");
				updateRequestMapFromUrl(rUrl, requestMap);
				updateRequestMapFromUrl(srpUrl, requestMap);
				otherDetails.put("pageId", getPageIdFromUrl(requestMap));
				otherDetails.put("vendorId", requestMap.get("hotelId"));
			} else if (otherDetails != null && otherDetails.containsKey("pageId")) {
				requestMap.put("vendorId", (String) otherDetails.get("vendorId"));
				requestMap.put("city", (String) otherDetails.get("city"));
				updateRequestMapFromPageId((String) otherDetails.get("pageId"), requestMap);
				otherDetails.put("rUrl", URLDecoder.decode(createRurl(requestMap), "UTF-8"));
				otherDetails.put("srpUrl", URLDecoder.decode(createSrpurl(requestMap), "UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return requestMap;
	}

	public static void updateRequestMapFromUrl(String url, HashMap<String, String> requestMap) {
		try {
			url = URLDecoder.decode(url, "UTF-8");
			url = url.split("\\?")[1];
			String[] pairs = url.split("&");
			for (String pair : pairs) {
				int idx = pair.indexOf("=");
				//String key = URLDecoder.decode(pair.substring(0, idx), "UTF-8").replace("roomRequests", "rooms");
				requestMap.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void updateRequestMapFromPageId(String pageId, HashMap<String, String> requestMap) {
		String checkInDate = getFormatedDate(pageId.substring(0,8));
		String checkOutDate = getFormatedDate(pageId.substring(9,17));
		requestMap.put("checkInDate", checkInDate);
		requestMap.put("checkOutDate", checkOutDate);
		setRoomRequest(0, requestMap, pageId.substring(18,25));
		setRoomRequest(1, requestMap, pageId.substring(26,33));
		setRoomRequest(2, requestMap, pageId.substring(34,41));
		setRoomRequest(3, requestMap, pageId.substring(42,49));
	}

	public static String getFormatedDate(String date){
		if(date==null){
			return date;
		}
		String day =  date.substring(0,2);
		String month = date.substring(2,4);
		String year = date.substring(4,8);
		return ""+day+"/"+ month +"/"+year  ;
	}

	public static void setRoomRequest(int roomIndex, Map<String, String> paramMap, String hashKey){
		if(roomIndex>-1 && 4>roomIndex){
			int noOfAdults = getNoOfAdultsFromRoomHashKey(hashKey);
			int noOfChildren = getNoOfChildrenRoomHashKey(hashKey);

			if(noOfAdults<5 && noOfAdults>0){
				paramMap.put("roomRequests["+(roomIndex)+"].id", ""+(roomIndex+1));
				paramMap.put("roomRequests["+(roomIndex)+"].noOfAdults", ""+noOfAdults);
				if(noOfChildren<6 && noOfChildren>0){
					paramMap.put("roomRequests["+(roomIndex)+"].noOfChildren", ""+noOfChildren);
					for(int i=1; i<=noOfChildren; i++){
						paramMap.put("roomRequests["+(roomIndex)+"].childrenAge["+(i-1)+"]", ""+(hashKey.charAt(i+1)-97)%12);
					}
				}else{
					paramMap.put("roomRequests["+(roomIndex)+"].noOfChildren", ""+0);
				}
			}
		}
	}

	public static int getNoOfAdultsFromRoomHashKey(String hashKey){
		int noOfAdults = 0;
		if(!StringUtils.isBlank(hashKey)){
			noOfAdults = Integer.parseInt(""+hashKey.charAt(0));
		}
		return noOfAdults;
	}

	public static int getNoOfChildrenRoomHashKey(String hashKey){
		int noOfChildren = 0;
		if(!StringUtils.isBlank(hashKey)){
			noOfChildren = Integer.parseInt(""+hashKey.charAt(1));
		}
		return noOfChildren;
	}

	public static String getPageIdFromUrl(HashMap<String, String> requestMap) {
		String hotelId = (String) requestMap.get("hotelId");
		hotelId.replace("TGR-", "");
		String pageId = "";
		pageId += getFormatedDateForPageId(getCheckInDateFromRequest(requestMap));
		pageId += "-";
		pageId += getFormatedDateForPageId(getCheckOutDateFromRequest(requestMap));
		pageId += getPaxDetailsKey(requestMap);
		pageId += "-"+hotelId;
		pageId += ":"+ getRandomKey();
		return pageId;
	}

	public static String getFormatedDateForPageId(String date){
		if(date==null){
			return "00000000";
		}
		if(date.charAt(4)=='-'||date.charAt(4)=='/'){		// 2015-02-20
			String day =  date.substring(8,10);
			String month = date.substring(5,7);
			String year = date.substring(0,4);
			String newDate = day+""+ month +""+year  ;
			return newDate;
		}else if(date.charAt(2)=='-'||date.charAt(2)=='/'){	// 21/02/2015
			String day =  date.substring(0,2);
			String month = date.substring(3,5);
			String year = date.substring(6,10);
			String newDate = day+""+ month +""+year  ;
			return newDate;
		}
		return "00000000";
	}
	public static String createRurl(HashMap<String, String> requestMap) {
		String rUrl = "//homestays.yatra.com/homestay-search/domhs/details?source=HOMESTAY_CHAT&tenant=HSTAYS_B2C&city.name=New Delhi&"
				+ "city.code=New Delhi&checkinDate=01/02/2017&checkoutDate=02/02/2017&appType=HOMESTAY&roomRequests[0].noOfChildren=0&"
				+ "roomRequests[0].id=1&roomRequests[0].noOfAdults=1&hotelId=00069898&excludeHotelTax=true&targetTo=room";
		String url = "//homestays.yatra.com/homestay-search/domhs/details?";
		url += "source=" + source + "&";
		url += "appType=" + appType+ "&";
		url += "tenant=" + tenant + "&";
		url += "city.name=" +(String) requestMap.get("city") + "&";
		url += "city.code=" +(String) requestMap.get("city") + "&";
		url += "checkinDate=" +(String) requestMap.get("checkInDate") + "&"; 
		url += "checkoutDate=" +(String) requestMap.get("checkOutDate") + "&";
		url += "hotelId=" +(String) requestMap.get("vendorId") + "&";

		Iterator<String> keySetIterator = requestMap.keySet().iterator();
		while(keySetIterator.hasNext()){
			String key = keySetIterator.next();
			if(key.startsWith("roomRequests")){
				url += key + "=" + requestMap.get(key) + "&";
			}
		}

		url += "excludeHotelTax=" + excludeHotelTax + "&";
		url += "targetTo=" + targetTo;
		
		return url;
	}

	public static String createSrpurl(HashMap<String, String> requestMap) {
		String rUrl = "//homestays.yatra.com/homestay-search/domhs/details?source=HOMESTAY_CHAT&city.name=New Delhi&city.code=New Delhi&"
				+ "checkinDate=11/02/2017&checkoutDate=12/02/2017&appType=HOMESTAY&roomRequests[0].noOfChildren=0&roomRequests[0].id=1&"
				+ "roomRequests[0].noOfAdults=1";
		String url = "//homestays.yatra.com/homestay-search/domhs/search?";
		url += "source=" + source + "&"; 
		url += "city.name=" +(String) requestMap.get("city") + "&";
		url += "city.code=" +(String) requestMap.get("city") + "&";
		url += "checkinDate=" +(String) requestMap.get("checkInDate") + "&";
		url += "checkoutDate=" +(String) requestMap.get("checkOutDate") + "&";

		Iterator<String> keySetIterator = requestMap.keySet().iterator();
		while(keySetIterator.hasNext()){
			String key = keySetIterator.next();
			if(key.startsWith("roomRequests")){
				url += key + "=" + requestMap.get(key) + "&";
			}
		}
		url += "appType=" + appType;
		return url;
	}

	public static String getRandomKey() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = dateFormat.format(date).replace(":", "");
		DecimalFormat randomKeyFormatter = new DecimalFormat("00000");

		time = "" + (Integer.parseInt(time.substring(0, 2)) * 3600 + Integer.parseInt(time.substring(2, 4)) * 60
				+ Integer.parseInt(time.substring(4, 6)) + new Random().nextInt(1000));

		return randomKeyFormatter.format(Integer.parseInt(time));
	}

	public static String getCheckInDateFromRequest(Map<String, String> clientRequestMap) {
		 String checkInDate = "";
		if(clientRequestMap.containsKey("checkInDate")){
			checkInDate = clientRequestMap.get("checkInDate");
		}else if(clientRequestMap.containsKey("checkinDate")){
			checkInDate = clientRequestMap.get("checkinDate");
		}
		return checkInDate;
	}

	public static String getCheckOutDateFromRequest(Map<String, String> clientRequestMap) {
		 String checkOutDate = "";
		if(clientRequestMap.containsKey("checkOutDate")){
			checkOutDate = clientRequestMap.get("checkOutDate");
		}else if(clientRequestMap.containsKey("checkoutDate")){
			checkOutDate = clientRequestMap.get("checkoutDate");
		}
		return checkOutDate;
	}

	public static String getPaxDetailsKey(Map<String,String> requestMap){
		String searchHashKey = "";
		for(int roomIterator=0; roomIterator<4; roomIterator++){
			searchHashKey += "-";
			 String suffix="";
			 if(requestMap.containsKey("roomRequests["+roomIterator+"].noOfAdults")){
				 suffix="roomRequests";
			 } 
			 if(requestMap.containsKey("rooms["+roomIterator+"].noOfAdults")){
				 suffix="rooms"; 
			 } 

			 if(requestMap.containsKey(suffix+"["+roomIterator+"].noOfAdults")){
				searchHashKey += searchValueFromMap(requestMap, suffix+"["+roomIterator+"].noOfAdults");
				int noOfChildren = Integer.parseInt(searchValueFromMap(requestMap, suffix+"["+roomIterator+"].noOfChildren"));
				searchHashKey += noOfChildren;
				int childrenIterator=0;
				for(childrenIterator=0; childrenIterator<noOfChildren; childrenIterator++){
					searchHashKey += getAlphabet(searchValueFromMap(requestMap, suffix+"["+roomIterator+"].childrenAge["+childrenIterator+"]"));
				}
				while(childrenIterator<5){
					childrenIterator++;
					searchHashKey += "z";
				}
			}else{
				searchHashKey += "00zzzzz";
			}
		}
		return searchHashKey;
	}

	private static String searchValueFromMap(Map<String,String> requestMap, String key){
		if(requestMap.containsKey(key)){
			if(requestMap.containsKey(key) && !StringUtils.isEmpty(requestMap.get(key))){
				return requestMap.get(key);
			}
		}
		return "0";	
	}

	private static char getAlphabet(String str){
		int i = Integer.parseInt(str);
		i=i+97;
		return (char) i;
	}
}