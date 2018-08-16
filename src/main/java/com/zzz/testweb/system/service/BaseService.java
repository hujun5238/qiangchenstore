/*	
 * @(#)BaseService.java     1.0 2010/10/12		
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
package com.zzz.testweb.system.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.zzz.testweb.system.constants.TestConstants;
import com.zzz.testweb.system.db.BaseDaoImpl;
import com.zzz.testweb.system.util.ConvertUtil;
import com.zzz.testweb.system.util.DateUtil;

/**
 * 
 * 	鍩虹被锛堝叡閫氾級Service
 * 
 * 
 * 
 * @author lipc
 * @version 1.0 2010.10.12
 */

public class BaseService {
	
	@Resource
	protected BaseDaoImpl baseDaoImpl;
	

	
	/**
	 * 鍙栧緱绯荤粺鏃堕棿
	 * 
	 * @param
	 * @return String
	 */
	public String getSYSDate(){	
		return baseDaoImpl.getSYSDate();
	}
	
	/**
	 * 鍙栧緱绯荤粺鏃堕棿(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param
	 * @return String
	 */
	public String getSYSDateTime(){	
		return baseDaoImpl.getSYSDateTime();
	}
	
	/**
	 * 鍙栧緱绯荤粺鏃堕棿(骞存湀鏃�)
	 * 
	 * @param
	 * @return String
	 */
	public String getDateYMD(){	
		return baseDaoImpl.getDateYMD();
	}
	
	/**
	 * 鏌ヨ鍋囨棩
	 * 
	 * @param Map
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getHolidays(Map<String, Object> map) {
		Map parameterMap = new HashMap();
		parameterMap.putAll(map);
		parameterMap.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.getHolidays");
		return baseDaoImpl.getList(parameterMap);
	}
	
	/**
	 * 鍙栧緱缁欏畾鏃ユ湡鐨勮储鍔℃棩
	 * 
	 * @param orgInfoId
	 * 			缁勭粐ID
	 * @param cal
	 * 			鏃ユ湡
	 * @return String
	 */
	public String getFiscalDate(int orgInfoId, Date date){
		Map<String, Object> map = new HashMap<String, Object>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//map.put(TestConstants.ORGANIZATIONINFOID, orgInfoId);
		map.put(TestConstants.YEAR, cal.get(Calendar.YEAR));
		map.put(TestConstants.MONTH, cal.get(Calendar.MONTH) + 1);
		map.put(TestConstants.DAY, cal.get(Calendar.DAY_OF_MONTH));
		map.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.getFiscalDate");
		return (String)baseDaoImpl.get(map);
	}
	
	/**
	 * 鍙栧緱缁欏畾鑷劧鏃ュ搴旂殑搴撳瓨鍘嗗彶鎴鏃堕棿
	 * 
	 * @param map
	 * 
	 * @return String
	 */
	public Object getCutOfDate(Map<String, Object> map,String flag){
		map.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.get"+flag+"CutOfDate");
		return baseDaoImpl.get(map);
	}
	
	/**
	 * 鍙栧緱绯荤粺鏃堕棿
	 * 
	 * @param
	 * @return String
	 */
	public String getBussinessDate(Map<String, Object> map){	
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.putAll(map);
		parameterMap.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.getBussinessDate");
		return (String)baseDaoImpl.get(parameterMap);
	}
	
	/**
	 * 鍙栧緱 1.涓氬姟鏃ユ湡,2.鏃ョ粨鏍囧織
	 * 
	 * @param map 鏌ヨ鏉′欢
	 * @return 涓氬姟鏃ユ湡
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getBussinessDateMap(Map<String, Object> map){	
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.putAll(map);
		parameterMap.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.getBussinessDateMap");
		return (Map<String, Object>)baseDaoImpl.get(parameterMap);
	}
	
	/**
	 * 鍙栧緱 鏃ョ粨鐘舵�佺‘瀹氱殑涓氬姟鏃ユ湡
	 * 
	 * @param map 鏌ヨ鏉′欢
	 * @return 涓氬姟鏃ユ湡
	 */
	public String getBusDate(Map<String, Object> map){	
		Map<String, Object> busMap = getBussinessDateMap(map);
		// 涓氬姟鏃ユ湡
		String busDate = ConvertUtil.getString(busMap.get("businessDate"));
		// 鏃ョ粨鏍囧織
		String closeFlag = ConvertUtil.getString(busMap.get("closeFlag"));
		// 褰撳ぉ涓氬姟缁撴潫锛屼笟鍔℃棩鏈熶笅涓�澶�
		if("1".equals(closeFlag)){
			return DateUtil.addDateByDays(TestConstants.DATE_PATTERN, busDate, 1);
		}else{
			return busDate;
		}
	}
	
	/**
	 * 鏌ヨ鎸囧畾鏃ユ湡鎵�鍦ㄧ殑璐㈠姟骞存湀
	 * 
	 * @param map 鏌ヨ鏉′欢
	 * @return 鎸囧畾鏃ユ湡鎵�鍦ㄧ殑璐㈠姟骞存湀
	 */
	public Map<String, Object> getFiscalMonth(Map<String, Object> map){	
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.putAll(map);
		parameterMap.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.getFiscalMonth");
		return (Map)baseDaoImpl.get(parameterMap);
	}
	
	/**
	 * 鏍规嵁鎸囧畾鐨勮嚜鐒舵棩锛岃繑鍥炶鑷劧鏃ユ墍灞炶储鍔℃湀瀵瑰簲鐨勬棩鏈熷簭鍒�(鑷劧鏃�)
	 * @param map
	 * @return
	 */
	public List<String> getFiscalPeriodByNatural(Map<String, Object> map) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.putAll(map);
		parameterMap.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.getFiscalPeriodByNatural");
		return (List<String>)baseDaoImpl.getList(parameterMap);
	}
	
	/**
	 * 鏌ヨ鎸囧畾璐㈠姟鏈堢殑鏈�灏忔渶澶ц嚜鐒舵棩
	 * 
	 * @param map 鏌ヨ鏉′欢
	 * @return 鎸囧畾璐㈠姟鏈堢殑鏈�灏忔渶澶ц嚜鐒舵棩
	 */
	public Map<String, Object> getMinMaxDateValue(Map<String, Object> map){	
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.putAll(map);
		parameterMap.put(TestConstants.IBATIS_SQL_ID, "BINOLCMINC99.getMinMaxDateValue");
		return (Map)baseDaoImpl.get(parameterMap);
	}
	
	/**
	 * 鎵嬪姩鎻愪氦浜嬪姟
	 * 
	 * @param 鏃�
	 * 
	 * @return 鏃�
	 * 
	 */
	public void manualCommit() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(TestConstants.IBATIS_SQL_ID,"BINOLCMINC99.commit");
		baseDaoImpl.update(paramMap);
	}

	/**
	 * 鎵嬪姩鍥炴粴浜嬪姟
	 * 
	 * @param 鏃�
	 * 
	 * @return 鏃�
	 * 
	 */
	public void manualRollback() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(TestConstants.IBATIS_SQL_ID,"BINOLCMINC99.rollback");
		baseDaoImpl.update(paramMap);
	}
}
