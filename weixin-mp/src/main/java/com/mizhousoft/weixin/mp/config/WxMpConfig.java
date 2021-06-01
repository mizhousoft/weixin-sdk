package com.mizhousoft.weixin.mp.config;

import com.mizhousoft.weixin.common.WxConfig;

/**
 * 微信公众号配置
 *
 * @version
 */
public class WxMpConfig extends WxConfig
{
	//
	private volatile String token;

	//
	private volatile String aesKey;

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