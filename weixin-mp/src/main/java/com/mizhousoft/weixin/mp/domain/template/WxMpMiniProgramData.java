package com.mizhousoft.weixin.mp.domain.template;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 小程序数据
 *
 * @version
 */
public class WxMpMiniProgramData
{
	// 应用ID
	@JsonProperty("appid")
	private String appId;

	// 页面路径
	@JsonProperty("pagepath")
	private String pagePath;

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
	 * 获取pagePath
	 * 
	 * @return
	 */
	public String getPagePath()
	{
		return pagePath;
	}

	/**
	 * 设置pagePath
	 * 
	 * @param pagePath
	 */
	public void setPagePath(String pagePath)
	{
		this.pagePath = pagePath;
	}
}
