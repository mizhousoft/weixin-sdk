package com.mizhousoft.weixin.payment;

import java.util.Set;

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
	private volatile String apiV3Key;

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
	private volatile Set<String> certPemFilePaths;

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
	 * 获取apiV3Key
	 * 
	 * @return
	 */
	public String getApiV3Key()
	{
		return apiV3Key;
	}

	/**
	 * 设置apiV3Key
	 * 
	 * @param apiV3Key
	 */
	public void setApiV3Key(String apiV3Key)
	{
		this.apiV3Key = apiV3Key;
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
	 * 获取certPemFilePaths
	 * 
	 * @return
	 */
	public Set<String> getCertPemFilePaths()
	{
		return certPemFilePaths;
	}

	/**
	 * 设置certPemFilePaths
	 * 
	 * @param certPemFilePaths
	 */
	public void setCertPemFilePaths(Set<String> certPemFilePaths)
	{
		this.certPemFilePaths = certPemFilePaths;
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
