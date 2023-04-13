package com.mizhousoft.weixin.payment.service.impl;

import java.security.PrivateKey;
import java.time.Instant;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.service.WxPayCredential;
import com.mizhousoft.weixin.payment.util.RSAUtils;

/**
 * 凭证
 *
 * @version
 */
public class WxPayCredentialImpl implements WxPayCredential
{
	public static final String SCHEMA_PREFIX = "WECHATPAY2-";

	private volatile String merchantId;

	private volatile String certSerialNumber;

	private volatile PrivateKey privateKey;

	/**
	 * 构造函数
	 *
	 * @param merchantId
	 * @param certSerialNumber
	 * @param privateKey
	 */
	public WxPayCredentialImpl(String merchantId, String certSerialNumber, PrivateKey privateKey)
	{
		super();
		this.merchantId = merchantId;
		this.certSerialNumber = certSerialNumber;
		this.privateKey = privateKey;
	}

	@Override
	public String getMerchantId()
	{
		return merchantId;
	}

	@Override
	public String getSchema()
	{
		return SCHEMA_PREFIX + RSAUtils.ALGORITHM;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String sign(String message) throws WXException
	{
		return RSAUtils.sign(message, certSerialNumber, privateKey);
	}

	@Override
	public String getAuthorization(String canonicalUrl, String httpMethod, String body) throws WXException
	{
		String nonceStr = RandomGenerator.genHexString(16, false);
		long timestamp = Instant.now().getEpochSecond();
		body = body == null ? "" : body;

		String message = httpMethod + "\n" + canonicalUrl + "\n" + timestamp + "\n" + nonceStr + "\n" + body + "\n";

		String signature = RSAUtils.sign(message, certSerialNumber, privateKey);

		String token = "mchid=\"" + getMerchantId() + "\"," + "nonce_str=\"" + nonceStr + "\"," + "timestamp=\"" + timestamp + "\","
		        + "serial_no=\"" + certSerialNumber + "\"," + "signature=\"" + signature + "\"";

		String schema = getSchema();

		return schema + " " + token;
	}
}
