package org.shadow.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class EncryptUtils {

	private final static Logger logger = Logger.getLogger(EncryptUtils.class);

	public static String toMD5String(String text) {
		return encrypt(text, "MD5");
	}
	
	public static String toSHA1String(String text)
	{
		return encrypt(text, "SHA1");
	}

	private static String encrypt(String text, String algo) {
		StringBuilder sb = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algo);

			byte[] bytes = md.digest(text.getBytes("UTF-8"));

			sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				String s = Integer.toHexString(bytes[i] & 0xFF);
				sb.append(s.length() == 1 ? (s + "F") : s);
			}

		} catch (NoSuchAlgorithmException e) {
			logger.error("MD5加密失败", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("MD5加密失败", e);
		}

		return sb.toString().toUpperCase();
	}
}
