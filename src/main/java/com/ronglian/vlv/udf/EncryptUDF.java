package com.ronglian.vlv.udf;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.metadata.HiveException;

import com.ronglian.vlv.aes.AesUtils;
import com.ronglian.vlv.aes.CryptoType;
import com.ronglian.vlv.aes.EncodeType;
import com.ronglian.vlv.aes.TypeConvert;

@SuppressWarnings("deprecation")
@Description(name = "maskEmail",
value = "_FUNC_(<data_string>) - Returns encrypted words ",
extended = "Example:\n >SELECT _FUNC_(emails) FROM src LIMIT 1;\n  EC28507A4661CC1B7E6B1846F9B934D443DDF66BC8813E6261651D6A22DEE949")
public class EncryptUDF  extends UDF{

	public String evaluate(String content) throws HiveException {
		AesUtils utils = new AesUtils();
		byte[] encryptBytes = null;
		//TODO 密钥有设计规则
		String key = null;
        try {
            if(StringUtils.isEmpty(content)) {
                
				encryptBytes = utils.encrypt(
						content.getBytes("UTF-8"), 
						key, 
						null, 
						CryptoType.AES_256, 
						EncodeType.AES_DEFAULT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String encryptString = TypeConvert.bytesToHexString(encryptBytes);
        
        return encryptString;
    }

    public String getDisplayString(String[] strings) {
        return " Usage : using AES to encrypting datas ";
    }

}
