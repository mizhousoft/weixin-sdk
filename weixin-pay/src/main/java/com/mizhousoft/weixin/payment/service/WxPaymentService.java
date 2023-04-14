package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.request.WxPayOrderCreateRequest;
import com.mizhousoft.weixin.payment.response.WxPayOrderQueryResult;
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
	 * 获取商户号ID
	 * 
	 * @return
	 */
	String getMchId();

	/**
	 * 创建订单
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayOrderCreateResult createOrder(WxPayOrderCreateRequest request) throws WXException;

	/**
	 * 查询订单
	 * 
	 * @param transactionId
	 * @param outTradeNo
	 * @return
	 * @throws WXException
	 */
	WxPayOrderQueryResult queryOrderByTransactionId(String transactionId) throws WXException;

	/**
	 * 查询订单
	 * 
	 * @param transactionId
	 * @param outTradeNo
	 * @return
	 * @throws WXException
	 */
	WxPayOrderQueryResult queryOrderByOutTradeNo(String outTradeNo) throws WXException;
}
