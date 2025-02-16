package com.mizhousoft.weixin.miniapp.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息
 *
 * @version
 */
public class WxMiniAppUserChangeMessage extends WxMiniAppMessage
{
	/**
	 * 小程序的UserName
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
	 * 小程序的AppID
	 */
	@JsonProperty("AppID")
	private String appId;

	/**
	 * 用户撤回的授权信息，
	 * 1:车牌号,
	 * 2:地址,
	 * 3:发票信息,
	 * 4:蓝牙,
	 * 5:麦克风,
	 * 6:昵称和头像,
	 * 7:摄像头,
	 * 8:手机号,
	 * 12:微信运动步数,
	 * 13:位置信息,
	 * 14:选中的图片或视频,
	 * 15:选中的文件,
	 * 16:邮箱地址,
	 * 18:选择的位置信息,
	 * 19:昵称输入键盘中选择的微信昵称,
	 * 20:获取用户头像组件中选择的微信头像
	 */
	@JsonProperty("RevokeInfo")
	private String revokeInfo;

	/**
	 * 插件场景用户撤回，插件的AppID
	 */
	@JsonProperty("PluginID")
	private String pluginID;

	/**
	 * 插件场景用户撤回，撤回用户的OpenPID
	 */
	@JsonProperty("OpenPID")
	private String openPID;

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

	/**
	 * 获取pluginID
	 * 
	 * @return
	 */
	public String getPluginID()
	{
		return pluginID;
	}

	/**
	 * 设置pluginID
	 * 
	 * @param pluginID
	 */
	public void setPluginID(String pluginID)
	{
		this.pluginID = pluginID;
	}

	/**
	 * 获取openPID
	 * 
	 * @return
	 */
	public String getOpenPID()
	{
		return openPID;
	}

	/**
	 * 设置openPID
	 * 
	 * @param openPID
	 */
	public void setOpenPID(String openPID)
	{
		this.openPID = openPID;
	}
}
