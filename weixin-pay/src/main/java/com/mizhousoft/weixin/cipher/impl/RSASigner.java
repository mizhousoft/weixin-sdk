package com.mizhousoft.weixin.cipher.impl;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import com.mizhousoft.weixin.cipher.Signer;
import com.mizhousoft.weixin.common.WXException;

/**
 * 签名
 *
 */
public class RSASigner implements Signer
{
	public static String ALGORITHM = "SHA256-RSA2048";

	public static String SHA256WITHRSA = "SHA256withRSA";

	private PrivateKey privateKey;

	public RSASigner(PrivateKey privateKey)
	{
		this.privateKey = privateKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String sign(String message) throws WXException
	{
		try
		{
			Signature signature = Signature.getInstance(SHA256WITHRSA);
			signature.initSign(privateKey);
			signature.update(message.getBytes(StandardCharsets.UTF_8));
			byte[] sign = signature.sign();

			return Base64.getEncoder().encodeToString(sign);
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new WXException("The current Java environment does not support " + SHA256WITHRSA, e);
		}
		catch (InvalidKeyException e)
		{
			throw new WXException(SHA256WITHRSA + " signature uses an illegal privateKey.", e);
		}
		catch (SignatureException e)
		{
			throw new WXException("An error occurred during the sign process.", e);
		}
	}
}
