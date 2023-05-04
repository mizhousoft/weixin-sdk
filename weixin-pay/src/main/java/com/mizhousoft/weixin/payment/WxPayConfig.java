package com.mizhousoft.weixin.payment;

import com.mizhousoft.weixin.cipher.CipherService;

/**
 * 配置
 *
 */
public class WxPayConfig
{
	/**
	 * 标识
	 */
	private volatile String identifier;

	/**
	 * 微信支付分配的商户号
	 */
	private volatile String mchId;

	/**
	 * 商户证书序列号
	 */
	private volatile String mchCertSerialNumber;

	/**
	 * 商户平台证书序列号
	 */
	private volatile String platformCertSerialNumber;

	/**
	 * 密文服务
	 */
	private CipherService cipherService;

	/**
	 * endpoint
	 */
	private String endpoint;

	/**
	 * 微信支付异步回掉地址，通知url必须为直接可访问的url，不能携带参数
	 */
	private String payNotifyUrl;

	/**
	 * 微信退款异步回掉地址，通知url必须为直接可访问的url，不能携带参数
	 */
	private String refundNotifyUrl;

	/**
	 * 获取identifier
	 * 
	 * @return
	 */
	public String getIdentifier()
	{
		return identifier;
	}

	/**
	 * 设置identifier
	 * 
	 * @param identifier
	 */
	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
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
	 * 获取mchCertSerialNumber
	 * 
	 * @return
	 */
	public String getMchCertSerialNumber()
	{
		return mchCertSerialNumber;
	}

	/**
	 * 设置mchCertSerialNumber
	 * 
	 * @param mchCertSerialNumber
	 */
	public void setMchCertSerialNumber(String mchCertSerialNumber)
	{
		this.mchCertSerialNumber = mchCertSerialNumber;
	}

	/**
	 * 获取platformCertSerialNumber
	 * 
	 * @return
	 */
	public String getPlatformCertSerialNumber()
	{
		return platformCertSerialNumber;
	}

	/**
	 * 设置platformCertSerialNumber
	 * 
	 * @param platformCertSerialNumber
	 */
	public void setPlatformCertSerialNumber(String platformCertSerialNumber)
	{
		this.platformCertSerialNumber = platformCertSerialNumber;
	}

	/**
	 * 获取cipherService
	 * 
	 * @return
	 */
	public CipherService getCipherService()
	{
		return cipherService;
	}

	/**
	 * 设置cipherService
	 * 
	 * @param cipherService
	 */
	public void setCipherService(CipherService cipherService)
	{
		this.cipherService = cipherService;
	}

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
