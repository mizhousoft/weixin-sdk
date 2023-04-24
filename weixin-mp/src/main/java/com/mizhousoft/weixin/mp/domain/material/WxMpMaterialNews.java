package com.mizhousoft.weixin.mp.domain.material;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mizhousoft.weixin.common.WxError;
import com.mizhousoft.weixin.mp.domain.serializer.NumericDateDeserializer;

/**
 * 素材
 *
 */
public class WxMpMaterialNews extends WxError
{
	// 创建时间
	@JsonProperty("create_time")
	@JsonDeserialize(using = NumericDateDeserializer.class)
	private Date createTime;

	// 更新时间
	@JsonProperty("update_time")
	@JsonDeserialize(using = NumericDateDeserializer.class)
	private Date updateTime;

	// 文章
	@JsonProperty("news_item")
	private List<WxMpNewsArticle> articles = new ArrayList<>();

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
	 * 获取articles
	 * 
	 * @return
	 */
	public List<WxMpNewsArticle> getArticles()
	{
		return articles;
	}

	/**
	 * 设置articles
	 * 
	 * @param articles
	 */
	public void setArticles(List<WxMpNewsArticle> articles)
	{
		this.articles = articles;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"createTime\":\"");
		builder.append(createTime);
		builder.append("\", \"updateTime\":\"");
		builder.append(updateTime);
		builder.append("\", \"articles\":\"");
		builder.append(articles);
		builder.append("\"}");
		return builder.toString();
	}
}
