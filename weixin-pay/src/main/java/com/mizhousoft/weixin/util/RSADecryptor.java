package com.mizhousoft.weixin.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.mizhousoft.weixin.common.WXException;

/**
 * RSA解密
 *
 */
public abstract class RSADecryptor
{
	private static Cipher cipher;

	public static void init()
	{
		try
		{
			cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			throw new IllegalArgumentException("The current Java environment does not support RSA.", e);
		}
	}

	public static String decrypt(String cipherText, PrivateKey privateKey) throws WXException
	{
		try
		{
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)), StandardCharsets.UTF_8);
		}
		catch (InvalidKeyException e)
		{
			throw new WXException("The given private key is invalid for decryption", e);
		}
		catch (BadPaddingException | IllegalBlockSizeException e)
		{
			throw new WXException("Decryption failed", e);
		}
	}
}
