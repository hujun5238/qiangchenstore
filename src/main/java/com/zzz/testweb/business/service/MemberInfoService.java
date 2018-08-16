package com.zzz.testweb.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzz.testweb.system.constants.TestConstants;
import com.zzz.testweb.system.service.BaseService;

public class MemberInfoService extends BaseService {
	
	/**
	 * testweb 
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMenberByCode(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMenberByCode");
		return baseDaoImpl.getList(map);
	}
	
	
	
	
	
	
	
	
	/**
	 * 浼氬憳妯＄硦鏌ヨ
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMemberInfoLike(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberInfoLike");
		return baseDaoImpl.getList(map);
	}
	
	
	/**
	 * 浼氬憳妯＄硦鏌ヨ锛堜慨鏀�20140319锛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMemberInfoLike2(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberInfoLike2");
		return baseDaoImpl.getList(map);
	}

	/**
	 * 浼氬憳淇℃伅鏌ヨ
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMemberInfo(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberInfo");
		return baseDaoImpl.getList(map);
	}
	
	
	/**
	 * 浼氬憳淇℃伅鏌ヨ锛堜慨鏀�20140319锛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMemberInfo2(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberInfo2");
		return baseDaoImpl.getList(map);
	}
	
	
	/**
	 * 鏂板浼氬憳
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int newMemberInfo(Map<String,Object> map){
		int iRtn=0;
		baseDaoImpl.save(map, "MemberInfo.newMemberInfo");
		iRtn = (Integer)map.get("rtnStatus");
		return iRtn;
	}
	
	/**
	 * 淇敼浼氬憳
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateMemberInfo(Map<String,Object> map){
		int iRtn=0;
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.updateMemberInfo");
		baseDaoImpl.update(map);
		iRtn = (Integer)map.get("rtnStatus");
		return iRtn;
	}
	
//	/**
//	 * 浼氬憳绉垎鏌ヨ
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public List<Map<String,Object>> getMemberPoint(Map<String,Object> map){
//		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberPoint");
//		return baseDaoImpl.getList(map);
//	}
//	
//	
//	/**
//	 * 浼氬憳绉垎鏌ヨ(淇敼20140319)
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public List<Map<String,Object>> getMemberPoint2(Map<String,Object> map){
//		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberPoint2");
//		return baseDaoImpl.getList(map);
//	}
	
	
	
	/**
	 * 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>>  getMemberLastSaleDetail(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberLastSaleDetail");
		return baseDaoImpl.getList(map);
	}
	
	
	/**
	 * 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ锛堜慨鏀�20140319锛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>>  getMemberLastSaleDetail2(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemberLastSaleDetail2");
		return baseDaoImpl.getList(map);
	}
	
	
	
	/**
	 * 浼氬憳鍞竴鎬ф鏌�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int checkMemberCodeMobile(Map<String,Object> map){
		int iRtn=0;
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.checkMemberCodeMobile");
		baseDaoImpl.getList(map);
		iRtn = (Integer)map.get("count");
		return iRtn;
	}
	
	/**
	 * test
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getCityInfo(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getCityInfo");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇浼氬憳鐢熸棩绀煎搧鏄惁棰嗙敤
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMemBirthGift(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getMemBirthGift");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鏍规嵁鍝佺墝ID锛屼細鍛樺崱鍙凤紝浼氬憳鍚嶇О锛屼細鍛樻墜鏈猴紝浼氬憳鐢熸棩鏌ヨ浼氬憳鐨勫熀鏈俊鎭�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberReportInfoByBrandId(Map<String,Object> map){
		Map<String,Object> configMap=new HashMap<String,Object>();
		configMap.put("brandId",map.get("brandId"));
		Map<String,Object> typeMap=new HashMap<String,Object>();
		typeMap.put("counts", map.get("counts"));
		typeMap.put("memCode", map.get("memCode"));
		typeMap.put("memName", map.get("memName"));
		typeMap.put("mobilePhone", map.get("mobilePhone"));
		typeMap.put("memBirth", map.get("memBirth"));
		typeMap.put("brandCode", map.get("brandId").toString());
		configMap.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberPointConfig2");
		List<Map<String,Object>> configList=baseDaoImpl.getList(configMap);
		if(configList.size()==0){
			return null;
		}else{
			String configMemAct=configList.get(0).get("memAct").toString();
			if("YES".equals(configMemAct)){
				typeMap.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportInfoByType6");
				return baseDaoImpl.getList(typeMap);
			}else if("NO".equals(configMemAct)){
				typeMap.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportInfoByType5");
				return baseDaoImpl.getList(typeMap);
			}
		} 
		
		return null;
	}
	
	
//	/**
//	 * 鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public  List<Map<String,Object>> getReportMemberReportInfoByType4(Map<String,Object> map){
//		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportInfoByType4");
//		return baseDaoImpl.getList(map);
//	}
//	
//	
//	/**
//	 *  娌℃湁婵�娲荤殑鎯呭喌涓嬭皟鐢�      鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public  List<Map<String,Object>> getReportMemberReportInfoByType3(Map<String,Object> map){
//		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportInfoByType3");
//		return baseDaoImpl.getList(map);
//	}
//	
	
	/**
	 * 鏌ヨ浼氬憳鍥炵瓟杩囩殑闂嵎
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberReportMemPaper(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportMemPaper");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鏌ヨ浼氬憳鐨勫綋鍓嶆湁鏁堢Н鍒� 
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberCurpoints(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberCurpoints");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇绀煎埜浣跨敤鍒楄〃 
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberReportCouponMain(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportCouponMain");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇绀煎埜浣跨敤鍒楄〃,鏄庣粏鏁版嵁
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberReportCouponDetail(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportCouponDetail");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇鍗冲皢杩囨湡绉垎
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberPointToclear(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberPointToclear");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇鍙敤绉垎
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberResourpoint(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberResourpoint");
		return baseDaoImpl.getList(map);
	}
	
	/**
	 * 鑾峰彇浼氬憳娑堣垂淇℃伅 
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberReportSaleAmount2(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberReportSaleAmount2");
		return baseDaoImpl.getList(map);
	}
	
	
	/**
	 * 鏌ヨ1鏈懆锛�2鏈湀锛�3涓嬩竴鏈堟椂闂存鍐呯殑浼氬憳淇℃伅
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public  List<Map<String,Object>> getReportMemberBirthday(Map<String,Object> map){
		map.put(TestConstants.IBATIS_SQL_ID, "MemberInfo.getReportMemberBirthday");
		return baseDaoImpl.getList(map);
	}
	
	
	
}
