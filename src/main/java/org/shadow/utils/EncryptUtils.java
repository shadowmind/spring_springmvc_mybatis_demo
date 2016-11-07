package org.shadow.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptUtils {
	private static final Logger log = LoggerFactory.getLogger(EncryptUtils.class);

	private static final String MD5 = "MD5";

	private static final String SHA1 = "SHA1";

	private static final String DEFAULT_SALT = "org.shadow";

	public static String toMD5String(String text, String salt) {
		return encrypt(text, salt, MD5);
	}

	public static String toSHA1String(String text, String salt) {
		return encrypt(text, salt, SHA1);
	}

	private static String encrypt(String text, String salt, String algo) {
		if (salt == null || salt.trim().isEmpty()) {
			salt = DEFAULT_SALT;
		}

		StringBuilder sb = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algo);

			byte[] bytes = md.digest((text + salt).getBytes("UTF-8"));

			sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				String s = Integer.toHexString(bytes[i] & 0xFF);
				sb.append(s.length() == 1 ? (s + "F") : s);
			}

		} catch (NoSuchAlgorithmException e) {
			log.error(algo + "加密失败", e);
		} catch (UnsupportedEncodingException e) {
			log.error(algo + "加密失败", e);
		}

		return sb.toString().toUpperCase();
	}
}
