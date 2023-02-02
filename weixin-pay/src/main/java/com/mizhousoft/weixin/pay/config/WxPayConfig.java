package com.mizhousoft.weixin.pay.config;

/**
 * 微信支付配置
 *
 * @version
 */
public class WxPayConfig
{
	// 终端地址
	private String endpoint;

	// 微信支付分配的商户号
	private String mchId;

	// 商户密钥
	private volatile String mchKey;

	// 微信支付异步回掉地址，通知url必须为直接可访问的url，不能携带参数
	private String payNotifyUrl;

	// 微信退款异步回掉地址，通知url必须为直接可访问的url，不能携带参数
	private String refundNotifyUrl;

	// 签名方式
	private String signType;

	// 指定支付方式
	private String limitPay;

	/**
	 * 获取endpoint
	 * 
	 * @return
	 */
	public String getEndpoint()
	{
		return endpoint;
	}

	/**
	 * 设置endpoint
	 * 
	 * @param endpoint
	 */
	public void setEndpoint(String endpoint)
	{
		this.endpoint = endpoint;
	}

	/**
	 * 获取mchId
	 * 
	 * @return
	 */
	public String getMchId()
	{
		return mchId;
	}

	/**
	 * 设置mchId
	 * 
	 * @param mchId
	 */
	public void setMchId(String mchId)
	{
		this.mchId = mchId;
	}

	/**
	 * 获取mchKey
	 * 
	 * @return
	 */
	public String getMchKey()
	{
		return mchKey;
	}

	/**
	 * 设置mchKey
	 * 
	 * @param mchKey
	 */
	public void setMchKey(String mchKey)
	{
		this.mchKey = mchKey;
	}

	/**
	 * 获取payNotifyUrl
	 * 
	 * @return
	 */
	public String getPayNotifyUrl()
	{
		return payNotifyUrl;
	}

	/**
	 * 设置payNotifyUrl
	 * 
	 * @param payNotifyUrl
	 */
	public void setPayNotifyUrl(String payNotifyUrl)
	{
		this.payNotifyUrl = payNotifyUrl;
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

	/**
	 * 获取signType
	 * 
	 * @return
	 */
	public String getSignType()
	{
		return signType;
	}

	/**
	 * 设置signType
	 * 
	 * @param signType
	 */
	public void setSignType(String signType)
	{
		this.signType = signType;
	}

	/**
	 * 获取limitPay
	 * 
	 * @return
	 */
	public String getLimitPay()
	{
		return limitPay;
	}

	/**
	 * 设置limitPay
	 * 
	 * @param limitPay
	 */
	public void setLimitPay(String limitPay)
	{
		this.limitPay = limitPay;
	}
}
