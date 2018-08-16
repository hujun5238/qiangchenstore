package com.zzz.testweb.system.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SwiftNumber {
	public static Map<String,Object> map=null;
	static{
		map=new HashMap<String,Object>();
		map.put("time","");
		map.put("number", "");
	}

	/**
	   * 鏃ユ湡锛堝勾鏈堟棩鏃跺垎绉掞級+娴佹按鍙�
	   * @param time
	   * @return
	   */
	  public static String  getSwiftNumber(String nowTime){
		  synchronized(nowTime){
			  String propTime=map.get("time").toString(); 
			  String propNumber=map.get("number").toString();
			  
			  String strReturn;
			  SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			  if(nowTime.equals(propTime)){
				  String nextNum=getNumber(propNumber);
				  map.put("time",nowTime);
				  map.put("number", nextNum);
				  strReturn=nowTime+nextNum;
			  }else{
				  map.put("time",nowTime);
				  map.put("number", "001");
				  strReturn=nowTime+"001";
			  }
			  return strReturn; 
		  }
	  }
	  
	
	
	
	
	
//	  /**
//	   * 鏃ユ湡锛堝勾鏈堟棩鏃跺垎绉掞級+娴佹按鍙�
//	   * @param time
//	   * @return
//	   */
//	  public  String  getSwiftNumber(String nowTime){
//		  String propTime=null;
//		  String propNumber=null;
//		  Properties prop = new Properties(); 
//		  String filename=SwiftNumber.class.getClassLoader().getResource("conf/properties/time-number.properties").getPath();//
//	        try {  
//	        	InputStream inputStream = new FileInputStream(filename);
//	        	prop.load(inputStream);
//	            propTime=prop.getProperty("time");  
//	            propNumber=prop.getProperty("number");  
//	            inputStream.close();
//	        } catch(IOException e) {  
//	            e.printStackTrace();  
//	        }  
//		  String strReturn;
//		  SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
//		  if(nowTime.equals(propTime)){
//			  String nextNum=getNumber(propNumber);
//			  prop.setProperty("time",nowTime);
//			  prop.setProperty("number", nextNum);
//			  strReturn=nowTime+nextNum;
//			  try{
//				     OutputStream outputStream = new FileOutputStream(filename);  
//				 	 prop.store(outputStream, "properties");
//				 	outputStream.close();
//			 	  } catch (FileNotFoundException e) {
//			 	 	 e.printStackTrace();
//			 	  } catch (IOException e) {
//			 		 e.printStackTrace();
//			 	  }
//			 
//		  }else{
//			  prop.setProperty("time",nowTime);
//			  prop.setProperty("number", "001");
//			  strReturn=nowTime+"001";
//			  try {
//				    OutputStream outputStream = new FileOutputStream(filename);  
//					prop.store(outputStream, "properties");
//					outputStream.close();
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		  }
//		  return strReturn; 
//	  }
//	  
	  
	  /**
	   * 娴佹按鍙�
	   * @param strNum
	   * @return
	   */
	  public static String getNumber(String strNum){
		  String strRet;
		  if(null==strNum || "".equals(strNum)){
			  strRet="001";
		  }else{
			  //鐢变簬鍗曟嵁鍙疯鍞竴濡傛灉瓒呰繃3涓哄垯4浣�
			  int iNum=Integer.parseInt(strNum);
			  iNum++;
			  String strAfter=iNum+"";
			  int size=3-strAfter.length();
			  StringBuffer sb=new StringBuffer();
			  for(int i=0;i<size;i++){
				  sb.append("0");
			  }
			  strRet=sb.toString()+strAfter;
		  }
		  return strRet;
	  }
	  
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		for(int i=0;i<1000000;i++){	
		
			System.out.println(SwiftNumber.getSwiftNumber(format.format(new Date())));
		}
	}

}
