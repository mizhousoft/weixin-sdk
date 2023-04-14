package com.mizhousoft.weixin.payment;

/**
 * 配置
 *
 * @version
 */
public class WxPayConfig
{
	/**
	 * 微信支付分配的商户号
	 */
	private volatile String mchId;

	/**
	 * 商户密钥
	 */
	private volatile String apiV3key;

	/**
	 * 证书序列号
	 */
	private volatile String certSerialNumber;

	/**
	 * 私钥路径
	 */
	private volatile String privateKeyPath;

	/**
	 * 证书文件路径
	 */
	private volatile String certPemFilePath;

	/**
	 * 微信支付异步回掉地址，通知url必须为直接可访问的url，不能携带参数
	 */
	private String payNotifyUrl;

	/**
	 * 微信退款异步回掉地址，通知url必须为直接可访问的url，不能携带参数
	 */
	private String refundNotifyUrl;

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
	 * 获取apiV3key
	 * 
	 * @return
	 */
	public String getApiV3key()
	{
		return apiV3key;
	}

	/**
	 * 设置apiV3key
	 * 
	 * @param apiV3key
	 */
	public void setApiV3key(String apiV3key)
	{
		this.apiV3key = apiV3key;
	}

	/**
	 * 获取certSerialNumber
	 * 
	 * @return
	 */
	public String getCertSerialNumber()
	{
		return certSerialNumber;
	}

	/**
	 * 设置certSerialNumber
	 * 
	 * @param certSerialNumber
	 */
	public void setCertSerialNumber(String certSerialNumber)
	{
		this.certSerialNumber = certSerialNumber;
	}

	/**
	 * 获取privateKeyPath
	 * 
	 * @return
	 */
	public String getPrivateKeyPath()
	{
		return privateKeyPath;
	}

	/**
	 * 设置privateKeyPath
	 * 
	 * @param privateKeyPath
	 */
	public void setPrivateKeyPath(String privateKeyPath)
	{
		this.privateKeyPath = privateKeyPath;
	}

	/**
	 * 获取certPemFilePath
	 * 
	 * @return
	 */
	public String getCertPemFilePath()
	{
		return certPemFilePath;
	}

	/**
	 * 设置certPemFilePath
	 * 
	 * @param certPemFilePath
	 */
	public void setCertPemFilePath(String certPemFilePath)
	{
		this.certPemFilePath = certPemFilePath;
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
}
