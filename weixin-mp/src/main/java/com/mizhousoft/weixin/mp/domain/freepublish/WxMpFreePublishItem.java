package com.mizhousoft.weixin.mp.domain.freepublish;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mizhousoft.weixin.mp.domain.serializer.NumericDateDeserializer;

/**
 * 发布列表的一条记录
 *
 */
public class WxMpFreePublishItem
{
	/**
	 * 成功发布的图文消息id
	 */
	@JsonProperty("article_id")
	private String articleId;

	/**
	 * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS。
	 */
	@JsonProperty("content")
	private WxMpFreePublishInfo content;

	/**
	 * 这篇图文消息素材的最后更新时间
	 */
	@JsonProperty("update_time")
	@JsonDeserialize(using = NumericDateDeserializer.class)
	private Date updateTime;

	/**
	 * 获取articleId
	 * 
	 * @return
	 */
	public String getArticleId()
	{
		return articleId;
	}

	/**
	 * 设置articleId
	 * 
	 * @param articleId
	 */
	public void setArticleId(String articleId)
	{
		this.articleId = articleId;
	}

	/**
	 * 获取content
	 * 
	 * @return
	 */
	public WxMpFreePublishInfo getContent()
	{
		return content;
	}

	/**
	 * 设置content
	 * 
	 * @param content
	 */
	public void setContent(WxMpFreePublishInfo content)
	{
		this.content = content;
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
}
