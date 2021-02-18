package com.jida.common.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;

public class AESUtil {
	private static int AES128KEY_LENGTH = 16;
//	private static int AES128KEY_LENGTH = 16;
	private static final String KEY_ALGORITHM = "AES";

	private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	private static final String KEY = "fFK/B5sFXeITk6cXV5rTNA==";

	public static Key toKey(byte[] key) throws Exception {
		key = Arrays.copyOf(key,AES128KEY_LENGTH);
		return new SecretKeySpec(key, KEY_ALGORITHM);
	}

	public static String encrypt(String data, String key) throws Exception {
		Key k = toKey(key.getBytes());


		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

		cipher.init(Cipher.ENCRYPT_MODE, k);
		byte[] bytes = cipher.doFinal(data.getBytes());
		return byteToHexStr(bytes);
	}

	public static String decrypt(String data, String key) throws Exception {
		Key k = toKey(key.getBytes());
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

		cipher.init(Cipher.DECRYPT_MODE, k);
		byte[] bytes = hexStrToByte(data);
		return new String(cipher.doFinal(bytes));
	}

	public static String encrypt(String data) {
		try {
			return encrypt(data, KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String data){
		try {
			return decrypt(data, KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String byteToHexStr(byte[] bytes){
		if(bytes==null){
			return null;
		}
		return Hex.encodeHexString(bytes,true);
	}

	public static byte[] hexStrToByte(String str){
		if(str==null){
			return null;
		}
		try {
			return Hex.decodeHex(str.toCharArray());
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String aa = "fsa反抗军";
		String bb = encrypt(aa);
		System.out.println(bb);
		System.out.println(decrypt(bb));
	}
}
