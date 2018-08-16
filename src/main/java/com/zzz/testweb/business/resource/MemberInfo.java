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

import com.zzz.testweb.business.interfaces.MemberInfo_IF;
import com.zzz.testweb.system.db.CustomerContextHolder;
import com.zzz.testweb.system.service.BaseInfo;
import com.zzz.testweb.system.util.AES256Util;
import com.zzz.testweb.system.util.Des3Util;
import com.zzz.testweb.system.util.MobileChecker;
import com.zzz.testweb.system.util.MobileUtil;

//****  http://localhost:8080/testweb/rs/memInfo/hello

@Path("/memInfo")
@Component
public class MemberInfo extends BaseInfo {

	private static Logger logger = LoggerFactory.getLogger(MemberInfo.class.getName());

	@Resource(name = "memberInfoLogic")
	private MemberInfo_IF memberInfoLogic;
	

	// 浼氬憳妯＄硦鏌ヨ
	public static final String TradeType_GetMemberInfoLike = "GetMemberInfoLike";
	// 浼氬憳妯＄硦鏌ヨ锛堜慨鏀�20140319锛�
	public static final String TradeType_GetMemberInfoLike2 = "GetMemberInfoLike2";
	// 浼氬憳淇℃伅鏌ヨ
	public static final String TradeType_GetMemberInfo = "GetMemberInfo";
	// 浼氬憳淇℃伅鏌ヨ锛堜慨鏀�20140319锛�
	public static final String TradeType_GetMemberInfo2 = "GetMemberInfo2";
	// 鏂板浼氬憳
	public static final String TradeType_NewMemberInfo = "NewMemberInfo";
	// 淇敼浼氬憳
	public static final String TradeType_UpdateMemberInfo = "UpdateMemberInfo";
	// 浼氬憳绉垎鏌ヨ
	public static final String TradeType_GetMemberPoint = "GetMemberPoint";
	// 浼氬憳绉垎鏌ヨ锛堜慨鏀�20140319锛�
	public static final String TradeType_GetMemberPoint2 = "GetMemberPoint2";
	// 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ
	public static final String TradeType_GetMemberLastSaleDetail = "GetMemberLastSaleDetail";
	// 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ锛堜慨鏀�20140319锛�
	public static final String TradeType_GetMemberLastSaleDetail2 = "GetMemberLastSaleDetail2";
	// 浼氬憳鍞竴鎬ф鏌�
	public static final String TradeType_CheckMemberCodeMobile = "CheckMemberCodeMobile";
	// 鑾峰彇浼氬憳鐢熸棩绀煎搧鏄惁棰嗙敤
	public static final String TradeType_GetReportSaleInforAmount= "GetmemBirthGift";	
	//鏍规嵁鍝佺墝ID锛岃幏鍙栭厤缃」淇℃伅
	public static final String TradeType_GetReportMemberReportInfoByBrandId = "GetReportMemberReportInfoByBrandId";
//	//鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//	public static final String TradeType_GetReportMemberReportInfoByType4 = "GetReportMemberReportInfoByType4";
//	//娌℃湁婵�娲荤殑鎯呭喌涓嬭皟鐢� 鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//	public static final String TradeType_GetReportMemberReportInfoByType3 = "GetReportMemberReportInfoByType3";
	//鏌ヨ浼氬憳鍥炵瓟杩囩殑闂嵎
	public static final String TradeType_GetReportMemberReportMemPaper = "GetReportMemberReportMemPaper";
	//鏌ヨ浼氬憳鐨勫綋鍓嶆湁鏁堢Н鍒�
	public static final String TradeType_GetReportMemberCurpoints = "GetReportMemberCurpoints";
	// 鑾峰彇绀煎埜浣跨敤鍒楄〃
	public static final String TradeType_GetReportMemberReportCouponMain = "GetReportMemberReportCouponMain";
	// 鑾峰彇绀煎埜浣跨敤鍒楄〃,鏄庣粏鏁版嵁
	public static final String TradeType_GetReportMemberReportCouponDetail = "GetReportMemberReportCouponDetail";
	// 鑾峰彇鍗冲皢杩囨湡绉垎
	public static final String TradeType_GetReportMemberPointToclear = "GetReportMemberPointToclear";
	// 鑾峰彇鍙敤绉垎
	public static final String TradeType_GetReportMemberResourpoint = "GetReportMemberResourpoint";
	//鑾峰彇浼氬憳娑堣垂淇℃伅
	public static final String TradeType_GetReportMemberReportSaleAmount2 = "GetReportMemberReportSaleAmount2";
	//鏌ヨ1鏈懆锛�2鏈湀锛�3涓嬩竴鏈堟椂闂存鍐呯殑浼氬憳淇℃伅
	public static final String TradeType_GetReportMemberBirthday = "GetReportMemberBirthday";
	
	 @GET
	 @Path("/hello")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String hello() throws Exception  {
		 //TestApp 
			CustomerContextHolder.setCustomerDataSourceType("OldCofing");
		 
		 Map<String, Object> paramMap = new HashMap<String, Object>();
		    paramMap.put("TradeType", "GetMenberByCode");
			paramMap.put("code", "001");
		    String bb=getEncryptReturnString(memberInfoLogic.getMenberByCode(paramMap),3);

		    return bb;

			
//			//鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//			paramMap.put("TradeType", "GetReportMemberReportInfoByType4");
//			
//			
//			//娌℃湁婵�娲荤殑鎯呭喌涓嬭皟鐢� 鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//			paramMap.put("TradeType", "GetReportMemberReportInfoByType3");
//			paramMap.put("counts", 11);
//			paramMap.put("memcode","");
//			paramMap.put("memname","11112");
//			paramMap.put("mobilephone", "");
//			paramMap.put("membirth", "12_AVON");
		    
		
//			logger.debug(MobileUtil.map2Json(paramMap));  
//			logger.debug(new String(AES256Util.encrypt(MobileUtil.map2Json(paramMap),productInfoService.getBrandKey())));  
//	        return new String(AES256Util.encrypt(MobileUtil.map2Json(paramMap),productInfoService.getBrandKey()));
	        
//	        logger.debug(new String(Des3Util.encode(MobileUtil.map2Json(paramMap),super.getKey())));  
//		    return new String(Des3Util.encode(MobileUtil.map2Json(paramMap),super.getKey()));
	 }

	 
		/**
		 * 鏌ヨ浼氬憳淇℃伅
		 * @param paramData
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public String getMemberInfo(@QueryParam("paramData") String paramData,@QueryParam("mpos_id")String mpos_id,
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
				if (tradeType.equals(TradeType_GetMemberInfoLike)){
					// 浼氬憳妯＄硦鏌ヨ		
					return getEncryptReturnString(memberInfoLogic.getMemberInfoLike(paramMap),3);
				}else if(tradeType.equals(TradeType_GetMemberInfoLike2)){
					// 浼氬憳妯＄硦鏌ヨ(淇敼20140319)		
					return getEncryptReturnString(memberInfoLogic.getMemberInfoLike2(paramMap),3);
				} else if (tradeType.equals(TradeType_GetMemberInfo)){
					// 浼氬憳淇℃伅鏌ヨ	
					return getEncryptReturnString(memberInfoLogic.getMemberInfo(paramMap),3);
				} else if (tradeType.equals(TradeType_GetMemberInfo2)){
					// 浼氬憳淇℃伅鏌ヨ锛堜慨鏀�20140319锛�	
					return getEncryptReturnString(memberInfoLogic.getMemberInfo2(paramMap),3);
				} else  if (tradeType.equals(TradeType_NewMemberInfo)){
					// 鏂板浼氬憳
					return getEncryptReturnString(memberInfoLogic.newMemberInfo(paramMap),3);
				} else if (tradeType.equals(TradeType_UpdateMemberInfo)){
					// 淇敼浼氬憳
					return getEncryptReturnString(memberInfoLogic.updateMemberInfo(paramMap),3);
//				} else if (tradeType.equals(TradeType_GetMemberPoint)){
//					// 浼氬憳绉垎鏌ヨ		
//					return getEncryptReturnString(memberInfoLogic.getMemberPoint(paramMap),3);
//				}else if (tradeType.equals(TradeType_GetMemberPoint2)){
//					// 浼氬憳绉垎鏌ヨ锛堜慨鏀�20140319锛�		
//					return getEncryptReturnString(memberInfoLogic.getMemberPoint2(paramMap),3);
				} else if (tradeType.equals(TradeType_GetMemberLastSaleDetail)){
					// 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ
					return getEncryptReturnString(memberInfoLogic.getMemberLastSaleDetail(paramMap),3);
				}  else if (tradeType.equals(TradeType_GetMemberLastSaleDetail2)){
					// 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ锛堜慨鏀�20140319锛�
					return getEncryptReturnString(memberInfoLogic.getMemberLastSaleDetail2(paramMap),3);
				} else if (tradeType.equals(TradeType_CheckMemberCodeMobile)){
					// 浼氬憳鍞竴鎬ф鏌�
					return getEncryptReturnString(memberInfoLogic.checkMemberCodeMobile(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportSaleInforAmount)){
					//鑾峰彇浼氬憳鐢熸棩绀煎搧鏄惁棰嗙敤
					return getEncryptReturnString(memberInfoLogic.getMemBirthGift(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberReportInfoByBrandId)){
					//鏍规嵁鍝佺墝ID锛岃幏鍙栭厤缃」淇℃伅
					return getEncryptReturnString(memberInfoLogic.getReportMemberReportInfoByBrandId(paramMap),3);
//				}else if(tradeType.equals(TradeType_GetReportMemberReportInfoByType4)){
//					//鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//					return getEncryptReturnString(memberInfoLogic.getReportMemberReportInfoByType4(paramMap),3);
//				}else if(tradeType.equals(TradeType_GetReportMemberReportInfoByType3)){
//					//娌℃湁婵�娲荤殑鎯呭喌涓嬭皟鐢� 鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//					return getEncryptReturnString(memberInfoLogic.getReportMemberReportInfoByType3(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberReportMemPaper)){
					//鏌ヨ浼氬憳鍥炵瓟杩囩殑闂嵎
					return getEncryptReturnString(memberInfoLogic.getReportMemberReportMemPaper(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberCurpoints)){
					//鏌ヨ浼氬憳鐨勫綋鍓嶆湁鏁堢Н鍒�
					return getEncryptReturnString(memberInfoLogic.getReportMemberCurpoints(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberReportCouponMain)){
					// 鑾峰彇绀煎埜浣跨敤鍒楄〃
					return getEncryptReturnString(memberInfoLogic.getReportMemberReportCouponMain(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberReportCouponDetail)){
					// 鑾峰彇绀煎埜浣跨敤鍒楄〃,鏄庣粏鏁版嵁
					return getEncryptReturnString(memberInfoLogic.getReportMemberReportCouponDetail(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberPointToclear)){
					// 鑾峰彇鍗冲皢杩囨湡绉垎
					return getEncryptReturnString(memberInfoLogic.getReportMemberPointToclear(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberResourpoint)){
					// 鑾峰彇鍙敤绉垎
					return getEncryptReturnString(memberInfoLogic.getReportMemberResourpoint(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberReportSaleAmount2)){
					//鑾峰彇浼氬憳娑堣垂淇℃伅
					return getEncryptReturnString(memberInfoLogic.getReportMemberReportSaleAmount2(paramMap),3);
				}else if(tradeType.equals(TradeType_GetReportMemberBirthday)){
					//鑾峰彇浼氬憳娑堣垂淇℃伅
					return getEncryptReturnString(memberInfoLogic.getReportMemberBirthday(paramMap),3);
				}else {
					retMap.put("ERRORCODE", "E0003");
					retMap.put("ResultContent", "");
					logger.error("鍙傛暟 TradeType 閿欒銆�");
					return getEncryptReturnString(retMap,3);
				}
				
			} catch (Exception ex) {
				logger.error("MemberInfo ERROR:", ex.getMessage());
				logger.error("MemberInfo ERROR paramData:"+ paramData);
     			retMap.put("ERRORCODE", "E0099");
  				retMap.put("ERRORMSG", "MobileServer's Error "+ex.getMessage());
				return getEncryptReturnString(retMap,3);
			}
		}
	   
}