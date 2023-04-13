package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.request.WxPayOrderCreateRequest;
import com.mizhousoft.weixin.payment.result.WxPayOrderCreateResult;

/**
 * 支付服务
 *
 * @version
 */
public interface WxPaymentService
{
	String ENDPOINT = "https://api.mch.weixin.qq.com";

	/**
	 * 创建订单
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayOrderCreateResult createOrder(WxPayOrderCreateRequest request) throws WXException;
}
