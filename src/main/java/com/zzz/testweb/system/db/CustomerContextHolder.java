/*
 * @(#)CustomerContextHolder.java     1.0 2010/12/10
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

import org.springframework.util.Assert;

public class CustomerContextHolder {
	// 瀛愮嚎绋嬩篃鑳藉叡浜埗绾跨▼鐨勭嚎绋嬫湰鍦板彉閲忕殑鍊�
	// private static final ThreadLocal<String> contextHolder =
	// new InheritableThreadLocal<String>();
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static void setCustomerDataSourceType(String customerDataSourceType) {
		Assert.notNull(customerDataSourceType,
				"customerDataSourceType cannot be null");
		contextHolder.set(customerDataSourceType);
	}

	public static String getCustomerDataSourceType() {
		return (String) contextHolder.get();
	}

	public static void clearCustomerDataSourceType() {
		contextHolder.remove();
	}
	
	
}
