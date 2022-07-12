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
value = "_FUNC_(<data_string>) - Returns decrypted words ",
extended = "Example:\n >SELECT _FUNC_(emails) FROM src LIMIT 1;\n  EC28507A4661CC1B7E6B1846F9B934D443DDF66BC8813E6261651D6A22DEE949")
public class DecryptUDF  extends UDF{

	public String evaluate(String content) throws HiveException {
		AesUtils utils = new AesUtils();
		byte[] decryptBytes = null;
		//TODO 密钥有设计规则
		String key = null;
        try {
            if(StringUtils.isEmpty(content)) {
            	byte[] contentBytes = TypeConvert.hexStringToBytes(content);
            	decryptBytes = utils.decrypt(
            			contentBytes, 
						key, 
						null, 
						CryptoType.AES_256, 
						EncodeType.AES_DEFAULT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String decryptStr = TypeConvert.bytesToHexString(decryptBytes);
        String decryptString = TypeConvert.hexStr2Str(decryptStr);
        return decryptString;
    }

    public String getDisplayString(String[] strings) {
        return " Usage : using AES to decrypting datas ";
    }

}
