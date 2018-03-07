package com.prem.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

public class DateConversion {

	public static String getDay(String day, String month, String year) {
		LocalDate date = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
		return date.getDayOfWeek().toString();
	}
	 
  public static void main(String[] args) {
/*
    Calendar modifiedDate=DateConversion.dateConverterUtil("2016-05-27 15:48:04","yyyy-MM-dd HH:mm:ss");
    Calendar verifiedDate=DateConversion.dateConverterUtil("2016-05-27 15:52:59.0","yyyy-MM-dd HH:mm:ss");
    System.out.println(modifiedDate.before(verifiedDate));

    System.out.println(modifiedDate.getTime().toString());
    System.out.println(verifiedDate.getTime().toString());
*/
    LocalDateTime modifiedDate=DateConversion.dateConverterUtil2("2016-05-27 15:48:04","yyyy-MM-dd HH:mm:ss");
    LocalDateTime verifiedDate=DateConversion.dateConverterUtil2("2016-05-27 15:52:59.0","yyyy-MM-dd HH:mm:ss.S");
    System.out.println(modifiedDate.isBefore(verifiedDate));

/*
    System.out.println(modifiedDate.getTime().toString());
    System.out.println(verifiedDate.getTime().toString());
*/

  }


  private static Calendar dateConverterUtil(String baseDate, String dateFormat){
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    Calendar cal =null;
    Date date = null;
    try {
      date = sdf.parse(baseDate);
      cal = Calendar.getInstance();
      cal.setTime(date);
    } catch (ParseException e) {
//      Logger.debug("Error in parsing date");
    }
    return cal;
  }

  private static LocalDateTime dateConverterUtil2(String baseDate, String dateFormat){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

    return LocalDateTime.parse(baseDate, formatter);
//    parsedDate.isBefore()
/*
    DateTime dt = formatter.parseDateTime(string);
    LocalDate date1 = LocalDate.of(2014, 01, 14);
    if(date1.equals(today)){
      System.out.printf("Today %s and date1 %s are same date %n", today, date1);
    }


    Read more: http://javarevisited.blogspot.com/2015/03/20-examples-of-date-and-time-api-from-Java8.html#ixzz4RxDWn0fD


    fmt.parse(baseDate);
*/








   /* SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    Calendar cal =null;
    Date date = null;
    try {
      date = sdf.parse(baseDate);
      cal = Calendar.getInstance();
      cal.setTime(date);
    } catch (ParseException e) {
//      Logger.debug("Error in parsing date");
    }
    return cal;*/
  }


}
