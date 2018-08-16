/*		
 * @(#)CherryUtil.java     1.0 2010/10/12		
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.util.LocalizedTextUtil;
import com.zzz.testweb.system.constants.TestConstants;

/**
 * 鍏遍�氬鐞嗙被锛堜笌涓氬姟鏃犲叧锛屼富瑕佹槸甯哥敤鐨刯ava鏂规硶锛�
 * 
 * @author dingyc
 * 
 */
@SuppressWarnings("unchecked")
public class MobileUtil {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	/** 瀛楃鏁扮粍 */
	public static final char[] CHAR_ARRAY = { 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9' };

	/**
	 * 灏哠tring杞崲涓篿nt鍨嬶紝涓嶈兘杞崲鐨勫皢杩斿洖0鍊�
	 * 
	 * @param arg
	 * @return
	 */
	public static int string2int(String arg) {
		try {
			if ("null".equals(arg) || "NULL".equals(arg)) {
				return 0;
			}
			return Integer.valueOf(arg);
		} catch (Exception ex) {
			return 0;
		}
	}
	
	/**
	 * 灏哠tring杞崲涓簂ong鍨嬶紝涓嶈兘杞崲鐨勫皢杩斿洖0鍊�
	 * 
	 * @param arg
	 * @return
	 */
	public static long string2Long(String arg) {
		try {
			if ("NULL".equalsIgnoreCase(arg)) {
				return 0;
			}
			return Long.valueOf(arg);
		} catch (Exception ex) {
			return 0;
		}
	}

	/**
	 * 灏哠tring杞崲涓篿nt鍨嬶紝涓嶈兘杞崲鐨勫皢杩斿洖0鍊�
	 * 
	 * @param arg
	 * @return
	 */
	public static int obj2int(Object obj) {
		if (null == obj) {
			return 0;
		}
		if (obj instanceof Number) {
			Number num = (Number)obj;
			return num.intValue();
		}else if (obj instanceof String) {
			return string2int((String) obj);
		} else {
			return 0;
		}
	}
	
	/**
	 * 灏哋bject杞崲涓簂ong鍨嬶紝涓嶈兘杞崲鐨勫皢杩斿洖0鍊�
	 * 
	 * @param arg
	 * @return
	 */
	public static long obj2Long(Object obj) {
		if (null == obj) {
			return 0;
		}
		if (obj instanceof Number) {
			Number num = (Number)obj;
			return num.longValue();
		}else if (obj instanceof String) {
			return string2Long((String) obj);
		} else {
			return 0;
		}
	}

	/**
	 * 灏哠tring杞崲涓篿nt鍨嬶紝涓嶈兘杞崲鐨勫皢杩斿洖0鍊�
	 * 
	 * @param arg
	 * @return
	 */
	public static double string2double(String arg) {
		try {
			if ("null".equals(arg) || "NULL".equals(arg)) {
				return 0.00;
			}
			return Double.valueOf(arg);
		} catch (Exception ex) {
			return 0.00;
		}
	}

	/**
	 * 鍙栧緱绯荤粺鐨勫綋鍓嶆椂闂达紝骞朵互鎸囧畾鐨勬牸寮忚繑鍥炲瓧绗︿覆
	 * 
	 * @param format
	 * @return
	 */
	public static String getSysDateTime(String format) {
		SimpleDateFormat dateFm = new SimpleDateFormat(format); // 鏍煎紡鍖栧綋鍓嶇郴缁熸棩鏈�
		String dateTime = dateFm.format(new java.util.Date());
		return dateTime;
	}

	/**
	 * 鍘婚櫎Map涓殑绌哄��
	 * 
	 * @param Map
	 *            杞崲鍓嶇殑Map
	 * @return Map 杞崲鍚庣殑Map
	 */
	public static Map<String, Object> removeEmptyVal(Map<String, Object> map) {
		if (null != map && !map.isEmpty()) {
			Set keys = map.keySet();
			// Map涓墍鏈夌殑key
			Object[] keyArr = keys.toArray();
			Map goalMap = new HashMap();
			for (Object key : keyArr) {
				Object value = map.get(key);
				// 鍊间笉涓虹┖鏃舵斁鍏ユ柊鐨凪ap涓�
				if (null != value && !"".equals(value)) {
					goalMap.put(key, value);
				}
			}
			return goalMap;
		}
		return null;
	}

	/**
	 * 鍘婚櫎Map涓殑绌哄��
	 * 
	 * @param Map
	 *            杞崲鍓嶇殑Map
	 * @param String
	 *            [] 涓嶅鐞嗙殑瀛楁
	 * 
	 * @return Map 杞崲鍚庣殑Map
	 */
	public static Map<String, Object> removeEmptyValIgnored(
			Map<String, Object> map, String[] ignoredKeys) {
		if (null != map && !map.isEmpty()) {
			Set keys = map.keySet();
			// Map涓墍鏈夌殑key
			Object[] keyArr = keys.toArray();
			Map goalMap = new HashMap();
			for (Object key : keyArr) {
				Object value = map.get(key);
				if (null != ignoredKeys && 0 != ignoredKeys.length) {
					boolean ignoredFlg = false;
					for (String ignoredKey : ignoredKeys) {
						if (null == ignoredKey && null == key
								|| null != ignoredKey && ignoredKey.equals(key)) {
							ignoredFlg = true;
							break;
						}
					}
					if (ignoredFlg) {
						goalMap.put(key, value);
						continue;
					}
				}
				// 鍊间笉涓虹┖鏃舵斁鍏ユ柊鐨凪ap涓�
				if (null != value && !"".equals(value)) {
					goalMap.put(key, value);
				}
			}
			return goalMap;
		}
		return null;
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
			if (MobileChecker.checkDate(date)) {
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
	 * 澶嶅埗鏂囦欢
	 * 
	 * @param File
	 *            鍘熷鏂囦欢
	 * 
	 * @param File
	 *            鐩爣鏂囦欢
	 * @return
	 * @throws Exception
	 */
	public static void copyFileByChannel(File src, File dst) throws Exception {
		int length = TestConstants.COPYFILE_MAX_SIZE;
		// 杈撳叆娴�
		FileInputStream in = null;
		// 杈撳嚭娴�
		FileOutputStream out = null;
		// 杈撳叆绠￠亾
		FileChannel inC = null;
		// 杈撳嚭绠￠亾
		FileChannel outC = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			inC = in.getChannel();
			outC = out.getChannel();
			ByteBuffer buffer = null;
			while (true) {
				if (inC.position() == inC.size()) {
					inC.close();
					outC.close();
					in.close();
					out.close();
					return;
				}
				if ((inC.size() - inC.position()) < length) {
					length = (int) (inC.size() - inC.position());
				} else {
					length = TestConstants.COPYFILE_MAX_SIZE;
				}
				buffer = ByteBuffer.allocateDirect(length);
				inC.read(buffer);
				buffer.flip();
				outC.write(buffer);
				outC.force(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != inC) {
				inC.close();
			}
			if (null != outC) {
				outC.close();
			}
			if (null != in) {
				in.close();
			}
			if (null != out) {
				out.close();
			}
		}

	}

	/**
	 * 姣旇緝涓や釜鏁板瓧鏄惁鐩哥瓑
	 * 
	 * @param String
	 *            鏁板瓧1
	 * 
	 * @param String
	 *            鏁板瓧2
	 * @return boolean 姣旇緝缁撴灉
	 * 
	 */
	public static boolean equalsDouble(String num1, String num2) {
		if ((null == num1 || "".equals(num1))
				&& (null == num2 || "".equals(num2))) {
			return true;
		}
		try {
			double dou1 = Double.parseDouble(num1.trim());
			double dou2 = Double.parseDouble(num2.trim());
			if (dou1 == dou2) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * 鐢熸垚闅忔満瀵嗙爜
	 * 
	 * @param length
	 *            闅忔満瀵嗙爜闀垮害
	 * 
	 * @return 闅忔満瀵嗙爜
	 * 
	 */
	public static String generateSalt(int length) {

		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyz");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	/**
	 * 鍙栧緱len闀垮害鐨勯殢鏈哄瓧绗︿覆
	 * 
	 * @param len
	 * @return
	 */
	public static String getRandomStr(int len) {
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		for (int i = 1; i <= len; i++) {
			sb.append(CHAR_ARRAY[r.nextInt(CHAR_ARRAY.length)]);
		}
		return sb.toString();
	}
	
	/**
	 * Map涓殑鍊紅rim澶勭悊
	 * 
	 * @param Map
	 */
	public static void trimMap(Map<String, Object> map) {
		if (null != map && !map.isEmpty()) {
			// 寰幆map鍓旈櫎value鍊煎墠鍚庣┖鏍�
			for(Map.Entry<String,Object> en: map.entrySet()){
				if(en.getValue() instanceof String){
					en.setValue(((String)en.getValue()).trim());
				}
			}
		}
	}
	
	/**
	 * 鎶婁笉绗﹀悎JSON瀵硅薄鐨勫瓧绗︿覆杞崲鎴愮鍚圝SON瀵硅薄鐨勫瓧绗︿覆
	 * 
	 * @param s 涓嶇鍚圝SON瀵硅薄鐨勫瓧绗︿覆
	 * @return 绗﹀悎JSON瀵硅薄鐨勫瓧绗︿覆
	 */
	public static String convertStrToJson(String s) {
		if(s != null && (s.contains("\"") || s.contains("\\"))) {
			return s.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
		} else {
			return s;
		}
	}
	
	/**
	 * 鍒╃敤Jackson灏唈son鏍煎紡鐨勫瓧绗︿覆瑙ｆ瀽鎴怣ap
	 * 
	 * */
	public static Map json2Map(String json) throws Exception{
		
		Map<String, Object> maps = null;
		try {
			maps = objectMapper.readValue(json, Map.class);
		} catch (Exception e) {
			throw e;
		} 
		return maps;
	}
	
	/**
	 * 鍒╃敤Jackson灏哅ap杞寲鎴恓son鏍煎紡鐨勫瓧绗︿覆
	 * 
	 * 
	 * */
	public static String map2Json(Map map) throws Exception{
		String dataLine = null;
		try {
			dataLine = objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			throw e;
		} 
		return dataLine;
	}
	
	public static String obj2Json(Object obj) throws Exception{
		String dataLine = null;
		try {
			dataLine = objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw e;
		} 
		//System.out.println(new SimpleDateFormat("yyyy:MM:dd hh:mm:ss.SSS").format((new Date()).getTime()));
		return dataLine;
	} 
	
	
	/**
	 * 閬嶅巻maps灏唊ey鍋氬涓嬪鐞嗭細濡傛灉绗簩涓瓧姣嶆槸澶у啓鍒欎笉澶勭悊锛屽惁鍒欏皢棣栧瓧姣嶈浆涓哄皬鍐�
	 * 骞朵笖灏唌ap涓殑key鍜寁alue鍒嗗埆杩涜trim锛屽幓鎺夊墠鍚庣殑绌烘牸
	 * 
	 * */
	public static Map dealMap(Map<String,Object> map){
		
		Map<String,Object> dealedMap = new HashMap<String,Object>();
		
		for(Map.Entry<String, Object> temp : map.entrySet()){
			
			//鍙栧緱map涓殑value
			Object value = temp.getValue();
			String key = temp.getKey().trim();
			
			if (key.length() == 1) {
                key = key.toLowerCase();
            } else if (!Character.isUpperCase(key.charAt(1))) {
                key = key.substring(0, 1).toLowerCase() +
                    key.substring(1);
            }
			
			//濡傛灉value鏄泦鍚堢被鍨嬫繁搴﹂�掑綊缁х画澶勭悊
			if(value instanceof List){
				List<Map> list = (List<Map>)value;
				List<Map> list1 = new ArrayList<Map>();
				for(Map temp1 : list){
					Map tempMap1 = dealMap(temp1);
					list1.add(tempMap1);
				}
				dealedMap.put(key, list1);
			}else if(value instanceof Map){
				Map temp2 = dealMap((Map)value);
				dealedMap.put(key, temp2);
			}else if(null == value){
				dealedMap.put(key,"");
			}else{
				dealedMap.put(key,value.toString().trim());
			}
		}
		return dealedMap;
	}
	
	/**
	  * 宸﹁ˉ浣嶏紝鍙冲榻�
	  * @param oriStr  鍘熷瓧绗︿覆
	  * @param len  鐩爣瀛楃涓查暱搴�
	  * @param alexin  琛ヤ綅瀛楃
	  * @return  鐩爣瀛楃涓�
	  */
	public static String padLeft(String oriStr, int len, char alexin) {
		int strlen = oriStr.length();
		if(strlen < len) {
			StringBuffer str = new StringBuffer();
			for(int i = 0; i < len - strlen; i++) {
				str.append(alexin);
			}
			return str.toString() + oriStr;
		}
		return oriStr;
	}
	
	/**
	 * 姣旇緝涓�涓猯ist涓殑String锛岃繑鍥炴渶澶х殑String
	 * @param list
	 * @return
	 */
	public static String getMaxNoInList(List<Integer> list) {
		if(list==null||list.size()==0){
			return "";
		}
		 int retInt = 0;
		 for (int i=0; i<list.size(); i++){
		   if (list.get(i)> retInt ){
			   retInt = list.get(i);
		     }
		 }
		 return String.valueOf(retInt);
	}
	
	/**
	 * 鏍规嵁骞撮緞鍜屽熀鍑嗘椂闂村彇寰楃敓鏃ュ勾
	 * @param age 骞撮緞
	 * @param standardDate 鍩哄噯鏃堕棿锛堜竴鑸彇绯荤粺鏃堕棿锛�
	 * @return 鐢熸棩骞�
	 */
	public static String getYearByAge(String age, String standardDate) {
		String year = null;
		if(age != null && !"".equals(age) && standardDate != null && !"".equals(standardDate)) {
			try {
				year = String.valueOf(Integer.parseInt(standardDate.substring(0,4)) - Integer.parseInt(age) + 1);
			} catch (Exception e) {
				return year;
			}
		}
		return year;
	}
	
	/** Cron琛ㄨ揪寮忔椂闂磋鍒欏父閲忓畾涔� **/
    public static final String EVERY = "*";
    public static final String ANY = "?";
    public static final String RANGES = "-";
    public static final String INCREMENTS = "/";
    public static final String ADDITIONAL = ",";
    public static final String LAST = "L";
    public static final String WEEKDAY = "W";
    public static final String THENTH = "#";
    public static final String CALENDAR = "C";
    public static final String BLANK = " ";
    
    /** 
     * 椤甸潰璁剧疆杞负Cron琛ㄨ揪寮�
     * @param type 娌熼�氭椂闂寸被鍨嬶紙1锛氭寚瀹氭椂闂达紝2锛氬弬鑰冩煇涓椂闂达紝3锛氬惊鐜墽琛岋紝4锛氭潯浠惰Е鍙戯級
     * @param date 娌熼�氭棩鏈熷�硷紙鏍煎紡涓猴細yyyy-MM-dd锛�
     * @param time 娌熼�氭椂闂村�硷紙鏍煎紡涓猴細HH:mm:ss锛�
     * @param frequency 棰戠巼锛圷Y锛氭瘡骞达紝MM锛氭瘡鏈堬紝DD锛氭病澶╋級
     * @return Cron琛ㄨ揪寮�
     */ 
    public static String convertDateToCronExp(String type, String date, String time, String frequency) {
    	String cronEx = "";
    	try {
    		if("1".equals(type)) {
        		String[] dates = date.split("-");
        		String[] times = time.split(":");
        		cronEx = times[2] + BLANK + times[1] + BLANK + times[0] + BLANK + dates[2] + BLANK + dates[1] + BLANK + ANY + BLANK + dates[0];
        	} else if("2".equals(type)) {
        		String[] times = time.split(":");
        		cronEx = times[2] + BLANK + times[1] + BLANK + times[0] + BLANK + EVERY + BLANK + EVERY + BLANK + ANY;
        	} else if("3".equals(type)) {
        		if("YY".equals(frequency)) {
        			String[] dates = date.split("-");
            		String[] times = time.split(":");
            		cronEx = times[2] + BLANK + times[1] + BLANK + times[0] + BLANK + dates[1] + BLANK + dates[0] + BLANK + ANY;
        		} else if("MM".equals(frequency)) {
            		String[] times = time.split(":");
            		cronEx = times[2] + BLANK + times[1] + BLANK + times[0] + BLANK + date + BLANK + EVERY + BLANK + ANY;
        		} else if("DD".equals(frequency)) {
        			String[] times = time.split(":");
            		cronEx = times[2] + BLANK + times[1] + BLANK + times[0] + BLANK + EVERY + BLANK + EVERY + BLANK + ANY;
        		}
        	} else if("4".equals(type)) {
        		String[] times = time.split(":");
        		cronEx = times[2] + BLANK + times[1] + BLANK + times[0] + BLANK + EVERY + BLANK + EVERY + BLANK + ANY;
        	}
    	} catch (Exception e) {
			
		}
        return cronEx;
    }
    
    /**
	 * 鍘婚櫎Map涓殑绌哄��
	 * 
	 * @param Map
	 *            杞崲鍓嶇殑Map
	 * @return Map 杞崲鍚庣殑Map
	 */
	public static Map<String, Object> remEmptyVal(Map<String, Object> map) {
		if (null != map && !map.isEmpty()) {
			Map<String, Object> goalMap = new HashMap<String, Object>();
			for (String key : map.keySet()) {
				Object value = map.get(key);
				if(value instanceof ArrayList) {
					List _value = (List)value;
					if(_value != null && !_value.isEmpty()) {
						goalMap.put(key, value);
					}
				} else {
					// 鍊间笉涓虹┖鏃舵斁鍏ユ柊鐨凪ap涓�
					if (null != value && !"".equals(value)) {
						goalMap.put(key, value);
					}
				}
			}
			return goalMap;
		}
		return null;
	}
	/*
	 * 鍙栧緱瀛恖ist
	 * 
	 * @param list
	 * @param pageInfo
	 * @return
	 */
	public static List<Map<String, Object>> getSubList(List<Map<String, Object>> list,
			int fromIndex, int pageLength) {
		int listSize = list.size();
		int toIndex = fromIndex + pageLength;
		List<Map<String, Object>> subList = null;
		if (fromIndex < listSize) {
			if (listSize < toIndex) {
				toIndex = fromIndex + listSize;
			}
			subList = list.subList(fromIndex, toIndex);
		}
		return subList;
	}
	
	/** 
     * 闄ゆ硶杩愮畻锛屽綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸囧畾绮惧害锛屼互鍚庣殑鏁板瓧鍥涜垗浜斿叆
     * 
     * @param v1 琚櫎鏁� 
     * @param v2 闄ゆ暟 
     * @param scale 琛ㄧず琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐逛互鍚庡嚑浣�
     * 
     * @return 涓や釜鍙傛暟鐨勫晢 
     */  
    public static double div(double v1, double v2, int scale) {
        if(scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /**
     * 鍙栧緱璧勬簮鐨勫��
     * @param baseName 璧勬簮鐨勬枃浠跺悕绉帮紙鏃犺瑷�鏃犲悗缂�锛夈�傚彇鍏遍�氳祫婧愪紶鍊糿ull鎴�""
     * @param language 璇█
     * @param key 璧勬簮鐨勯敭
     */
    public static String getResourceValue(String baseName, String language, String key) {
        try{
            //涓虹┖鏃讹紝鏌ヨ鍏遍�氳瑷�璧勬簮鏂囦欢
            String path = "i18n/common/commonText";
            if(null != baseName && !"".equals(baseName)){
            	String sysName = baseName.substring(5, 7);
                //Linux涓嬪ぇ灏忓啓鏁忔劅锛屼紶鍏ヨ祫婧愮殑鏂囦欢鍚嶇О鍏ㄦ槸澶у啓锛屾埅鍙栫殑绯荤粺鍚嶄篃鏄ぇ鍐�
                //浣嗘槸瀹為檯鏂囦欢澶圭殑鍚嶇О鏄皬鍐欙紝杩欐牱灏卞彇涓嶅埌鐩爣鏂囦欢
                //涓轰簡鍦ㄥ吋瀹筁inux锛岃繖閲屾妸鎴彇鍚庣殑绯荤粺鍚嶈浆鎴愬皬鍐欍��
                sysName = sysName.toLowerCase();
                path = "i18n/"+sysName+"/"+baseName;
            }
            return LocalizedTextUtil.findResourceBundle(path, new Locale(language)).getString(key);
        }catch(Exception e){
            return key;
        }
    }
    
	/**
	 * 涓嫳娣峰悎瀛楃涓茬殑瀛楄妭闀垮害
	 * @param value
	 * @return
	 */
	public static int mixStrLength(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 鑾峰彇瀛楁鍊肩殑闀垮害锛屽鏋滃惈涓枃瀛楃锛屽垯姣忎釜涓枃瀛楃闀垮害涓�2锛屽惁鍒欎负1 */
        for (int i = 0; i < value.length(); i++) {
            /* 鑾峰彇涓�涓瓧绗� */
            String temp = value.substring(i, i + 1);
            /* 鍒ゆ柇鏄惁涓轰腑鏂囧瓧绗� */
            if (temp.matches(chinese)) {
                /* 涓枃瀛楃闀垮害涓�2 */
                valueLength += 2;
            } else {
                /* 鍏朵粬瀛楃闀垮害涓�1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }
	
	/** 
     * 鑾峰彇鐧惧垎姣�
     * 
     * @param  p1 琚櫎鏁�
     * @param  p2 闄ゆ暟
     * @param  scale 淇濈暀鐨勫皬鏁颁綅鏁�
     * @return 鐧惧垎姣�
     */ 
	public static String percent(double p1, double p2, int scale) {
		String str;
        double p3 = p1/p2;
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(scale);
        str = nf.format(p3);
        return str;
    }
	
    /**
     * 鏇挎崲鎷艰MQ娑堟伅瀛楁鐨勭壒娈婂瓧绗︼紙鍗曚釜瀛楁锛�
     * @param map
     * @return
     */
    public static String replaceMQSpecialChar(String key){
        if(null != key && !key.equals("")){
            key = key.replaceAll(",", "锛�").replaceAll("'", "~");
        }
        return key;
    }
    
    /**
     * 鏇挎崲鎷艰MQ娑堟伅瀛楁鐨勭壒娈婂瓧绗︼紙鏁翠釜map锛�
     * @param map
     * @return
     */
    public static Map<String,Object> replaceMQSpecialChar(Map<String,Object> map){
        if (null != map && !map.isEmpty()) {
            for(Map.Entry<String,Object> en: map.entrySet()){
                if(en.getValue() instanceof String){
                    String value = ConvertUtil.getString(en.getValue());
                    en.setValue(replaceMQSpecialChar(value));
                }
            }
        }
        return map;
    }
    
    /** 
	 * 鍒犻櫎鍗曚釜鏂囦欢
	 * 
	 * @param sPath 琚垹闄ゆ枃浠剁殑鏂囦欢鍚� 
	 * @return 鍗曚釜鏂囦欢鍒犻櫎鎴愬姛杩斿洖true锛屽惁鍒欒繑鍥瀎alse
	 */  
	public static boolean deleteFile(String sPath) {
	    boolean flag = false;
	    File file = new File(sPath);
	    // 璺緞涓烘枃浠朵笖涓嶄负绌哄垯杩涜鍒犻櫎  
	    if (file.isFile() && file.exists()) {
	        file.delete();
	        flag = true;
	    }
	    return flag;
	}
	
	/** 
	 * 鍒犻櫎鐩綍锛堟枃浠跺す锛変互鍙婄洰褰曚笅鐨勬枃浠� 
	 * 
	 * @param sPath 琚垹闄ょ洰褰曠殑鏂囦欢璺緞
	 * @return 鐩綍鍒犻櫎鎴愬姛杩斿洖true锛屽惁鍒欒繑鍥瀎alse 
	 */  
	public static boolean deleteDirectory(String sPath) {
	    // 濡傛灉sPath涓嶄互鏂囦欢鍒嗛殧绗︾粨灏撅紝鑷姩娣诲姞鏂囦欢鍒嗛殧绗�
	    if (!sPath.endsWith(File.separator)) {
	        sPath = sPath + File.separator;
	    }
	    File dirFile = new File(sPath);
	    // 濡傛灉dir瀵瑰簲鐨勬枃浠朵笉瀛樺湪锛屾垨鑰呬笉鏄竴涓洰褰曪紝鍒欓��鍑�
	    if (!dirFile.exists() || !dirFile.isDirectory()) {
	        return false;
	    }
	    boolean flag = true;
	    // 鍒犻櫎鏂囦欢澶逛笅鐨勬墍鏈夋枃浠�(鍖呮嫭瀛愮洰褰�)
	    File[] files = dirFile.listFiles();
	    for (int i = 0; i < files.length; i++) {
	        // 鍒犻櫎瀛愭枃浠�
	        if (files[i].isFile()) {
	            flag = deleteFile(files[i].getAbsolutePath());
	            if (!flag) break;
	        }
	        else {// 鍒犻櫎瀛愮洰褰�
	            flag = deleteDirectory(files[i].getAbsolutePath());
	            if (!flag) break;
	        }
	    }
	    if (!flag) return false;
	    // 鍒犻櫎褰撳墠鐩綍
	    if (dirFile.delete()) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	/** 
	 * 鍒犻櫎鎸囧畾session鐨勬墍鏈変复鏃舵枃浠�
	 * 
	 * @param sessionId
	 * @return 鍒犻櫎鎴愬姛杩斿洖true锛屽惁鍒欒繑鍥瀎alse 
	 */  
	public static boolean deleteTempFile(String sessionId) {
        return false;
	}
}
