package com.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecoding {

	public static void main(String[] args){
		/*String url = "http://172.16.1.131:7070/ccwebapp/mobile/hotel/mdomhotelandroid/hotelDetails2.htm?osVersion\u003d22\u0026isInternational\u003dfalse\u0026deviceId\u003d67dd09760607aa0c\u0026parentPageId\u003d10112016-11112016-10zzzzz-00zzzzz-00zzzzz-00zzzzz%3A53945\u0026sessionId\u003dda9539b9-621c-4522-93f5-28b447ccd66f\u0026appVersion\u003d8\u0026hotelID\u003dTGR-00077438";
		try {
			String productUrl = URLDecoder.decode(url, "UTF-8");
			System.out.println(productUrl);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		 //String url = "http%3A%2F%2F172.16.1.131%3A7070%2Fccwebapp%2Fmobile%2Fhotel%2Fmdomhotelandroid%2FhotelDetails2.htm%3FosVersion%3D21%26isInternational%3Dfalse%26deviceId%3De84048fcf4e1e799%26parentPageId%3D20102016-21102016-10zzzzz-00zzzzz-00zzzzz-00zzzzz%3A41181%26sessionId%3D04bd639b-37e4-4ee2-807d-3312df8f2f3f%26appVersion%3D8%26hotelID%3DTGR-00077442&ssoToken=4559ae92-eab0-4139-844f-192a9091a737";
		 String url = "Test+property+Room+only";
		 try {
			url = URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(url);
	}
}
