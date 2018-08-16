package com.zzz.testweb.business.interfaces;

import java.util.Map;

public interface MemberInfo_IF {
	
	/** testweb */
	Map getMenberByCode(Map map);
	
	
	
	
	
	
	/** 浼氬憳妯＄硦鏌ヨ */
	Map getMemberInfoLike(Map map);
	/** 浼氬憳妯＄硦鏌ヨ锛堜慨鏀�20140319锛� */
	Map getMemberInfoLike2(Map map);
	/** 浼氬憳淇℃伅鏌ヨ */
	Map getMemberInfo(Map map);
	/** 浼氬憳淇℃伅鏌ヨ锛堜慨鏀�20140319锛� */
	Map getMemberInfo2(Map map);
	/** 鏂板浼氬憳 */
	Map newMemberInfo(Map map);
	/** 淇敼浼氬憳 */
	Map updateMemberInfo(Map map);
//	/** 浼氬憳绉垎鏌ヨ */
//	Map getMemberPoint(Map map);
//	/** 浼氬憳绉垎鏌ヨ锛堜慨鏀�20140319锛� */
//	Map getMemberPoint2(Map map);
	/** 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ */
	Map getMemberLastSaleDetail(Map map);
	/** 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ锛堜慨鏀�20140319锛� */
	Map getMemberLastSaleDetail2(Map map);
	/** 浼氬憳鍞竴鎬ф鏌� */
	Map checkMemberCodeMobile(Map map);
	/** Test */
	Map getCityInfo(Map map);
	/** 鑾峰彇浼氬憳鐢熸棩绀煎搧鏄惁棰嗙敤 */
	Map getMemBirthGift(Map map);
	/** 鏍规嵁鍝佺墝ID锛屼細鍛樺崱鍙凤紝浼氬憳鍚嶇О锛屼細鍛樻墜鏈猴紝浼氬憳鐢熸棩鏌ヨ浼氬憳鐨勫熀鏈俊鎭� */
	Map getReportMemberReportInfoByBrandId(Map map);
//	/** 鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅 */
//	Map getReportMemberReportInfoByType4(Map map);
//	/** 娌℃湁婵�娲荤殑鎯呭喌涓嬭皟鐢�     鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅 */
//	Map getReportMemberReportInfoByType3(Map map);
	/** 鏌ヨ浼氬憳鍥炵瓟杩囩殑闂嵎 */
	Map getReportMemberReportMemPaper(Map map);
    /**  鏌ヨ浼氬憳鐨勫綋鍓嶆湁鏁堢Н鍒�  */
	Map getReportMemberCurpoints(Map map);
	/** 鑾峰彇绀煎埜浣跨敤鍒楄〃 */
	Map getReportMemberReportCouponMain(Map map) ;
	/** 鑾峰彇绀煎埜浣跨敤鍒楄〃,鏄庣粏鏁版嵁 */
	Map getReportMemberReportCouponDetail(Map map);
	/** 鑾峰彇鍗冲皢杩囨湡绉垎 */
	Map getReportMemberPointToclear(Map map);
	/** 鑾峰彇鍙敤绉垎 */
	Map getReportMemberResourpoint(Map map);
	/** 鑾峰彇浼氬憳娑堣垂淇℃伅  */
	Map getReportMemberReportSaleAmount2(Map map);
	/** 鏌ヨ1鏈懆锛�2鏈湀锛�3涓嬩竴鏈堟椂闂存鍐呯殑浼氬憳淇℃伅  */
	Map getReportMemberBirthday(Map map);
}
