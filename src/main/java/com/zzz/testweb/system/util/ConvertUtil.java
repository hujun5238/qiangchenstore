/*	
 * @(#)ConvertUtil.java     1.0 2010/10/12		
 * 		
 * Copyright (c) 2010 SHANGHAI BINGKUN DIGITAL TECHNOLOGY CO.,LTD		
 * All rights reserved		
 * 		
 * This software is the confidential and proprietary information of 		
 * SHANGHAI BINGKUN.("Confidential Information").  You shall not		
 * disclose such Confidential Information and shall use it only in		
 * accordance with the terms of the license agreement you entered into		
 * with SHANGHAI BINGKUN.		
 */
package com.zzz.testweb.system.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

//import com.googlecode.jsonplugin.JSONException;
//import com.googlecode.jsonplugin.JSONUtil;

/**
 * <p>
 * 共通 转换Util
 * </p>
 * 
 * @author lipc
 * 
 */
@SuppressWarnings("unchecked")
public class ConvertUtil {

	/**
	 * <p>
	 * 层级List转换(支持多层转换)
	 * </p>
	 *  
	 * @param List
	 *          	转换前List
	 * @param List
	 *          	转换后List
	 * @param List
	 *          	多层key
	 * @param int
	 *          	层级      
	 * @return 无
	 * 
	 * @throws 无
	 */
	public static void convertList2DeepList(List<Map<String, Object>> list,
			List<Map<String, Object>> rootList, List<String[]> keysList,
			int deep) {
		if (list != null && rootList != null && keysList != null
				&& keysList.size() > deep) {
			String[] keys = keysList.get(deep);
			String id = null;
			if (keys != null && keys.length > 0) {
				id = keys[0];
			}
			for (Map<String, Object> map : list) {
				// 判断是否已经存在了
				boolean isNotEqual = true;
				for (Map<String, Object> rootMap : rootList) {
					// 外层List的id
					Object value = rootMap.get(id);
					/* id相等的时候说明已经存在 */
					if (value != null && value.equals(map.get(id))) {
						// 更新外层List已存在的map
						updateRootList(2, map, rootMap, "list", id, keys);
						isNotEqual = false;
						break;
					}
				}
				if (isNotEqual) {
					Map<String, Object> rootMap = new HashMap<String, Object>();
					rootList.add(rootMap);
					// 往外层List添加map
					updateRootList(1, map, rootMap, "list", id, keys);
				}
			}
			if (deep < keysList.size() - 1) {
				deep++;
				for (Map<String, Object> rootMap : rootList) {
					List<Map<String, Object>> deepList = (List<Map<String, Object>>) rootMap
							.get("list");
					List<Map<String, Object>> deepListNew = new ArrayList<Map<String, Object>>();
					rootMap.put("list", deepListNew);
					convertList2DeepList(deepList, deepListNew, keysList, deep);
				}
			}
		}
	}

	/**
	 * <p>
	 * 层级List转换(两层)
	 * </p>
	 * 
	 * @param List
	 *            	转换前List
	 * @param String
	 *            	里面一层List的名字
	 * @param String
	 *            	外层List的id属性
	 * @param String[] 
	 * 				外层List其它的属性
	 * @return String 
	 * 				转换好的层级List
	 * 
	 * @throws 无
	 */
	public static List<Map<String, Object>> convertList2HierarchyList(
			List<Map<String, Object>> list, String depName, String id,
			String... keys) {
		// 外层List
		List<Map<String, Object>> rootList = new ArrayList<Map<String, Object>>();
		if (list != null) {
			for (Map<String, Object> map : list) {
				// 判断是否已经存在了
				boolean isNotEqual = true;
				for (Map<String, Object> rootMap : rootList) {
					// 外层List的id
					Object value = rootMap.get(id);
					/* id相等的时候说明已经存在 */
					if (value != null && value.equals(map.get(id))) {
						// 更新外层List已存在的map
						updateRootList(2, map, rootMap, depName, id, keys);
						isNotEqual = false;
						break;
					}
				}
				if (isNotEqual) {
					Map<String, Object> rootMap = new HashMap<String, Object>();
					rootList.add(rootMap);
					// 往外层List添加map
					updateRootList(1, map, rootMap, depName, id, keys);
				}

			}
		}
		return rootList;
	}

	/**
	 * <p>
	 * 更新外层List
	 * </p>
	 * 
	 * @param int 
	 * 				更新区分
	 * @param Map
	 *            	读取的map
	 * @param String
	 *            	外层List的map
	 * @param String
	 *            	里面一层List的名字
	 * @param String
	 *            	外层List的id属性
	 * @param String[] 
	 * 				外层List其它的属性
	 * @return 无
	 * 
	 * @throws 无
	 */

	private static void updateRootList(int updateFlg, Map<String, Object> map,
			Map<String, Object> rootMap, String depName, String id,
			String[] keys) {
		// 里层List
		List<Map<String, Object>> depList = new ArrayList<Map<String, Object>>();
		if (map != null && rootMap != null) {
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.putAll(map);
			if (updateFlg == 1) {
				// 外层List的id属性
				rootMap.put(id, tempMap.get(id));
				tempMap.remove(id);
				// 往外层List中添加里层List属性
				rootMap.put(depName, depList);
			} else {
				depList = (List<Map<String, Object>>) rootMap.get(depName);
				tempMap.remove(id);
			}
			if (keys != null) {
				/* 往外层List中添加其它属性 */
				for (String key : keys) {
					if (id != null && !id.equals(key)) {
						if (updateFlg == 1) {
							rootMap.put(key, tempMap.get(key));
						}
						tempMap.remove(key);
					}
				}
			}
			Map<String, Object> depMap = new HashMap<String, Object>();
			depMap.putAll(tempMap);
			if (depList != null) {
				depList.add(depMap);
			}
		}
	}

	/**
	 * <p>
	 * 页面上的层级List转换(支持多层转换)
	 * </p>
	 * 
	 * @param List
	 *          	转换前List
	 * @param List
	 *          	转换后List
	 * @param List
	 *          	多层key
	 * @param int
	 *          	层级
	 * @return 无
	 * 
	 * @throws 无
	 */
	public static void jsTreeDataDeepList(List<Map<String, Object>> list,
			List<Map<String, Object>> rootList, List<String[]> keysList,
			int deep) {
		if (list != null && rootList != null && keysList != null
				&& keysList.size() > deep) {
			String[] keys = keysList.get(deep);
			String id = null;
			String name = null;
			String[] otherKeys = null;
			if (keys != null && keys.length > 1) {
				id = keys[0];
				name = keys[1];
				if (keys.length > 2) {
					otherKeys = new String[keys.length - 2];
					for (int i = 0; i < keys.length - 2; i++) {
						otherKeys[i] = keys[i + 2];
					}
				}
			}
			for (Map<String, Object> map : list) {
				// 判断是否已经存在了
				boolean isNotEqual = true;
				for (Map<String, Object> rootMap : rootList) {
					// 外层List的id
					Object value = rootMap.get("id");
					/* id相等的时候说明已经存在 */
					if (value != null && value.equals(map.get(id))) {
						// 更新外层List已存在的map
						updatePageRootList(2, map, rootMap, "nodes", id,
								name, otherKeys);
						isNotEqual = false;
						break;
					}
				}
				if (isNotEqual) {
					Map<String, Object> rootMap = new HashMap<String, Object>();
					rootList.add(rootMap);
					// 往外层List添加map
					updatePageRootList(1, map, rootMap, "nodes", id, name, otherKeys);
				}
			}
			if (deep < keysList.size() - 1) {
				deep++;
				for (Map<String, Object> rootMap : rootList) {
					List<Map<String, Object>> deepList = (List<Map<String, Object>>) rootMap
							.get("nodes");
					List<Map<String, Object>> deepListNew = new ArrayList<Map<String, Object>>();
					rootMap.put("nodes", deepListNew);
					jsTreeDataDeepList(deepList, deepListNew, keysList, deep);
				}
			} else {
				for (Map<String, Object> rootMap : rootList) {
					rootMap.remove("nodes");
				}
			}
		}
	}

	/**
	 * <p>
	 * 更新页面外层List
	 * </p>
	 * 
	 * @param int 
	 * 				更新区分
	 * @param Map
	 *            	读取的map
	 * @param String
	 *            	外层List的map
	 * @param String
	 *            	里面一层List的名字
	 * @param String
	 *            	外层List的id属性
	 * @param String 
	 * 				外层List其它的属性
	 * @return 无
	 * 
	 * @throws 无
	 */

	private static void updatePageRootList(int updateFlg,
			Map<String, Object> map, Map<String, Object> rootMap,
			String depName, String id, String name, String[] otherKeys) {
		// 里层List
		List<Map<String, Object>> depList = new ArrayList<Map<String, Object>>();
		if (map != null && rootMap != null) {
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.putAll(map);
			if (updateFlg == 1) {
				// 外层List的id属性
				rootMap.put("id", tempMap.get(id));
				tempMap.remove(id);
				// 往外层List中添加里层List属性
				rootMap.put(depName, depList);
			} else {
				depList = (List<Map<String, Object>>) rootMap.get(depName);
				tempMap.remove(id);
			}
			rootMap.put("name", tempMap.get(name));
			tempMap.remove(name);
			if (otherKeys != null) {
				/* 往外层List中添加其它属性 */
				for (String key : otherKeys) {
					if (updateFlg == 1) {
						rootMap.put(key, tempMap.get(key));
					}
					tempMap.remove(key);
				}
			}
			Map<String, Object> depMap = new HashMap<String, Object>();
			depMap.putAll(tempMap);
			if (depList != null) {
				depList.add(depMap);
			}
		}
	}

	/**
	 * <p>
	 * 判断对象数组中是否存在相同值的对象
	 * </p>
	 * 
	 * 
	 * @param tArray
	 *            对象数组
	 * @param obj
	 *            比较的对象
	 * @return boolean 比较结果
	 * 
	 * @throws 无
	 */
	public static <T> boolean isContain(T[] tArray, T obj) {
		if (tArray != null) {
			for (T t : tArray) {
				if (t != null && t.equals(obj)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * obj 转换成字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String getString(Object obj) {
		if (null == obj) {
			return "";
		}
		if (obj instanceof String) {
			return (String) obj;
		} else {
			return obj.toString();
		}
	}
	
	public static float getFloat(Object obj){
		float res = 0;
		if(obj instanceof Integer){
			res = (Integer)obj;
		}else if(obj instanceof Float){
			res = (Float)obj;
		}else if(obj instanceof Number){
			Number num = (Number)obj;
			res = num.floatValue();
		}else{
			try{
				res= Float.parseFloat(getString(obj));
			}catch(Exception e){}
		}
		return res;
	}
	
	public static String obj2Price(Object obj){
		float price = getFloat(obj);
		DecimalFormat df = new DecimalFormat("0.00"); 
		return df.format(price);
	}
	/**
	 * obj 转换成整形
	 * @param obj
	 * @return
	 * 
	 * */
	public static int getInt(Object obj){
		//对象为空返回0
		if(null==obj){
			return 0;
		}
		//对像为Integer类型直接返回
		if(obj instanceof Integer){
			return (Integer)obj;
		}
		//对象为String类型
		else if(obj instanceof String){
			try{
				return Integer.parseInt(String.valueOf(obj));
			}catch(Exception e){
				return 0;
			}
		}else if(obj instanceof Number){
			Number num = (Number)obj;
			return num.intValue();
		}else{
			return 0;
		}
	}

	/**
	 * 将json写入response
	 * 
	 * @param response
	 * @param object
	 * @throws Exception
	 */
//	public static void setResponseByAjax(HttpServletResponse response,
//			Object object) throws Exception {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");
//		if (object instanceof String){
//			response.getWriter().write((String)object);
//		}else{
//			// 响应JSON对象
//			response.getWriter().write(JSONUtil.serialize(object));
//		}
//
//	}

	/**
	 * 将Map设置成JsTreeMap
	 * 
	 * @param list
	 * @param key
	 */
	public static void setJsTreeMap(HashMap map, String key, String value,
			List childrenList) {
		HashMap attrMap = new HashMap();
		attrMap.put("id", key);
		map.put("attr", attrMap);
		map.put("data", value);
		map.put("state", "");
		if (null != childrenList) {
			map.put("children", childrenList);
		}
	}
	
	/**
	 * 
	 * 根据树的层级关系把线性的数据转换成List树型结构
	 * 
	 * @param 
	 * 		List 线性数据List
	 * @return 
	 * 		List 树型结构List
	 */
	public static List<Map<String, Object>> getTreeList(List<Map<String, Object>> list,String key) {
		if(list == null || list.isEmpty()) {
			return null;
		}
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		// 取得第一个节点的层级
		double d = Double.parseDouble(list.get(0).get("level").toString());
		// 循环遍历整棵树
		while(!list.isEmpty()) {
			// 取得当前节点的层级
			double _d = Double.parseDouble(list.get(0).get("level").toString());
			// 当前节点的层级与第一个节点的层级不相同时
			if(d != _d) {
				// 当前节点是上一层级的子节点时
				if(d < _d) {
					// 递归调用取得上一层级最后一个节点的所有子节点，然后添加到该节点下
					resultList.get(resultList.size()-1).put(key, getTreeList(list,key));
				} else {// 当前节点不是上一层级的子节点时退出循环
					break;
				}
			} else { // 当前节点的层级与第一个节点的层级相同时
				// 在当前层级上添加一个节点
				//addMapToList(list.get(0), resultList);
				resultList.add(list.get(0));
				// 从树中删除该节点
				list.remove(0);
			}
		}
		return resultList;
	}
	
	public static void addMapToList(Map<String, Object> map, List<Map<String, Object>> list) {
		if(list == null || map == null || map.isEmpty()) {
			return;
		}
		if(list.isEmpty()) {
			list.add(map);
		} else {
			boolean exitMap = false;
			for(Map<String, Object> m: list) {
				if(m.get("path") != null && map.get("path") != null && m.get("path").toString().equals(map.get("path").toString())) {
					exitMap = true;
					break;
				}
			}
			if(!exitMap) {
				list.add(map);
			}
		}
	}
	
	/**
	 * 根据key将list分组
	 * @param list
	 * @param key
	 */
	public static List listGroup (List listAll,String key,String listKey){
		Map<String ,List> groupMap = new HashMap<String ,List>();  
		for (int i=0;i<listAll.size();i++){
			HashMap map = (HashMap)listAll.get(i);
			// 取得分组id
			String grpID = String.valueOf(map.get(key));
			if (groupMap.containsKey(grpID)){
				List listSingle = groupMap.get(grpID);  
				listSingle.add(map);
			}else{
				 List listSingle = new ArrayList();  //重新声明一个list
				 listSingle.add(map);
				 groupMap.put(grpID, listSingle);
			}
		}
		
		// 新建一个分组List
		List groupList = new ArrayList();
		// 遍历分组Map
		Iterator iter = groupMap.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    Object val = entry.getValue(); 
		    HashMap tmpMap = new HashMap();
		    tmpMap.put(listKey, val);
		    groupList.add(tmpMap);
		    
		} 
		
		Collections.reverse(groupList);
		return groupList;
	}
	
	
	/**
	 * 在最底层的节点中添加一个虚节点,用于上层父节点的展开
	 * @param list
	 */
	public static void addArtificialCounterDeep(List list){
		if (list!=null && !list.isEmpty()){
			for (int i=0;i<list.size();i++){
				HashMap map = (HashMap)list.get(i);
				List childList = (List)map.get("nodes");
				if (childList !=null && !childList.isEmpty()){
					addArtificialCounterDeep(childList);
				}else{
					List artificialList = new ArrayList();
					HashMap artificialMap = new HashMap();
					artificialMap.put("name","artificialCounter");
					artificialMap.put("id","artificialCounter");
					artificialList.add(artificialMap);
					map.put("nodes", artificialList);
				}
			}
		}
	}
	
	/**
	 * 以二进制方式克隆对象  
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public static Object byteClone(Object src) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(src);
		out.close();
		ByteArrayInputStream bin = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bin);
		Object clone = in.readObject();
		in.close();
		return (clone);
	}  
	
	/**
	 * 用DTO2来覆盖DTO1
	 * 
	 * @param dto1 
	 * 			需要覆盖的DTO
	 * @param dto2
	 * 			用来覆盖的DTO
	 * @param flg 
	 * 			true:空值也覆盖   false:空值不覆盖
	 * @return
	 * 
	 * @throws Exception 
	 */
	public static <T> void convertDTO(T dto1, T dto2, boolean flg) throws Exception{
		if (null != dto1 && null != dto2) {
			Method[] mdArr2 = dto2.getClass().getMethods();
			for (Method md2 : mdArr2) {
				if (md2.getName().indexOf("get") == 0) {
					Object value = md2.invoke(dto2);
					if (!flg && (null == value || "".equals(value))) {
						continue;
					}
					Method[] mdArr1 = dto1.getClass().getMethods();
					String mdName = "set" + md2.getName().substring(3);
					for (Method md1 : mdArr1) {
						if (mdName.equals(md1.getName())) {
							md1.invoke(dto1, value);
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * 用DTO2来覆盖DTO1
	 * 
	 * @param dto1 
	 * 			需要覆盖的DTO
	 * @param dto2
	 * 			用来覆盖的DTO
	 * @param flg 
	 * 			true:空值也覆盖   false:空值不覆盖
	 * @return
	 * 
	 * @throws Exception 
	 */
	public static <T> void convertNewDTO(T dto1, T dto2, boolean flg) throws Exception{
		if (null != dto1 && null != dto2) {
			Method[] mdArr2 = dto2.getClass().getMethods();
			for (Method md2 : mdArr2) {
				Class[] ptypes = md2.getParameterTypes();
				if (md2.getName().indexOf("get") == 0 && null != ptypes && ptypes.length == 0) {
					Object value = md2.invoke(dto2);
					if (!flg && (null == value || "".equals(value))) {
						continue;
					}
					Method[] mdArr1 = dto1.getClass().getMethods();
					String mdName = "set" + md2.getName().substring(3);
					for (Method md1 : mdArr1) {
						if (mdName.equals(md1.getName())) {
							md1.invoke(dto1, value);
							break;
						}
					}
				}
			}
		}
	}
		
	/**
	 * 返回字符串的字符长度,汉字的长度为2
	 * 
	 * 
	 * */
	public static int getStringLength(String str){
		
		int length = 0;
		if(null == str || str.length() == 0){
			return length;
		}
		//将字符串转化成字符数组
		char[] charArr = str.toCharArray();
		for(char tempChar : charArr){
			//如果是汉字则长度加2
			if(tempChar >= 0x0391 && tempChar <= 0xFFE5){
				length += 2;
			}else{
				length ++;
			}
		}
		return length;
	}
	
	/**
	 * JSON字符串转List
	 * @param json
	 * @return
	 */
//	public static List<Map<String, Object>> json2List(String json){
//		List<Map<String, Object>> list = null;
//		if(null != json && !"".equals(json.trim())){
//			try {
//				list = (List<Map<String, Object>>)JSONUtil.deserialize(json);
//			} catch (JSONException e) {
//			}
//		}
//		return list;
//	}
	
	/**
	 * JSON字符串转Map
	 * @param json
	 * @return
	 */
//	public static Map<String, Object> json2Map(String json){
//		Map<String, Object> map = null;
//		if(null != json && !"".equals(json.trim())){
//			try {
//				map = (Map<String, Object>)JSONUtil.deserialize(json);
//			} catch (JSONException e) {
//			}
//		}
//		return map;
//	}
	/**
	 * map转list
	 * @param map
	 * @return
	 */
	public static List<Map<String, Object>> map2List(Map<String, Object> map){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		if(null != map){
			for(Map.Entry<String,Object> en: map.entrySet()){
				Map<String, Object> temp = (Map<String, Object>)en.getValue();
				list.add(new HashMap<String,Object>(temp));
			}
		}
		return list;
	}
	
	/**
	 * 取得不重复的KEY集合
	 * @param srcList
	 * @param key
	 * @return
	 */
	public static List<String> getKeyList(List<Map<String,Object>> srcList, String key){
		List<String> keyList = new ArrayList<String>();
		if(null != srcList){
			for(Map<String,Object> map : srcList){
				String value = getString(map.get(key));
				if(!keyList.contains(value)){
					keyList.add(value);
				}
			}
		}
		return keyList;
	}
	
	/**
	 * List复制
	 * @param srcList
	 * @return
	 */
	public static List<Map<String,Object>> copyList(List<Map<String,Object>> srcList){
		List<Map<String,Object>> list = null;
		if(null != srcList){
			list = new ArrayList<Map<String,Object>>();
			for (Map<String,Object> src : srcList) {
				list.add(new HashMap<String, Object>(src));
			}
		}
		return list;
	}
	
	/**
	 * 把树中不为柜台的叶子节点删除掉
	 * 
	 * @param treeList 待处理树型结构
	 */
	public static void cleanTreeList(List<Map<String, Object>> treeList) {
		for(int i = 0; i < treeList.size(); i++) {
			Map<String, Object> map = treeList.get(i);
			List<Map<String, Object>> nextList = (List)map.get("nodes");
			if(nextList != null && !nextList.isEmpty()) {
				cleanTreeList(nextList);
				if(nextList.isEmpty()) {
					treeList.remove(i);
					i--;
				}
			} else {
				Object type = map.get("type");
				if(type != null && "4".equals(type.toString())) {
					continue;
				} else {
					treeList.remove(i);
					i--;
				}
			}
		}
	}
}
