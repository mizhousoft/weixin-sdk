package com.mizhousoft.weixin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Locale;

import org.apache.commons.io.FileUtils;

import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.weixin.common.WXException;

/**
 * 证书加载器
 *
 */
public abstract class PemLoader
{
	public static String getSerialNumber(X509Certificate certificate)
	{
		return certificate.getSerialNumber().toString(16).toUpperCase(Locale.ENGLISH);
	}

	/**
	 * 从文件路径加载X.509证书
	 *
	 * @param certificatePath 证书文件路径
	 * @return X.509证书
	 * @throws WXException
	 */
	public static X509Certificate loadX509FromPath(String certificatePath) throws WXException
	{
		try (FileInputStream inputStream = new FileInputStream(certificatePath))
		{
			return loadX509FromStream(inputStream);
		}
		catch (IOException e)
		{
			throw new WXException("Load x509 failed.", e);
		}
	}

	/**
	 * 从输入流加载X.509证书
	 *
	 * @param inputStream 私钥输入流
	 * @return X.509证书
	 * @throws WXException
	 */
	public static X509Certificate loadX509FromStream(InputStream inputStream) throws WXException
	{

		try
		{
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(inputStream);
			cert.checkValidity();
			return cert;
		}
		catch (CertificateExpiredException e)
		{
			throw new WXException("Certificate expired.", e);
		}
		catch (CertificateNotYetValidException e)
		{
			throw new WXException("Certificate not yet valid.", e);
		}
		catch (CertificateException e)
		{
			throw new WXException("Load x509 failed.", e);
		}
	}

	/**
	 * 从文件路径加载RSA私钥
	 *
	 * @param keyPath 私钥路径
	 * @return RSA私钥
	 * @throws WXException
	 */
	public static PrivateKey loadPrivateKeyFromPath(String keyPath) throws WXException
	{
		try
		{
			String body = FileUtils.readFileToString(new File(keyPath), CharEncoding.UTF8);

			return loadPrivateKeyFromString(body);
		}
		catch (IOException e)
		{
			throw new WXException("Load private key failed.", e);
		}
	}

	/**
	 * 从字符串中加载RSA私钥。
	 *
	 * @param keyString 私钥字符串
	 * @return RSA私钥
	 * @throws WXException
	 */
	public static PrivateKey loadPrivateKeyFromString(String keyString) throws WXException
	{
		try
		{
			keyString = keyString.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "").replaceAll("\\s+",
			        "");

			return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keyString)));
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new WXException("Load private key failed.", e);
		}
		catch (InvalidKeySpecException e)
		{
			throw new WXException("Load private key failed.", e);
		}
	}
}
