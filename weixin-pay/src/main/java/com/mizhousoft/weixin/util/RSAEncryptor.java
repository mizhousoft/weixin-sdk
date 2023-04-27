package com.mizhousoft.weixin.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.mizhousoft.weixin.common.WXException;

/**
 * 加密器
 *
 */
public abstract class RSAEncryptor
{
	private static Cipher cipher;

	public static void initCipher()
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

	public static String encrypt(String plaintext, PublicKey publicKey) throws WXException
	{
		try
		{
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);

			return Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8)));
		}
		catch (InvalidKeyException e)
		{
			throw new WXException("RSA encryption using an illegal publicKey", e);
		}
		catch (BadPaddingException | IllegalBlockSizeException e)
		{
			throw new WXException("Plaintext is too long.", e);
		}
	}
}
