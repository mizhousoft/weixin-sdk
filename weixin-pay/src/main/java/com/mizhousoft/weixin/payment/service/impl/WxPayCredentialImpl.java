package com.mizhousoft.weixin.payment.service.impl;

import java.security.PrivateKey;
import java.time.Instant;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;
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

	private volatile WxPayConfig config;

	private volatile PrivateKey privateKey;

	/**
	 * 构造函数
	 *
	 * @param config
	 */
	public WxPayCredentialImpl(WxPayConfig config, PrivateKey privateKey)
	{
		super();
		this.config = config;
		this.privateKey = privateKey;
	}

	@Override
	public String getMerchantId()
	{
		return config.getMchId();
	}

	@Override
	public String getAPIV3key()
	{
		return config.getApiV3key();
	}

	@Override
	public String getPayNotifyUrl()
	{
		return config.getPayNotifyUrl();
	}

	@Override
	public String getRefundNotifyUrl()
	{
		return config.getRefundNotifyUrl();
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
		return RSAUtils.sign(message, privateKey);
	}

	@Override
	public String getAuthorization(String canonicalUrl, String httpMethod, String body) throws WXException
	{
		String nonceStr = RandomGenerator.genHexString(16, false);
		long timestamp = Instant.now().getEpochSecond();
		body = body == null ? "" : body;

		String message = httpMethod + "\n" + canonicalUrl + "\n" + timestamp + "\n" + nonceStr + "\n" + body + "\n";

		String certSerialNumber = config.getCertSerialNumber();
		String signature = RSAUtils.sign(message, privateKey);

		String token = "mchid=\"" + getMerchantId() + "\"," + "nonce_str=\"" + nonceStr + "\"," + "timestamp=\"" + timestamp + "\","
		        + "serial_no=\"" + certSerialNumber + "\"," + "signature=\"" + signature + "\"";

		String schema = getSchema();

		return schema + " " + token;
	}
}
