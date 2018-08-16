package com.zzz.testweb.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzz.testweb.system.constants.TestConstants;
import com.zzz.testweb.system.service.BaseService;

public class SystemInfoService extends BaseService {
	
	/**
	 * app鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> CheckVersionApp(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "SystemInfo.checkVersionApp");
		return baseDaoImpl.getList(map);
	}

	/**
	 * logo鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> CheckVersionLogo(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "SystemInfo.checkVersionLogo");
		return baseDaoImpl.getList(map);
	}

	/**
	 * db鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> CheckVersionDb(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "SystemInfo.checkVersionDb");
		return baseDaoImpl.getList(map);
	}
	
	
	/**
	 * app logo db鐗堟湰鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> CheckVersionAllType(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "SystemInfo.checkVersionAllType");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇鍚庡彴褰撳墠鍝佺墝锛屽悇琛ㄦ暟鎹悓姝ョ増鏈俊鎭�
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> GetVersionDb(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getVersionDb");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇閰嶇疆琛ㄦ暟鎹�
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> GetConfigsDb(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getConfigsDb");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int UpdateVersionDb(Map<String,Object> map){
		int intRet=0;
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.updateVersionDb");
		baseDaoImpl.update(map);
		intRet=Integer.parseInt(map.get("rtn").toString());
		return  intRet;
	}
	
	/**
	 * 鍥炲啓缁堢淇℃伅琛�
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int UpdateDbMachineinfo(Map<String,Object> map){
		int intRet=0;
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.updateDbMachineinfo");
		baseDaoImpl.update(map);
		intRet=Integer.parseInt(map.get("rtn").toString());
		return intRet;
	}
	
	/**
	 * 鑾峰彇鏈嶅姟鍣ㄦ椂闂�
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> GetServerDate(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getServerDate");
		return baseDaoImpl.getList(map);
	}

	
//
//	/**
//	 * 鑾峰彇鍝佺墝id
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public List<Map<String,Object>> getBrandId(Map<String,Object> map){
//		map.put(TestConstants.IBATIS_SQL_ID, "SystemInfo.GetBrandId");
//		return baseDaoImpl.getList(map);
//		
//	}
//	
	/**
	 * 鏌ヨ褰撳墠鍝佺墝鐨勫姞瀵咾EY鍊�
	 * @return
	 * @throws Exception
	 */
	public String getBrandKey(){
		String sRtn;
		int iBrandId;
		Map<String,Object> map =new HashMap<String,Object>();
		map.put(TestConstants.IBATIS_SQL_ID, "SystemInfo.GetBrandId");
		baseDaoImpl.getList(map);
		iBrandId=(Integer) map.get("brandId");
		map =new HashMap<String,Object>();
		map.put("brand_code",iBrandId );
		map.put(TestConstants.IBATIS_SQL_ID, "SystemInfo.getBrandKey");
		List<Map<String,Object>> listResult=baseDaoImpl.getList(map);
		sRtn=listResult.get(0).get("content").toString();
		return sRtn;
	}
	
	/**
	 * 鏌ヨ褰撳墠鍝佺墝浠ｅ彿
	 * @return
	 */
	public String getBrandCode(){
		String sRtn;
		int iBrandId;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.GetBrandId");
		baseDaoImpl.getList(map);
		iBrandId=(Integer)map.get("brandId");
		map=new HashMap<String,Object>();
		map.put("brandId", iBrandId);
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getBrandCode");
		List<Map<String,Object>> listResult=baseDaoImpl.getList(map);
		sRtn=listResult.get(0).get("abbr").toString();
		return sRtn;
	}
	
	/**
	 *  鏍规嵁mpos_id鏌ヨ杩炴帴鏁版嵁搴撲俊鎭� 
	 *  @return
	 */
	public List<Map<String,Object>> getBrandDataBase(Map map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getBrandDataBase");
		return baseDaoImpl.getList(map);
	}
	/**
	 * 涓嬭浇鏁版嵁锛岃彍鍗曡〃
	 * @return
	 */
	public  List<Map<String,Object>> getDbMenus(Map map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getDbMenus");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 涓嬭浇鏁版嵁锛岃彍鍗曞搧鐗岃〃
	 * @return
	 */
	public  List<Map<String,Object>> getDbMenuBrands(Map map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getDbMenuBrands");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇鏁版嵁婧愪俊鎭�
	 * @return
	 */
	public  List<Map<String,Object>> getDataSource(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getDataSource");
		return baseDaoImpl.getList(map);
	}
	
	
	/**
	 * 鑾峰彇鏀粯绫诲瀷琛ㄦ暟鎹� 
	 * @return
	 */
	public  List<Map<String,Object>> getDbPaymentTypes(Map map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getDbPaymentTypes");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 涓嬭浇brand琛�
	 * @return
	 */
	public  List<Map<String,Object>> getDbBrandCounters(Map map){
		map.put(TestConstants.IBATIS_SQL_ID,"SystemInfo.getDbBrandCounters");
		return baseDaoImpl.getList(map);
	}
	
}
