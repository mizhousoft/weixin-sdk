package com.mizhousoft.weixin.mp.domain.freepublish;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mizhousoft.weixin.common.WxError;
import com.mizhousoft.weixin.mp.domain.serializer.NumericDateDeserializer;

/**
 * 发布能力-通过 article_id 获取已发布文章.
 *
 */
public class WxMpFreePublishInfo extends WxError
{
	// 创建时间
	@JsonProperty("create_time")
	@JsonDeserialize(using = NumericDateDeserializer.class)
	private Date createTime;

	/**
	 * 文章列表
	 */
	@JsonProperty("news_item")
	private List<WxMpFreePublishArticle> newsItem;

	/**
	 * 更新时间
	 */
	@JsonProperty("update_time")
	@JsonDeserialize(using = NumericDateDeserializer.class)
	private Date updateTime;

	/**
	 * 获取createTime
	 * 
	 * @return
	 */
	public Date getCreateTime()
	{
		return createTime;
	}

	/**
	 * 设置createTime
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * 获取newsItem
	 * 
	 * @return
	 */
	public List<WxMpFreePublishArticle> getNewsItem()
	{
		return newsItem;
	}

	/**
	 * 设置newsItem
	 * 
	 * @param newsItem
	 */
	public void setNewsItem(List<WxMpFreePublishArticle> newsItem)
	{
		this.newsItem = newsItem;
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
