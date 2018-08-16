package com.zzz.testweb.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.zzz.testweb.business.service.SystemInfoService;
import com.zzz.testweb.system.db.CustomerContextHolder;
import com.zzz.testweb.system.util.AESUtil;
import com.zzz.testweb.system.util.Compress;
import com.zzz.testweb.system.util.Des3Util;
import com.zzz.testweb.system.util.MobileChecker;
import com.zzz.testweb.system.util.MobileUtil;

public class BaseInfo {
	
	@Resource(name = "systemInfoService")
	private SystemInfoService systemInfoService;
	//瀵嗛挜
	protected String getKey(){
//		System.out.println(systemInfoService.getBrandKey());
//		return systemInfoService.getBrandKey();
		return "abc";  //---加密解密用key值，存Db中，按实际需要设置；现在调框架，暂时固定值
	}


    /** 
     * 鎸囧畾鏁版嵁婧愶紙榛樿LOGIN锛� 
     *  
     * @param paramData 
     *            浼犲叆鍙傛暟 
     * @param paramMap 
     *            杞琈AP 鍚庣殑鍙傛暟
     * @return 
     */  
	protected boolean setDataSource(String mpos_id) {
		boolean flag=false;
		if(mpos_id==null || "".equals(mpos_id)){
			CustomerContextHolder.setCustomerDataSourceType("OldCofing");
			flag=true;
		}else{
			CustomerContextHolder.setCustomerDataSourceType("CherryBrandDB");
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("mpos_id", mpos_id);
			//鏍规嵁mpos_id鏌ヨdatasourcename
			List<Map<String,Object>>   dataSource = systemInfoService.getBrandDataBase(map);
			if(dataSource.size()==0){
				flag=false;
			}else{	
				flag=true;
				String dataSourceName=dataSource.get(0).get("datasourcename").toString();
				System.out.println(dataSourceName);
				CustomerContextHolder.setCustomerDataSourceType(dataSourceName);
			}
		}
		return flag;
		
	}

    /** 
     * 璋冪敤Service鏃讹紝浼犲叆鍙傛暟check,瑙ｅ瘑,JSON杞琈AP 
     *  
     * @param paramData 
     *            浼犲叆鍙傛暟 
     * @param paramMap 
     *            杞琈AP 鍚庣殑鍙傛暟
     * @return 
     */  
protected boolean parseParam(String paramData, Map<String, Object> paramMap,int type) throws Exception {
		
		if(MobileChecker.isNullOrEmpty(paramData)){
			paramMap.put("ERRORCODE", "E0001");
			paramMap.put("ERRORMSG", "鍙傛暟paramData鏄繀椤荤殑");
			return false;
		}
	    
		//灏嗚В瀵嗗悗鐨凧SON瀛楃涓茶浆鎹㈡垚Map
		System.err.println(paramData);  
		//paramData = AESUtil.decrypt(AESUtil.PASSWORD,paramData);
		//paramData =AES256Util.decrypt(paramData,productInfoService.getBrandKey());
		//1:ASE  2:AES256 3:DES3
		if(type==1){
			paramData = AESUtil.decrypt(AESUtil.PASSWORD,paramData);
		}else{
			paramData =Des3Util.decode(paramData,this.getKey());
		}
		
		System.err.println(paramData);  
		paramMap.putAll(MobileUtil.json2Map(paramData));
		return true;
	}

	/** 
	 * Service璋冪敤瀹屽悗,灏嗕俊鎭浆JSON鍔犲瘑鍚庤繑鍥�
	 *  
	 * @param retMap 
	 *            鍔犲瘑鍓嶄俊鎭�
	 * @param compressFlg 
	 *            鏄惁鍘嬬缉
	 * @return  String 杩斿洖鐢ㄥ姞瀵嗕俊鎭�
	 */  
	protected String getEncryptReturnString (Map<String, Object> retMap,int type) throws Exception{		
		if(retMap.containsKey("ERRORCODE")){
			// 涓氬姟涓姤閿欙紝鐩存帴杩斿洖鎶ラ敊淇℃伅
			return MobileUtil.map2Json(retMap);
		}
		
		HashMap<String,Object>	returnMap = new HashMap<String,Object>();
		returnMap.put("ERRORCODE", "0");
		returnMap.put("ERRORMSG", "成功");
		// 鑳芥甯歌幏鍙栧埌鍝佺墝鐨凙ES Key
		if(retMap.containsKey("ResultContent")){
			// List褰㈠紡鐨勮繑鍥炵粨鏋�
			//System.out.println(MobileUtil.obj2Json(retMap.get("ResultContent")));
			//returnMap.put("ResultContent", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultContent"))));	
			//returnMap.put("ResultContent", AES256Util.encrypt(MobileUtil.obj2Json(retMap.get("ResultContent")),productInfoService.getBrandKey()));
			//returnMap.put("ResultContent", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
			//1:ASE  2:AES256 3:DES3
			if(type==1){
				returnMap.put("ResultContent", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultContent"))));
			}else{
				//returnMap.put("ResultContent", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
				returnMap.put("ResultContent", MobileUtil.obj2Json(retMap.get("ResultContent")));
			}
			
			
			
		}else if(retMap.containsKey("ResultMap")){
			// Map褰㈠紡鐨勮繑鍥炵粨鏋�
			//System.out.println(MobileUtil.obj2Json(retMap.get("ResultMap")));
			//returnMap.put("ResultMap", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultMap"))));	
			//returnMap.put("ResultMap", AES256Util.encrypt(MobileUtil.obj2Json(retMap.get("ResultMap")),productInfoService.getBrandKey()));	
			returnMap.put("ResultMap", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
		}else if(retMap.containsKey("ResultString")){
			// String褰㈠紡鐨勮繑鍥炵粨鏋�
			//System.out.println(MobileUtil.obj2Json(retMap.get("ResultString")));
			//returnMap.put("ResultString", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultString"))));	
			//returnMap.put("ResultString", AES256Util.encrypt(MobileUtil.obj2Json(retMap.get("ResultString")),productInfoService.getBrandKey()));
			returnMap.put("ResultString", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
		}
		return MobileUtil.map2Json(returnMap);
		
	}
	
	/** 
	 * Service璋冪敤瀹屽悗,灏嗕俊鎭浆JSON鍔犲瘑鍚庤繑鍥�
	 *  
	 * @param retMap 
	 *            鍔犲瘑鍓嶄俊鎭�
	 * @param compressFlg 
	 *            鏄惁鍘嬬缉
	 * @return  byte[]  杩斿洖鐢ㄥ姞瀵嗕俊鎭�
	 */  
	protected byte[]  getEncryptReturnByte (Map<String, Object> retMap,int type) throws Exception{	
		
		if(retMap.containsKey("ERRORCODE")){
			// 涓氬姟涓姤閿欙紝鐩存帴杩斿洖鎶ラ敊淇℃伅
			return  Compress.byteCompress(MobileUtil.map2Json(retMap).getBytes());
		}

		HashMap<String,Object>	returnMap = new HashMap<String,Object>();
		returnMap.put("ERRORCODE", "0");
		returnMap.put("ERRORMSG", "鎵ц鎴愬姛");
		// 鑳芥甯歌幏鍙栧埌鍝佺墝鐨凙ES Key
		if(retMap.containsKey("ResultContent")){
			// List褰㈠紡鐨勮繑鍥炵粨鏋�
			//returnMap.put("ResultContent", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultContent"))));
			//SimpleDateFormat form=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.sss");
			//System.out.println("start:"+form.format(new Date()));
//			returnMap.put("ResultContent", AES256Util.encrypt(MobileUtil.obj2Json(retMap.get("ResultContent")),productInfoService.getBrandKey()));
			//returnMap.put("ResultContent", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
			if(type==1){
				returnMap.put("ResultContent", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultContent"))));
			}else{
				returnMap.put("ResultContent", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
			}
			//System.out.println("end:"+form.format(new Date()));
		}else if(retMap.containsKey("ResultMap")){
			// Map褰㈠紡鐨勮繑鍥炵粨鏋�
			//returnMap.put("ResultMap", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultMap"))));	
//			returnMap.put("ResultMap", AES256Util.encrypt(MobileUtil.obj2Json(retMap.get("ResultMap")),productInfoService.getBrandKey()));	
			returnMap.put("ResultContent", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
		}else if(retMap.containsKey("ResultString")){
			// String褰㈠紡鐨勮繑鍥炵粨鏋�
			//returnMap.put("ResultString", AESUtil.encrypt(AESUtil.PASSWORD,MobileUtil.obj2Json(retMap.get("ResultString"))));	
//			returnMap.put("ResultString", AES256Util.encrypt(MobileUtil.obj2Json(retMap.get("ResultString")),productInfoService.getBrandKey()));
			returnMap.put("ResultContent", Des3Util.encode(MobileUtil.obj2Json(retMap.get("ResultContent")),this.getKey()));
		}

		return Compress.byteCompress(MobileUtil.map2Json(returnMap).getBytes());
		
	}
}