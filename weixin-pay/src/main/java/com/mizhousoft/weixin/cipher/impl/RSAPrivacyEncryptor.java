package com.mizhousoft.weixin.cipher.impl;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.mizhousoft.weixin.cipher.PrivacyEncryptor;
import com.mizhousoft.weixin.common.WXException;

/**
 * RSA敏感信息加密器
 *
 */
public class RSAPrivacyEncryptor implements PrivacyEncryptor
{
	private final PublicKey publicKey;

	public RSAPrivacyEncryptor(PublicKey publicKey)
	{
		this.publicKey = publicKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encrypt(String plaintext) throws WXException
	{
		try
		{
			Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");

			cipher.init(Cipher.ENCRYPT_MODE, publicKey);

			return Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8)));
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			throw new IllegalArgumentException("The current Java environment does not support RSA.", e);
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
