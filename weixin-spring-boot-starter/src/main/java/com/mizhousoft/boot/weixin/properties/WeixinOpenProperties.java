package com.mizhousoft.boot.weixin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "weixin.open")
public class WeixinOpenProperties
{
	/**
	 * 应用ID
	 */
	private volatile String appId;

	/**
	 * 应用密钥
	 */
	private volatile String appSecret;

	/**
	 * Token
	 */
	private volatile String token;

	/**
	 * 密钥
	 */
	private volatile String aesKey;

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
	 * 获取appSecret
	 * 
	 * @return
	 */
	public String getAppSecret()
	{
		return appSecret;
	}

	/**
	 * 设置appSecret
	 * 
	 * @param appSecret
	 */
	public void setAppSecret(String appSecret)
	{
		this.appSecret = appSecret;
	}

	/**
	 * 获取token
	 * 
	 * @return
	 */
	public String getToken()
	{
		return token;
	}

	/**
	 * 设置token
	 * 
	 * @param token
	 */
	public void setToken(String token)
	{
		this.token = token;
	}

	/**
	 * 获取aesKey
	 * 
	 * @return
	 */
	public String getAesKey()
	{
		return aesKey;
	}

	/**
	 * 设置aesKey
	 * 
	 * @param aesKey
	 */
	public void setAesKey(String aesKey)
	{
		this.aesKey = aesKey;
	}
}
