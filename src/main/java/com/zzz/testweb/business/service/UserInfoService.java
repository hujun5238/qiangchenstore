package com.zzz.testweb.business.service;

import java.util.HashMap;
import java.util.Map;

import com.zzz.testweb.system.constants.TestConstants;
import com.zzz.testweb.system.service.BaseService;

public class UserInfoService extends BaseService {
	
	/**
	 * 新增用户
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> addUserInfo(Map<String,Object> map){
		Map<String,Object> newMap =new HashMap<String,Object>();
		baseDaoImpl.save(map, "UserInfo.addUserInfo");
		newMap.put("rtn", map.get("rtn"));
		newMap.put("rtn_employee_code", map.get("rtn_employee_code"));
		return newMap;
	}
	
	/**
	 * 修改用户
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateUserInfo(Map<String,Object> map){
		int iRtn=0;
		map.put(TestConstants.IBATIS_SQL_ID, "UserInfo.updateUserInfo");
		baseDaoImpl.update(map);
		iRtn=(Integer)map.get("rtn");
		return iRtn;
	}

}
