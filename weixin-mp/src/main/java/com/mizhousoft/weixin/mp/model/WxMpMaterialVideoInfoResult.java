package com.mizhousoft.weixin.mp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mizhousoft.weixin.common.WxError;

/**
 * 视频消息素材
 *
 * @version
 */
public class WxMpMaterialVideoInfoResult extends WxError
{
	// 图文消息的标题
	@JsonProperty("title")
	private String title;

	// 描述
	@JsonProperty("description")
	private String description;

	// 下载地址
	@JsonProperty("down_url")
	private String downUrl;

	/**
	 * 获取title
	 * 
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * 设置title
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * 获取description
	 * 
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * 获取downUrl
	 * 
	 * @return
	 */
	public String getDownUrl()
	{
		return downUrl;
	}

	/**
	 * 设置downUrl
	 * 
	 * @param downUrl
	 */
	public void setDownUrl(String downUrl)
	{
		this.downUrl = downUrl;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"title\":\"");
		builder.append(title);
		builder.append("\", \"description\":\"");
		builder.append(description);
		builder.append("\", \"downUrl\":\"");
		builder.append(downUrl);
		builder.append("\", \"errorCode\":\"");
		builder.append(errorCode);
		builder.append("\", \"errorMsg\":\"");
		builder.append(errorMsg);
		builder.append("\"}");
		return builder.toString();
	}
}
