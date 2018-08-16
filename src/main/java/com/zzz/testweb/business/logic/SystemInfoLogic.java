package com.zzz.testweb.business.logic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zzz.testweb.business.interfaces.SystemInfo_IF;
import com.zzz.testweb.business.service.SystemInfoService;

public class SystemInfoLogic implements SystemInfo_IF  {

	private static Logger logger = LoggerFactory.getLogger(SystemInfoLogic.class.getName());
	
	@Resource(name = "systemInfoService")
	private SystemInfoService systemInfoService;

	/**
	 * app鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map CheckVersionApp(Map paramMap) {
		logger.info("SystemInfoLogic.CheckVersionApp START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		List sysList = systemInfoService.CheckVersionApp(paramMap);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.CheckVersionApp END");
		return retMap;
	}
	
	/**
	 * logo鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map CheckVersionLogo(Map paramMap) {
		logger.info("SystemInfoLogic.CheckVersionLogo START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		List sysList = systemInfoService.CheckVersionLogo(paramMap);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.CheckVersionLogo END");
		
		return retMap;
	}

	/**
	 * db鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map CheckVersionDb(Map paramMap) {
		logger.info("SystemInfoLogic.CheckVersionDb START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		List sysList = systemInfoService.CheckVersionDb(paramMap);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.CheckVersionDb END");
		return retMap;
	}

	
	/**
	 * app logo db鐗堟湰鏄惁瑕佹洿鏂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map CheckVersionAllType(Map paramMap) {
		logger.info("SystemInfoLogic.CheckVersionAllType START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		List sysList = systemInfoService.CheckVersionAllType(paramMap);
		
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			int totalSize=0;
			URL url=null;
		    try {
		    	for(int i=0;i<sysList.size();i++){
		    		Map<String,Object> map=  (Map<String, Object>) sysList.get(i);
		    		String path=map.get("url").toString();
		    		url=new URL(path);
		    		HttpURLConnection   urlcon=(HttpURLConnection)url.openConnection();   
		    		map.put("Size",urlcon.getContentLength());	
		    	}
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			retMap.put("ResultContent", sysList);
			
		}
		logger.info("SystemInfoLogic.CheckVersionAllType END");
		return retMap;
	}

	/**
	 * 鑾峰彇鍚庡彴褰撳墠鍝佺墝锛屽悇琛ㄦ暟鎹悓姝ョ増鏈俊鎭�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map GetVesrsionDb(Map map) {
		logger.info("SystemInfoLogic.GetVersionDb START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		List sysList=systemInfoService.GetVersionDb(map);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.GetVersionDb END");
		return retMap;
	}

	
	/**
	 * 鑾峰彇閰嶇疆琛ㄦ暟鎹�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map GetConfigsDb(Map map) {
		logger.info("SystemInfoLogic.GetConfigsDb START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		List sysList=systemInfoService.GetConfigsDb(map);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.GetConfigsDb END");
		return retMap;
	}
  
	
	/**
	 * 鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map UpdateVersionDb(Map map) {
		logger.info("SystemInfoLogic.UpdateVersionDb START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		int result=systemInfoService.UpdateVersionDb(map);
		if (result!=1) {
			logger.info("鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃澶辫触");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", result);
		}
		logger.info("SystemInfoLogic.UpdateVersionDb END");
		return retMap;
	}

	/**
	 * 鍥炲啓缁堢淇℃伅琛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map UpdateDbMachineinfo(Map map) {
		logger.info("SystemInfoLogic.updateDbMachineinfo START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		int result=systemInfoService.UpdateDbMachineinfo(map);
		if (result!=1) {
			logger.info("鍥炲啓缁堢淇℃伅琛�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", result);
		}
		logger.info("SystemInfoLogic.updateDbMachineinfo END");
		return retMap;
	}

	/**
	 * 鑾峰彇鏈嶅姟鍣ㄦ椂闂�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getServerDate(Map map) {
		logger.info("SystemInfoLogic.GetServerDate START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		List sysList=systemInfoService.GetServerDate(map);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.GetServerDate END");
		return retMap;
	}

	/**
	 * 涓嬭浇鏁版嵁锛岃彍鍗曡〃
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getDbMenus(Map map) {
		logger.info("SystemInfoLogic.getDbMenus START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		List sysList=systemInfoService.getDbMenus(map);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.getDbMenus END");
		return retMap;
	}

	/**
	 * 涓嬭浇鏁版嵁锛岃彍鍗曞搧鐗岃〃
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getDbMenuBrands(Map map) {
		logger.info("SystemInfoLogic.getDbMenuBrands START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		List sysList=systemInfoService.getDbMenuBrands(map);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.getDbMenuBrands END");
		return retMap;
	}

//	/**
//	 * 鏍规嵁mposid鏌ヨ杩炴帴鏁版嵁搴撲俊鎭�
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public Map getBrandDataBase(Map map) {
//		logger.info("SystemInfoLogic.getBrandDataBase START");
//		Map<String,Object> retMap=new HashMap<String,Object>();
//		
//		List sysList=systemInfoService.getBrandDataBase(map);
//		if (sysList == null || sysList.size() == 0) {
//			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
//			retMap.put("ERRORCODE", "ES0001");
//			retMap.put("ResultContent", "");
//		} else {
//			retMap.put("ResultContent", sysList);
//		}
//		logger.info("SystemInfoLogic.getBrandDataBase END");
//		return retMap;
//	}
	
	
	/**
	 * 鑾峰彇鏀粯绫诲瀷琛ㄦ暟鎹� 
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getDbPaymentTypes(Map map) {
		logger.info("SystemInfoLogic.getDbPaymentTypes START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		List sysList=systemInfoService.getDbPaymentTypes(map);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.getDbPaymentTypes END");
		return retMap;
	}
	
	/**
	 * 涓嬭浇brand琛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getDbBrandCounters(Map map) {
		logger.info("SystemInfoLogic.getDbBrandCounters START");
		Map<String,Object> retMap=new HashMap<String,Object>();
		
		List sysList=systemInfoService.getDbBrandCounters(map);
		if (sysList == null || sysList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "ES0001");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", sysList);
		}
		logger.info("SystemInfoLogic.getDbBrandCounters END");
		return retMap;
	}
	
	
	
}
