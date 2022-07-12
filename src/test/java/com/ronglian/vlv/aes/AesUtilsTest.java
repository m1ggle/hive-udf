package com.ronglian.vlv.aes;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class AesUtilsTest {
	
	@Test
	public void encryptTest() {
		
		String content = "volvo数据加密";
		String passKey = "https://ronglian.com";
		AesUtils utils = new AesUtils();
		byte[] byteContent;
		byte[] encrypt = null;
		try {
			
			byteContent = content.getBytes("UTF-8");
			encrypt = utils.encrypt(byteContent, passKey, null, CryptoType.AES_256, EncodeType.AES_DEFAULT);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String encodeStr = TypeConvert.bytesToHexString(encrypt);
		System.out.println("明文是：" + content);
		System.out.println("加密后是：" + encodeStr);
		//EC28507A4661CC1B7E6B1846F9B934D443DDF66BC8813E6261651D6A22DEE949
		byte[] decrypt = utils.decrypt(encrypt, passKey, null, CryptoType.AES_256, EncodeType.AES_DEFAULT);
		String decryptStr = TypeConvert.bytesToHexString(decrypt);
		
		System.out.println("解密后是：" + TypeConvert.hexStr2Str(decryptStr));
		
	}

}
