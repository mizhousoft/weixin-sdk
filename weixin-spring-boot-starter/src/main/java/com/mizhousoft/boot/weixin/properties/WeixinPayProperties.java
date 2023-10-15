package com.mizhousoft.boot.weixin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "weixin.pay.merchants")
public class WeixinPayProperties
{
	/**
	 * identifier
	 */
	private volatile String identifier;

	/**
	 * 商户ID
	 */
	private volatile String mchId;

	/**
	 * api V3密钥
	 */
	private volatile String apiV3Key;

	/**
	 * 商户私钥路径
	 */
	private volatile String mchPrivFilePath;

	/**
	 * 商户证书路径
	 */
	private volatile String mchCertFilePath;

	/**
	 * 平台商户证书路径
	 */
	private volatile String platformCertFilePath;

	/**
	 * endpoint
	 */
	private volatile String endpoint = "https://api.mch.weixin.qq.com";

	/**
	 * 支付通知url
	 */
	private volatile String notifyUrl;

	/**
	 * 退款通知url
	 */
	private volatile String refundNotifyUrl;

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
	 * 获取mchPrivFilePath
	 * 
	 * @return
	 */
	public String getMchPrivFilePath()
	{
		return mchPrivFilePath;
	}

	/**
	 * 设置mchPrivFilePath
	 * 
	 * @param mchPrivFilePath
	 */
	public void setMchPrivFilePath(String mchPrivFilePath)
	{
		this.mchPrivFilePath = mchPrivFilePath;
	}

	/**
	 * 获取mchCertFilePath
	 * 
	 * @return
	 */
	public String getMchCertFilePath()
	{
		return mchCertFilePath;
	}

	/**
	 * 设置mchCertFilePath
	 * 
	 * @param mchCertFilePath
	 */
	public void setMchCertFilePath(String mchCertFilePath)
	{
		this.mchCertFilePath = mchCertFilePath;
	}

	/**
	 * 获取platformCertFilePath
	 * 
	 * @return
	 */
	public String getPlatformCertFilePath()
	{
		return platformCertFilePath;
	}

	/**
	 * 设置platformCertFilePath
	 * 
	 * @param platformCertFilePath
	 */
	public void setPlatformCertFilePath(String platformCertFilePath)
	{
		this.platformCertFilePath = platformCertFilePath;
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
	 * 获取notifyUrl
	 * 
	 * @return
	 */
	public String getNotifyUrl()
	{
		return notifyUrl;
	}

	/**
	 * 设置notifyUrl
	 * 
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl)
	{
		this.notifyUrl = notifyUrl;
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
