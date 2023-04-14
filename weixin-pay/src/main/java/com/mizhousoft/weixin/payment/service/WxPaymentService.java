package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.request.WxPayOrderCreateRequest;
import com.mizhousoft.weixin.payment.request.WxPayRefundRequest;
import com.mizhousoft.weixin.payment.response.SignatureHeader;
import com.mizhousoft.weixin.payment.result.WxPayOrderAPPCreateResult;
import com.mizhousoft.weixin.payment.result.WxPayOrderJSAPICreateResult;
import com.mizhousoft.weixin.payment.result.WxPayOrderQueryResult;
import com.mizhousoft.weixin.payment.result.WxPayRefundNotifyResult;
import com.mizhousoft.weixin.payment.result.WxPayRefundResult;

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
	WxPayOrderAPPCreateResult createAppOrder(WxPayOrderCreateRequest request) throws WXException;

	/**
	 * 创建订单
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayOrderJSAPICreateResult createJSAPIOrder(WxPayOrderCreateRequest request) throws WXException;

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

	/**
	 * 解析支付订单通知结果
	 * 
	 * @param notifyData
	 * @param header
	 * @return
	 * @throws WXException
	 */
	WxPayOrderQueryResult parsePayOrderNotifyResult(String notifyData, SignatureHeader header) throws WXException;

	/**
	 * 退款
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayRefundResult refund(WxPayRefundRequest request) throws WXException;

	/**
	 * 退款查询
	 * 
	 * @param outRefundNo
	 * @return
	 * @throws WXException
	 */
	WxPayRefundResult refundQuery(String outRefundNo) throws WXException;

	/**
	 * 解析退款结果通知
	 * 
	 * @param notifyData
	 * @param header
	 * @return
	 * @throws WXException
	 */
	WxPayRefundNotifyResult parseRefundNotifyResult(String notifyData, SignatureHeader header) throws WXException;

}
