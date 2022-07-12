package com.ronglian.vlv.aes;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtils {

	/**
	 * AES 256加密
	 * @param byteContent 明文的byte[]字节数组
	 * @param key 密钥
	 * @param iv 向量，采用CBC方式加密时明文必须是16字节同时必须提供初始向量IvParameterSpec
	 * @param type 加密方式，提供AES256，具体参见CryptoType.java
	 * @param modeAndPadding 具体参见EncodeType.java 加密解密算法/加密模式/填充方式
	 * @return 加密后的字节数据
	 */
	public byte[] encrypt(byte[] byteContent, String key,byte[] iv, CryptoType type, String modeAndPadding){
    	byte[] encryptByte = null;
    	KeyGenerator kgen;
		try {
			kgen = KeyGenerator.getInstance("AES");
		    //增加次数，防止在Linux下报错
	        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
	        random.setSeed(key.getBytes());
	        kgen.init(type.value, random);
	        SecretKey secretKey = kgen.generateKey();
	        byte[] enCodeFormat = secretKey.getEncoded();
	        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
	        //创建密码
	        Cipher cipher = Cipher.getInstance(modeAndPadding);
	        if ( null !=iv ) {
	            //指定一个初始化向量 (Initialization vector，IV)， IV 必须是16位
	            cipher.init(1, keySpec, new IvParameterSpec(iv));
	        } else {
	            cipher.init(1, keySpec);
	        }
	        encryptByte = cipher.doFinal(byteContent);
		} catch (InvalidKeyException 
				| NoSuchAlgorithmException
				| InvalidAlgorithmParameterException
				| NoSuchPaddingException
				| BadPaddingException
				| IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		return encryptByte;
    }

	/**
	 * AES 256 解密
	 * @param byteContent 密文的byte[]字节数组
	 * @param key 密钥
	 * @param iv 向量，采用CBC方式加密时明文必须是16字节同时必须提供初始向量IvParameterSpec
	 * @param type 加密方式，提供AES128、AES192、AES256，具体参见CryptoType.java
	 * @param modeAndPadding 具体参见EncodeType.java 加密解密算法/加密模式/填充方式
	 * @return 解密后的字节数据
	 */
    public byte[] decrypt(byte[] byteContent, String key,byte[] iv, CryptoType type, String modeAndPadding){
    	byte[] decryptByte = null;
    	KeyGenerator kgen;
		try {
			kgen = KeyGenerator.getInstance("AES");
		    //增加次数，防止在Linux下报错
	        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
	        random.setSeed(key.getBytes());
	        kgen.init(type.value, random);
	        SecretKey secretKey = kgen.generateKey();
	        byte[] enCodeFormat = secretKey.getEncoded();
	        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
	        //创建密码
	        Cipher cipher = Cipher.getInstance(modeAndPadding);
	        if ( null != iv ) {
	            //指定一个初始化向量 (Initialization vector，IV)， IV 必须是16位
	            cipher.init(javax.crypto.Cipher.DECRYPT_MODE , keySpec, new IvParameterSpec(iv));
	        } else {
	            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, keySpec);
	        }
	        decryptByte = cipher.doFinal(byteContent);
		} catch (InvalidKeyException 
				| NoSuchAlgorithmException
				| InvalidAlgorithmParameterException
				| NoSuchPaddingException
				| BadPaddingException
				| IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		return decryptByte;
    }
}
