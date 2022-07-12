package com.ronglian.vlv.aes;

/**
 *  --定义加密类型常量
 * @author ywren
 *
 */
public class EncodeType {
	
	//默认为 ECB/PKCS5Padding
	public final static String AES_DEFAULT = "AES";
    public final static String AES_CBC_NoPadding = "AES/CBC/NoPadding";
    public final static String AES_CBC_PKCS5Padding = "AES/CBC/PKCS5Padding";
    public final static String AES_CBC_ISO10126Padding = "AES/CBC/ISO10126Padding";
    public final static String AES_CFB_NoPadding = "AES/CFB/NoPadding";
    public final static String AES_CFB_PKCS5Padding = "AES/CFB/PKCS5Padding";
    public final static String AES_CFB_ISO10126Padding = "AES/CFB/ISO10126Padding";
    public final static String AES_ECB_NoPadding = "AES/ECB/NoPadding";
    public final static String AES_ECB_PKCS5Padding = "AES/ECB/PKCS5Padding";
    public final static String AES_ECB_ISO10126Padding = "AES/ECB/ISO10126Padding";
    public final static String AES_OFB_NoPadding = "AES/OFB/NoPadding";
    public final static String AES_OFB_PKCS5Padding = "AES/OFB/PKCS5Padding";
    public final static String AES_OFB_ISO10126Padding = "AES/OFB/ISO10126Padding";
    public final static String AES_PCBC_NoPadding = "AES/PCBC/NoPadding";
    public final static String AES_PCBC_PKCS5Padding = "AES/PCBC/PKCS5Padding";
    public final static String AES_PCBC_ISO10126Padding = "AES/PCBC/ISO10126Padding";

}
