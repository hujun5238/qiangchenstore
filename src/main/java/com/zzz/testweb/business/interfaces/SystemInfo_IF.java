package com.zzz.testweb.business.interfaces;

import java.util.Map;

public interface SystemInfo_IF {
	/** app鏄惁瑕佹洿鏂� */
	Map CheckVersionApp(Map map);
	/** logo鏄惁瑕佹洿鏂� */
	Map CheckVersionLogo(Map map);
	/** db鏄惁瑕佹洿鏂� */
	Map CheckVersionDb(Map map);
	/** app logo db  鏄惁瑕佹洿鏂� */
	Map CheckVersionAllType(Map map);
	/** 鑾峰彇鍚庡彴褰撳墠鍝佺墝锛屽悇琛ㄦ暟鎹悓姝ョ増鏈俊鎭� */
	Map GetVesrsionDb(Map map);
	/** 鑾峰彇閰嶇疆琛ㄦ暟鎹� */
	Map GetConfigsDb(Map map);
	/**  鏁版嵁鍚屾鎴愬姛鍚庯紝鍥炲啓鍚勭粓绔暟鎹増鏈褰曡〃  */
	Map UpdateVersionDb(Map map);
	/** 鍥炲啓缁堢淇℃伅琛�  */
	Map UpdateDbMachineinfo(Map map);
	/** 鑾峰彇鏈嶅姟鍣ㄦ椂闂� */
	Map getServerDate(Map map);
	/** 涓嬭浇鏁版嵁锛岃彍鍗曡〃  */
	Map getDbMenus(Map map);
	/** 涓嬭浇鏁版嵁锛岃彍鍗曞搧鐗岃〃 */
	Map getDbMenuBrands(Map map);
	/** 鑾峰彇鏀粯绫诲瀷琛ㄦ暟鎹� */
    Map getDbPaymentTypes(Map map) ;
    /** 涓嬭浇brand琛�  */
    Map getDbBrandCounters(Map map);


	
}
