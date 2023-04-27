package com.mizhousoft.weixin.cipher.impl;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.mizhousoft.weixin.certificate.CertificateProvider;
import com.mizhousoft.weixin.cipher.CipherService;
import com.mizhousoft.weixin.common.WXException;

/**
 * 密文服务
 *
 */
public class CipherServiceImpl implements CipherService
{
	public static String ALGORITHM = "SHA256-RSA2048";

	public static String SHA256WITHRSA = "SHA256withRSA";

	private PrivateKey privateKey;

	private PublicKey publicKey;

	private CertificateProvider certificateProvider;

	/**
	 * 构造函数
	 *
	 * @param privateKey
	 * @param publicKey
	 * @param certificateProvider
	 */
	public CipherServiceImpl(PrivateKey privateKey, PublicKey publicKey, CertificateProvider certificateProvider)
	{
		super();
		this.privateKey = privateKey;
		this.publicKey = publicKey;
		this.certificateProvider = certificateProvider;
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
			throw new IllegalArgumentException("The current Java environment does not support RSA.", e);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(String serialNumber, String message, String signature) throws WXException
	{
		X509Certificate certificate = certificateProvider.getCertificate(serialNumber);

		try
		{
			Signature sign = Signature.getInstance(SHA256WITHRSA);
			sign.initVerify(certificate);
			sign.update(message.getBytes(StandardCharsets.UTF_8));
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
			throw new WXException("The current Java environment does not support " + SHA256WITHRSA, e);
		}
	}
}
