package com.mizhousoft.weixin.pay.converter;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.internal.WxPayOrderQueryRequest;
import com.mizhousoft.weixin.pay.request.IPayOrderQueryRequest;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 支付订单查询转换器
 *
 * @version
 */
public abstract class WxPayOrderQueryRequestConverter
{
	public static WxPayOrderQueryRequest convert(IPayOrderQueryRequest request, WxPayConfig wxPayConfig)
	        throws WXException
	{
		WxPayOrderQueryRequest wxreq = new WxPayOrderQueryRequest();

		String nonceStr = RandomGenerator.genHexString(16, false);

		wxreq.setAppid(request.getAppId());
		wxreq.setMchId(wxPayConfig.getMchId());
		wxreq.setNonceStr(nonceStr);
		wxreq.setOutTradeNo(request.getOutTradeNo());
		wxreq.setSignType(wxPayConfig.getSignType());
		wxreq.setTransactionId(request.getTransactionId());

		String sign = WxPaySignUtils.createSign(wxreq, wxPayConfig.getSignType(), wxPayConfig.getMchKey(), null);
		wxreq.setSign(sign);

		return wxreq;
	}
}
