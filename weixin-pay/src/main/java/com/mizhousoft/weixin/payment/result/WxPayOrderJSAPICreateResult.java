package com.mizhousoft.weixin.payment.result;

/**
 * 订单创建结果
 *
 * @version
 */
public class WxPayOrderJSAPICreateResult
{
	/**
	 * 应用APPID
	 */
	private String appId;

	/**
	 * 数据包
	 */
	private String packageValue;

	/**
	 * 随机值
	 */
	private String nonceStr;

	/**
	 * 时间戳
	 */
	private String timeStamp;

	/**
	 * 签名
	 */
	private String sign;

	/**
	 * 签名类型
	 */
	private String signType;

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
}