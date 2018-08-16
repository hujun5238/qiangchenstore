/*  
 * @(#)IBaseService.java     1.0 2011/05/31      
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
package com.zzz.testweb.system.db;

import java.util.List;

@SuppressWarnings("unchecked")
/**
 * Service鍩虹被鎺ュ彛
 * 
 * @author huzd
 * @version 1.0 2010.04.12
 */
public interface IBaseDao {

	/**
	 * 鍙栧緱澶氫釜缁撴灉闆�
	 * 
	 * @param ob
	 *            Object
	 * @return List
	 */
	public List getList(Object ob);

	/**
	 * 鍙栧緱缁撴灉闆嗕欢鏁�
	 * 
	 * @param ob
	 *            Object
	 * @return List
	 */
	public Integer getSum(Object ob);

	/**
	 * 鍙栧緱鍗曚釜缁撴灉闆�
	 * 
	 * @param ob
	 *            Object
	 * @return Object
	 */
	public Object get(Object ob);

	/**
	 * 鎻掑叆涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 */
	public void save(Object ob);

	/**
	 * 鎻掑叆涓�缁勬暟鎹苟杩斿洖涓�涓嚜澧為暱id
	 * 
	 * @param ob
	 *            Object
	 * @return int
	 */
	public int saveBackId(Object ob);

	/**
	 * 鍒犻櫎涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @return int
	 */
	public int remove(Object ob);

	/**
	 * 鏇存柊涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @return int
	 */
	public int update(Object ob);

	/**
	 * 鎵ц涓�涓瓨鍌ㄨ繃绋嬶紝鏌ヨ骞跺彇寰楃粨鏋滈泦
	 * 
	 * @param ob
	 *            Object
	 * @return Object
	 */
	public Object getProcs(Object ob);

	/**
	 * 鎵ц涓�涓瓨鍌ㄨ繃绋嬶紝鏇存柊DB鏁版嵁
	 * 
	 * @param ob
	 *            Object
	 * @return Object
	 */
	public Object updateProcs(Object ob);

	/**
	 * 鍙栧緱绯荤粺鏃堕棿
	 * 
	 * @return String
	 */
	public String getSYSDate();
}
