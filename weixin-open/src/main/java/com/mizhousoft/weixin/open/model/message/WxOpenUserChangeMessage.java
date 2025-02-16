package com.mizhousoft.weixin.open.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息
 *
 * @version
 */
public class WxOpenUserChangeMessage extends WxOpenMessage
{
	/**
	 * 移动应用的UserName
	 */
	@JsonProperty("ToUserName")
	private String toUserName;

	/**
	 * 平台推送服务UserName
	 */
	@JsonProperty("FromUserName")
	private String fromUserName;

	/**
	 * 发送时间
	 */
	@JsonProperty("CreateTime")
	private long createTime;

	/**
	 * 授权用户OpenID
	 */
	@JsonProperty("OpenID")
	private String openId;

	/**
	 * 移动应用的AppID
	 */
	@JsonProperty("AppID")
	private String appId;

	/**
	 * 用户撤回的授权信息，301:用户撤回移动应用所有授权信息
	 */
	@JsonProperty("RevokeInfo")
	private String revokeInfo;

	/**
	 * 获取toUserName
	 * 
	 * @return
	 */
	public String getToUserName()
	{
		return toUserName;
	}

	/**
	 * 设置toUserName
	 * 
	 * @param toUserName
	 */
	public void setToUserName(String toUserName)
	{
		this.toUserName = toUserName;
	}

	/**
	 * 获取fromUserName
	 * 
	 * @return
	 */
	public String getFromUserName()
	{
		return fromUserName;
	}

	/**
	 * 设置fromUserName
	 * 
	 * @param fromUserName
	 */
	public void setFromUserName(String fromUserName)
	{
		this.fromUserName = fromUserName;
	}

	/**
	 * 获取createTime
	 * 
	 * @return
	 */
	public long getCreateTime()
	{
		return createTime;
	}

	/**
	 * 设置createTime
	 * 
	 * @param createTime
	 */
	public void setCreateTime(long createTime)
	{
		this.createTime = createTime;
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
	 * 获取revokeInfo
	 * 
	 * @return
	 */
	public String getRevokeInfo()
	{
		return revokeInfo;
	}

	/**
	 * 设置revokeInfo
	 * 
	 * @param revokeInfo
	 */
	public void setRevokeInfo(String revokeInfo)
	{
		this.revokeInfo = revokeInfo;
	}
}
