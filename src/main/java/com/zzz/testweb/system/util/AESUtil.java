package com.zzz.testweb.system.util;


import java.io.UnsupportedEncodingException;  
import java.security.Key;    
import java.security.Security;  

import javax.crypto.Cipher;
import javax.crypto.SecretKey;    
import javax.crypto.spec.SecretKeySpec;   


/**  
 * AES加密工具类  
 */  
public class AESUtil {
	public static final String PASSWORD = "witposmobilewitposmobile";  

    // 加解密统一使用的编码方式   
    private final static String encoding = "utf-8";   

	public static String encrypt(String dataPassword, String cleartext)
			throws Exception {
		SecretKeySpec key = getKey(dataPassword);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedData = cipher.doFinal(cleartext.getBytes(encoding));

		return new String(Base64.encodeUrlSafe(encryptedData), encoding);
	}

	public static String decrypt(String dataPassword, String encrypted)
			throws Exception {

		SecretKeySpec key = getKey(dataPassword);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] byteMi = Base64.decodeUrlSafe(encrypted.getBytes(encoding));
		byte[] decryptedData = cipher.doFinal(byteMi);

		return new String(decryptedData, encoding);
	}
	
	
	private static SecretKeySpec getKey(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes();
        byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）

        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");

        return skeySpec;
    }


	public static void main(String[] args) throws Exception {
        String Code = "中文ABc123";
        //String key = "1q2w3e4r";
        String key = PASSWORD;
        String codE;

        codE = AESUtil.encrypt(key, Code);

        System.out.println("原文：" + Code);
        System.out.println("密钥：" + key);
        System.out.println("密文：" + codE);
        System.out.println("解密：" + AESUtil.decrypt(key, codE));
    }


}