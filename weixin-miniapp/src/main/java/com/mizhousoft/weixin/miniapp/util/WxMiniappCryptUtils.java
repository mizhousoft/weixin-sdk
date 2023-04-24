package com.mizhousoft.weixin.miniapp.util;

import java.security.AlgorithmParameters;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.util.PKCS7Encoder;

/**
 * 解密工具类
 *
 */
public abstract class WxMiniappCryptUtils
{
	/**
	 * AES解密.
	 *
	 * @param sessionKey session_key
	 * @param encryptedData 消息密文
	 * @param ivStr iv字符串
	 * @throws WXException
	 */
	public static String decrypt(String sessionKey, String encryptedData, String ivStr) throws WXException
	{
		try
		{
			AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
			params.init(new IvParameterSpec(Base64.decodeBase64(ivStr)));

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Base64.decodeBase64(sessionKey), "AES"), params);

			byte[] bytes = PKCS7Encoder.decode(cipher.doFinal(Base64.decodeBase64(encryptedData)));

			return new String(bytes, CharEncoding.UTF8);
		}
		catch (Exception e)
		{
			throw new WXException("Decrypt data failed.", e);
		}
	}
}
