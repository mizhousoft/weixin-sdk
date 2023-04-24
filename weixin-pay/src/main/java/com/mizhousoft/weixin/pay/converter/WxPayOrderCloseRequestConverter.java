package com.mizhousoft.weixin.pay.converter;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.internal.WxPayOrderCloseRequest;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 支付订单关闭请求转换器
 *
 * 
 */
public abstract class WxPayOrderCloseRequestConverter
{
	public static WxPayOrderCloseRequest convert(String appId, String outTradeNo, WxPayConfig wxPayConfig)
	        throws WXException
	{
		WxPayOrderCloseRequest wxreq = new WxPayOrderCloseRequest();

		String nonceStr = RandomGenerator.genHexString(16, false);

		wxreq.setAppid(appId);
		wxreq.setMchId(wxPayConfig.getMchId());
		wxreq.setNonceStr(nonceStr);
		wxreq.setOutTradeNo(outTradeNo);
		wxreq.setSignType(wxPayConfig.getSignType());

		String sign = WxPaySignUtils.createSign(wxreq, wxPayConfig.getSignType(), wxPayConfig.getMchKey(), null);
		wxreq.setSign(sign);

		return wxreq;
	}
}
