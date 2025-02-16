package com.mizhousoft.weixin.common;

/**
 * 微信配置
 *
 */
public class WxConfig
{
	// appId
	protected volatile String appId;

	// appSecret
	protected volatile String appSecret;

	//
	protected volatile String token;

	//
	protected volatile String aesKey;

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
