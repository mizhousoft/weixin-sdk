package com.mizhousoft.weixin.pay.converter;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.internal.WxPayRefundQueryRequest;
import com.mizhousoft.weixin.pay.request.IWxPayRefundQueryRequest;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 转换器
 *
 * @version
 */
public class WxPayRefundQueryRequestConverter
{
	public static WxPayRefundQueryRequest convert(IWxPayRefundQueryRequest req, WxPayConfig wxPayConfig)
	        throws WXException
	{
		WxPayRefundQueryRequest wxRequest = new WxPayRefundQueryRequest();
		wxRequest.setTransactionId(StringUtils.trimToNull(req.getTransactionId()));
		wxRequest.setOutTradeNo(StringUtils.trimToNull(req.getOutTradeNo()));
		wxRequest.setOutRefundNo(StringUtils.trimToNull(req.getOutRefundNo()));
		wxRequest.setRefundId(StringUtils.trimToNull(req.getRefundId()));
		wxRequest.setAppid(req.getAppId());
		wxRequest.setMchId(wxPayConfig.getMchId());
		wxRequest.setSignType(wxPayConfig.getSignType());

		String nonceStr = RandomGenerator.genHexString(16, false);
		wxRequest.setNonceStr(nonceStr);

		String sign = WxPaySignUtils.createSign(wxRequest, wxPayConfig.getSignType(), wxPayConfig.getMchKey(), null);
		wxRequest.setSign(sign);

		return wxRequest;
	}
}
