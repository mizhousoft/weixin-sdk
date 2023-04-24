package com.mizhousoft.weixin.mp.domain.freepublish;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mizhousoft.weixin.common.WxError;

/**
 * 发布能力-获取成功发布列表.
 *
 */
public class WxMpFreePublishList extends WxError
{
	/**
	 * 成功发布素材的总数
	 */
	@JsonProperty("total_count")
	private Integer totalCount;

	/**
	 * 本次调用获取的素材的数量
	 */
	@JsonProperty("item_count")
	private Integer itemCount;

	/**
	 * 所有成功发布列表
	 */
	@JsonProperty("item")
	private List<WxMpFreePublishItem> items;

	/**
	 * 获取totalCount
	 * 
	 * @return
	 */
	public Integer getTotalCount()
	{
		return totalCount;
	}

	/**
	 * 设置totalCount
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(Integer totalCount)
	{
		this.totalCount = totalCount;
	}

	/**
	 * 获取itemCount
	 * 
	 * @return
	 */
	public Integer getItemCount()
	{
		return itemCount;
	}

	/**
	 * 设置itemCount
	 * 
	 * @param itemCount
	 */
	public void setItemCount(Integer itemCount)
	{
		this.itemCount = itemCount;
	}

	/**
	 * 获取items
	 * 
	 * @return
	 */
	public List<WxMpFreePublishItem> getItems()
	{
		return items;
	}

	/**
	 * 设置items
	 * 
	 * @param items
	 */
	public void setItems(List<WxMpFreePublishItem> items)
	{
		this.items = items;
	}
}
