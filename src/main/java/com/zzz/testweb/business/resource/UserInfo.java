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


import com.zzz.testweb.business.interfaces.UserInfo_IF;
import com.zzz.testweb.system.db.CustomerContextHolder;
import com.zzz.testweb.system.service.BaseInfo;
import com.zzz.testweb.system.util.AES256Util;
import com.zzz.testweb.system.util.Des3Util;
import com.zzz.testweb.system.util.MobileChecker;
import com.zzz.testweb.system.util.MobileUtil;

@Path("/userInfo")
@Component
public class UserInfo extends BaseInfo {
	private static Logger logger = LoggerFactory.getLogger(UserInfo.class.getName());

	@Resource(name = "userInfoLogic")
	private UserInfo_IF userInfoLogic;

	
    // 鏂板浼氬憳
	public static final String TradeType_AddUserInfo = "AddUserInfo";
	// 淇敼浼氬憳
	public static final String TradeType_UpdateUserInfo = "UpdateUserInfo";
	
	
	@GET
	 @Path("/hello")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String hello() throws Exception  {
		 //TestApp 
		    Map<String, Object> paramMap = new HashMap<String, Object>();
//		    //鏂板鐢ㄦ埛
		    paramMap.put("TradeType", "AddUserInfo");
			paramMap.put("brandId", 11);
			paramMap.put("counterCode", "E-338");
		    //paramMap.put("employee_code", "lS000186");
			paramMap.put("employee_name", "娑�3");
//			paramMap.put("employee_name_foreign", value);
//			paramMap.put("identity_card", "222456789987654335");
			paramMap.put("mobilephone", "13641934264");
			//paramMap.put("email", "a@a.com");
			//paramMap.put("password", "111");
			//paramMap.put("Machinecode", "867746014676738");
			paramMap.put("Machinecode", "12345");
			paramMap.put("flag", 1);
			

//			String aa=getEncryptReturnString(userInfoLogic.addUserInfo(paramMap),3);
			//String aa=getEncryptReturnString(userInfoLogic.updateUserInfo(paramMap),3);
		    
		    
//		    //淇敼鐢ㄦ埛
//		    paramMap.put("TradeType", "UpdateUserInfo");
//			paramMap.put("brandId", 11);
//			paramMap.put("counterCode ", "E-011");
//			paramMap.put("employee_code", "lS000008");
//			paramMap.put("employee_name", "MikeAnny");
//			paramMap.put("identity_card", "222456789987654335");
//			paramMap.put("mobilephone", "98712344321");
//			paramMap.put("email", "a@a.com");
//			paramMap.put("password", "111");
//			paramMap.put("flag", 1);
			
			
			
			
			
			
			
			
			//String aa=getEncryptReturnString(userInfoLogic.updateUserInfo(paramMap));
//		    System.out.println(aa);
		    
			CustomerContextHolder.setCustomerDataSourceType("OldConfig");
			logger.debug(MobileUtil.map2Json(paramMap));  

			logger.debug(new String(Des3Util.encode(MobileUtil.map2Json(paramMap),super.getKey())));  
		    return new String(Des3Util.encode(MobileUtil.map2Json(paramMap),super.getKey()));
	 }

	 
		/**
		 * 鏌ヨ鐢ㄦ埛淇℃伅
		 * @param paramData
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public String getUserInfo(@QueryParam("paramData") String paramData,@QueryParam("mpos_id")String mpos_id,
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
				//璋冪敤鐖剁被鏂规硶锛岃В鏋愬弬鏁�
				Map<String, Object> paramMap = new HashMap<String, Object>();
				boolean parseFlag = this.parseParam(paramData,paramMap,3);
				if(!parseFlag){
					logger.error("浼犲叆鍙傛暟 paramData 鍐呭鏈夎銆�");
					return getEncryptReturnString(paramMap,3);
				}
				
				//鍙傛暟 TradeType 楠岃瘉锛�
				if(MobileChecker.isNullOrEmpty(paramMap.get("TradeType"))){
					retMap.put("ERRORCODE", "E0002");
					retMap.put("ResultContent", "");
					logger.error("鍙傛暟 TradeType 涓嶈兘涓虹┖銆�");
					return getEncryptReturnString(retMap,3);
				}
				
				String tradeType = String.valueOf(paramMap.get("TradeType"));
				if (tradeType.equals(TradeType_AddUserInfo)){
					// 鏂板鐢ㄦ埛	
					return getEncryptReturnString(userInfoLogic.newUserInfo(paramMap),3);
				} else if (tradeType.equals(TradeType_UpdateUserInfo)){
					// 淇敼鐢ㄦ埛
					return getEncryptReturnString(userInfoLogic.updateUserInfo(paramMap),3);
				} else {
					retMap.put("ERRORCODE", "E0003");
					retMap.put("ResultContent", "");
					logger.error("鍙傛暟 TradeType 閿欒銆�");
					return getEncryptReturnString(retMap,3);
				}
				
			} catch (Exception ex) {
				logger.error("UserInfo ERROR:", ex.getMessage());
				logger.error("UserInfo ERROR paramData:"+ paramData);
    			retMap.put("ERRORCODE", "E0099");
 				retMap.put("ERRORMSG", "MobileServer's Error "+ex.getMessage());
				return getEncryptReturnString(retMap,3);
			}
		}

}
