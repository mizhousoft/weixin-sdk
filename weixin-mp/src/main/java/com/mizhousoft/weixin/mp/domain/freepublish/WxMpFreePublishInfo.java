package com.mizhousoft.weixin.mp.domain.freepublish;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mizhousoft.weixin.common.WxError;

/**
 * 发布能力-通过 article_id 获取已发布文章.
 *
 * @version
 */
public class WxMpFreePublishInfo extends WxError
{
	/**
	 * 文章列表
	 */
	@JsonProperty("news_item")
	private List<WxMpFreePublishArticles> newsItem;

	/**
	 * 获取newsItem
	 * 
	 * @return
	 */
	public List<WxMpFreePublishArticles> getNewsItem()
	{
		return newsItem;
	}

	/**
	 * 设置newsItem
	 * 
	 * @param newsItem
	 */
	public void setNewsItem(List<WxMpFreePublishArticles> newsItem)
	{
		this.newsItem = newsItem;
	}
}
