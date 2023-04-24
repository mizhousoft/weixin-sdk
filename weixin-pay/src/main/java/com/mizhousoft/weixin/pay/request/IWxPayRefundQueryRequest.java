package com.mizhousoft.weixin.pay.request;

/**
 * 退款查询请求
 *
 * 
 */
public class IWxPayRefundQueryRequest
{
	// 应用APPID
	private String appId;

	// 微信订单号
	private String transactionId;

	// 商户订单号
	// transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no
	private String outTradeNo;

	// 商户退款单号
	// 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	private String outRefundNo;

	// 微信退款单号
	private String refundId;

	/**
	 * 获取appId
	 * 
	 * @return
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * 
	 * @param appId
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	/**
	 * 获取transactionId
	 * 
	 * @return
	 */
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * 设置transactionId
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}

	/**
	 * 获取outTradeNo
	 * 
	 * @return
	 */
	public String getOutTradeNo()
	{
		return outTradeNo;
	}

	/**
	 * 设置outTradeNo
	 * 
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo)
	{
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 获取outRefundNo
	 * 
	 * @return
	 */
	public String getOutRefundNo()
	{
		return outRefundNo;
	}

	/**
	 * 设置outRefundNo
	 * 
	 * @param outRefundNo
	 */
	public void setOutRefundNo(String outRefundNo)
	{
		this.outRefundNo = outRefundNo;
	}

	/**
	 * 获取refundId
	 * 
	 * @return
	 */
	public String getRefundId()
	{
		return refundId;
	}

	/**
	 * 设置refundId
	 * 
	 * @param refundId
	 */
	public void setRefundId(String refundId)
	{
		this.refundId = refundId;
	}
}
