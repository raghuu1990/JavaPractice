package com.yatra;

import org.apache.commons.codec.binary.Base64;
import com.utils.StringUtils;
import java.util.Scanner;

public class Authorization {

	public static void main(String args[] ) throws Exception {	
		String str1 = "https://www.tripadvisor.com/img/cdsi/img2/ratings/traveler/s4.0-11942-5.png";
		String str2 = "https://static.tacdn.com/img2/ratings/traveler/ss4.5.gif";
		String str3 = "https://www.tripadvisor.com/img/cdsi/img2/ratings/traveler/s4.0-11942-5.png";
		String str4 = "4.0";
		String str5 = "aaas4.0";
		String str6 = "rav3333333333eler/s4.0";
			
		System.out.println(getRatingFromRatingImageURL(str1));
		System.out.println(getRatingFromRatingImageURL(str2));
		System.out.println(getRatingFromRatingImageURL(str3));
		System.out.println(getRatingFromRatingImageURL(str4));
		System.out.println(getRatingFromRatingImageURL(str5));
		System.out.println(getRatingFromRatingImageURL(str6));

		System.out.println("Please enter sso token to generate Authorization code :");
		Scanner in = new Scanner(System.in);
		String ssoToken  = in.nextLine();
		if(StringUtils.isNotEmpty(ssoToken)){
            byte[] encodedBytes = Base64.encodeBase64(("HMS/"+ssoToken).getBytes());
            ssoToken =  "BEARER "+new String(encodedBytes);   
        }
		in.close();
		System.out.println(ssoToken);
		System.out.println(getSourceString());
	}
	
	public static String getSourceString(){
		String scope = "tghscandroid"; 
		return scope.contains("mtg")?"tg":(scope.contains("tghs")?"travelguru":"yatra");
	}
	
	private static float getRatingFromRatingImageURL(String ratingImageURL) {
		if(!ratingImageURL.isEmpty()){ 
			if(ratingImageURL.contains("/traveler/")){
				ratingImageURL= ratingImageURL.substring(ratingImageURL.lastIndexOf("/traveler/")+10);
			}
			
			int indexOfFirstS=0;
			if(ratingImageURL.contains("s")){
				indexOfFirstS = ratingImageURL.indexOf("s");
				ratingImageURL = ratingImageURL.substring(indexOfFirstS);
			}
			
			int countOfS=0;
			while(ratingImageURL.charAt(countOfS)=='s'){
				countOfS++;
			}
			try{
				float rating = Float.parseFloat(ratingImageURL.substring(countOfS, countOfS+3));
				return rating;
			}catch(NumberFormatException ex){
			}
		}
		return 0;		
	}
}
