package com.zzz.testweb.system.util; 

import java.io.UnsupportedEncodingException; 
import java.security.Key;  
import java.security.Security; 

import javax.annotation.Resource;
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

//import com.witposmobile.business.interfaces.ProductInfo_IF;


public class AES256Util {  

//	@Resource(name = "productInfoLogic")
//	private ProductInfo_IF productInfoLogic;
	
	 private final static String encoding = "utf-8";
	 public static final String PASSWORD = "witposmobilewitposmobil";//加密,解密时用的密钥(自定义)
	 
	 static{
		  try{
			  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); 
		  }catch(Exception e){
		   e.printStackTrace();
		  }
		 }


	 
         /** 
         * 密钥算法 
         * java6支持56位密钥，bouncycastle支持64位 
         * */  
        public static final String KEY_ALGORITHM="AES";  
        private final static String KEY_GENERATION_ALG = "PBKDF2WithHmacSHA1";
    	private final static int HASH_ITERATIONS = 10000;
    	private final static int KEY_LENGTH = 256;
    	private static char[] humanPassphrase = { 'P', 'e', 'r', ' ', 'v', 'a', 'l', 'l',
    			'u', 'm', ' ', 'd', 'u', 'c', 'e', 's', ' ', 'L', 'a', 'b', 'a',
    			'n', 't' };
    	private static byte[] salt = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xA, 0xB, 0xC, 0xD,
    			0xE, 0xF }; // must save this for next time we want the key
    	
    	
        /** 
         * 加密/解密算法/工作模式/填充方式 
         *  
         * JAVA6 支持PKCS5PADDING填充方式 
         * Bouncy castle支持PKCS7Padding填充方式 
         * */  
        public static final String CIPHER_ALGORITHM="AES/ECB/PKCS7Padding";
    	private static PBEKeySpec myKeyspec = new PBEKeySpec(humanPassphrase, salt,
    			HASH_ITERATIONS, KEY_LENGTH);
    	private static SecretKeyFactory keyfactory = null;
    	private static SecretKey sk = null;
    	private static SecretKeySpec skforAES = null;
        /** 
         *  
         * 生成密钥，java6只支持56位密钥，bouncycastle支持64位密钥 
         * @return byte[] 二进制密钥 
         * */  
        public static String initkey() throws Exception {  

          //实例化密钥生成器  
          Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); 
          KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM, "BC");  
          //初始化密钥生成器，AES要求密钥长度为128位、192位、256位  
            kg.init(256);  
          //kg.init(128); 
          //生成密钥  
          SecretKey secretKey=kg.generateKey();  
          //获取二进制密钥编码形式  
          return secretKey.getEncoded().toString();  
            //为了便于测试，这里我把key写死了，如果大家需要自动生成，可用上面注释掉的代码 
//            return new byte[] { 0x08, 0x08, 0x04, 0x0b, 0x02, 0x0f, 0x0b, 0x0c, 
//                    0x01, 0x03, 0x09, 0x07, 0x0c, 0x03, 0x07, 0x0a, 0x04, 0x0f, 
//                    0x06, 0x0f, 0x0e, 0x09, 0x05, 0x01, 0x0a, 0x0a, 0x01, 0x09, 
//                    0x06, 0x07, 0x09, 0x0d }; 
        } 
        
        /** 
         * 转换密钥 
         * @param key 二进制密钥 
         * @return Key 密钥 
         * */  
        public static Key toKey(String strKey) throws Exception{  
//        	byte[] arrBTmp = strKey.getBytes();
//            byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）
//
//            for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
//                arrB[i] = arrBTmp[i];
//            }
            char[] charArray=strKey.toCharArray();
        	 PBEKeySpec keyspec = new PBEKeySpec(charArray, salt,
         			HASH_ITERATIONS, KEY_LENGTH);
            keyfactory = SecretKeyFactory.getInstance(KEY_GENERATION_ALG);
			sk = keyfactory.generateSecret(keyspec);
            //实例化DES密钥  
            //生成密钥  
            //SecretKey secretKey=new SecretKeySpec(arrB,KEY_ALGORITHM);  
			SecretKey secretKey=new SecretKeySpec(sk.getEncoded(),KEY_ALGORITHM);
            return secretKey;  
        }  

        /** 
         * 加密数据 
         * @param data 待加密数据 
         * @param key 密钥 
         * @return byte[] 加密后的数据 
         * */  
        public static String encrypt(String data,String strKey) throws Exception{  
            //还原密钥  
            Key k=toKey(strKey);  
            /** 
             * 实例化 
             * 使用 PKCS7PADDING 填充方式，按如下方式实现,就是调用bouncycastle组件实现 
             * Cipher.getInstance(CIPHER_ALGORITHM,"BC") 
             */  
            //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); 
            Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM, "BC");  
            //初始化，设置为加密模式  
            cipher.init(Cipher.ENCRYPT_MODE, k);   
            byte[] encryptedData = cipher.doFinal(data.getBytes(encoding));
            return new String(Base64.encodeUrlSafe(encryptedData), encoding); 
        }
        
        /** 
         * 解密数据 
         * @param data 待解密数据 
         * @param key 密钥 
         * @return byte[] 解密后的数据 
         * */  
        public static String decrypt(String data,String strKey) throws Exception{  
            //还原密钥  
            Key k =toKey(strKey);  
            /** 
             * 实例化 
             * 使用 PKCS7PADDING 填充方式，按如下方式实现,就是调用bouncycastle组件实现 
             * Cipher.getInstance(CIPHER_ALGORITHM,"BC") 
             */  
            Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM,"BC");  
            //初始化，设置为解密模式 
            cipher.init(Cipher.DECRYPT_MODE, k);  
            byte[] byteMi = Base64.decodeUrlSafe(data.getBytes(encoding));
    		byte[] decryptedData = cipher.doFinal(byteMi);
            //执行操作  
    		return new String(decryptedData, encoding); 
        }  

        /**  
         * @param args 
         * @throws UnsupportedEncodingException 
         * @throws Exception  
         */  

        public static void main(String[] args) throws UnsupportedEncodingException{  

            String str="AESDES加密解密测试";  
            System.out.println("原文："+str);  

            //初始化密钥  

            //byte[] key;
         
          //  String strkey;

            try { 
            	// strkey=AES256Util.initkey();
//                key = AES256Util.initkey(); 
//                System.out.print("密钥：");  
//
//                for(int i = 0;i<key.length;i++){ 
//                    System.out.printf("%x", key[i]); 
//                } 
//
//                System.out.print("\n"); 

                //加密数据  
                String data=AES256Util.encrypt(str, AES256Util.PASSWORD);  

                System.out.println("加密后:"+data);
//                System.out.print("加密后："); 
//                for(int i = 0;i<data.length;i++){ 
//                    System.out.printf("%x", data[i]); 
//                } 
//                System.out.print("\n"); 

                //解密数据  
                data=AES256Util.decrypt(data,AES256Util.PASSWORD);  
                System.out.println("解密后："+data);
                
            } catch (Exception e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 

            }  

        }  

    } 
