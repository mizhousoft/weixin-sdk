package com.mizhousoft.weixin.cipher.impl;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.mizhousoft.weixin.cipher.PrivacyDecryptor;
import com.mizhousoft.weixin.common.WXException;

/**
 * 敏感信息解密器
 *
 */
public class RSAPrivacyDecryptor implements PrivacyDecryptor
{
	private PrivateKey privateKey;

	public RSAPrivacyDecryptor(PrivateKey privateKey)
	{
		this.privateKey = privateKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String decrypt(String ciphertext) throws WXException
	{
		try
		{
			Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");

			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)), StandardCharsets.UTF_8);
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			throw new IllegalArgumentException("The current Java environment does not support RSA.", e);
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
