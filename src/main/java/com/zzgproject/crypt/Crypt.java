package com.zzgproject.crypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class Crypt {

	public static SecretKey key;
	public static String MD5Token;
	public static String DESKey = "pytgames1234";
	static {
		try {
			/**
			 * 不走配置文件
			 */
			DESKeySpec dks = new DESKeySpec(DESKey.getBytes());
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	        key = keyFactory.generateSecret(dks);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		String password="kL0S0pDMUyM=";
		System.out.println(Crypt.decryptByDES(password));
		System.out.println(Crypt.encryptToDES("2222"));
	}

	/**
	 * 创建密匙
	 * @param algorithm 加密算法, 可用 DES, DESede, Blowfish
	 * @return SecretKey 秘密（对称）密钥
	 */
	public static SecretKey createSecretKey(String algorithm) {
		// 声明KeyGenerator对象
		KeyGenerator keygen;
		// 声明 密钥对象
		SecretKey deskey = null;
		try {
			// 返回生成指定算法的秘密密钥的 KeyGenerator 对象
			keygen = KeyGenerator.getInstance(algorithm);
			// 生成一个密钥
			deskey = keygen.generateKey();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 返回密匙
		return deskey;
	}

	/**
	 * 根据密匙进行DES加密
	 * @param key 密匙
	 * @param info 要加密的信息
	 * @return String 加密后的信息
	 */
	public static String encryptToDES(SecretKey key, String info) {
		// 定义 加密算法,可用 DES,DESede,Blowfish
		String Algorithm = "DES";
		// 定义要生成的密文
		byte[] cipherByte = null;
		try {
			// 得到加密/解密器
			Cipher c1 = Cipher.getInstance(Algorithm);
			// 用指定的密钥和模式初始化Cipher对象
			// 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)
			c1.init(Cipher.ENCRYPT_MODE, key);
			// 对要加密的内容进行编码处理,
			cipherByte = c1.doFinal(info.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回密文的十六进制形式
		return new String(Base64.encode(cipherByte));
	}

	public static String encryptToDES(String info) {
		return encryptToDES(key, info);
	}

	public static String decryptByDES(String sInfo) {
		return decryptByDES(key, sInfo);
	}

	/**
	 * 根据密匙进行DES解密
	 * @param key 密匙
	 * @param sInfo 要解密的密文
	 * @return String 返回解密后信息
	 */
	public static String decryptByDES(SecretKey key, String sInfo) {
		// 定义 加密算法,
		String Algorithm = "DES";
		byte[] cipherByte = null;
		try {
			// 得到加密/解密器
			Cipher c1 = Cipher.getInstance(Algorithm);
			// 用指定的密钥和模式初始化Cipher对象
			c1.init(Cipher.DECRYPT_MODE, key);
			// 对要解密的内容进行编码处理
			cipherByte = c1.doFinal(Base64.decode(sInfo.getBytes("UTF-8")));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return new String(cipherByte);
	}

}
