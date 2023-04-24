package com.mizhousoft.weixin.mp.domain.material;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mizhousoft.weixin.mp.domain.serializer.NumericDateDeserializer;

/**
 * 消息素材
 *
 */
public class WxMaterialFileBatchGetNewsItem
{
	// 素材ID
	@JsonProperty("media_id")
	private String mediaId;

	// 更新时间
	@JsonProperty("update_time")
	@JsonDeserialize(using = NumericDateDeserializer.class)
	private Date updateTime;

	// 文件名称
	@JsonProperty("name")
	private String name;

	// 图片的URL
	@JsonProperty("url")
	private String url;

	/**
	 * 获取mediaId
	 * 
	 * @return
	 */
	public String getMediaId()
	{
		return mediaId;
	}

	/**
	 * 设置mediaId
	 * 
	 * @param mediaId
	 */
	public void setMediaId(String mediaId)
	{
		this.mediaId = mediaId;
	}

	/**
	 * 获取updateTime
	 * 
	 * @return
	 */
	public Date getUpdateTime()
	{
		return updateTime;
	}

	/**
	 * 设置updateTime
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	/**
	 * 获取name
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 设置name
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * 获取url
	 * 
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * 设置url
	 * 
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"mediaId\":\"");
		builder.append(mediaId);
		builder.append("\", \"updateTime\":\"");
		builder.append(updateTime);
		builder.append("\", \"name\":\"");
		builder.append(name);
		builder.append("\", \"url\":\"");
		builder.append(url);
		builder.append("\"}");
		return builder.toString();
	}
}
