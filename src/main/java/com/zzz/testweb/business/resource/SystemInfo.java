package com.zzz.testweb.business.resource;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zzz.testweb.business.interfaces.SystemInfo_IF;
import com.zzz.testweb.system.db.CustomerContextHolder;
import com.zzz.testweb.system.service.BaseInfo;
import com.zzz.testweb.system.util.AES256Util;
import com.zzz.testweb.system.util.Des3Util;
import com.zzz.testweb.system.util.MobileChecker;
import com.zzz.testweb.system.util.MobileUtil;

@Path("/sysInfo")
@Component
public class SystemInfo extends BaseInfo {

	private static Logger logger = LoggerFactory.getLogger(SystemInfo.class
			.getName());

	@Resource(name = "systemInfoLogic")
	private SystemInfo_IF systemInfoLogic;

	// app鏄惁瑕佹洿鏂�
	public static final String TradeType_CheckVersionApp = "CheckVersionApp";
	// logo鏄惁瑕佹洿鏂�
	public static final String TradeType_CheckVersionLogo = "CheckVersionLogo";
	// db鏄惁瑕佹洿鏂�
	public static final String TradeType_CheckVersionDb = "CheckVersionDb";
	// app logo db鏄惁瑕佹洿鏂�
	public static final String TradeType_CheckVersionAllType = "CheckVersionAllType";
	// 鑾峰彇鍚庡彴褰撳墠鍝佺墝锛屽悇琛ㄦ暟鎹悓姝ョ増鏈俊鎭�
	public static final String TradeType_GetVersionDb = "GetVersionDb";
	// 鑾峰彇閰嶇疆琛ㄦ暟鎹�
	public static final String TradeType_GetConfigsDb = "GetConfigsDb";
	//鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃
	public static final String TradeType_UpdateVersionDb="UpdateVersionDb";
    //鍥炲啓缁堢淇℃伅琛�
	public static final String TradeType_UpdateDbMachineinfo="UpdateDbMachineinfo";
	//鑾峰彇鏈嶅姟鍣ㄦ椂闂�
	public static final String TradeType_GetServerDate="GetServerDate";
	//涓嬭浇鏁版嵁锛岃彍鍗曡〃
	public static final String TradeType_GetDbMenus="GetDbMenus";
	//涓嬭浇鏁版嵁锛岃彍鍗曞搧鐗岃〃
	public static final String TradeType_GetDbMenuBrands="GetDbMenuBrands";
	//鑾峰彇鏀粯绫诲瀷琛ㄦ暟鎹� 
	public static final String TradeType_GetDbPaymentTypes="GetDbPaymentTypes";
	//涓嬭浇brand琛�
	public static final String TradeType_GetDbBrandCounters="GetDbBrandCounters";
	
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() throws Exception {
		// TestApp
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// //paramMap.put("TradeType", "CheckVersionApp");
		// //paramMap.put("TradeType", "CheckVersionLogo");
//		paramMap.put("TradeType", "CheckVersionDb");
//		paramMap.put("brandId", 11);
//		paramMap.put("counterCode", "");
//		paramMap.put("systemType", "");
//		paramMap.put("imei", "android");
//		paramMap.put("currentVersion", 99);
//
//		// app logo db鏄惁瑕佹洿鏂�
//		paramMap.put("TradeType", "CheckVersionAllType");
//		paramMap.put("brandId", 11);
//		paramMap.put("counterCode", "E-011");
//		paramMap.put("systemType", "android");
//		paramMap.put("imei", "");
//		paramMap.put("currentVersionApp", 3);
//		paramMap.put("currentVersionDb", 1);
//		paramMap.put("currentVersionLogo", 1);
//		String aa = getEncryptReturnString(systemInfoLogic
//				.CheckVersionAllType(paramMap));
		//exec [WPM_check_versions_all_type] 11,'E-011','android','',1,1,1
		
//		// 鑾峰彇鍚庡彴褰撳墠鍝佺墝锛屽悇琛ㄦ暟鎹悓姝ョ増鏈俊鎭�
//		paramMap.put("TradeType", "GetVersionDb");
//		paramMap.put("brandId",11);
//		paramMap.put("counterCode","");
//		paramMap.put("systemType","");
//		paramMap.put("imei","");
//
//		String aa = getEncryptReturnString(systemInfoLogic
//				.GetVesrsionDb(paramMap));
//		
		
//		 //鑾峰彇閰嶇疆琛ㄦ暟鎹�
//		paramMap.put("TradeType", "GetConfigsDb");
//		paramMap.put("brandId",10);
//		paramMap.put("counterCode","");
//		paramMap.put("systemType","");
//		paramMap.put("imei","");
//
//		String aa = getEncryptReturnString(systemInfoLogic
//				.GetConfigsDb(paramMap));
		
		
//		//鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃
//		paramMap.put("TradeType", "UpdateVersionDb");
//		paramMap.put("brandId", 11);
//		paramMap.put("counterCode","E-011");
//		paramMap.put("systemType", "android");
//		paramMap.put("imei", "abcde1234567890");
//		paramMap.put("tableName", "WPM_configs");
//		paramMap.put("tableExt", "");
//		paramMap.put("currentVersion", 2);

//		String aa = getEncryptReturnString(systemInfoLogic
//				.UpdateVersionDb(paramMap));
//		
		
		//鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃
//		paramMap.put("TradeType", "UpdateDbMachineinfo");
//		paramMap.put("brandId", 11);
//		paramMap.put("counterCode","E-011");
//		paramMap.put("systemType", "android");
//		paramMap.put("imei", "abcde1234567890");
//		paramMap.put("currentVersionApp", 2);
//		paramMap.put("currentVersionDb", 3);
//		paramMap.put("currentVersionLogo",2);
//
//		String aa = getEncryptReturnString(systemInfoLogic
//		.UpdateDbMachineinfo(paramMap),3);
		
		
//		//鑾峰彇鏈嶅姟鍣ㄦ椂闂�
//		paramMap.put("brandId ", 11);
//		paramMap.put("counterCode ", "e-011");
		//String aa = getEncryptReturnString(systemInfoLogic.getServerDate(paramMap));
		
		
//		//涓嬭浇鏁版嵁锛岃彍鍗曡〃
//		paramMap.put("TradeType", "GetDbMenus");
//		paramMap.put("brandId", 11);
//		paramMap.put("counterCode","E-011");
//		paramMap.put("systemType", "android");
//		paramMap.put("imei", "");
		
//		
//		//涓嬭浇鏁版嵁锛岃彍鍗曞搧鐗岃〃
//		paramMap.put("TradeType", "GetDbMenuBrands");
//		paramMap.put("brandId", 11);
//		paramMap.put("counterCode","E-011");
//		paramMap.put("systemType", "android");
//		paramMap.put("imei", "");
		
//		paramMap.put("TradeType", "GetDbPaymentTypes");
//		paramMap.put("brandId", 11);
//		paramMap.put("counterCode","E-011");
		
		paramMap.put("TradeType", "GetDbBrandCounters");
		paramMap.put("brandId", 11);
		paramMap.put("counterCode", "E-011");
		paramMap.put("subBrand", "");

		
		CustomerContextHolder.setCustomerDataSourceType("OldCofing");
		
//		String aaa=AES256Util.encrypt(MobileUtil.map2Json(paramMap),AES256Util.PASSWORD);
////		
//			System.out.println(aaa);
		logger.debug(MobileUtil.map2Json(paramMap));  
		
		logger.debug(new String(Des3Util.encode(MobileUtil.map2Json(paramMap),super.getKey())));  
	    return new String(Des3Util.encode(MobileUtil.map2Json(paramMap),super.getKey()));
	}

	/**
	 * 绯荤粺閰嶇疆鐢ㄦ煡璇�
	 * 
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public String getSystemInfo(@QueryParam("paramData") String paramData,@QueryParam("mpos_id")String mpos_id,
			@Context HttpServletRequest request) throws Exception {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			//鎸囧畾鏁版嵁婧�
			if(!this.setDataSource(mpos_id)){
				retMap.put("ERRORCODE", "E0004");
				retMap.put("ResultContent", "");
				logger.error("鏁版嵁婧愪笉瀛樺湪銆�");
				return getEncryptReturnString(retMap,3);
			}
			// 璋冪敤鐖剁被鏂规硶锛岃В鏋愬弬鏁�
			Map<String, Object> paramMap = new HashMap<String, Object>();
			boolean parseFlag = this.parseParam(paramData, paramMap,3);
			if (!parseFlag) {
				logger.error("浼犲叆鍙傛暟 paramData 鍐呭鏈夎銆�");
				return getEncryptReturnString(paramMap,3);
			}

			// 鍙傛暟 TradeType 楠岃瘉锛�
			if (MobileChecker.isNullOrEmpty(paramMap.get("TradeType"))) {
				retMap.put("ERRORCODE", "E0002");
				retMap.put("ResultContent", "");
				logger.error("鍙傛暟 TradeType 涓嶈兘涓虹┖銆�");
				return getEncryptReturnString(retMap,3);
			}
			
			String tradeType = String.valueOf(paramMap.get("TradeType"));
			if (tradeType.equals(TradeType_CheckVersionApp)) {
				// app鏄惁瑕佹洿鏂�
				return getEncryptReturnString(systemInfoLogic.CheckVersionApp(paramMap),3);
			} else if (tradeType.equals(TradeType_CheckVersionLogo)) {
				// logo鏄惁瑕佹洿鏂�
				return getEncryptReturnString(systemInfoLogic.CheckVersionLogo(paramMap),3);
			} else if (tradeType.equals(TradeType_CheckVersionDb)) {
				// db鏄惁瑕佹洿鏂�
				return getEncryptReturnString(systemInfoLogic.CheckVersionDb(paramMap),3);
			} else if (tradeType.equals(TradeType_CheckVersionAllType)) {
				// app logo db鏄惁瑕佹洿鏂�
				return getEncryptReturnString(systemInfoLogic.CheckVersionAllType(paramMap),3);
			}else if(tradeType.equals(TradeType_GetVersionDb)){
				// 鑾峰彇鍚庡彴褰撳墠鍝佺墝锛屽悇琛ㄦ暟鎹悓姝ョ増鏈俊鎭�
				return getEncryptReturnString(systemInfoLogic.GetVesrsionDb(paramMap),3);
			}else if(tradeType.equals(TradeType_GetConfigsDb)){
				// 鑾峰彇閰嶇疆琛ㄦ暟鎹�
				return getEncryptReturnString(systemInfoLogic.GetConfigsDb(paramMap),3);
			}else if(tradeType.equals(TradeType_UpdateVersionDb)){
				//鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃
				return getEncryptReturnString(systemInfoLogic.UpdateVersionDb(paramMap),3);
			}else if(tradeType.equals(TradeType_UpdateDbMachineinfo)){
				//鍥炲啓缁堢淇℃伅琛�
				return getEncryptReturnString(systemInfoLogic.UpdateDbMachineinfo(paramMap),3);
			}else if(tradeType.equals(TradeType_GetServerDate)){
				//鑾峰彇鏈嶅姟鍣ㄦ椂闂�
				return getEncryptReturnString(systemInfoLogic.getServerDate(paramMap),3);
			}else if(tradeType.equals(TradeType_GetDbMenus)){
				//涓嬭浇鏁版嵁锛岃彍鍗曡〃
				return getEncryptReturnString(systemInfoLogic.getDbMenus(paramMap),3);
			}else if(tradeType.equals(TradeType_GetDbMenuBrands)){
				//涓嬭浇鏁版嵁锛岃彍鍗曞搧鐗岃〃
				return getEncryptReturnString(systemInfoLogic.getDbMenuBrands(paramMap),3);
			}else if(tradeType.equals(TradeType_GetDbPaymentTypes)){
				//鑾峰彇鏀粯绫诲瀷琛ㄦ暟鎹� 
				return getEncryptReturnString(systemInfoLogic.getDbPaymentTypes(paramMap),3);
			}else if(tradeType.equals(TradeType_GetDbBrandCounters)){
				//涓嬭浇brand琛�
				return getEncryptReturnString(systemInfoLogic.getDbBrandCounters(paramMap),3);
			}else {
				retMap.put("ERRORCODE", "E0003");
				retMap.put("ResultContent", "");
				logger.error("鍙傛暟 TradeType 閿欒銆�");
				return getEncryptReturnString(retMap,3);
			}

		} catch (Exception ex) {
			logger.error("SystemInfo ERROR:", ex.getMessage());
			logger.error("SystemInfo ERROR paramData:" + paramData);
			retMap.put("ERRORCODE", "E0099");
			retMap.put("ERRORMSG", "MobileServer's Error " + ex.getMessage());
			return getEncryptReturnString(retMap,3);
		}
	}

}