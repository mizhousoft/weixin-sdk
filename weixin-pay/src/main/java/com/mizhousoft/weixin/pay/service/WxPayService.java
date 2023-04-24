package com.mizhousoft.weixin.pay.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.pay.notify.WxPayOrderNotifyResult;
import com.mizhousoft.weixin.pay.notify.WxPayRefundNotifyResult;
import com.mizhousoft.weixin.pay.request.IPayUnifiedOrderRequest;
import com.mizhousoft.weixin.pay.request.IWxPayRefundQueryRequest;
import com.mizhousoft.weixin.pay.request.IWxPayRefundRequest;
import com.mizhousoft.weixin.pay.result.WxPayOrderCloseResult;
import com.mizhousoft.weixin.pay.result.WxPayOrderCreateResult;
import com.mizhousoft.weixin.pay.result.WxPayOrderQueryResult;
import com.mizhousoft.weixin.pay.result.WxPayRefundQueryResult;
import com.mizhousoft.weixin.pay.result.WxPayRefundResult;
import com.mizhousoft.weixin.pay.result.WxPayUnifiedOrderResult;

/**
 * 微信支付服务
 *
 * 
 */
public interface WxPayService
{
	String PAY_ENDPOINT = "https://api.mch.weixin.qq.com";

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
	WxPayOrderCreateResult createOrder(IPayUnifiedOrderRequest request) throws WXException;

	/**
	 * 统一下单
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayUnifiedOrderResult unifiedOrder(IPayUnifiedOrderRequest request) throws WXException;

	/**
	 * 查询订单
	 * 
	 * @param appId
	 * @param transactionId
	 * @param outTradeNo
	 * @return
	 * @throws WXException
	 */
	WxPayOrderQueryResult queryOrder(String appId, String transactionId, String outTradeNo) throws WXException;

	/**
	 * 关闭订单
	 * 
	 * @param appId
	 * @param outTradeNo
	 * @return
	 * @throws WXException
	 */
	WxPayOrderCloseResult closeOrder(String appId, String outTradeNo) throws WXException;

	/**
	 * 解析支付订单通知结果
	 * 
	 * @param xmlData
	 * @return
	 * @throws WXException
	 */
	WxPayOrderNotifyResult parsePayOrderNotifyResult(String xmlData) throws WXException;

	/**
	 * 申请退款
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayRefundResult refund(IWxPayRefundRequest request) throws WXException;

	/**
	 * 查询退款，参数四选一
	 * 
	 * @param appId
	 * @param transactionId
	 * @param outTradeNo
	 * @param outRefundNo
	 * @param refundId
	 * @return
	 * @throws WXException
	 */
	WxPayRefundQueryResult refundQuery(String appId, String transactionId, String outTradeNo, String outRefundNo, String refundId)
	        throws WXException;

	/**
	 * 查询退款
	 * 
	 * @param request
	 * @return
	 * @throws WXException
	 */
	WxPayRefundQueryResult refundQuery(IWxPayRefundQueryRequest request) throws WXException;

	/**
	 * 解析退款通知结果
	 * 
	 * @param xmlData
	 * @return
	 * @throws WXException
	 */
	WxPayRefundNotifyResult parseRefundNotifyResult(String xmlData) throws WXException;
}
