package com.zzz.testweb.system.util;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**  
 * 3DES加密工具类  
 */  
public class Des3Util {   
    // 密钥   
   // private final static String secretKey = "witposmobilewitposmobilw";   
    // 向量   
    private final static String iv = "01234567";   
    // 加解密统一使用的编码方式   
    private final static String encoding = "utf-8";   
  
    /**  
     * 3DES加密  
     *   
     * @param plainText 普通文本  
     * @return  
     * @throws Exception   
     */  
    public static String encode(String plainText,String strKey) throws Exception { 
        Key deskey = null;   
        DESedeKeySpec spec = new DESedeKeySpec(getSecretKey(strKey));   
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");   
        deskey = keyfactory.generateSecret(spec);   
  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");   
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());   
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);   
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        
        //return Base64.encode(encryptData); -- '+' error
        System.out.println(new String(Base64.encodeUrlSafe(encryptData), encoding));
        return new String(Base64.encodeUrlSafe(encryptData), encoding);
    }   
    
    /**  
     * 3DES解密  
     *   
     * @param encryptText 加密文本  
     * @return  
     * @throws Exception  
     */  
    public static String decode(String encryptText,String strKey) throws Exception {   
        Key deskey = null;   
        DESedeKeySpec spec = new DESedeKeySpec(getSecretKey(strKey));   
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");   
        deskey = keyfactory.generateSecret(spec);   
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");   
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());   
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);   
        
        byte[] encryptData = encryptText.getBytes(encoding);   
        byte[] decryptData = cipher.doFinal(Base64.decodeUrlSafe(encryptData));
        //byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));
        
        return new String(decryptData, encoding);
    }   

    /**
     * 得到密钥
     * @param key
     * @return
     */
    public static byte[] getSecretKey(String key){
    	String secretKey="";
    	if(key.length() >= 24){
    		secretKey = key.substring(0, 24);
		}else{//小于24位补充
			StringBuffer buffer = new StringBuffer(key);
			for (int i = 0; i < 24; i++) {
				buffer.append(key);
				if(buffer.length() >= 24){
					break;
				}
			}
			secretKey = buffer.substring(0, 24);
		}
    	return secretKey.getBytes();

    }
    
public static void main(String[] args) throws Exception {  
	   
//	    //明文   
//	    //String ming = "www.baidu.com";  
//	    String ming = "{\"TradeType\":\"GetCountersByGPS\",\"brandId\":10,\"longitude\":\"121.544078\",\"latitude\":\"31.250094\",\"km\":10}"; 
////	    Map<String, Object> paramMap = new HashMap<String, Object>();
////		paramMap.put("mobilePhone", "XXs473A27MdHVBOs9cDkfw==");
////		paramMap.put("nameCn", "uuuuuo");
////		paramMap.put("sex", 2);
////		paramMap.put("memberCode", "00002");
////		System.err.println(MobileUtil.map2Json(paramMap));  
////		String param = MobileUtil.map2Json(paramMap);
//	    //加密后的密文   
//	    String mi = Des3Util.encode(ming,secretKey);  
//	    System.err.println(mi);  
//	   // ming = ming + mi;
//	   // System.err.println(ming);  
//	    //解密后的明文   
//
//	    ming = Des3Util.decode(mi,secretKey);  
//	    System.err.println(ming);  
	    
	System.out.println(new String(getSecretKey("witposmobilewitposmobil")));
	    
	    
    }  
}  