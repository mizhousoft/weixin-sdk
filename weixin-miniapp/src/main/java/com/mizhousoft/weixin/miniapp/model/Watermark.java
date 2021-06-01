package com.mizhousoft.weixin.miniapp.model;

/**
 * 数据水印
 *
 * @version
 */
public class Watermark
{
	// 敏感数据归属 appId，开发者可校验此参数与自身 appId 是否一致
	private String appid;

	// 敏感数据获取的时间戳, 开发者可以用于数据时效性校验
	private long timestamp;

	/**
	 * 获取appid
	 * 
	 * @return
	 */
	public String getAppid()
	{
		return appid;
	}

	/**
	 * 设置appid
	 * 
	 * @param appid
	 */
	public void setAppid(String appid)
	{
		this.appid = appid;
	}

	/**
	 * 获取timestamp
	 * 
	 * @return
	 */
	public long getTimestamp()
	{
		return timestamp;
	}

	/**
	 * 设置timestamp
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}
}
