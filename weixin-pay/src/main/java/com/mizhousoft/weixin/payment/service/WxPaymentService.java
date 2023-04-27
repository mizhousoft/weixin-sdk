package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.weixin.cipher.SignatureHeader;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.request.WxPayOrderCreateRequest;
import com.mizhousoft.weixin.payment.request.WxPayRefundRequest;
import com.mizhousoft.weixin.payment.result.WxPayOrderCreateResult;
import com.mizhousoft.weixin.payment.result.WxPayOrderQueryResult;
import com.mizhousoft.weixin.payment.result.WxPayRefundNotifyResult;
import com.mizhousoft.weixin.payment.result.WxPayRefundResult;

/**
 * 支付服务
 *
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
	WxPayOrderCreateResult createAppOrder(WxPayOrderCreateRequest request) throws WXException;

	/**
	 * 创建订单
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayOrderCreateResult createJSAPIOrder(WxPayOrderCreateRequest request) throws WXException;

	/**
	 * 创建订单
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	String createH5Order(WxPayOrderCreateRequest request) throws WXException;

	/**
	 * 查询订单
	 * 
	 * @param mchId
	 * @param transactionId
	 * @return
	 * @throws WXException
	 */
	WxPayOrderQueryResult queryOrderByTransactionId(String mchId, String transactionId) throws WXException;

	/**
	 * 查询订单
	 * 
	 * @param mchId
	 * @param outTradeNo
	 * @return
	 * @throws WXException
	 */
	WxPayOrderQueryResult queryOrderByOutTradeNo(String mchId, String outTradeNo) throws WXException;

	/**
	 * 解析支付订单通知结果
	 * 
	 * @param mchId
	 * @param notifyData
	 * @param header
	 * @return
	 * @throws WXException
	 */
	WxPayOrderQueryResult parsePayOrderNotifyResult(String mchId, String notifyData, SignatureHeader header) throws WXException;

	/**
	 * 退款
	 * 
	 * @param mchId
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayRefundResult refund(String mchId, WxPayRefundRequest request) throws WXException;

	/**
	 * 退款查询
	 * 
	 * @param mchId
	 * @param outRefundNo
	 * @return
	 * @throws WXException
	 */
	WxPayRefundResult refundQuery(String mchId, String outRefundNo) throws WXException;

	/**
	 * 解析退款结果通知
	 * 
	 * @param mchId
	 * @param notifyData
	 * @param header
	 * @return
	 * @throws WXException
	 */
	WxPayRefundNotifyResult parseRefundNotifyResult(String mchId, String notifyData, SignatureHeader header) throws WXException;

}
