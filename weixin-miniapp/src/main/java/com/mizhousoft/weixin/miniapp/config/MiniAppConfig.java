package com.mizhousoft.weixin.miniapp.config;

/**
 * 配置
 *
 */
public class MiniAppConfig
{
	// appId
	private volatile String appId;

	// appSecret
	private volatile String appSecret;

	//
	private volatile String token;

	//
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
