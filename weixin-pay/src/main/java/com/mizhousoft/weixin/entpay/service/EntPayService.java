package com.mizhousoft.weixin.entpay.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.entpay.request.IEntPayQueryRequest;
import com.mizhousoft.weixin.entpay.request.IEntPayRequest;
import com.mizhousoft.weixin.entpay.result.EntPayQueryResult;
import com.mizhousoft.weixin.entpay.result.EntPayResult;

/**
 * 企业支付服务
 *
 * 
 */
public interface EntPayService
{
	String ENT_PAY_ENDPOINT = "https://api.mch.weixin.qq.com";

	/**
	 * 获取商户号ID
	 * 
	 * @return
	 */
	String getMchId();

	/**
	 * 企业支付到零钱
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	EntPayResult entPay(IEntPayRequest request) throws WXException;

	/**
	 * 查询企业付款到零钱
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	EntPayQueryResult queryEntPay(IEntPayQueryRequest request) throws WXException;
}
