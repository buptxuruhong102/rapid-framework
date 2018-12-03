package com.jd.springmvcbase.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * DES加密解密，可对文件及字符串加密、解密
 * 其中，字符串加密解密用到了Base64编码
 * 文件加密是针对文件流的加解密
 * 
 * 使用方式是new DESUtil("可见的密钥")
 * 
 * @author luyan3
 *
 */
public class DESUtil {
	
	private static final Logger log = Logger.getLogger(DESUtil.class);
	private static final String STR_KEY = "1RmnGiuzp1iomKP1ZPOJE8";
	private static SecretKey key;

	/**
	 * 根据参数生成 KEY
	 */
	static {
		try {
			DESKeySpec desKeySpec = new DESKeySpec(STR_KEY.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			key = keyFactory.generateSecret(desKeySpec);
			if (key == null) {
				KeyGenerator _generator = KeyGenerator.getInstance("DES");
				_generator.init(new SecureRandom(STR_KEY.getBytes()));
				key = _generator.generateKey();
				_generator = null;
			}
		} catch (Exception e) {
			log.error("生成DES密钥失败", e);
			e.printStackTrace();
		}
	}

	/**
	 * 加密 String 明文输入 ,String 密文输出
	 */
	public static String encryptStr(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		try {
			byteMing = strMing.getBytes("UTF-8");
			byteMi = encryptByte(byteMing);
			strMi = new String(Base64.encodeBase64(byteMi), "UTF-8");
		} catch (Exception e) {
			log.error("对字符串DES加密失败", e);
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以 String 密文输入 ,String 明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public static String decryptStr(String strMi) {
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = Base64.decodeBase64(strMi.getBytes("UTF-8"));
			byteMing = decryptByte(byteMi);
			strMing = new String(byteMing, "UTF-8");
		} catch (Exception e) {
			log.error("对字符串DES解密失败", e);
			e.printStackTrace();
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以 byte[] 明文输入 ,byte[] 密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private static byte[] encryptByte(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			log.error("对byte数组DES加密失败", e);
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以 byte[] 密文输入 , 以 byte[] 明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private static byte[] decryptByte(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			log.error("对byte数组DES解密失败", e);
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}


	public static void main(String[] args) throws Exception {
		String str1 = "COC向广告平台推送test";
		// DES 加密字符串
		String str2 = DESUtil.encryptStr("admin");
		// DES 解密字符串
		String deStr = DESUtil.decryptStr("admin");
		System.out.println(" 加密前： " + str1);
		System.out.println(" 加密后： " + str2);
		System.out.println(" 解密后： " + deStr);
	}
}
