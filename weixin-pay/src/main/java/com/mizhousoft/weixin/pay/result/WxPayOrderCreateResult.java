package com.mizhousoft.weixin.pay.result;

/**
 * 订单结果
 *
 * @version
 */
public class WxPayOrderCreateResult
{
	// 应用APPID
	private String appId;

	// 微信支付分配的商户号
	private String partnerId;

	// 微信返回的支付交易会话ID
	private String prepayId;

	// 数据包
	private String packageValue;

	// 随机值
	private String nonceStr;

	// 时间戳
	private String timeStamp;

	// 签名
	private String sign;

	// 签名方式
	private String signType;

	// 支付跳转链接
	private String mwebUrl;

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
	 * 获取partnerId
	 * 
	 * @return
	 */
	public String getPartnerId()
	{
		return partnerId;
	}

	/**
	 * 设置partnerId
	 * 
	 * @param partnerId
	 */
	public void setPartnerId(String partnerId)
	{
		this.partnerId = partnerId;
	}

	/**
	 * 获取prepayId
	 * 
	 * @return
	 */
	public String getPrepayId()
	{
		return prepayId;
	}

	/**
	 * 设置prepayId
	 * 
	 * @param prepayId
	 */
	public void setPrepayId(String prepayId)
	{
		this.prepayId = prepayId;
	}

	/**
	 * 获取packageValue
	 * 
	 * @return
	 */
	public String getPackageValue()
	{
		return packageValue;
	}

	/**
	 * 设置packageValue
	 * 
	 * @param packageValue
	 */
	public void setPackageValue(String packageValue)
	{
		this.packageValue = packageValue;
	}

	/**
	 * 获取nonceStr
	 * 
	 * @return
	 */
	public String getNonceStr()
	{
		return nonceStr;
	}

	/**
	 * 设置nonceStr
	 * 
	 * @param nonceStr
	 */
	public void setNonceStr(String nonceStr)
	{
		this.nonceStr = nonceStr;
	}

	/**
	 * 获取timeStamp
	 * 
	 * @return
	 */
	public String getTimeStamp()
	{
		return timeStamp;
	}

	/**
	 * 设置timeStamp
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	/**
	 * 获取sign
	 * 
	 * @return
	 */
	public String getSign()
	{
		return sign;
	}

	/**
	 * 设置sign
	 * 
	 * @param sign
	 */
	public void setSign(String sign)
	{
		this.sign = sign;
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
	 * 获取mwebUrl
	 * 
	 * @return
	 */
	public String getMwebUrl()
	{
		return mwebUrl;
	}

	/**
	 * 设置mwebUrl
	 * 
	 * @param mwebUrl
	 */
	public void setMwebUrl(String mwebUrl)
	{
		this.mwebUrl = mwebUrl;
	}
}
