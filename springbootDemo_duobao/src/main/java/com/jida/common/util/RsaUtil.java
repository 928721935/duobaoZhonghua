package com.jida.common.util;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class RsaUtil {

    //私钥
    public String getPrivateKey() {
        return "aaa";
    }

    //私钥解密
    public String decryptByPrikey(String data, String privateKey) {
        byte[] priKey = decodeBase64(privateKey);
        byte[] design = null;
        try {
            String pass = URLDecoder.decode(data, "UTF-8");
            design = decryptByPrikey(Base64.decodeBase64(pass),priKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(design);
    }

    private byte[] decryptByPrikey(byte[] data,byte[] priKey) throws Exception{
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(priKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,privateKey);
        return cipher.doFinal(data);
    }

    private byte[] decodeBase64(String key) {
        return Base64.decodeBase64(key);
    }
}
