package com.zzz.testweb.business.logic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zzz.testweb.business.interfaces.MemberInfo_IF;
import com.zzz.testweb.business.service.MemberInfoService;
import com.zzz.testweb.system.util.MobileChecker;

public class MemberInfoLogic implements MemberInfo_IF  {

	private static Logger logger = LoggerFactory.getLogger(MemberInfoLogic.class.getName());
	
	@Resource(name = "memberInfoService")
	private MemberInfoService memberInfoService;

	/**
	 * testweb
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMenberByCode(Map paramMap) {
		logger.info("MemberInfoLogic.getMemberInfoLike START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		if (MobileChecker.isNullOrEmpty(paramMap.get("code"))) {
			logger.error("a empty code");
			retMap.put("ERRORCODE", "EM0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		List memList = memberInfoService.getMenberByCode(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getMemberInfoLike END");
		return retMap;
		
	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * 浼氬憳妯＄硦鏌ヨ
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMemberInfoLike(Map paramMap) {
		logger.info("MemberInfoLogic.getMemberInfoLike START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("mobilePhone"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("nameCn"))) {
			logger.error("浼氬憳鍙�,鎵嬫満,濮撳悕 涓嶈兘鍚屾椂涓虹┖");
			retMap.put("ERRORCODE", "EM0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		List memList = memberInfoService.getMemberInfoLike(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getMemberInfoLike END");
		return retMap;
	}
	
	
	/**
	 * 浼氬憳妯＄硦鏌ヨ锛堜慨鏀�20140319锛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMemberInfoLike2(Map paramMap) {
		logger.info("MemberInfoLogic.getMemberInfoLike2 START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("mobilePhone"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("nameCn"))) {
			logger.error("浼氬憳鍙�,鎵嬫満,濮撳悕 涓嶈兘鍚屾椂涓虹┖");
			retMap.put("ERRORCODE", "EM0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		List memList = memberInfoService.getMemberInfoLike2(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getMemberInfoLike2 END");
		return retMap;
	}
	
	
	
	
	/**
	 * 浼氬憳淇℃伅鏌ヨ
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMemberInfo(Map paramMap) {
		logger.info("MemberInfoLogic.getMemberInfo START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("mobilePhone"))) {
			logger.error("浼氬憳鍙�,鎵嬫満 涓嶈兘鍚屾椂涓虹┖");
			retMap.put("ERRORCODE", "EM0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		List memList = memberInfoService.getMemberInfo(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getMemberInfo END");
		return retMap;
	}
	
	
	/**
	 * 浼氬憳淇℃伅鏌ヨ锛堜慨鏀�20140319锛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMemberInfo2(Map paramMap) {
		logger.info("MemberInfoLogic.getMemberInfo2 START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("memMobile"))) {
			logger.error("浼氬憳鍙�,鎵嬫満 涓嶈兘鍚屾椂涓虹┖");
			retMap.put("ERRORCODE", "EM0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		List memList = memberInfoService.getMemberInfo2(paramMap);
		
		Map<String,Object> map=null;
		System.out.println(memList.size());
		for(int i=0;i<memList.size();i++){
			map=(Map<String, Object>) memList.get(i);
			System.out.println(map.get("member_code")+","+map.get("name_cn"));;
		}
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getMemberInfo2 END");
		return retMap;
	}
	
	
	
	
	
	/**
	 * 鏂板浼氬憳
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map newMemberInfo(Map paramMap) {
		logger.info("MemberInfoLogic.newMemberInfo START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 鏌ヨ浼氬憳鍩烘湰淇℃伅
		// 妫�鏌ュ弬鏁�
		// 浼氬憳鍙�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))) {
			logger.error("浼氬憳鍙� 涓嶈兘涓虹┖");
			retMap.put("ERRORCODE", "E0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		int iRet = memberInfoService.newMemberInfo(paramMap);
		retMap.put("ResultContent", iRet);
		logger.info("MemberInfoLogic.newMemberInfo END");
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
	public Map updateMemberInfo(Map paramMap) {
		logger.info("MemberInfoLogic.updateMemberInfo START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 鏌ヨ浼氬憳鍩烘湰淇℃伅
		// 妫�鏌ュ弬鏁�
		// 浼氬憳鍙�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))) {
			logger.error("浼氬憳鍙� 涓嶈兘涓虹┖");
			retMap.put("ERRORCODE", "E0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		int iRet = memberInfoService.updateMemberInfo(paramMap);
		retMap.put("ResultContent", iRet);
		
		logger.info("MemberInfoLogic.updateMemberInfo END");
		return retMap;
	}

//	/**
//	 * 浼氬憳绉垎鏌ヨ
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public Map getMemberPoint(Map paramMap) {
//		logger.info("MemberInfoLogic.getMemberPoint START");
//		// 鏌ヨ浼氬憳鍩烘湰淇℃伅
//		// 妫�鏌ュ弬鏁�
//		Map<String, Object> retMap = new HashMap<String, Object>();
//		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
//		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
//				&& MobileChecker.isNullOrEmpty(paramMap.get("mobilePhone"))) {
//			logger.error("浼氬憳鍙�,鎵嬫満 涓嶈兘鍚屾椂涓虹┖");
//			retMap.put("ERRORCODE", "E0001");
//			retMap.put("ResultContent", "");
//			return retMap;
//		}
//		
//		List memList = memberInfoService.getMemberPoint(paramMap);
//		if (memList == null || memList.size() == 0) {
//			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
//			retMap.put("ERRORCODE", "EM0004");
//			retMap.put("ResultContent", "");
//		} else {
//			retMap.put("ResultContent", memList);
//		}
//		
//		logger.info("MemberInfoLogic.getMemberPoint END");
//		return retMap;
//	}
//	
//	/**
//	 * 浼氬憳绉垎鏌ヨ锛堜慨鏀�20140319锛�
//	 * @param map
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public Map getMemberPoint2(Map paramMap) {
//		logger.info("MemberInfoLogic.getMemberPoint2 START");
//		// 鏌ヨ浼氬憳鍩烘湰淇℃伅
//		// 妫�鏌ュ弬鏁�
//		Map<String, Object> retMap = new HashMap<String, Object>();
//		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
//		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
//				&& MobileChecker.isNullOrEmpty(paramMap.get("memMobile"))) {
//			logger.error("浼氬憳鍙�,鎵嬫満 涓嶈兘鍚屾椂涓虹┖");
//			retMap.put("ERRORCODE", "E0001");
//			retMap.put("ResultContent", "");
//			return retMap;
//		}
//		
//		List memList = memberInfoService.getMemberPoint2(paramMap);
//		if (memList == null || memList.size() == 0) {
//			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
//			retMap.put("ERRORCODE", "EM0004");
//			retMap.put("ResultContent", "");
//		} else {
//			retMap.put("ResultContent", memList);
//		}
//		
//		logger.info("MemberInfoLogic.getMemberPoint2 END");
//		return retMap;
//	}
	
	
	/**
	 * 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMemberLastSaleDetail(Map paramMap) {
		logger.info("MemberInfoLogic.getMemberLastSaleDetail START");
		// 鏌ヨ浼氬憳鍩烘湰淇℃伅
		// 妫�鏌ュ弬鏁�
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("mobilePhone"))) {
			logger.error("浼氬憳鍙�,鎵嬫満 涓嶈兘鍚屾椂涓虹┖");
			retMap.put("ERRORCODE", "E0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		List memList = memberInfoService.getMemberLastSaleDetail(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");			
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getMemberLastSaleDetail END");
		return retMap;
	}
	
	/**
	 * 浼氬憳鏈�杩戞秷璐癸紙鎴栧巻鍙诧級鏌ヨ锛堜慨鏀�20140319锛�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMemberLastSaleDetail2(Map paramMap) {
		logger.info("MemberInfoLogic.getMemberLastSaleDetail2 START");
		// 鏌ヨ浼氬憳鍩烘湰淇℃伅
		// 妫�鏌ュ弬鏁�
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 浼氬憳鍙�,鎵嬫満,濮撳悕 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭煡璇�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("memMobile"))) {
			logger.error("浼氬憳鍙�,鎵嬫満 涓嶈兘鍚屾椂涓虹┖");
			retMap.put("ERRORCODE", "E0001");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		List memList = memberInfoService.getMemberLastSaleDetail2(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");			
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getMemberLastSaleDetail2 END");
		return retMap;
	}
	
	/**
	 * 浼氬憳鍞竴鎬ф鏌�
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map checkMemberCodeMobile(Map paramMap) {
		logger.info("MemberInfoLogic.checkMemberCodeMobile START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 浼氬憳鍙�,鎵嬫満 閮芥病鏈夎緭鍏ワ紝鍒欎笉鍋氭鏌�
		if (MobileChecker.isNullOrEmpty(paramMap.get("memCode"))
				&& MobileChecker.isNullOrEmpty(paramMap.get("mobilePhone"))) {
			logger.error("浼氬憳鍙�,鎵嬫満 涓嶈兘鍚屾椂涓虹┖");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
			return retMap;
		}
		
		int iRet = memberInfoService.checkMemberCodeMobile(paramMap);
		retMap.put("ResultContent", iRet);

		logger.info("MemberInfoLogic.checkMemberCodeMobile END");
		return retMap;
	}
	
	/**
	 * test
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getCityInfo(Map paramMap) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		List memList = memberInfoService.getCityInfo(paramMap);
		retMap.put("ResultContent", memList);
		return retMap;
	}
	
	/**
	 * 鑾峰彇浼氬憳鐢熸棩绀煎搧鏄惁棰嗙敤
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getMemBirthGift(Map paramMap) {
		logger.info("MemberInfoLogic.getMemBirthGift START");
		Map<String, Object> retMap = new HashMap<String, Object>();
		List memList = memberInfoService.getMemBirthGift(paramMap);
		retMap.put("ResultContent", memList);

		logger.info("MemberInfoLogic.getMemBirthGift END");
		return retMap;
	}
	
	
	/**
	 * 鏍规嵁鍝佺墝ID锛屼細鍛樺崱鍙凤紝浼氬憳鍚嶇О锛屼細鍛樻墜鏈猴紝浼氬憳鐢熸棩鏌ヨ浼氬憳鐨勫熀鏈俊鎭�
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberReportInfoByBrandId(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberReportInfoByBrandId START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberReportInfoByBrandId(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getReportMemberReportInfoByBrandId END");
		return retMap;
	}

//	/**
//	 * 鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//	 * @param paramData
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public Map getReportMemberReportInfoByType4(Map paramMap) {
//		logger.info("MemberInfoLogic.getReportMemberReportInfoByType4 START");
//		Map<String, Object> retMap = new HashMap<String, Object>();
//
//		List memList = memberInfoService.getReportMemberReportInfoByType4(paramMap);
//		if (memList == null || memList.size() == 0) {
//			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
//			retMap.put("ERRORCODE", "EM0002");
//			retMap.put("ResultContent", "");
//		} else {
//			retMap.put("ResultContent", memList);
//		}
//		
//		logger.info("MemberInfoLogic.getReportMemberReportInfoByType4 END");
//		return retMap;
//	}
//
//	/**
//	 * 娌℃湁婵�娲荤殑鎯呭喌涓嬭皟鐢�  鏍规嵁浼氬憳鍗″彿锛屼細鍛樺悕绉帮紝浼氬憳鎵嬫満锛屼細鍛樼敓鏃ユ煡璇細鍛樼殑鍩烘湰淇℃伅
//	 * @param paramData
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public Map getReportMemberReportInfoByType3(Map paramMap) {
//		logger.info("MemberInfoLogic.getReportMemberReportInfoByType3 START");
//		Map<String, Object> retMap = new HashMap<String, Object>();
//
//		List memList = memberInfoService.getReportMemberReportInfoByType3(paramMap);
//		if (memList == null || memList.size() == 0) {
//			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
//			retMap.put("ERRORCODE", "EM0002");
//			retMap.put("ResultContent", "");
//		} else {
//			retMap.put("ResultContent", memList);
//		}
//		
//		logger.info("MemberInfoLogic.getReportMemberReportInfoByType3 END");
//		return retMap;
//	}

	/**
	 * 鏌ヨ浼氬憳鍥炵瓟杩囩殑闂嵎
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberReportMemPaper(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberReportMemPaper START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberReportMemPaper(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getReportMemberReportMemPaper END");
		return retMap;
	}

	/**
	 * 鏌ヨ浼氬憳鐨勫綋鍓嶆湁鏁堢Н鍒�
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberCurpoints(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberCurpoints START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberCurpoints(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getReportMemberCurpoints END");
		return retMap;
	}
	
	
	/**
	 * 鑾峰彇绀煎埜浣跨敤鍒楄〃
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberReportCouponMain(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberReportCouponMain START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberReportCouponMain(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			BigDecimal sumPrice=new BigDecimal(0);
			BigDecimal sumQuantity=new BigDecimal(0);
			int size=memList.size();
			for(int i=0;i<size;i++){
				Map<String,Object> memMap=(Map<String, Object>) memList.get(i);
				
				String strPrice="0";
				String strQuantity="0";
				
				if(memMap.get("price") != null){
					strPrice=memMap.get("price").toString();
				}
				if(memMap.get("quantity") != null){
					strQuantity=memMap.get("quantity").toString();
				}
				
				sumPrice=sumPrice.add(new BigDecimal(strPrice));
				sumQuantity=sumQuantity.add(new BigDecimal(strQuantity));
			}
			Map<String,Object> newMap=new HashMap<String,Object>();
			newMap.put("param","鍚堣");
			newMap.put("price",sumPrice);
			newMap.put("quantity",sumQuantity);
			newMap.put("banameMax", "");
			newMap.put("counterCode", "");
			newMap.put("memname", "");
			newMap.put("datetimes", "");
			
			memList.add(0,newMap);
			
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getReportMemberReportCouponMain END");
		return retMap;
	}
	
	
	/**
	 * 鑾峰彇绀煎埜浣跨敤鍒楄〃,鏄庣粏鏁版嵁
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberReportCouponDetail(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberReportCouponDetail START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberReportCouponDetail(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			BigDecimal sumNormalPrice=new BigDecimal(0);
			BigDecimal sumPrice=new BigDecimal(0);
			BigDecimal sumQuantity=new BigDecimal(0);
			int size=memList.size();
			for(int i=0;i<size;i++){
				Map<String,Object> memMap=(Map<String, Object>) memList.get(i);
				
				String strNormalPrice="0";
				String strPrice="0";
				String strQuantity="0";
				
				if(memMap.get("normalPrice") != null){
					strNormalPrice=memMap.get("normalPrice").toString();
				}
				if(memMap.get("price") != null){
					strPrice=memMap.get("price").toString();
				}
				if(memMap.get("quantity") != null){
					strQuantity=memMap.get("quantity").toString();
				}
				
				sumNormalPrice=sumNormalPrice.add(new BigDecimal(strNormalPrice));
				sumPrice=sumPrice.add(new BigDecimal(strPrice));
				sumQuantity=sumQuantity.add(new BigDecimal(strQuantity));
			}
			Map<String,Object> newMap=new HashMap<String,Object>();
			newMap.put("arcode", "鍚堣");
			newMap.put("normalPrice", sumNormalPrice);
			newMap.put("price", sumPrice);
			newMap.put("quantity", sumQuantity);
			
			memList.add(0,newMap);
			retMap.put("ResultContent", memList);
		}
		
		logger.info("MemberInfoLogic.getReportMemberReportCouponDetail END");
		return retMap;
	}

	/**
	 * 鑾峰彇鍗冲皢杩囨湡绉垎
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberPointToclear(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberPointToclear START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberPointToclear(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			String pointToClear=((Map<String,Object>)memList.get(0)).get("point_toclear").toString();
			retMap.put("ResultContent", pointToClear);
		}
		
		logger.info("MemberInfoLogic.getReportMemberPointToclear END");
		return retMap;
	}

	/**
	 * 鑾峰彇鍙敤绉垎
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberResourpoint(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberResourpoint START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberResourpoint(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			String ChangablePoint=((Map<String,Object>)memList.get(0)).get("ChangablePoint").toString();
			retMap.put("ResultContent", ChangablePoint);
		}
		
		logger.info("MemberInfoLogic.getReportMemberResourpoint END");
		return retMap;
	}
	
	
	/**
	 * 鑾峰彇浼氬憳娑堣垂淇℃伅 
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberReportSaleAmount2(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberReportSaleAmount2 START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberReportSaleAmount2(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		logger.info("MemberInfoLogic.getReportMemberReportSaleAmount2 END");
		return retMap;
	}
	
	
	/**
	 * 鏌ヨ1鏈懆锛�2鏈湀锛�3涓嬩竴鏈堟椂闂存鍐呯殑浼氬憳淇℃伅
	 * @param paramData
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map getReportMemberBirthday(Map paramMap) {
		logger.info("MemberInfoLogic.getReportMemberBirthday START");
		Map<String, Object> retMap = new HashMap<String, Object>();

		List memList = memberInfoService.getReportMemberBirthday(paramMap);
		if (memList == null || memList.size() == 0) {
			logger.info("鏌ヨ鏁版嵁涓嶅瓨鍦�");
			retMap.put("ERRORCODE", "EM0002");
			retMap.put("ResultContent", "");
		} else {
			retMap.put("ResultContent", memList);
		}
		logger.info("MemberInfoLogic.getReportMemberBirthday END");
		return retMap;
	}
	
}
