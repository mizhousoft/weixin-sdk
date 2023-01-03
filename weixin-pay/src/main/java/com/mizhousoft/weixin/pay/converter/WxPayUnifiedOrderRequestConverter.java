package com.mizhousoft.weixin.pay.converter;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.constant.WxPayFeeType;
import com.mizhousoft.weixin.pay.internal.WxPayUnifiedOrderRequest;
import com.mizhousoft.weixin.pay.request.IPayUnifiedOrderRequest;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 统一订单请求转换器
 *
 * @version
 */
public abstract class WxPayUnifiedOrderRequestConverter
{
	public static WxPayUnifiedOrderRequest convert(IPayUnifiedOrderRequest request, WxPayConfig wxPayConfig) throws WXException
	{
		WxPayUnifiedOrderRequest wxreq = new WxPayUnifiedOrderRequest();

		String nonceStr = RandomGenerator.genHexString(16, false);

		wxreq.setAppid(request.getAppId());
		wxreq.setAttach(request.getAttach());
		wxreq.setBody(request.getBody());
		wxreq.setDetail(request.getDetail());
		wxreq.setDeviceInfo(request.getDeviceInfo());
		wxreq.setFeeType(WxPayFeeType.CNY);
		wxreq.setLimitPay(wxPayConfig.getLimitPay());
		wxreq.setMchId(wxPayConfig.getMchId());
		wxreq.setNonceStr(nonceStr);

		// 优先取请求对象中的
		if (null != request.getPayNotifyUrl())
		{
			wxreq.setNotifyUrl(request.getPayNotifyUrl());
		}
		else
		{
			wxreq.setNotifyUrl(wxPayConfig.getPayNotifyUrl());
		}

		wxreq.setOutTradeNo(request.getOutTradeNo());
		wxreq.setSignType(wxPayConfig.getSignType());
		wxreq.setSpbillCreateIp(request.getSpbillCreateIp());
		wxreq.setTimeExpire(request.getTimeExpire());
		wxreq.setTimeStart(request.getTimeStart());
		wxreq.setTotalFee(request.getTotalFee());
		wxreq.setTradeType(request.getTradeType());
		wxreq.setOpenId(request.getOpenId());

		String sign = WxPaySignUtils.createSign(wxreq, wxPayConfig.getSignType(), wxPayConfig.getMchKey(), null);
		wxreq.setSign(sign);

		return wxreq;
	}
}
