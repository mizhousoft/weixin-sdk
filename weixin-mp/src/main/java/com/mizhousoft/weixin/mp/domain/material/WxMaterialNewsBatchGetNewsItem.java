package com.mizhousoft.weixin.mp.domain.material;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mizhousoft.weixin.mp.domain.serializer.NumericDateDeserializer;

/**
 * 图文消息素材
 *
 * @version
 */
public class WxMaterialNewsBatchGetNewsItem
{
	// 素材ID
	@JsonProperty("media_id")
	private String mediaId;

	// 更新时间
	@JsonProperty("update_time")
	@JsonDeserialize(using = NumericDateDeserializer.class)
	private Date updateTime;

	// 内容
	@JsonProperty("content")
	private WxMpMaterialNews content;

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
	 * 获取content
	 * 
	 * @return
	 */
	public WxMpMaterialNews getContent()
	{
		return content;
	}

	/**
	 * 设置content
	 * 
	 * @param content
	 */
	public void setContent(WxMpMaterialNews content)
	{
		this.content = content;
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
		builder.append("\", \"content\":\"");
		builder.append(content);
		builder.append("\"}");
		return builder.toString();
	}
}
