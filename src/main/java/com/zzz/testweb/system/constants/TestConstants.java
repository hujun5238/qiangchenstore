/*  
 * @(#)CherryConstants.java     1.0 2011/05/31      
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
package com.zzz.testweb.system.constants;

public class TestConstants {
	
	// ====================== ibatis相关 ============================ //
	/** SqlIDkey */
	public static final String IBATIS_SQL_ID = "ibatis_sql_id";	
	
	/** 批处理一页最大数 */
	public final static int BATCH_PAGE_MAX_NUM = 5000;
	
	// ====================== session中存放数据使用的常量key ============================ //	
	/** 用户信息key */
	public static final String SESSION_USERINFO = "userinfo";
	/** 语言key */
	public static final String SESSION_LANGUAGE = "language";
	
	/** 语言key */
	public static final String SESSION_CHERRY_LANGUAGE = "cherry_language";
	
	/** 语言key 中文*/
	public static final String SESSION_LANGUAGE_CN = "zh_CN";
	
	/** 语言key 英文*/
	public static final String SESSION_LANGUAGE_EN = "en_US";
	
	/** 打印状态：已打印 */
	public static final int PRINT_STATUS_1= 1;
	
	public static final String CHAR_ENCODING = "UTF-8";
	
	public static final String CHAR_ENCODING_ISO = "ISO8859-1";
	
	public static final String CHAR_ENCODING_GBK = "GBK";
	
	/** 逗号 */
	public static final String COMMA = ",";

	/** 空字符串 */
	public static final String BLANK = "";
	
	/** 点 */
	public static final String POINT = ".";
	
	/** 空格 */
	public static final String SPACE = " ";
	
	/** 下划线 */
	public static final String UNLINE = "_" ;
	 
	/** 斜线 */
	public static final String SLASH  = "/" ;
	
	/** 日期格式 */
	public static final String DATE_PATTERN = "yyyy-MM-dd" ;
	
	/** 日期格式 yyyyMMdd*/
	public static final String DATE_YYMMDD = "yyyyMMdd" ;
	
	/** 日期格式(年月) */
	public static final String DATEYYYYMM = "yyyyMM" ;
	
	/** 日期格式(24小时制) */
	public static final String DATE_PATTERN_24_HOURS = "yyyy-MM-dd HH:mm:ss" ;
	
	/** 日期 */
	public static final String DATE = "date" ;
	
	/** 年 */
	public static final String YEAR = "year" ;
	
	/** 月 */
	public static final String MONTH = "month" ;
	
	/** 日 */
	public static final String DAY = "day" ;
	
	/** 有效期默认年限 */
	public static final int USEFUL_LIFE  = 100 ;
	
	/** 上传图片的最大M数*/
	public static final int IMAGE_MAX_SIZE = 2;
	
	/** 上传图片的类型*/
	public static final String IMAGE_TYPES = "jpg,gif,jpeg,png,bmp";
	
	/** 上传文件的结果(失败)*/
	public static final String result_NG = "NG";
	
	/** 上传文件的结果(成功)*/
	public static final String result_OK = "OK";
	
	/** 复制文件最大传输字节数*/
	public static final int COPYFILE_MAX_SIZE = 2097152;
	// ====================== struts2配置相关 ============================ //	
	/** 全局错误*/
	public static final String GLOBAL_ERROR = "globalError";
	/** action执行结果（错误，成功，字段校验错误）*/
	public static final String GLOBAL_ACCTION_RESULT = "globalAcctionResult";
	/** action执行结果（错误，成功）替换整张页面 */
	public static final String GLOBAL_ACCTION_RESULT_BODY = "globalAcctionResultBody";
	/** action执行结果（错误，成功）替换DIALOG指定的DIV */
	public static final String GLOBAL_ACCTION_RESULT_DIALOG = "globalAcctionResultDialog";
	/** action执行结果（错误，成功）替换整张页面,并刷新父页面 */
	public static final String GLOBAL_ACCTION_RESULT_PAGE = "globalAcctionResultPage";
	/** 登录画面*/
	public static final String GLOBAL_LOGIN = "globalLogin";
	

}
