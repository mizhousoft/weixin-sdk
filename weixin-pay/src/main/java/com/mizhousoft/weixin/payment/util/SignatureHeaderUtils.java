package com.mizhousoft.weixin.payment.util;

import java.util.Map;

import com.mizhousoft.weixin.payment.constant.HttpConstants;
import com.mizhousoft.weixin.payment.response.SignatureHeader;

/**
 * 工具类
 *
 * @version
 */
public abstract class SignatureHeaderUtils
{
	public static SignatureHeader buildHeader(Map<String, String> headers)
	{
		String timestamp = headers.get(HttpConstants.WECHAT_PAY_TIMESTAMP);
		String serial = headers.get(HttpConstants.WECHAT_PAY_SERIAL);
		String nonce = headers.get(HttpConstants.WECHAT_PAY_NONCE);
		String signature = headers.get(HttpConstants.WECHAT_PAY_SIGNATURE);

		SignatureHeader signHeader = new SignatureHeader();
		signHeader.setNonce(nonce);
		signHeader.setSerial(serial);
		signHeader.setSignature(signature);
		signHeader.setTimeStamp(timestamp);

		return signHeader;
	}
}
