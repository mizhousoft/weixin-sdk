package com.mizhousoft.weixin.certificate.impl;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.mizhousoft.weixin.certificate.CertificateProvider;

/**
 * 根据序列号获取证书
 *
 * @version
 */
public class CertificateProviderImpl implements CertificateProvider
{
	private final ConcurrentHashMap<BigInteger, X509Certificate> certificates = new ConcurrentHashMap<>(10);

	public CertificateProviderImpl(List<X509Certificate> certificates)
	{
		for (X509Certificate item : certificates)
		{
			this.certificates.put(item.getSerialNumber(), item);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public X509Certificate getCertificate(String serialNumber)
	{
		BigInteger key = new BigInteger(serialNumber, 16);

		return certificates.get(key);
	}
}
