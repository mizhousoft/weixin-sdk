package com.mizhousoft.weixin.entpay.converter;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.entpay.internal.EntPayQueryRequest;
import com.mizhousoft.weixin.entpay.request.IEntPayQueryRequest;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.constant.WxPaySignType;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 企业支付请求转换器
 *
 * @version
 */
public abstract class EntPayQueryRequestConverter
{
	public static EntPayQueryRequest convert(IEntPayQueryRequest request, WxPayConfig wxPayConfig) throws WXException
	{
		EntPayQueryRequest wxreq = new EntPayQueryRequest();

		String nonceStr = RandomGenerator.genHexString(16, false);

		wxreq.setMchId(wxPayConfig.getMchId());
		wxreq.setAppid(request.getAppId());
		wxreq.setPartnerTradeNo(request.getPartnerTradeNo());
		wxreq.setNonceStr(nonceStr);
		// 只支持MD5
		wxreq.setSignType(WxPaySignType.MD5);

		String[] ignoredParams = wxreq.getIgnoredParamsForSign();

		String sign = WxPaySignUtils.createSign(wxreq, wxreq.getSignType(), wxPayConfig.getMchKey(), ignoredParams);
		wxreq.setSign(sign);

		// 签名类型不能放到请求body中
		wxreq.setSignType(null);

		return wxreq;
	}
}
