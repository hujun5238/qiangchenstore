/*  
 * @(#)DecryptionDataSource.java     1.0 2011/05/31      
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

import org.logicalcobwebs.proxool.ProxoolDataSource;

/**
 * 閲嶅啓org.logicalcobwebs.proxool.ProxoolDataSource 閲嶇疆鏁版嵁搴撳瘑鐮佷负鏄庢枃
 * 
 * @author huzd
 * 
 */
public class DecryptionDataSource extends ProxoolDataSource {
	/**
	 * 閲嶇疆鏁版嵁搴撳瘑鐮佷俊鎭负鏄庢枃
	 */
	public void setPassword(String pwd) {
		String decodePwd = DesDecode(pwd);
		super.setPassword(decodePwd);
	}
    /** 
    * @see ConnectionPoolDefinitionIF#getHouseKeepingSleepTime 
    *姝ゅ灏唅nt绫诲瀷鏀逛负long绫诲瀷 
    */  
   public void setHouseKeepingSleepTime(long houseKeepingSleepTime) {  
        super.setHouseKeepingSleepTime((int)houseKeepingSleepTime);  
   } 
    
	/**
	 * 閲嶇疆鏁版嵁搴撶敤鎴峰悕淇℃伅涓烘槑鏂�
	 */
	public void setUser(String user) {
		String decodeUser = DesDecode(user);
		super.setUser(decodeUser);
	}
	/**
	 * 閲嶇疆鏁版嵁搴撻摼鎺ュ瓧绗︿覆淇℃伅涓烘槑鏂�
	 */
	public void setDriverUrl(String url) {
		String decodeUrl = DesDecode(url);
		super.setDriverUrl(decodeUrl);
	}
	

	/* 鏍规嵁鏁版嵁搴撻厤缃枃浠跺瘑鐮佸瘑鏂囧緱鍒版槑鏂� */
	public String DesDecode(String mi) {
		String strDes ="";
		try {
			//DESPlus des = new DESPlus("binkun");//鑷畾涔夊瘑閽�
			//strDes = des.decrypt(mi);
			strDes = mi;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return strDes;
	}
	
	
	
	
}
