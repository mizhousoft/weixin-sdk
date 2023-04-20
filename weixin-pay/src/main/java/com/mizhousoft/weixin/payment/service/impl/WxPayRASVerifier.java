package com.mizhousoft.weixin.payment.service.impl;

import java.security.cert.X509Certificate;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.weixin.certificate.CertificateProvider;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.constant.HttpConstants;
import com.mizhousoft.weixin.payment.service.WxPayVerifier;
import com.mizhousoft.weixin.payment.util.RSAUtils;

/**
 * 响应验证器
 *
 * @version
 */
public class WxPayRASVerifier implements WxPayVerifier
{
	private static final Logger LOG = LoggerFactory.getLogger(WxPayRASVerifier.class);

	private static final int RESPONSE_EXPIRED_MINUTES = 5;

	private CertificateProvider certificateProvider;

	/**
	 * 构造函数
	 *
	 * @param certificateProvider
	 */
	public WxPayRASVerifier(CertificateProvider certificateProvider)
	{
		super();
		this.certificateProvider = certificateProvider;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws WXException
	 */
	@Override
	public boolean validate(Map<String, String> headers, String body) throws WXException
	{
		String timestamp = headers.get(HttpConstants.WECHAT_PAY_TIMESTAMP);
		String requestId = headers.get(HttpConstants.REQUEST_ID);
		String nonce = headers.get(HttpConstants.WECHAT_PAY_NONCE);
		String signature = headers.get(HttpConstants.WECHAT_PAY_SIGNATURE);

		body = body == null ? "" : body;

		try
		{
			Instant responseTime = Instant.ofEpochSecond(Long.parseLong(timestamp));

			// 拒绝过期请求
			if (Duration.between(responseTime, Instant.now()).abs().toMinutes() >= RESPONSE_EXPIRED_MINUTES)
			{
				throw new WXException(String.format("Validate http response,timestamp[%s] of httpResponse is expires, " + "request-id[%s]",
				        timestamp, requestId));
			}
		}
		catch (DateTimeException | NumberFormatException e)
		{
			throw new WXException(
			        String.format("Validate http response,timestamp[%s] of httpResponse is invalid, request-id[%s]", timestamp, requestId));
		}

		String message = timestamp + "\n" + nonce + "\n" + body + "\n";
		LOG.debug("Message for verifying signatures is [{}]", message);
		LOG.debug("Signature for verifying signatures is [{}]", signature);

		String serialNumber = headers.get(HttpConstants.WECHAT_PAY_SERIAL);
		LOG.debug("SerialNumber for verifying signatures is [{}]", serialNumber);

		X509Certificate certificate = certificateProvider.getCertificate(serialNumber);

		return RSAUtils.verify(message, signature, certificate);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(String serialNumber, byte[] bytes, String signature) throws WXException
	{
		X509Certificate certificate = certificateProvider.getCertificate(serialNumber);

		return RSAUtils.verify(bytes, signature, certificate);
	}
}
