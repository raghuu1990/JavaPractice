package com.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Decode {
	public static void main(String args[]){
		Date dob=null;
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			dob=df.parse("2014-02-10 11:15:00");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		GregorianCalendar cal = new GregorianCalendar();

		cal.setTime(dob);
		XMLGregorianCalendar xmlDate2 = null;
		XMLGregorianCalendar xmlDate3 = null;
		try {
			xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			xmlDate3 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH),dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(xmlDate2);
		System.out.println(xmlDate3);
		
			    GregorianCalendar c = new GregorianCalendar();
			    try {
			    	System.out.println( DatatypeFactory.newInstance().newXMLGregorianCalendar(2016, 10, 21, DatatypeConstants.FIELD_UNDEFINED,DatatypeConstants.FIELD_UNDEFINED,DatatypeConstants.FIELD_UNDEFINED,DatatypeConstants.FIELD_UNDEFINED,DatatypeConstants.FIELD_UNDEFINED));
			    } catch (DatatypeConfigurationException e) {
			      e.printStackTrace();
			  }
		
		
		
		
		/*HashMap<String, String> paramMap = new HashMap<String, String>();
		setSearchCriteriaFromHashKey(paramMap,"0105150305151abcde0aadfq0aabba0aaxxx");
		
		//   010515030515 1abcde 2abctp 3aabba 4aaxxx
		System.out.println(paramMap.toString());*/
	}
		
	public static String getFormatedDate(String date){
		if(date==null)
		return date;
		String day =  date.substring(0,2);
		String month = date.substring(2,4);
		String year = date.substring(4,6);
		return day+"/"+ month +"/20"+year  ;
	}
	
	public static void setRoomRequest(int roomIndex, Map<String, String> paramMap, String hashKey){
		if(roomIndex>-1 && 4>roomIndex){
			int noOfAdults = Integer.parseInt(""+hashKey.charAt(0));
			int noOfChildren = 0;
			for(int i=1; i<6; i++){
				if(hashKey.charAt(i)<109 && hashKey.charAt(i)>96){
					noOfChildren += 1;
				}
			}
			
			if(noOfAdults<4 && noOfAdults>0){
				paramMap.put("roomRequests["+(roomIndex)+"].id", ""+(roomIndex));
				paramMap.put("roomRequests["+(roomIndex)+"].noOfAdults", ""+noOfAdults);
				if(noOfChildren<6 && noOfChildren>0){
					paramMap.put("roomRequests["+(roomIndex)+"].noOfChildren", ""+noOfChildren);
					for(int i=1; i<=noOfChildren; i++){
						paramMap.put("roomRequests["+(roomIndex)+"].childrenAge["+(i-1)+"]", ""+(hashKey.charAt(i)-97)%12);
					}
				}
			}
		}		
	}
	
	private static void setSearchCriteriaFromHashKey(Map<String, String> paramMap, String hashKey) {
		String checkInDate = hashKey.substring(0,6);
		String checkOutDate = hashKey.substring(6,12);
		setRoomRequest(0, paramMap,hashKey.substring(12,18));
		setRoomRequest(1, paramMap,hashKey.substring(18,24));
		setRoomRequest(2, paramMap,hashKey.substring(24,30));
		setRoomRequest(3, paramMap,hashKey.substring(30,36));
		paramMap.put("checkinDate", getFormatedDate(checkInDate));
		paramMap.put("checkoutDate", getFormatedDate(checkOutDate));
	}
}

