package com.zzz.testweb.business.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.zzz.testweb.business.activeMQ.ProducerConsumer;
import com.zzz.testweb.business.interfaces.UserInfo_IF;
//import com.zzz.testweb.business.service.MQLogService;
import com.zzz.testweb.business.service.SystemInfoService;
import com.zzz.testweb.business.service.UserInfoService;
import com.zzz.testweb.system.util.MobileChecker;
import com.zzz.testweb.system.util.SwiftNumber;

public class UserInfoLogic implements UserInfo_IF {
	private static Logger logger = LoggerFactory.getLogger(UserInfoLogic.class.getName());
	
	@Resource(name = "userInfoService")
	private UserInfoService userInfoService;
//	@Resource(name = "mqlogService")
//	private MQLogService mqlogService;
	@Resource(name = "systemInfoService")
	private SystemInfoService systemInfoService;

	/**
	 * 鏂板鐢ㄦ埛
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map newUserInfo(Map map) {
		logger.info("UserInfoLogic.addUserInfo START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (MobileChecker.isNullOrEmpty(map.get("mobilephone"))
				|| MobileChecker.isNullOrEmpty(map.get("employee_name"))) {
			logger.error("濮撳悕,鎵嬫満 涓嶈兘涓嶈兘涓虹┖");
			retMap.put("ERRORCODE", "EU0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		Map<String,Object> addMap = userInfoService.addUserInfo(map);
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(addMap);
		retMap.put("ResultContent", list);
		
		try{
			SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			//鍚慚Q鏃ュ織琛∕Q_Log涓彃鍏ユ暟鎹�
					Map<String,Object> newMap=new HashMap<String,Object>();
					newMap.put("Source", "WITPOS");
					newMap.put("SendOrRece", "S");
					newMap.put("BillType", "BA");
					newMap.put("MemberCode", "");
					newMap.put("BillCode", "BA"+SwiftNumber.getSwiftNumber(format.format(new Date())));
					newMap.put("JMSXGroupID", "");
					newMap.put("ModifyCounts", 0);
					newMap.put("CounterCode", map.get("counterCode").toString());
					newMap.put("TxdDate", "");
					newMap.put("TxdTime", "");
					newMap.put("GetTime", "");
					newMap.put("Flag", "0");
					//"+systemInfoService.getBrandCode()+"
					String Msg="[Version],AMQ.001.001"+"\r\n"+
								"[Type],0003"+"\r\n"+
								"[CommLine],BrandCode,TradeType,SubType,Sourse,MachineCode,TradeNoIF"+"\r\n"+
								"[MainDataLine],"+systemInfoService.getBrandCode()+",BA,0,MPOS,null,"+newMap.get("BillCode")+"\r\n"+
								"[CommLine],BAcode,Baname,Flag,Countercode,BaTel"+"\r\n"+
								"[DetailDataLine],"+map.get("rtn_employee_code").toString()+","+map.get("employee_name").toString()+","+map.get("flag").toString()+","+map.get("counterCode").toString()+","+map.get("mobilephone").toString()+"\r\n"+
								"[End]";
					newMap.put("OriginalMsg", Msg);
//					mqlogService.addMQLogInfo(newMap);
	
					//鍚慚Q鍙戦�佹秷鎭�
//					ProducerConsumer test=new ProducerConsumer();
//					test.sendMessage(Msg);
				}
			catch(Exception ex){
				logger.error("UserInfo activeMQ ERROR:", ex.getMessage());	
			}
		
		logger.info("UserInfoLogic.addUserInfo END");
		return retMap;
	}

	/**
	 * 淇敼浼氬憳
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map updateUserInfo(Map map) {
		logger.info("UserInfoLogic.updateUserInfo START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		int iRet = userInfoService.updateUserInfo(map);
		retMap.put("ResultContent", iRet);
		
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		//鍚慚Q鏃ュ織琛∕Q_Log涓彃鍏ユ暟鎹�
				Map<String,Object> newMap=new HashMap<String,Object>();
				newMap.put("Source", "WITPOS");
				newMap.put("SendOrRece", "S");
				newMap.put("BillType", "BA");
				newMap.put("MemberCode", "");
				newMap.put("BillCode", "BA"+SwiftNumber.getSwiftNumber(format.format(new Date())));
				newMap.put("JMSXGroupID", "");
				newMap.put("ModifyCounts", 0);
				newMap.put("CounterCode", map.get("counterCode").toString());
				newMap.put("TxdDate", "");
				newMap.put("TxdTime", "");
				newMap.put("GetTime", "");
				newMap.put("Flag", "0");
				String Msg="[Version],AMQ.001.001"+"\r\n"+
							"[Type],0003"+"\r\n"+
							"[CommLine],BrandCode,TradeType,SubType,Sourse,MachineCode,TradeNoIF"+"\r\n"+
							"[MainDataLine],"+systemInfoService.getBrandCode()+",BA,1,MPOS,null"+newMap.get("BillCode")+"\r\n"+
							"[CommLine],BAcode,Baname,Flag,Countercode,BaTel"+"\r\n"+
							"[DetailDataLine],"+map.get("employee_code").toString()+","+map.get("employee_name").toString()+","+map.get("flag").toString()+","+map.get("counterCode").toString()+","+map.get("mobilephone").toString()+"\r\n"+
							"[End]";
				newMap.put("OriginalMsg", Msg);
//				mqlogService.addMQLogInfo(newMap);

				//鍚慚Q鍙戦�佹秷鎭�
//				ProducerConsumer test=new ProducerConsumer();
//				test.sendMessage(Msg);
		
		
		logger.info("UserInfoLogic.updateUserInfo END");
		return retMap;
	}

}
