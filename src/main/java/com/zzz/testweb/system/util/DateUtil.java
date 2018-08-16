/*  
 * @(#)DateUtil.java     1.0 2011/05/31      
 *      
 * Copyright (c) 2010 SHANGHAI BINGKUN DIGITAL TECHNOLOGY CO.,LTD       
 * All rights reserved      
 *      
 * This software is the confidential and proprietary information of         
 * SHANGHAI BINGKUN.("Confidential Information").  You shall not        
 * disclose such Confidential Information and shall use it only in      
 * accordance with the terms of the license agreement you entered into      
 * with SHANGHAI BINGKUN.       
 */
package com.zzz.testweb.system.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*	
 * @(#)DateUtil.java     1.0 2010/10/12		
 * 		
 * Copyright (c) 2010 SHANGHAI BINGKUN DIGITAL TECHNOLOGY CO.,LTD		
 * All rights reserved		
 * 		
 * This software is the confidential and proprietary information of 		
 * SHANGHAI BINGKUN.("Confidential Information").  You shall not		
 * disclose such Confidential Information and shall use it only in		
 * accordance with the terms of the license agreement you entered into		
 * with SHANGHAI BINGKUN.		
 */

/**
 * <p>
 * 鍏遍�� 鏃堕棿Util
 * </p>
 * 
 * @author huzd
 * 
 */
public class DateUtil {
	
	/** 骞存湀鏃ユ牸寮� */
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	/** 鏃跺垎绉� */
	public static final String TIME_PATTERN = "HH:mm:ss";
	
	/** 骞存湀鏃ユ椂鍒嗙 */
	public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 鎶奃ate杞崲鎴怱tring鍨嬫棩鏈�
	 * @param date
	 * @return
	 */
	public static String date2String (Date date,String formatType){
		DateFormat format = new SimpleDateFormat(formatType);        
		String dateStr = format.format(date);
		return dateStr;
	}
	
	/**
	 * 鏃ユ湡瀛楃涓叉牸寮忓寲
	 * @param date
	 * @return
	 */
	public static String formatDate (String date){
		return  DateUtil.date2String(DateUtil.coverString2Date(date));
	}
	
	/**
	 * 鎶奃ate杞崲鎴怱tring鍨嬫棩鏈�
	 * @param date
	 * @return
	 */
	public static String date2String (Date date){
		return date2String(date,DATE_PATTERN);
	}
	
	/**
	 * 鏍规嵁灏忔椂娣诲姞鏃ユ湡
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static Date addDateByHours (Date date,int hours){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date); 
		cal.add(Calendar.HOUR_OF_DAY, hours);//24灏忔椂鍒� 
		date = cal.getTime(); 
		return date;
	}
	
	/**
	 * 鏃ユ湡澧炲姞鎸囧畾澶╂暟
	 * @param pattern
	 * @param date
	 * @param days
	 * @return
	 */
	public static String addDateByDays (String pattern, String date, int days){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(coverString2Date(date)); 
		cal.add(Calendar.DAY_OF_MONTH, days);
		return date2String(cal.getTime(),pattern);
	}
	
	/**
	 * 鏃ユ湡澧炲姞鎸囧畾骞�
	 * @param pattern
	 * @param date
	 * @param years
	 * @return
	 */
	public static String addDateByYears (String pattern, String date, int years){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(coverString2Date(date)); 
		cal.add(Calendar.YEAR, years);
		return date2String(cal.getTime(),pattern);
	}
	
	/**
	 * 鎶婂瓧绗︿覆杞垚鎸囧畾鏍煎紡鐨勬棩鏈�
	 * 
	 * @param s 寰呰浆鎹㈢殑瀛楃涓�
	 * @param pattern 鎸囧畾鐨勬棩鏈熸牸寮�
	 * @return 濡傛灉杞崲鎴愬姛杩斿洖鏃ユ湡锛屽惁鍒欒繑鍥瀗ull
	 */
	public static Date coverString2Date(String s, String pattern) {
		
		if(s == null || "".equals(s))
			return null;
		if(pattern == null || "".equals(pattern))
			return null;
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			Date d = df.parse(s);
	        if(df.format(d).equals(s)) {
	        	return d;
	        } else {
	        	return null;
	        }
	    } catch (ParseException e) {
	         return null;
	    }
	}
	
	/**
	 * 鎶婂瓧绗︿覆杞垚鏃ユ湡(鏀寔澶氱鏍煎紡)
	 * 
	 * @param s 寰呰浆鎹㈢殑瀛楃涓�
	 * @return 濡傛灉杞崲鎴愬姛杩斿洖鏃ユ湡锛屽惁鍒欒繑鍥瀗ull
	 */
	public static Date coverString2Date(String s) {
		
		if(s == null || "".equals(s))
			return null;
		Date d = coverString2Date(s, "yyyy-MM-dd");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyy-M-d");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyy-MM-d");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyy-M-dd");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyy/MM/dd");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyy/M/d");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyy/MM/d");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyy/M/dd");
		if(d != null)
			return d;
		d = coverString2Date(s, "yyyyMMdd");
		if(d != null)
			return d;
		d = coverString2Date(s,DATETIME_PATTERN);
		if(d != null)
			return d;
		return null;
	}
	
	/**
	 * 閫氳繃涓�涓棩鏈燂紝鍙栧緱璇ユ棩鏈熸墍鍦ㄦ湀浠界殑绗竴澶╃殑鏃ユ湡(骞存湀鏃�)
	 * 
	 * @param date 浠讳綍涓�涓棩鏈�(骞存湀鏃�)
	 * @return 绗竴澶╃殑鏃ユ湡(骞存湀鏃�)
	 * @throws Exception 
	 */
	public static String getFirstDateYMD(String date) throws Exception {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(sf.parse(date));
    	ca.set(Calendar.DAY_OF_MONTH,ca.getMinimum(Calendar.DAY_OF_MONTH));
		return sf.format(ca.getTime());
	}
	
	/**
	 * 璁＄畻涓や釜鏃ユ湡涔嬮棿闂撮殧鐨勫ぉ鏁�
	 * @param startday 寮�濮嬫棩鏈�
	 * @param endday 缁撴潫鏃ユ湡
	 * @return int 闂撮殧澶╂暟
	 * 
	 * */
	public static int getIntervalDays(Date startday,Date endday){
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		cal1.setTime(startday);
		cal2.setTime(endday);
		
        if(cal1.after(cal2)){
             Calendar cal=cal1;
             cal1=cal2;
             cal2=cal;
        }    
        long sl=cal1.getTimeInMillis();
        long el=cal2.getTimeInMillis();
        
        long ei=el-sl;           
        return (int)(ei/(1000*60*60*24));
		}
	/*
	 * 鎶婂瓧绗︿覆杞垚骞存湀鏃ユ牸寮忕殑鏃ユ湡(yyyy-MM-dd)
	 * 
	 * @param s 寰呰浆鎹㈢殑瀛楃涓�
	 * @param pattern 鎸囧畾鐨勬棩鏈熸牸寮�
	 * @return 濡傛灉杞崲鎴愬姛杩斿洖鏃ユ湡锛屽惁鍒欒繑鍥瀗ull
	 * @throws Exception 
	 */
	public static String coverTime2YMD(String time, String pattern) throws Exception {
		if(time == null || "".equals(time))
			return null;
		if(pattern == null || "".equals(pattern))
			return null;
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			Date d = df.parse(time);
			String dateStr = date2String(d, "yyyy-MM-dd");
			return dateStr;
	    } catch (ParseException e) {
	    	throw new Exception("datetime conversion error");
	    }
	}
	
	/**
	 * 璁剧疆鏃ユ湡鐨勬椂鍒嗙姣
	 * 
	 * @param String
	 *            杞崲鍓嶇殑鏃ユ湡 int 鏃ユ湡鍖哄垎(0:寮�濮嬫棩鏈�,1:缁撴潫鏃ユ湡)
	 * @return String 杞崲鍚庣殑鏃ユ湡
	 */
	public static String suffixDate(String date, int dateKbn) {
		if (null != date && !"".equals(date)) {
			if (checkDate(date)) {
				if (0 == dateKbn) {
					return date + " 00:00:00.000";
				} else {
					return date + " 23:59:59.000";
				}
			}
		}
		return date;
	}
	
	/**
	 * 妫�娴嬪瓧绗︿覆鏄惁绗﹀悎鏃ユ湡鏍煎紡(鏀寔澶氱鏍煎紡)
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @return 濡傛灉瀛楃涓茬鍚堟棩鏈熸牸寮忓垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean checkDate(String value) {
		if (checkDate(value, "yyyy-MM-dd"))
			return true;
		if (checkDate(value, "yyyy-M-d"))
			return true;
		if (checkDate(value, "yyyy-MM-d"))
			return true;
		if (checkDate(value, "yyyy-M-dd"))
			return true;
		if (checkDate(value, "yyyy/MM/dd"))
			return true;
		if (checkDate(value, "yyyy/M/d"))
			return true;
		if (checkDate(value, "yyyy/MM/d"))
			return true;
		if (checkDate(value, "yyyy/M/dd"))
			return true;
		if (checkDate(value, "yyyyMMdd"))
			return true;
		return false;
	}
	
	/**
	 * 妫�娴嬪瓧绗︿覆鏄惁绗﹀悎鎸囧畾鐨勬棩鏈熸牸寮�
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @param pattern
	 *            鎸囧畾鐨勬棩鏈熸牸寮�
	 * @return 濡傛灉瀛楃涓茬鍚堟寚瀹氱殑鏃ユ湡鏍煎紡鍒欒繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean checkDate(String value, String pattern) {
		if (value == null || "".equals(value))
			return false;
		if (pattern == null || "".equals(pattern))
			return false;
		boolean ret = true;
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			ret = df.format(df.parse(value)).equals(value);
			if (ret) {
				Calendar ca = Calendar.getInstance();
				ca.setTime(df.parse(value));
				ret = ca.get(Calendar.YEAR) < 10000;
			}
		} catch (ParseException e) {
			ret = false;
		}
		return ret;
	}
	
	/**
	 * 鍒涘缓鏃ユ湡
	 * 
	 * @param year
	 *            骞�
	 * @param month
	 *            鏈�
	 * @param day
	 *            鏃�
	 * @param formatType
	 *            鏃ユ湡鏍煎紡
	 * @return 杩斿洖鐢熸垚鐨勬棩鏈�
	 */
	public static String createDate(int year, int month, int day, String formatType) {
		Calendar ca1 = Calendar.getInstance();
		ca1.set(Calendar.YEAR, year);
		ca1.set(Calendar.MONTH, month);
		ca1.set(Calendar.DAY_OF_MONTH, day);
		return date2String(ca1.getTime(), formatType);
	}
	
	/**
	 * 鏃ユ湡澧炲姞鎸囧畾鏈堟暟
	 * 
	 * @param pattern
	 * @param date
	 * @param months
	 * @return
	 */
	public static String addDateByMonth(String pattern, String date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(coverString2Date(date));
		cal.add(Calendar.MONTH, months);
		return date2String(cal.getTime(), pattern);
	}
	
	/**
	 * 涓や釜瀛楃涓茬殑鏃ユ湡姣旇緝
	 * 
	 * @param value1
	 *            寰呮瘮杈冪殑瀛楃涓�1
	 * @param value2
	 *            寰呮瘮杈冪殑瀛楃涓�2
	 * @return 杩斿洖0琛ㄧず涓や釜鏃ユ湡鐩哥瓑锛岃繑鍥炴瘮0灏忕殑鍊艰〃绀簐alue1鍦╲alue2涔嬪墠锛岃繑鍥炴瘮0澶х殑鍊艰〃绀簐alue1鍦╲alue2涔嬪悗
	 */
	public static int compareDate(String value1, String value2) {
		Date d1 = coverString2Date(value1);
		Date d2 = coverString2Date(value2);
		return d1.compareTo(d2);
	}
	
	/**
	 * 鏃ユ湡鍑忓皯鎸囧畾鏈堟暟
	 * @param pattern
	 * @param date
	 * @param days
	 * @return
	 */
	public static String subDateByMonth (String pattern, String date, int month){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(coverString2Date(date)); 
		cal.add(Calendar.MONTH, - month);
		int dateYear = cal.get(Calendar.YEAR);
		int dateMonth = cal.get(Calendar.MONTH);
		cal.set(dateYear, dateMonth, 1);
		return date2String(cal.getTime(),pattern);
	}
	
	/**   
     * 鑾峰彇鏌愬勾绗竴澶╂棩鏈�
     * @param year 骞翠唤   
     * @return Date   
     */    
    public static String getCurrYearFirst(int year) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.clear();
    	calendar.set(Calendar.YEAR, year);
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	return sf.format(calendar.getTime());   
    }
    
    /**
	 * 鍒ゆ柇鏄惁涓洪棸骞�
	 * 
	 * @param year
	 *            骞翠唤
	 * @return 闂板勾杩斿洖true锛屽钩骞磋繑鍥瀎alse
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 鍒涘缓鏃ユ湡
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date createDate(int year, int month, int day){
		return getCalendar(year,month,day).getTime();
	}

   	public static Calendar getCalendar(String date){
   		Calendar cal = Calendar.getInstance();
   		cal.setTime(DateUtil.coverString2Date(date));
   		return cal;
   	}
   	
   	
   	public static Calendar getCalendar(int year, int month, int day){
   		Calendar cal = Calendar.getInstance();
   		// 骞冲勾
   		if(!isLeapYear(year) && month == 2 && day == 29){
   			day--;
   		}
   		cal.set(year, month-1, day);
   		return cal;
   	}
   	
   	/**
	 * 閫氳繃涓�涓棩鏈燂紝鍙栧緱璇ユ棩鏈熸墍鍦ㄦ湀浠界殑绗竴澶╂垨鑰呮渶鍚庡ぉ鐨勬棩鏈�(骞存湀鏃�)
	 * 
	 * @param date 浠讳綍涓�涓棩鏈�(骞存湀鏃�)
	 * @param flag 0锛氬彇寰楄鏃ユ湡鐨勭涓�澶╋紝1锛氬彇寰楄鏃ユ湡鐨勬渶鍚庡ぉ
	 * @return 绗竴澶╂垨鑰呮渶鍚庡ぉ鐨勬棩鏈�(骞存湀鏃�)
	 */
	public static String getFirstOrLastDateYMD(String date, int flag) {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(coverString2Date(date));
    	if(flag == 0) {
    		ca.set(Calendar.DAY_OF_MONTH,ca.getActualMinimum(Calendar.DAY_OF_MONTH));
    	} else {
    		ca.set(Calendar.DAY_OF_MONTH,ca.getActualMaximum(Calendar.DAY_OF_MONTH));
    	}
		return sf.format(ca.getTime());
	}
	
	/**
	 * 閫氳繃涓�涓湀浠斤紝鍙栧緱璇ユ湀浠界殑鏈�鍚庡ぉ
	 * 
	 * @param month 浠讳綍涓�涓湀浠�
	 * @return 鏈�鍚庡ぉ
	 */
	public static String getLastDateByMonth(String month) {
		
		int _month = Integer.parseInt(month);
		if(_month == 2) {
			return "29";
		} else if (_month == 4 || _month == 6 || _month == 9 || _month == 11) {
			return "30";
		} else {
			return "31";
		}
	}
	
	/**
	 * 璁＄畻涓や釜鏃ユ湡闂寸殑澶╂暟
	 * 
	 * @param startDate 寮�濮嬫棩鏈�
	 * @param endDate 缁撴潫鏃ユ湡
	 * @return 澶╂暟
	 */
	public static Long getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();  
        fromCalendar.setTime(startDate);  
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);  
        fromCalendar.set(Calendar.MINUTE, 0);  
        fromCalendar.set(Calendar.SECOND, 0);  
        fromCalendar.set(Calendar.MILLISECOND, 0);  
  
        Calendar toCalendar = Calendar.getInstance();  
        toCalendar.setTime(endDate);  
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);  
        toCalendar.set(Calendar.MINUTE, 0);  
        toCalendar.set(Calendar.SECOND, 0);  
        toCalendar.set(Calendar.MILLISECOND, 0);  
  
        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);  
    }
	
	/**
	 * 鍙栧緱鍥哄畾鏍煎紡鐨勬椂闂村瓧绗︿覆
	 * @param timeParam
	 * @return
	 */
	public static String getSpecificDate(String timeParam,String pattern){
		DateFormat format = new SimpleDateFormat(pattern);
		Date date = coverString2Date(timeParam);
		String dateStr = format.format(date);
		return dateStr;
	}
}
