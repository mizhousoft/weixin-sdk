package com.mizhousoft.weixin.mp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mizhousoft.weixin.common.WxError;

/**
 * 素材结果
 *
 * @version
 */
public class WxMpMaterialFileBatchGetResult extends WxError
{
	// 该类型的素材的总数
	@JsonProperty("total_count")
	private int totalCount;

	// 本次调用获取的素材的数量
	@JsonProperty("item_count")
	private int itemCount;

	// 素材
	@JsonProperty("item")
	private List<WxMaterialFileBatchGetNewsItem> items;

	/**
	 * 获取totalCount
	 * 
	 * @return
	 */
	public int getTotalCount()
	{
		return totalCount;
	}

	/**
	 * 设置totalCount
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	/**
	 * 获取itemCount
	 * 
	 * @return
	 */
	public int getItemCount()
	{
		return itemCount;
	}

	/**
	 * 设置itemCount
	 * 
	 * @param itemCount
	 */
	public void setItemCount(int itemCount)
	{
		this.itemCount = itemCount;
	}

	/**
	 * 获取items
	 * 
	 * @return
	 */
	public List<WxMaterialFileBatchGetNewsItem> getItems()
	{
		return items;
	}

	/**
	 * 设置items
	 * 
	 * @param items
	 */
	public void setItems(List<WxMaterialFileBatchGetNewsItem> items)
	{
		this.items = items;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"totalCount\":\"");
		builder.append(totalCount);
		builder.append("\", \"itemCount\":\"");
		builder.append(itemCount);
		builder.append("\", \"items\":\"");
		builder.append(items);
		builder.append("\", \"errorCode\":\"");
		builder.append(errorCode);
		builder.append("\", \"errorMsg\":\"");
		builder.append(errorMsg);
		builder.append("\"}");
		return builder.toString();
	}
}
