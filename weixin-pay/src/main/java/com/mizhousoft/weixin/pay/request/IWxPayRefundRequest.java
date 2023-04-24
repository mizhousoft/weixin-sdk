package com.mizhousoft.weixin.pay.request;

/**
 * 退款请求
 *
 * 
 */
public class IWxPayRefundRequest
{
	// 应用APPID
	private String appId;

	// 微信订单号
	private String transactionId;

	// 商户订单号
	private String outTradeNo;

	// 商户退款单号
	// 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	private String outRefundNo;

	// 订单金额，单位为分
	private Integer totalFee;

	// 退款金额，单位为分
	private Integer refundFee;

	// 退款原因
	private String refundDesc;

	// 微信退款异步回掉地址，如果不填写，那么将取配置对象的数据填充
	private String refundNotifyUrl;

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
	 * 获取totalFee
	 * 
	 * @return
	 */
	public Integer getTotalFee()
	{
		return totalFee;
	}

	/**
	 * 设置totalFee
	 * 
	 * @param totalFee
	 */
	public void setTotalFee(Integer totalFee)
	{
		this.totalFee = totalFee;
	}

	/**
	 * 获取refundFee
	 * 
	 * @return
	 */
	public Integer getRefundFee()
	{
		return refundFee;
	}

	/**
	 * 设置refundFee
	 * 
	 * @param refundFee
	 */
	public void setRefundFee(Integer refundFee)
	{
		this.refundFee = refundFee;
	}

	/**
	 * 获取refundDesc
	 * 
	 * @return
	 */
	public String getRefundDesc()
	{
		return refundDesc;
	}

	/**
	 * 设置refundDesc
	 * 
	 * @param refundDesc
	 */
	public void setRefundDesc(String refundDesc)
	{
		this.refundDesc = refundDesc;
	}

	/**
	 * 获取refundNotifyUrl
	 * 
	 * @return
	 */
	public String getRefundNotifyUrl()
	{
		return refundNotifyUrl;
	}

	/**
	 * 设置refundNotifyUrl
	 * 
	 * @param refundNotifyUrl
	 */
	public void setRefundNotifyUrl(String refundNotifyUrl)
	{
		this.refundNotifyUrl = refundNotifyUrl;
	}
}
