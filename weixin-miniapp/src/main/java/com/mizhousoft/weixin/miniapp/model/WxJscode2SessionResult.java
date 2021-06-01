package com.mizhousoft.weixin.miniapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 登录凭证校验结果
 *
 * @version
 */
public class WxJscode2SessionResult
{
	// 会话密钥
	@JsonProperty("session_key")
	private String sessionKey;

	// 用户唯一标识
	@JsonProperty("openid")
	private String openid;

	// 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
	@JsonProperty("unionid")
	private String unionid;

	// 错误码
	@JsonProperty("errcode")
	private int errcode;

	// 错误信息
	@JsonProperty("errmsg")
	private String errmsg;

	/**
	 * 获取sessionKey
	 * 
	 * @return
	 */
	public String getSessionKey()
	{
		return sessionKey;
	}

	/**
	 * 设置sessionKey
	 * 
	 * @param sessionKey
	 */
	public void setSessionKey(String sessionKey)
	{
		this.sessionKey = sessionKey;
	}

	/**
	 * 获取openid
	 * 
	 * @return
	 */
	public String getOpenid()
	{
		return openid;
	}

	/**
	 * 设置openid
	 * 
	 * @param openid
	 */
	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	/**
	 * 获取unionid
	 * 
	 * @return
	 */
	public String getUnionid()
	{
		return unionid;
	}

	/**
	 * 设置unionid
	 * 
	 * @param unionid
	 */
	public void setUnionid(String unionid)
	{
		this.unionid = unionid;
	}

	/**
	 * 获取errcode
	 * 
	 * @return
	 */
	public int getErrcode()
	{
		return errcode;
	}

	/**
	 * 设置errcode
	 * 
	 * @param errcode
	 */
	public void setErrcode(int errcode)
	{
		this.errcode = errcode;
	}

	/**
	 * 获取errmsg
	 * 
	 * @return
	 */
	public String getErrmsg()
	{
		return errmsg;
	}

	/**
	 * 设置errmsg
	 * 
	 * @param errmsg
	 */
	public void setErrmsg(String errmsg)
	{
		this.errmsg = errmsg;
	}
}
