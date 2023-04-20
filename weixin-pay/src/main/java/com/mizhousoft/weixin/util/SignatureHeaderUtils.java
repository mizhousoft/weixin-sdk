package com.mizhousoft.weixin.util;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.weixin.cipher.SignatureHeader;
import com.mizhousoft.weixin.payment.constant.HttpConstants;

/**
 * 工具类
 *
 * @version
 */
public abstract class SignatureHeaderUtils
{
	private static final Logger LOG = LoggerFactory.getLogger(SignatureHeaderUtils.class);

	public static SignatureHeader buildHeader(Map<String, String> headers)
	{
		String timestamp = getHeaderValue(HttpConstants.WECHAT_PAY_TIMESTAMP, headers);
		String serial = getHeaderValue(HttpConstants.WECHAT_PAY_SERIAL, headers);
		String nonce = getHeaderValue(HttpConstants.WECHAT_PAY_NONCE, headers);
		String signature = getHeaderValue(HttpConstants.WECHAT_PAY_SIGNATURE, headers);

		SignatureHeader signHeader = new SignatureHeader();
		signHeader.setNonce(nonce);
		signHeader.setSerialNumber(serial);
		signHeader.setSignature(signature);
		signHeader.setTimeStamp(timestamp);

		LOG.debug("Sign Header is {}", signHeader.toString());

		return signHeader;
	}

	public static String getHeaderValue(String key, Map<String, String> headers)
	{
		String value = headers.get(key);
		if (null == value)
		{
			value = headers.get(key.toLowerCase(Locale.ENGLISH));
		}

		return value;
	}
}
