package com.mizhousoft.weixin.pay.request;

/**
 * 订单查询请求
 *
 * 
 */
public class IPayOrderQueryRequest
{
	// 应用APPID
	private String appId;

	// 微信订单号
	private String transactionId;

	// 商户订单号
	private String outTradeNo;

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
}
