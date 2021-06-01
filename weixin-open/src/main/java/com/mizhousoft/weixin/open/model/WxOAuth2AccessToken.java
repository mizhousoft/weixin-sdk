package com.mizhousoft.weixin.open.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WxMpOAuth2AccessToken
 *
 * @version
 */
public class WxOAuth2AccessToken
{
	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private int expiresIn = -1;

	@JsonProperty("refresh_token")
	private String refreshToken;

	@JsonProperty("openid")
	private String openId;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("unionid")
	private String unionId;

	/**
	 * 获取accessToken
	 * 
	 * @return
	 */
	public String getAccessToken()
	{
		return accessToken;
	}

	/**
	 * 设置accessToken
	 * 
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	/**
	 * 获取expiresIn
	 * 
	 * @return
	 */
	public int getExpiresIn()
	{
		return expiresIn;
	}

	/**
	 * 设置expiresIn
	 * 
	 * @param expiresIn
	 */
	public void setExpiresIn(int expiresIn)
	{
		this.expiresIn = expiresIn;
	}

	/**
	 * 获取refreshToken
	 * 
	 * @return
	 */
	public String getRefreshToken()
	{
		return refreshToken;
	}

	/**
	 * 设置refreshToken
	 * 
	 * @param refreshToken
	 */
	public void setRefreshToken(String refreshToken)
	{
		this.refreshToken = refreshToken;
	}

	/**
	 * 获取openId
	 * 
	 * @return
	 */
	public String getOpenId()
	{
		return openId;
	}

	/**
	 * 设置openId
	 * 
	 * @param openId
	 */
	public void setOpenId(String openId)
	{
		this.openId = openId;
	}

	/**
	 * 获取scope
	 * 
	 * @return
	 */
	public String getScope()
	{
		return scope;
	}

	/**
	 * 设置scope
	 * 
	 * @param scope
	 */
	public void setScope(String scope)
	{
		this.scope = scope;
	}

	/**
	 * 获取unionId
	 * 
	 * @return
	 */
	public String getUnionId()
	{
		return unionId;
	}

	/**
	 * 设置unionId
	 * 
	 * @param unionId
	 */
	public void setUnionId(String unionId)
	{
		this.unionId = unionId;
	}
}
