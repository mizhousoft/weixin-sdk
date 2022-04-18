package com.mizhousoft.weixin.mp.util;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.util.PKCS7Encoder;

/**
 * 工具类
 *
 * @version
 */
public abstract class WxMpCryptUtils
{
	public static String sha1Sign(String... values)
	{
		Arrays.sort(values);

		StringBuilder sb = new StringBuilder();
		for (String a : values)
		{
			sb.append(a);
		}

		return DigestUtils.sha1Hex(sb.toString());
	}

	public static String decrypt(String cipherText, byte[] aesKey) throws WXException
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
			cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

			byte[] encrypted = Base64.decodeBase64(cipherText);
			byte[] original = cipher.doFinal(encrypted);
			byte[] bytes = PKCS7Encoder.decode(original);

			int xmlLength = 0;
			byte[] rangeBytes = Arrays.copyOfRange(bytes, 16, 20);
			for (int i = 0; i < 4; i++)
			{
				xmlLength <<= 8;
				xmlLength |= rangeBytes[i] & 0xff;
			}

			String result = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CharEncoding.UTF8);
			return result;
		}
		catch (Exception e)
		{
			throw new WXException("Decrypt xml failed.", e);
		}
	}

	public static String encrypt(String randomStr, String text, String appId, byte[] aesKey) throws WXException
	{
		ByteGroup byteCollector = new ByteGroup();

		byte[] randomStrBytes = randomStr.getBytes(CharEncoding.UTF8);
		byte[] textBytes = text.getBytes(CharEncoding.UTF8);
		byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
		byte[] appidBytes = appId.getBytes(CharEncoding.UTF8);

		// randomStr + networkBytesOrder + text + appid
		byteCollector.addBytes(randomStrBytes);
		byteCollector.addBytes(networkBytesOrder);
		byteCollector.addBytes(textBytes);
		byteCollector.addBytes(appidBytes);

		// ... + pad: 使用自定义的填充方式对明文进行补位填充
		byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
		byteCollector.addBytes(padBytes);

		// 获得最终的字节流, 未加密
		byte[] unencrypted = byteCollector.toBytes();

		try
		{
			// 设置加密模式为AES的CBC模式
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

			// 加密
			byte[] encrypted = cipher.doFinal(unencrypted);

			// 使用BASE64对加密后的字符串进行编码
			String base64Encrypted = Base64.encodeBase64String(encrypted);

			return base64Encrypted;
		}
		catch (Exception e)
		{
			throw new WXException("Encrypt value failed.", e);
		}
	}

	private static byte[] getNetworkBytesOrder(int sourceNumber)
	{
		byte[] orderBytes = new byte[4];
		orderBytes[3] = (byte) (sourceNumber & 0xFF);
		orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
		orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
		orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
		return orderBytes;
	}
}
