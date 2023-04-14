package com.mizhousoft.weixin.payment.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Base64;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.constant.PaymentConstant;

/**
 * RSA签名
 *
 * @version
 */
public abstract class RSAUtils
{
	public static String ALGORITHM = "SHA256-RSA2048";

	public static String sign(String message, String certSerialNumber, PrivateKey privateKey) throws WXException
	{
		String algorithmName = PaymentConstant.SHA256WITHRSA;

		try
		{
			Signature signature = Signature.getInstance(algorithmName);
			signature.initSign(privateKey);
			signature.update(message.getBytes(StandardCharsets.UTF_8));
			byte[] sign = signature.sign();

			return Base64.getEncoder().encodeToString(sign);
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new WXException("The current Java environment does not support " + algorithmName, e);
		}
		catch (InvalidKeyException e)
		{
			throw new WXException(ALGORITHM + " signature uses an illegal privateKey.", e);
		}
		catch (SignatureException e)
		{
			throw new WXException("An error occurred during the sign process.", e);
		}
	}

	public static boolean verify(String message, String signature, X509Certificate certificate) throws WXException
	{
		return verify(message.getBytes(StandardCharsets.UTF_8), signature, certificate);
	}

	public static boolean verify(byte[] bytes, String signature, X509Certificate certificate) throws WXException
	{
		String algorithmName = PaymentConstant.SHA256WITHRSA;

		try
		{
			Signature sign = Signature.getInstance(algorithmName);
			sign.initVerify(certificate);
			sign.update(bytes);
			return sign.verify(Base64.getDecoder().decode(signature));
		}
		catch (SignatureException e)
		{
			throw new WXException("Sign failed.", e);
		}
		catch (InvalidKeyException e)
		{
			throw new WXException("Verify uses an illegal certificate.", e);
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new WXException("The current Java environment does not support " + algorithmName, e);
		}
	}
}
