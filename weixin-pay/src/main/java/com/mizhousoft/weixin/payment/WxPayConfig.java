package com.mizhousoft.weixin.payment;

import java.security.PrivateKey;
import java.security.PublicKey;

import com.mizhousoft.weixin.certificate.CertificateProvider;

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
	 * 商户密钥
	 */
	private volatile String apiV3Key;

	/**
	 * 证书序列号
	 */
	private volatile String certSerialNumber;

	/**
	 * 私钥
	 */
	private volatile PrivateKey privateKey;

	/**
	 * 公钥
	 */
	private volatile PublicKey publicKey;

	/**
	 * 证书提供者
	 */
	private volatile CertificateProvider certProvider;

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
	 * 获取privateKey
	 * 
	 * @return
	 */
	public PrivateKey getPrivateKey()
	{
		return privateKey;
	}

	/**
	 * 设置privateKey
	 * 
	 * @param privateKey
	 */
	public void setPrivateKey(PrivateKey privateKey)
	{
		this.privateKey = privateKey;
	}

	/**
	 * 获取publicKey
	 * 
	 * @return
	 */
	public PublicKey getPublicKey()
	{
		return publicKey;
	}

	/**
	 * 设置publicKey
	 * 
	 * @param publicKey
	 */
	public void setPublicKey(PublicKey publicKey)
	{
		this.publicKey = publicKey;
	}

	/**
	 * 获取certProvider
	 * 
	 * @return
	 */
	public CertificateProvider getCertProvider()
	{
		return certProvider;
	}

	/**
	 * 设置certProvider
	 * 
	 * @param certProvider
	 */
	public void setCertProvider(CertificateProvider certProvider)
	{
		this.certProvider = certProvider;
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
