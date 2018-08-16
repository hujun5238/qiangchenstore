/*  
 * @(#)CherryChecker.java     1.0 2011/05/31      
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

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 鍏遍�氭鏌ョ被
 * 
 * @author dingyc
 * @date 2010-09-10
 * 
 */
public class MobileChecker {

	/**
	 * 妫�娴嬫寚瀹氬璞℃槸鍚︿负null 濡傛灉涓簄ull鍒欒繑鍥瀟rue 鍚﹀垯杩斿洖false
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNull(Object value) {
		if (null == value) {
			return true;
		}
		return false;
	}

	/**
	 * 妫�娴嬫寚瀹氬璞℃槸鍚︿负绌哄瓧绗︿覆 濡傛灉瀵硅薄涓嶄负瀛楃涓叉垨涓洪暱搴﹀ぇ浜�0鐨勫瓧绗︿覆鍒欒繑鍥瀎alse锛屽惁鍒欒繑鍥瀟rue銆傚嵆鍙湁褰撳璞′负""鏃惰繑鍥瀟rue
	 * 
	 * @param value
	 * @param trim
	 *            鍙�夊弬鏁帮紝鏄惁瑕佽皟鐢⊿tring鐨則rim()鏂规硶
	 * @return
	 */
	public static boolean isEmptyString(Object value, boolean... trim) {

		if (!(value instanceof String)) {
			return false;
		} else {
			String s = (String) value;

			if (trim.length > 0 && trim[0] == true) {
				s = s.trim();
			}

			if (s.length() == 0) {
				return true;
			}
			return false;
		}
	}

	/**
	 * 妫�娴嬫寚瀹氬璞℃槸鍚︿负null鎴栬�呯┖瀛楃涓� 濡傛灉瀵硅薄涓簄ull鎴栫┖瀛楃涓插垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @param trim
	 *            鍙�夊弬鏁帮紝褰搗alue涓篠tring绫诲瀷鏃讹紝鏄惁璋冪敤trim鍚庡啀鍒ゆ柇鍏堕暱搴�
	 * @return
	 */
	public static boolean isNullOrEmpty(Object value, boolean... trim) {
		if (null == value) {
			return true;
		}
		if (value instanceof String) {
			String s = (String) value;
			if (trim.length > 0 && trim[0] == true) {
				s = s.trim();
			}
			if (s.length() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁鍏ㄧ敱姝ｆ暟缁勬垚 濡傛灉瀛楃涓插叏鐢辨鏁扮粍鎴愬垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNumeric(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value.matches("[0-9]*");
		if (ret) {
			return true;
		}
		return false;
	}
	
	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁鍏ㄧ敱姝ｆ暟鍜岃礋鏁扮粍鎴� 濡傛灉瀛楃涓插叏鐢辨鏁板拰璐熸暟缁勬垚鍒欒繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isPositiveAndNegative(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value.matches("^-?[0-9]+");
		if (ret) {
			return true;
		}
		return false;
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁鍏ㄧ敱鑻辨枃瀛楁瘝缁勬垚 濡傛灉瀛楃涓插叏鐢卞瓧姣嶇粍鎴愬垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphabetic(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value.matches("[a-zA-Z]*");
		if (ret) {
			return true;
		}
		return false;
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁鍏ㄧ敱鑻辨枃瀛楁瘝鎴栬�呮暟瀛楃粍鎴� 濡傛灉瀛楃涓插叏鐢卞瓧姣嶆垨鑰呮暟瀛楃粍鎴愬垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphanumeric(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value.matches("[0-9a-zA-Z]*");
		if (ret) {
			return true;
		}
		return false;
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎閭欢鍦板潃鏍煎紡 濡傛灉瀛楃涓茬鍚堥偖浠跺湴鍧�鏍煎紡鍒欒繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmail(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value
				.matches("\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b");
		if (ret) {
			return true;
		}
		return false;
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎缃戝潃鏍煎紡 濡傛灉瀛楃涓茬鍚堢綉鍧�鏍煎紡鍒欒繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isURL(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		if (value.startsWith("https://")) {
			// URL doesn't understand the https protocol, hack it
			value = "http://" + value.substring(8);
		}
		try {
			new URL(value);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
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
	 * 妫�娴嬪瓧绗︿覆鏄惁绗﹀悎鏃堕棿鏍煎紡hh:MM:ss
	 * 
	 * @param value
	 *            
	 * @return 濡傛灉瀛楃涓茬鍚堟棩鏈熸牸寮忓垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean checkTime(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value
				.matches("^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");
		if (ret) {
			return true;
		}
		return false;
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
		Date d1 = DateUtil.coverString2Date(value1);
		Date d2 = DateUtil.coverString2Date(value2);
		return d1.compareTo(d2);
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎閭紪
	 * 
	 * @param zip
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @return 濡傛灉瀛楃涓茬鍚堥偖缂栨牸寮忓垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isZipValid(String zip) {
		if (zip == null || "".equals(zip)) {
			return false;
		}
		return zip.matches("^[1-9]\\d{5}(?!\\d)$");
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎娴偣鏁帮紝鑰屼笖鏁存暟浣嶆暟涓嶅ぇ浜庝紶鍏ュ弬鏁發en1锛屽皬鏁颁綅鏁颁笉澶т簬浼犲叆鍙傛暟len2
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @param len1
	 *            鏁存暟浣嶆暟鏈�澶ц寖鍥�
	 * @param len2
	 *            灏忔暟浣嶆暟鏈�澶ц寖鍥�
	 * @return 濡傛灉瀛楃涓茬鍚堟诞鐐规暟锛岃�屼笖鏁存暟浣嶆暟涓嶅ぇ浜庝紶鍏ュ弬鏁發en1锛屽皬鏁颁綅鏁颁笉澶т簬浼犲叆鍙傛暟len2锛屽垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isFloatValid(String value, int len1, int len2) {
		if (value == null || "".equals(value)) {
			return false;
		}
		boolean checkFloat = false;
		checkFloat = value.matches("^([0-9]\\d*)(\\.\\d+)?$");
		if (checkFloat) {
			String[] ar = value.split("[.]");
			if (ar.length == 2) {
				if (ar[0].length() > len1 || ar[1].length() > len2) {
					checkFloat = false;
				}
			} else if (ar.length == 1) {
				if (ar[0].length() > len1) {
					checkFloat = false;
				}
			} else {
				checkFloat = false;
			}
		}
		return checkFloat;
	}
	
	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎娴偣鏁帮紝鑰屼笖鏁存暟浣嶆暟涓嶅ぇ浜庝紶鍏ュ弬鏁發en1锛屽皬鏁颁綅鏁颁笉澶т簬浼犲叆鍙傛暟len2锛屽彲浠ヤ负璐熸暟
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @param len1
	 *            鏁存暟浣嶆暟鏈�澶ц寖鍥�
	 * @param len2
	 *            灏忔暟浣嶆暟鏈�澶ц寖鍥�
	 * @return 濡傛灉瀛楃涓茬鍚堟诞鐐规暟锛岃�屼笖鏁存暟浣嶆暟涓嶅ぇ浜庝紶鍏ュ弬鏁發en1锛屽皬鏁颁綅鏁颁笉澶т簬浼犲叆鍙傛暟len2锛屽垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isDecimal(String value, int len1, int len2) {
		if (value == null || "".equals(value)) {
			return false;
		}
		boolean checkFloat = false;
		checkFloat = value.matches("^\\-?([0-9]\\d*)(\\.\\d+)?$");
		if (checkFloat) {
			String[] ar = value.split("[.]");
			if (ar.length == 2) {
				if (ar[0].replaceAll("-", "").length() > len1 || ar[1].length() > len2) {
					checkFloat = false;
				}
			} else if (ar.length == 1) {
				if (ar[0].replaceAll("-", "").length() > len1) {
					checkFloat = false;
				}
			} else {
				checkFloat = false;
			}
		}
		return checkFloat;
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎灏忔椂鎴栧垎閽熸牸寮�
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @param flg
	 *            涓簍rue鏃惰〃绀洪獙璇佸皬鏃讹紝涓篺alse鏃惰〃绀洪獙璇佸垎閽�
	 * @return 濡傛灉瀛楃涓插惁绗﹀悎灏忔椂鎴栧垎閽熸牸寮忥紝鍒欒繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isTimeValid(String value, boolean flg) {
		if (value == null || "".equals(value)) {
			return false;
		}
		return (value.matches("^\\d+$") && Integer.parseInt(value) <= (flg ? 23
				: 59));
	}

	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎韬唤璇佸彿鏍煎紡
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @return 濡傛灉瀛楃涓插惁绗﹀悎韬唤璇佸彿鏍煎紡锛屽垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isICardValid(String value) {
		if (isNullOrEmpty(value)) {
			return false;
		}
		if (value.length() != 15 && value.length() != 18) {
			return false;
		}
		return value.matches("^[1-9]\\d+[0-9X]$");
	}
	
	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎鎵嬫満鍙风爜鏍煎紡
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @return 濡傛灉瀛楃涓插惁绗﹀悎鎵嬫満鍙风爜鏍煎紡锛屽垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isPhoneValid(String value) {
		if (isNullOrEmpty(value)) {
			return false;
		}
		if (value.length() != 11) {
			return false;
		}
		return value.matches("^1[3458]\\d+$");
	}
	
	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎鐢佃瘽鍙风爜鏍煎紡
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @return 濡傛灉瀛楃涓插惁绗﹀悎鐢佃瘽鍙风爜鏍煎紡锛屽垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isTelValid(String value) {
		if (isNullOrEmpty(value)) {
			return false;
		}
		if (value.length() > 20) {
			return false;
		}
		return value.matches("^[0-9-]+$");
	}
	
	/***
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁绗﹀悎鏌滃彴鐢佃瘽鍙风爜鏍煎紡
	 * 鐩墠鏍煎紡涓哄彧鑳藉寘鍚細銆愭暟瀛椼��"+"銆�"-"銆佹嫭鍙枫��"#"銆戯紝椤哄簭鏆傛椂涓嶈�冭檻
	 * @param value
	 * 				寰呴獙璇佺殑瀛楃涓�
	 * @return 濡傛灉瀛楃涓插惁绗﹀悎鏌滃彴鐢佃瘽鍙风爜鏍煎紡锛屽垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isCounterTelValid(String value) {
		if(isNullOrEmpty(value)) {
			return false;
		}
		if(value.length() > 20) {
			return false;
		}
		return value.matches("^[0-9-\\+()#]+$");
	}
	
	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁鏈夐噸澶嶅瓧绗�
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @return 濡傛灉瀛楃涓叉病鏈夐噸澶嶏紝鍒欒繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isNoDuplicate(String value) {
		if (!isNullOrEmpty(value)) {
			char[] charArr = value.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				String str = String.valueOf(charArr[i]);
				if (i != value.lastIndexOf(str)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁鏈夐噸澶�
	 * 
	 * @param value
	 *            寰呴獙璇佺殑瀛楃涓�
	 * @param splitChar
	 *            鐢ㄤ簬鍒嗗壊鐨勫瓧绗�
	 * @return 濡傛灉瀛楃涓叉病鏈夐噸澶嶏紝鍒欒繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse
	 */
	public static boolean isNoDupString(String value, String splitChar) {
		if (null != value && value.length() > 1) {
			String[] strArr = value.split(splitChar);
			for (int i = 0; i < strArr.length - 1; i++) {
				for (int j = i+1; j < strArr.length; j++) {
					if (strArr[i].equals(strArr[j])) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 妫�娴嬫寚瀹氬瓧绗︿覆鏄惁鍏ㄧ敱鑻辨枃瀛楁瘝鎴栬�呮暟瀛楁垨鑰呮í鏉犵粍鎴� 濡傛灉瀛楃涓插叏鐢卞瓧姣嶆垨鑰呮暟瀛楁垨鑰呮í鏉犵粍鎴愬垯杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmployeeCode(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value.matches("[-0-9a-zA-Z]+");
		if (ret) {
			return true;
		}
		return false;
	}
	
	/**
	 * 浜у搧缂栫爜楠岃瘉
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isUnitCode(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		boolean ret = value.matches("[.0-9a-zA-Z]+");
		if (ret) {
			return true;
		}
		return false;
	}
	
	/**
	 * 瀛楄妭鏁拌秴杩囨寚瀹氶暱搴﹂獙璇�
	 * 
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	public static boolean isByteLength(String value, int len) throws Exception {
		int count = value.getBytes("GBK").length;
		if(count > len){
			return true;
		}
		return false;
	}
	
	/**
	 * 鍘傚晢缂栫爜鍜屼績閿�鍝佹潯鐮侀獙璇�
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isPrmCode(String value) {
		if (value != null && !"".equals(value)) {
		      return value.matches("[-_0-9a-zA-Z.]+");
		  }
		  return false;
	}
	
	/**
	 * 浜у搧鍘傚晢缂栫爜鍜屼骇鍝佹潯鐮侀獙璇�
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isProCode(String value) {
		if (value != null && !"".equals(value)) {
		      return value.matches("[-_0-9a-zA-Z.]+");
		  }
		  return false;
	}
	
	/**
	 * 鏁版嵁搴撶増鏈彿楠岃瘉
	 * 
	 * @param value
	 * @return
	 */
	public static boolean checkDBVersion(String value) {
		if (value == null) {
			return false;
		}else{
			return value.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
		}
	}
}
