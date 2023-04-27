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
	 * 证书序列号
	 */
	private volatile String certSerialNumber;

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
