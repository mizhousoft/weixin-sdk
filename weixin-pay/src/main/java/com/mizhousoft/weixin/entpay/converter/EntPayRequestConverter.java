package com.mizhousoft.weixin.entpay.converter;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.entpay.internal.EntPayRequest;
import com.mizhousoft.weixin.entpay.request.IEntPayRequest;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.constant.WxPaySignType;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 企业支付请求转换器
 *
 * 
 */
public abstract class EntPayRequestConverter
{
	public static EntPayRequest convert(IEntPayRequest request, WxPayConfig wxPayConfig) throws WXException
	{
		EntPayRequest wxreq = new EntPayRequest();

		String nonceStr = RandomGenerator.genHexString(16, false);

		wxreq.setMchAppId(request.getMchAppId());
		wxreq.setMchId(wxPayConfig.getMchId());
		wxreq.setDeviceInfo(request.getDeviceInfo());
		wxreq.setPartnerTradeNo(request.getPartnerTradeNo());
		wxreq.setOpenid(request.getOpenid());
		wxreq.setCheckName(request.getCheckName());
		wxreq.setReUserName(request.getReUserName());
		wxreq.setAmount(request.getAmount());
		wxreq.setDescription(request.getDescription());
		wxreq.setSpbillCreateIp(request.getSpbillCreateIp());
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
