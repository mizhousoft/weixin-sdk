package com.mizhousoft.weixin.pay.converter;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.internal.WxPayRefundRequest;
import com.mizhousoft.weixin.pay.request.IWxPayRefundRequest;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 转换器
 *
 * @version
 */
public class WxPayRefundRequestConverter
{
	public static WxPayRefundRequest convert(IWxPayRefundRequest req, WxPayConfig wxPayConfig) throws WXException
	{
		WxPayRefundRequest wxRequest = new WxPayRefundRequest();
		wxRequest.setRefundDesc(req.getRefundDesc());
		wxRequest.setRefundFee(req.getRefundFee());
		wxRequest.setTotalFee(req.getTotalFee());
		wxRequest.setTransactionId(req.getTransactionId());
		wxRequest.setOutTradeNo(req.getOutTradeNo());
		wxRequest.setOutRefundNo(req.getOutRefundNo());
		wxRequest.setAppid(req.getAppId());
		wxRequest.setMchId(wxPayConfig.getMchId());
		wxRequest.setSignType(wxPayConfig.getSignType());

		// 优先取请求对象中的
		if (null != req.getRefundNotifyUrl())
		{
			wxRequest.setNotifyUrl(req.getRefundNotifyUrl());
		}
		else
		{
			wxRequest.setNotifyUrl(wxPayConfig.getRefundNotifyUrl());
		}

		String nonceStr = RandomGenerator.genHexString(16, false);
		wxRequest.setNonceStr(nonceStr);

		String sign = WxPaySignUtils.createSign(wxRequest, wxPayConfig.getSignType(), wxPayConfig.getMchKey(), null);
		wxRequest.setSign(sign);

		return wxRequest;
	}
}
